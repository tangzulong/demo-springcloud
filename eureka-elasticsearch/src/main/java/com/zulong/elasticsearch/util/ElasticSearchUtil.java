package com.zulong.elasticsearch.util;

import com.zulong.elasticsearch.entity.UserDto;
import net.sf.json.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project_Name: demo-springcloud
 * @Description: elasticsearch搜索帮助类
 * @Author: Mr.Tang
 * @Create_Date: 2018-07-17 17:33
 **/
public class ElasticSearchUtil {
    /**
     * 创建TransportClient 客户端连接
     * 在elasticsearch中可以执行 创建索引 获取索引 删除索引  搜索索引等操作
     * esClusterName es集群连接名 esIp es连接ip esPort es连接端口
     */
    private static TransportClient transportClient=null;

    private static Logger logger= LogManager.getLogger(ElasticSearchUtil.class);

    public static TransportClient getTransportClient(String esClusterName,String esIp,String esPort ){
        try {
            if(transportClient==null){
                if(esIp==null||"".equals(esIp)){
                    return null;
                }
                if(esPort==null||"".equals(esPort)){
                    return null;
                }
                Settings setting=Settings.builder() //
                        .put("cluster.name", esClusterName)// 集群名
                        // .put("client.transport.sniff", true) // 自动把集群下的机器添加到列表中
                        .build();
                transportClient= new PreBuiltTransportClient(setting);
                TransportAddress transportAddress=new InetSocketTransportAddress(InetAddress.getByName(esIp),Integer.parseInt(esPort));
                transportClient.addTransportAddress(transportAddress);

            }else{
                return transportClient;
            }
        } catch (UnknownHostException e) {
            logger.error("获取es客户端失败，失败原因："+e);
            if(transportClient!=null){
                transportClient.close();
            }
        }
        return transportClient;
    }

    /**
     * 判断索引是否存在
     * @param index
     */
    public static  boolean indexExists(String index){
        IndicesExistsRequest request = new IndicesExistsRequest(index);
        IndicesExistsResponse response = transportClient.admin().indices().exists(request).actionGet();
        if (response.isExists()) {
            return true;
        }
        return false;
    }

    //创建索引
    public static  void CreateIndex(String index){
        IndicesAdminClient adminClient = transportClient.admin().indices();
        if (!indexExists(index)) {

            	/*adminClient.prepareCreate(index.getId().toString())
            .setSettings(Settings.builder().put("index.cityName", index.getCityName()).put("index.provinceId", index.getProvinceId()))
            .addMapping(index.getCityName(), index.getId())
            .get();  */
            transportClient.admin().indices().create(new CreateIndexRequest(index)).actionGet();
            //wait for yellow
            transportClient.admin().cluster().health(new ClusterHealthRequest(index)
                    .waitForYellowStatus())
                    .actionGet();
            //createStoreNameMapping(index.getId().toString());
            logger.info("index creation success! create index: "+index);
        }else{
            logger.info("index"+index+" is exists");
        }
    }

    /**
     * 删除索引
     * @param index 要删除的索引名
     */
    public static void deleteIndex(String index){
        DeleteIndexResponse dResponse=null;
        if(indexExists(index)){
            dResponse = transportClient.admin().indices().prepareDelete(index)
                    .execute().actionGet();
            if(dResponse.isAcknowledged()){
                System.out.println("索引"+index+"已删除");
            }
        }else{
            System.out.println("索引:"+index+"不存在");
        }
    }
    public static Map<String, Object> addDataToEs(TransportClient client, List<Map<String, Object>> datas, String index, String type){
        Map<String, Object> returnMap=new HashMap<String, Object>();
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        if(datas!=null&&datas.size()>0){
            for (Map<String, Object> map : datas) {
                JSONObject json = JSONObject.fromObject(map);
                String userName= MapUtils.getString(map, "userName");
                String userId= MapUtils.getString(map, "userId");
                if(StringUtils.isBlank(userName)){
                    IndexRequestBuilder lrb = transportClient .prepareIndex(index, type) .setSource(json);
                    bulkRequest.add(lrb);
                }
                else{
                    IndexRequestBuilder lrb = transportClient.prepareIndex(index, type,userName) .setSource(json).setId(userId);
                    bulkRequest.add(lrb);
                }
            }
            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
            if (bulkResponse.hasFailures()) {
                logger.error(bulkResponse.getItems().toString());
                returnMap.put("500", "保存ES失败!");
                return returnMap;
            }
            bulkRequest = transportClient.prepareBulk();
            returnMap.put("200", "保存ES成功!");
            return returnMap;
        }
        return new HashMap<String, Object>();
    }

    /**
     * 根据条件搜索
     * @param cityName
     * @param index
     * @param type
     * @return
     */
    public static List<Map<String,Object>> searchUserName(String cityName, String index, String type){
        QueryStringQueryBuilder queryBuilder = null;
        if(cityName!=null && !cityName.trim().equals("")){
            cityName = QueryParser.escape(cityName);
            queryBuilder = new QueryStringQueryBuilder(cityName);
            queryBuilder.analyzer("ik_smart");
            queryBuilder.field("userName");
            queryBuilder.defaultOperator(Operator.AND);
        }
        List<String> ids=new ArrayList<String>();
        SearchResponse responses = transportClient.prepareSearch(index).setTypes(type)
                .setExplain(true)  //设置是否按查询匹配度排序
                .setQuery(queryBuilder) // 设置返回数据条数，不设置则默认10条
                .setFrom(0).setSize(1000) // 分页
                .execute().actionGet();

        SearchHits hit = responses.getHits();
        List<Map<String,Object>> hitList = new ArrayList();
        for (int i = 0; i < hit.getHits().length; i++) {
            String str=hit.getHits()[i].getSourceAsString();
            Map<String, Object> map=JSONObject.fromObject(str);
            UserDto userDto=new UserDto();
            userDto.setUserId(MapUtils.getString(map,"userId"));
            userDto.setUserName(MapUtils.getString(map,"userName"));
            userDto.setMobileNumber(MapUtils.getString(map,"mobileNumber"));
            userDto.setNickName(MapUtils.getString(map,"nickName"));
            userDto.setUserGroup(MapUtils.getString(map,"userGroup"));
            userDto.setBlackListFlag(MapUtils.getString(map,"blackListFlag"));
            userDto.setUserLable(MapUtils.getString(map,"userLable"));
            userDto.setRemark(MapUtils.getString(map,"remark"));
            userDto.setEmail(MapUtils.getString(map,"email"));
            userDto.setPassword(MapUtils.getString(map,"password"));
            userDto.setGender(MapUtils.getString(map,"gender"));
            userDto.setBirthDateStr(MapUtils.getString(map,"birthDateStr"));
            userDto.setRegistrationTimeStr(MapUtils.getString(map,"registrationTimeStr"));
            userDto.setLastLoginDateStr(MapUtils.getString(map,"lastLoginDateStr"));
            hitList.add(map);
            ids.add(hit.getHits()[i].getId());   //得到 根据条件查询出来的文档的唯一编号
        }
        System.out.println("query user info by userName:"+hitList);
        return hitList;
    }

    /**
     * 创建mapping(相当于约束某个index的字段值)
     */

    public static void createMapping(String index,String type){
        XContentBuilder mapping=null;
        try {
            mapping = XContentFactory.jsonBuilder()
                    .startObject()
                    .startObject(type)
                    .startObject("properties")
                    .startObject("userName")
                    .field("type","string")
                    .field("analyzer", "ik_max_word")
                    .field("search_analyzer", "ik_max_word")
                    .endObject()
                    .startObject("mobileNumber")
                    .field("type","string")
                    .endObject()  //文档的属性值
                    .endObject()
                    .endObject()
                    .endObject();

            PutMappingRequest mappingRequest = Requests.putMappingRequest(index).type(type).source(mapping);
            transportClient.admin().indices().putMapping(mappingRequest).actionGet();
        } catch (IOException e) {
            logger.error("create mapping failure:"+e);
        }

    }
}

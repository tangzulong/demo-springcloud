package com.zulong.elasticsearch;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.zulong.elasticsearch.entity.Address;
import com.zulong.elasticsearch.entity.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaElasticsearchApplicationTests {

	@Test
	public void contextLoads() {
		UserDto userDto=new UserDto();
		userDto.setUserName("小唐");
		userDto.setBlackListFlag("false");
		userDto.setEmail("1103330503@qq.com");
		userDto.setNickName("哈喽");

		List<Address> adds = new ArrayList<Address>();
		Address address1 = new Address();
		address1.setCountry("中国");
		address1.setProvince("安徽");
		address1.setCity("宿州");
		address1.setCounty("萧县");
		Address address2 = new Address();
		address2.setCountry("中国");
		address2.setProvince("上海");
		address2.setCity(null);
		address2.setCounty("");
		adds.add(address1);
		adds.add(address2);
		userDto.setAddresses(adds);

		String str="<userDto>\n" +
				"  <userName>小唐</userName>\n" +
				"  <nickName>哈喽</nickName>\n" +
				"  <blackListFlag>false</blackListFlag>\n" +
				"  <email>1103330503@qq.com</email>\n" +
				"  <Addresses>\n" +
				"    <Address>\n" +
				"      <country>中国</country>\n" +
				"      <province>安徽</province>\n" +
				"      <city>宿州</city>\n" +
				"      <county>萧县</county>\n" +
				"    </Address>\n" +
				"    <Address>\n" +
				"      <country>中国</country>\n" +
				"      <province>上海</province>\n" +
				"      <county></county>\n" +
				"    </Address>\n" +
				"  </Addresses>\n" +
				"  <startDate>0</startDate>\n" +
				"  <endDate>0</endDate>\n" +
				"  <pageNumber>0</pageNumber>\n" +
				"  <pageSize>0</pageSize>\n" +
				"</UserDto>";
		String xml=EurekaElasticsearchApplicationTests.toXml(userDto,true);
		System.out.println(xml);
		UserDto dto=EurekaElasticsearchApplicationTests.toBean(xml,UserDto.class);
		System.out.println(dto.toString());
	}


	/**
	 * xml转实体类
	 * @param xmlStr
	 * @param cls
	 * @param <T>
	 * @return
	 */
	public static <T> T toBean(String xmlStr, Class<T> cls) {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("userDto", UserDto.class);
		xstream.alias("address", Address.class);
		xstream.processAnnotations(cls);
		T obj = (T) xstream.fromXML(xmlStr);
		return obj;
	}

	/**
	 * 实体类转xml
	 * @param obj
	 * @param format
	 * @return
	 */
	public static String toXml(Object obj, boolean format) {
		XStream xstream = new XStream();
		xstream.alias("userDto", UserDto.class);
		xstream.alias("address", Address.class);
		xstream.processAnnotations(obj.getClass());
		xstream.setMode(XStream.NO_REFERENCES);
		if (format) {
			return xstream.toXML(obj);
		} else {
			Writer writer = new StringWriter();
			xstream.marshal(obj, new CompactWriter(writer));
			return writer.toString();
		}
	}
}

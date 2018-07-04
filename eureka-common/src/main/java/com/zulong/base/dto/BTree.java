package com.zulong.base.dto;

import java.util.List;

public interface BTree {
     String getId();
     void setId(String id);
     List<BTree> getChildren();
     void setChildren(List<BTree> bTrees);
}

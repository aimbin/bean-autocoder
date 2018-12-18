package org.aimbin.itemmanager.dao;

import java.util.List;
import java.util.Map;
import org.aimbin.itemmanager.bean.ItemType;

public interface ItemTypeMapper {


    public void createItemType (ItemType itemType) ;

    public void updateItemType (ItemType itemType) ;

    public void deleteItemType (String id) ;

    public List<ItemType>  queryItemType (Map<String, Object>  filter) ;
}
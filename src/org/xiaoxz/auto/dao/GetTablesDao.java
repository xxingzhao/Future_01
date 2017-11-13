package org.xiaoxz.auto.dao;


import org.xiaoxz.auto.bean.TableStruct;

import java.util.List;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public interface GetTablesDao {

    List<String> getTableNames();
    List<TableStruct> getTableStruct();
}

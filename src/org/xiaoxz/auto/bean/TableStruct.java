package org.xiaoxz.auto.bean;

import java.util.List;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class TableStruct {

    //表名
    private String tableName;
    private List columns;

    public TableStruct() {
    }

    public TableStruct(String tableName, List columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List getColumns() {
        return columns;
    }

    public void setColumns(List columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "TableStruct{" +
                "tableName='" + tableName + '\'' +
                ", columns=" + columns +
                '}';
    }
}

package org.xiaoxz.auto.bean;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class ColumnStruct {

    private String columnName;
    private String dataType;

    public ColumnStruct() {
    }

    public ColumnStruct(String columnName, String dataType) {
        this.columnName = columnName;
        this.dataType = dataType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "ColumnStruct{" +
                "columnName='" + columnName + '\'' +
                ", dataType='" + dataType + '\'' +
                '}';
    }
}

package org.xiaoxz.auto.util;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class NameUtil {

    /**
     * 处理文件名
     * @param tableName 表名
     * @return
     */
    public static String fileName(String tableName) {
        String fileName = "";
        String[] tableNames = tableName.split("_");
        for(int i=0; i<tableNames.length; i++) {
            tableNames[i] = tableNames[i].substring(0,1).toUpperCase() + tableNames[i].substring(1);
            fileName += tableNames[i];
        }
        return fileName;
    }

    /**
     * 处理变量名
     * @param columnName
     * @return
     */
    public static String columnName(String columnName) {
        String[] columnNames = columnName.split("_");
        String colName = "";
        for(int i=0; i<columnNames.length; i++) {
            for(int j=1; j<columnNames.length; j++) {
                columnNames[j] = columnNames[j].substring(0, 1).toUpperCase() + columnNames[j].substring(1);
            }
            colName += columnNames[i];
        }
        return colName;
    }


}

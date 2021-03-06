package org.xiaoxz.auto.util;

import org.apache.commons.lang3.StringUtils;

/**
 * mysql 数据类型处理工具类
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class DataTypeUtil {

    public static String getDataType(String dataType) {
        String type="";
        if("tinyint".equals(StringUtils.substringBefore(dataType, "("))){
            type="Byte";
        }
        if("smallint".equals(StringUtils.substringBefore(dataType, "("))){
            type="Short";
        }
        if("mediumint".equals(StringUtils.substringBefore(dataType, "("))){
            type="Integer";
        }
        if("int".equals(StringUtils.substringBefore(dataType, "("))){
            type="Integer";
        }
        if("integer".equals(StringUtils.substringBefore(dataType, "("))){
            type="Integer";
        }
        if("bigint".equals(StringUtils.substringBefore(dataType, "("))){
            type="Long";
        }
        if("bit".equals(StringUtils.substringBefore(dataType, "("))){
            type="Boolean";
        }
        if("double".equals(StringUtils.substringBefore(dataType, "("))){
            type="Double";
        }
        if("float".equals(StringUtils.substringBefore(dataType, "("))){
            type="Float";
        }
        if("decimal".equals(StringUtils.substringBefore(dataType, "("))){
            type="Long";
        }
        if("char".equals(StringUtils.substringBefore(dataType, "("))){
            type="String";
        }
        if("varchar".equals(StringUtils.substringBefore(dataType, "("))){
            type="String";
        }
        if("date".equals(StringUtils.substringBefore(dataType, "("))){
            type="Date";
        }
        if("time".equals(StringUtils.substringBefore(dataType, "("))){
            type="Date";
        }
        if("year".equals(StringUtils.substringBefore(dataType, "("))){
            type="Date";
        }
        if("timestamp".equals(StringUtils.substringBefore(dataType, "("))){
            type="Timestamp";
        }
        if("datetime".equals(StringUtils.substringBefore(dataType, "("))){
            type="Timestamp";
        }
        if("tinytext".equals(StringUtils.substringBefore(dataType, "("))){
            type="String";
        }
        if("enum".equals(StringUtils.substringBefore(dataType, "("))){
            type="String";
        }
        if("set".equals(StringUtils.substringBefore(dataType, "("))){
            type="String";
        }
        if("text".equals(StringUtils.substringBefore(dataType, "("))){
            type="String";
        }
        if("mediumtext".equals(StringUtils.substringBefore(dataType, "("))){
            type="String";
        }
        if("longtext".equals(StringUtils.substringBefore(dataType, "("))){
            type="String";
        }
        return type;
    }
}


package org.xiaoxz.auto.dao.impl;


import org.xiaoxz.auto.bean.ColumnStruct;
import org.xiaoxz.auto.bean.TableStruct;
import org.xiaoxz.auto.dao.BeanAutoDao;
import org.xiaoxz.auto.dao.GetTablesDao;
import org.xiaoxz.auto.util.ConfigUtil;
import org.xiaoxz.auto.util.DataTypeUtil;
import org.xiaoxz.auto.util.FileUtil;
import org.xiaoxz.auto.util.NameUtil;

import java.util.List;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class BeanAutoDaoImpl implements BeanAutoDao {

    private GetTablesDao getTablesDao = new GetTablesDaoImpl();
    List<TableStruct> list = getTablesDao.getTableStruct();

    @Override
    public boolean createBean() {
        String projectPath = ConfigUtil.projectPath;
        String beanFalg    = ConfigUtil.beanFlag;
        String beanPackage = ConfigUtil.beanPackage;
        if("true".equals(beanFalg)) {
            String beanPath = beanPackage.replaceAll(".", "/");
            String path     = projectPath +"/src/"+ beanPath;
            //遍历所有装有表的数据结构
            for(int i=0; i<list.size(); i++) {
                String fileName = list.get(i).getTableName() + "Bean";
                //遍历每个表的所有结构
                List<ColumnStruct> columns = list.get(i).getColumns();
                //(实体类）文件内容
                String packageCon       = "package "+beanPackage+";\n\n";
                StringBuffer importCon  = new StringBuffer();
                String className        = "public class "+fileName+"{\n\n";
                StringBuffer classCon   = new StringBuffer();
                StringBuffer gettersCon = new StringBuffer();
                StringBuffer settersCon = new StringBuffer();
                StringBuffer noneConstructor = new StringBuffer();
                StringBuffer constructor     = new StringBuffer();
                String constructorParam = "";
                StringBuffer constructorCon = new StringBuffer();
                //遍历List，将字段名称和字段类型写进文件
                for (int j = 0; j < columns.size(); j++) {
                    //变量名（属性名）
                    String columnName = NameUtil.columnName(columns.get(j).getColumnName());
                    //获得数据类型
                    String type = columns.get(j).getDataType();
                    //将mysql数据类型转换为java数据类型
                    String dateType = DataTypeUtil.getDataType(type);
                    //有date类型的数据需导包
                    if("Date".equals(dateType)){
                        importCon.append("import java.util.Date;\n\n");
                    }
                    //有Timestamp类型的数据需导包
                    if("Timestamp".equals(dateType)){
                        importCon.append("import java.sql.Timestamp;\n\n");
                    }

                    //生成属性
                    classCon.append("\t"+"private"+"\t"+dateType+"\t"+columnName+";\n");
                    //get、set的方法名
                    String getSetName=columnName.substring(0,1).toUpperCase()+columnName.substring(1);
                    //生成get方法
                    gettersCon.append("\t"+"public"+"\t"+dateType+"\t"+"get"+getSetName+"(){\n"+
                            "\t\t"+"return"+"\t"+columnName+";\n"+
                            "\t"+"}\n");
                    //生成set方法
                    settersCon.append("\t"+"public void"+"\t"+"set"+getSetName+"("+dateType+" "+columnName+"){\n"+
                            "\t\t"+"this."+columnName+" = "+columnName+";\n"+
                            "\t"+"}\n");
                    //获得有参构造器参数
                    if(constructorParam==null||"".equals(constructorParam)){
                        constructorParam=dateType+" "+columnName;
                    }else{
                        constructorParam+=","+dateType+" "+columnName;
                    }
                    //获得有参构造器的内容
                    constructorCon.append("\t\t"+"this."+columnName+" = "+columnName+";\n");
                }
                //生成无参构造器
                noneConstructor.append("\t"+"public"+"\t"+fileName+"(){\n"+
                        "\t\t"+"super();\n"+
                        "\t"+"}\n");
                //生成有参构造
                constructor.append("\t"+"public"+" "+fileName+"("+constructorParam+"){\n"+
                        "\t\t"+"super();\n"+constructorCon+
                        "\t"+"}\n");
                //拼接(实体类）文件内容
                StringBuffer content=new StringBuffer();
                content.append(packageCon);
                content.append(importCon.toString());
                content.append(className);
                content.append(classCon.toString());
                content.append(gettersCon.toString());
                content.append(settersCon.toString());
                content.append(noneConstructor.toString());
                content.append(constructor.toString());
                content.append("}");
                FileUtil.createFilePath(path+"/", fileName+".java", content.toString());
            }
            return true;
        }
        return false;
    }
}

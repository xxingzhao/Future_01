package org.xiaoxz.auto.dao.impl;

import com.xiaoxz.auto.bean.ColumnStruct;
import com.xiaoxz.auto.bean.TableStruct;
import com.xiaoxz.auto.dao.GetTablesDao;
import com.xiaoxz.auto.util.ConfigUtil;
import com.xiaoxz.auto.util.DataTypeUtil;
import com.xiaoxz.auto.util.FileUtil;
import com.xiaoxz.auto.util.NameUtil;

import java.util.List;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class DaoAutoDaoImpl implements DaoAutoDao {

    private GetTablesDao getTablesDao = new GetTablesDaoImpl();
    List<TableStruct> list = getTablesDao.getTableStruct();


    @Override
    public boolean createDao() {
        String projectPath = ConfigUtil.projectPath;
        String daoFlag     = ConfigUtil.daoFlag;
        String daoPackage  = ConfigUtil.daoPackage;
        String beanPackage = ConfigUtil.beanPackage;
        if("true".equals(daoFlag)) {
            String daoPath = daoPackage.replace(".", "/");
            String path    = projectPath +"/src/" + daoPath;
            for(int i=0; i<list.size(); i++) {
                String fileName = NameUtil.fileName(list.get(i).getTableName()) + "Dao";
                String beanName = NameUtil.fileName(list.get(i).getTableName()) +"Bean";
                //获得每个表的所有列结构
                List<ColumnStruct> columns =list.get(i).getColumns();
               //变量名（属性名）
                String columnName =NameUtil.columnName(columns.get(0).getColumnName());
                //获得数据类型
                String type = columns.get(0).getDataType();
                //将mysql数据类型转换为java数据类型
                String dateType = DataTypeUtil.getDataType(type);
                //(Dao接口）文件内容
                String packageCon ="package "+daoPackage+";\n\n";
                StringBuffer importCon=new StringBuffer();
                String className ="public interface "+fileName+"{\n\n";
                StringBuffer classCon = new StringBuffer();
                //生成导包内容
                importCon.append("import"+"\t"+beanPackage+"."+beanName+";\n\n");
                //有date类型的数据需导包
                if("Date".equals(dateType)){
                    importCon.append("import java.util.Date;\n\n");
                }
               //有Timestamp类型的数据需导包
                if("Timestamp".equals(dateType)){
                    importCon.append("import java.sql.Timestamp;\n\n");
                }
                importCon.append("import java.util.List;\n\n");
                //生成接口方法
                classCon.append("\t"+"public int insertRecord("+beanName+" record);//添加一条完整记录\n\n");
                classCon.append("\t"+"public int insertSelective("+beanName+" record);//添加指定列的数据\n\n");
                classCon.append("\t"+"public int deleteById("+dateType+" "+columnName+");//通过Id(主键)删除一条记录\n\n");
                classCon.append("\t"+"public int updateByIdSelective("+beanName+" record);//按Id(主键)修改指定列的值\n\n");
                classCon.append("\t"+"public int updateById("+beanName+" record);//按Id(主键)修改指定列的值\n\n");
                classCon.append("\t"+"public int countRecord();//计算表中的总记录数\n\n");
                classCon.append("\t"+"public int countSelective("+beanName+" record);//根据条件计算记录条数\n\n");
                classCon.append("\t"+"public int maxId();//获得表中的最大Id\n\n");
                classCon.append("\t"+"public"+"\t"+beanName+"\t"+"selectById("+dateType+"\t"+columnName+");//通过Id(主键)查询一条记录\n\n");
                classCon.append("\t"+"public List selectAll();//查询所有记录\n\n");
                //拼接(Dao接口）文件内容
                StringBuffer content=new StringBuffer();
                content.append(packageCon);
                content.append(importCon.toString());
                content.append(className);
                content.append(classCon.toString());
                content.append("\n}");
                FileUtil.createFilePath(path+"/", fileName+".java", content.toString());
            }
            return true;
        }
        return false;
    }
}

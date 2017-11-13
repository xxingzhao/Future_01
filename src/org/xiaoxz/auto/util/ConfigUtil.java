package org.xiaoxz.auto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class ConfigUtil {

    //项目路径的参数
    public static String projectPath;
    //生成Bean实体类的包名
    public static String beanFlag;
    //生成Bean实体类的包名
    public static String beanPackage;
    //是否生成Dao接口
    public static String daoFlag;
    //生成Dao接口的包名
    public static String daoPackage;
    //是否生成Mapper.xml
    public static String mapperXmlFlag;
    //生成Mapper.xml的包名
    public static String mapperXmlPackage;
    //是否生成Service接口
    public static String serviceFlag;
    //生成Service接口的包名
    public static String servicePackage;
    //是否生成ServiceImpl实现类
    public static String serviceImplFlag;
    //生成ServiceImpl实现类的包名
    public static String serviceImplPackage;

    static {
        try{
            String path = DataSourceUtil.class.getClassLoader().getResource("").getPath() + "org/xiaoxz/auto/config.properties";
            InputStream in  = new FileInputStream(new File(path));
            Properties pro = new Properties();
            pro.load(in);
            //将文件得到的信息,赋值到全局变量
            projectPath    = pro.getProperty("projectPath");
            beanFlag       = pro.getProperty("beanFlag");
            beanPackage    = pro.getProperty("beanPackage");
            daoFlag        = pro.getProperty("daoFlag");
            daoPackage     = pro.getProperty("daoPackage");
            serviceFlag    = pro.getProperty("serviceFlag");
            servicePackage = pro.getProperty("servicePackage");
            mapperXmlFlag  = pro.getProperty("mapperXmlFlag");
            mapperXmlPackage   = pro.getProperty("mapperXmlPackage");
            serviceImplFlag    = pro.getProperty("serviceImplFlag");
            serviceImplPackage = pro.getProperty("serviceImplPackage");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

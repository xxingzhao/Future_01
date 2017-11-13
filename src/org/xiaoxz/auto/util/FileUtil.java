package org.xiaoxz.auto.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件读取工具类
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class FileUtil {

    /**
     * 创建目录
     * @param dirName
     * @return
     */
    public static boolean createDir(String dirName) {
        File file = new File(dirName);
        if(!file.exists()) {
            if(file.mkdir()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 将内容写入到指定文件
     * @param filePath
     * @param content
     * @return
     */
    public static boolean writeFileContent(String filePath, String content) {
        boolean flag = false;
        File file = new File(filePath);
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            os.write(content.getBytes());
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  flag;
    }

    /**
     * 创建带内容的文件
     * @param filePath
     * @param content
     * @return
     */
    public static boolean createFile(String filePath, String content) {
        File file = new File(filePath);
        if(!file.exists()) {
            try {
                file.createNewFile();
                return writeFileContent(filePath, content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 创建指定路径下的文件并创建内容
     * @param path
     * @param fileName
     * @param content
     * @return
     */
    public static boolean createFilePath(String path, String fileName, String content) {
       if(createDir(path)) {
           StringBuffer sb = new StringBuffer(path);
           File file = new File(sb.append(fileName).toString());
           if(!file.exists()) {
               try {
                   file.createNewFile();
                   writeFileContent(sb.toString(), content);
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
           return true;
       } else {
           return createFile(path + fileName, content);
       }
    }

    /**
     * 删除文件
     * @param fileName
     * @return
     */
    public static boolean deleteFile(String fileName) {
        try{
            File file = new File(fileName);
            if(file.exists()) {
                file.deleteOnExit();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

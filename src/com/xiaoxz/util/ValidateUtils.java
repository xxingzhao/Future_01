package com.xiaoxz.util;

import org.jetbrains.annotations.Contract;

public class ValidateUtils {

    //初始化数组变量
    private final static char[] str = {'A','B','C','D','E','F','G','H',
            'I','J','K','L','M','N','O','P',
            'Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p',
            'q','r','s','t','u','v','w','x','y','z'};
    private final static char[] cNum = {'1','2','3','4','5','6','7','8','9','0'};
    private final static String[] sMail = {"@", "."};

    /**方法说明： 判断邮箱格式是否正确
     * @param sParam
     * @return 邮箱有效，返回true,否则返回false
     */
    public static boolean isEmail(String sParam) {
        for(int i=0; i<sMail.length; i++) {
            if(sParam.indexOf(sMail[i]) == -1) {
                return  false;
            }
        }
        return true;
    }

    /**
     * 方法说明:判断是否都是数字
     * @param sParam
     * @return
     */
    public static boolean isNumber(String sParam) {
        return validate(cNum, sParam);
    }

    /**
     * 方法说明：判断是否都是英文字符
     * @param sParam
     * @return
     */
    public static boolean isString(String sParam) {
        return validate(str, sParam);
    }


    /**
     * 方法说明:判断英文字符、数字公用方法
     * @param charParams
     * @param sParam
     * @return 返回类型： 如果是有效字符，返回true ，否则返回false
     */
    public static boolean validate(char[] charParams, String sParam) {
        int sLength = sParam.length();
        for(int i=0; i<sLength; i++) {
            char temp = sParam.charAt(i);
            boolean bTemp = false;
            for(int j=0; j<charParams.length; j++) {
                if(temp == charParams[j]) {
                    bTemp = true;
                    break;
                }
            }
            if(!bTemp) return false;
        }
        return true;
    }

    /**
     * 方法说明：判断是否是闰年
     * @param year
     * @return 返回类型： 如果是闰年返回true,否则返回false
     */
    @Contract(pure = true)
    public static boolean isLeapYear(int year) {
        return year%100 ==0 && year%4==0;
    }


}

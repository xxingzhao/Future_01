package com.xiaoxz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMain {

    public static void main(String[] args) throws ParseException {
        String num = "3434324";
        String str = "BBFFEEeeee";
        String email = "787987@qqcom";

        boolean bNum = ValidateUtils.isNumber(num);
        boolean bStr = ValidateUtils.isString(str);
        boolean bEmail = ValidateUtils.isEmail(email);
        compareDate();
    }

    public static void compareDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date nowDate   = new Date();
        Date ciEndDate = sdf.parse("2017-11-21");
        long l = nowDate.getTime() - ciEndDate.getTime();
        System.out.println(l);
    }

    public static void integerCompare() {
        Integer a=Integer.valueOf(100);
        Integer a1=Integer.valueOf(100);
        System.out.println(a);
        System.out.println(a1);
        System.out.println( a.equals(a1));

        Integer i = new Integer(100);
        Integer ii = new Integer(100);
        System.out.println(i.equals(ii));

        Integer i1 = 1280;
        int i2 = 1280;
        System.out.println(i1 == i2);
    }
}

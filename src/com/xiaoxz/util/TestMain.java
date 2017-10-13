package com.xiaoxz.util;

public class TestMain {

    public static void main(String[] args){
        String num = "3434324";
        String str = "BBFFEEeeee";
        String email = "787987@qqcom";

        boolean bNum = ValidateUtils.isNumber(num);
        boolean bStr = ValidateUtils.isString(str);
        boolean bEmail = ValidateUtils.isEmail(email);
        System.out.println("num: " + bNum + "; str: " + bStr +"; email: " + bEmail);
    }
}

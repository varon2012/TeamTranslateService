package com.bsuir.translateService.utils;

/**
 * Created by Олег Пятко on 08.05.2017.
 */
public class HelpUtils {
    public static boolean isNullOrEmpty(String string){
        if (string == null || string.isEmpty()){
            return true;
        }
        return false;
    }
}

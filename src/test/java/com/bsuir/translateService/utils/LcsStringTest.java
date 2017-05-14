package com.bsuir.translateService.utils;

import org.junit.Test;

/**
 * Created by Олег Пятко on 14.05.2017.
 */
public class LcsStringTest {
    @Test
    public void stringDiffTest(){
        DiffAlgorithmString lcsString = new DiffAlgorithmString("my stor is bad", "his story is good");
        String result = lcsString.getHtmlDiff();
    }
}
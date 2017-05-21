package com.bsuir.translateService.dto;

/**
 * Created by Олег Пятко on 22.05.2017.
 */
public class CompareDto {
    private String plainText;
    private String compareResult;

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getCompareResult() {
        return compareResult;
    }

    public void setCompareResult(String compareResult) {
        this.compareResult = compareResult;
    }
}

package com.bsuir.translateService.dto;

/**
 * Created by Олег Пятко on 22.05.2017.
 */
public class TaskDto {
    private String name;
    private String plainText;
    private String login;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

package com.bsuir.translateService.dto;

/**
 * Created by Олег Пятко on 25.05.2017.
 */
public class InviteDto {
    private String login;
    private String message;
    private String repName;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }
}

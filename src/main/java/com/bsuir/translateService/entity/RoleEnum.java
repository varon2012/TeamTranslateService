package com.bsuir.translateService.entity;

/**
 * Created by Олег Пятко on 21.05.2017.
 */
public enum RoleEnum {
    ADMIN(0),
    USER(1);

    private int levelId;

    RoleEnum(int levelId){
        this.levelId = levelId;
    }

    public int getValue(){
        return levelId;
    }
}

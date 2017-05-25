package com.bsuir.translateService.dto;

import com.bsuir.translateService.entity.BranchEntity;
import com.bsuir.translateService.entity.UserEntity;

/**
 * Created by Олег Пятко on 22.05.2017.
 */
public class EmployeesBranchDto {
    private UserEntity user;
    private BranchEntity branch;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }
}

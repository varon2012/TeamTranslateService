package com.bsuir.translateService.dto;

/**
 * Created by Олег Пятко on 22.05.2017.
 */
public class CompareCommitsDto {
    private String commit1;
    private String commit2;
    private int branchId;

    public String getCommit1() {
        return commit1;
    }

    public void setCommit1(String commit1) {
        this.commit1 = commit1;
    }

    public String getCommit2() {
        return commit2;
    }

    public void setCommit2(String commit2) {
        this.commit2 = commit2;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}

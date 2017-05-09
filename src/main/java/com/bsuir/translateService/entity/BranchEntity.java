package com.bsuir.translateService.entity;

import javax.persistence.*;

/**
 * Created by Олег Пятко on 09.05.2017.
 */
@Entity
@Table(name = "branch", schema = "git_translate")
public class BranchEntity {
    private int idBranch;
    private String name;
    private int idEmployee;

    @Id
    @Column(name = "idBranch", nullable = false)
    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "idEmployee", nullable = false)
    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchEntity that = (BranchEntity) o;

        if (idBranch != that.idBranch) return false;
        if (idEmployee != that.idEmployee) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBranch;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + idEmployee;
        return result;
    }
}

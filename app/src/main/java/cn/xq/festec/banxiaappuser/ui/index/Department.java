package cn.xq.festec.banxiaappuser.ui.index;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Department implements Serializable {

    private int depId;
    private String depNum;
    private String depName;
    private String depIntro;
    private String depExtra;
    private int deleted;
    private String createdAt;
    private String updatedAt;
    private String createdBy;
    private String updatedBy;

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepNum() {
        return depNum;
    }

    public void setDepNum(String depNum) {
        this.depNum = depNum;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepIntro() {
        return depIntro;
    }

    public void setDepIntro(String depIntro) {
        this.depIntro = depIntro;
    }

    public String getDepExtra() {
        return depExtra;
    }

    public void setDepExtra(String depExtra) {
        this.depExtra = depExtra;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depNum='" + depNum + '\'' +
                ", depName='" + depName + '\'' +
                ", depIntro='" + depIntro + '\'' +
                ", depExtra='" + depExtra + '\'' +
                ", deleted=" + deleted +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}

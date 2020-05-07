package cn.xq.festec.banxiaappuser.ui.index;

import java.io.Serializable;

public class Doctor implements Serializable {

    private int docId;

    private String docName;

    private int depId;

    private String depName;

    private int docGender;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getDocGender() {
        return docGender;
    }

    public void setDocGender(int docGender) {
        this.docGender = docGender;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "docId=" + docId +
                ", docName='" + docName + '\'' +
                '}';
    }
}

package cn.xq.festec.banxiaappuser.ui.index;

import java.io.Serializable;
import java.util.List;

public class DoctorList implements Serializable {

    private int status;

    private String msg;

    private List<Doctor> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Doctor> getData() {
        return data;
    }

    public void setData(List<Doctor> data) {
        this.data = data;
    }
}

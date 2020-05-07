package cn.xq.festec.banxiaappuser.ui.index;

import java.io.Serializable;

public class DoctorResult implements Serializable {

    private int status;

    private String msg;

    private DoctorPaged data;

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

    public DoctorPaged getData() {
        return data;
    }

    public void setData(DoctorPaged data) {
        this.data = data;
    }
}

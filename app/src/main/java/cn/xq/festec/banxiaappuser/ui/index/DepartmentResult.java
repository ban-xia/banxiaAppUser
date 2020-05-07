package cn.xq.festec.banxiaappuser.ui.index;

import java.io.Serializable;
import java.util.List;

public class DepartmentResult implements Serializable {

    private int status;
    private String msg;
    private List<Department> data;
    private String ok;

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

    public List<Department> getData() {
        return data;
    }

    public void setData(List<Department> data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    @Override
    public String toString() {
        return "DepartmentResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", ok='" + ok + '\'' +
                '}';
    }
}

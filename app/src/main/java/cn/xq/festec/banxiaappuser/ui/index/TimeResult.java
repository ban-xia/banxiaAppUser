package cn.xq.festec.banxiaappuser.ui.index;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimeResult implements Serializable {

    private int status;
    private String msg;
    private TreeMap<String, String> data;
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

    public TreeMap<String, String> getData() {
        return data;
    }

    public void setData(TreeMap<String, String> data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}

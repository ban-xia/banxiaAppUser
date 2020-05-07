package cn.xq.festec.banxiaappuser.ui.index;

import java.io.Serializable;
import java.util.List;

public class DoctorPaged implements Serializable {

    private int page;
    private int total;
    private int records;

    private List<Doctor> rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public List<Doctor> getRows() {
        return rows;
    }

    public void setRows(List<Doctor> rows) {
        this.rows = rows;
    }
}

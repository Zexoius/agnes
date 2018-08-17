package top.zexus.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 20:35 2018/7/22
 */
public class PageUtils implements Serializable {
    private static final long serialVersionUID = 1L;

    private int total;
    private List<?> rows;

    public PageUtils(int total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}

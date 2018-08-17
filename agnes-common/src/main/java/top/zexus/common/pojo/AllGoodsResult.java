package top.zexus.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 22:56 2018/8/14
 */
public class AllGoodsResult implements Serializable {
    private int total;
    private List<?> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}

package top.zexus.common.pojo.dto;

import java.io.Serializable;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 14:18 2018/9/12
 */
public class Cart implements Serializable {
    private Long userId;

    private Long goodsId;

    private String checked;

    private int goodsNum;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }
}

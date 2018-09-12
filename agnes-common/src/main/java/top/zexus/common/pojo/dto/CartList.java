package top.zexus.common.pojo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 10:35 2018/9/12
 */
public class CartList implements Serializable {

    private Long goodsId;

    private BigDecimal salePrice;

    private Long goodsNum;

    private String checked;

    private String goodsName;

    private String productImg;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Long getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
}

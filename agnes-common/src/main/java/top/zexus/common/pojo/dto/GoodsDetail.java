package top.zexus.common.pojo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 16:20 2018/8/21
 */
public class GoodsDetail implements Serializable {

    private Long goodsId;

    private BigDecimal saleprice;

    private String title;

    private String description;

    private String detail;

    private String productImageBig;

    private List<?> productImageSmall;


    public BigDecimal getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(BigDecimal saleprice) {
        this.saleprice = saleprice;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductImageBig() {
        return productImageBig;
    }

    public void setProductImageBig(String productImageBig) {
        this.productImageBig = productImageBig;
    }

    public List<?> getProductImageSmall() {
        return productImageSmall;
    }

    public void setProductImageSmall(List<?> productImageSmall) {
        this.productImageSmall = productImageSmall;
    }
}

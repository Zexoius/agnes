package top.zexus.common.pojo.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 16:36 2018/8/14
 */
public class Goods implements Serializable {
    private Long productId;

    private BigDecimal salePrice;

    private String productName;

    private String subTitle;

    private String productImageBig;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getProductImageBig() {
        return productImageBig;
    }

    public void setProductImageBig(String productImageBig) {
        this.productImageBig = productImageBig;
    }
}

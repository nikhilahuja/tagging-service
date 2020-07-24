package com.system.design.tagging.data;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Table("products")
public class Product implements Serializable {

    private static final long serialVersionUID = 3723862014835570874L;

    @PrimaryKey(value = "product_id")
    private Integer productId;
    @Column(value = "product_name")
    private String productName;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

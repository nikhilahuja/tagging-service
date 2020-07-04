package com.system.design.tagging.data;

import java.io.Serializable;
import java.sql.Timestamp;

public class Tag implements Serializable {

    private static final long serialVersionUID = -1764970284520387975L;

    private String tagName;
    private int productId;
    private String contentId;
    private Timestamp timestamp;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
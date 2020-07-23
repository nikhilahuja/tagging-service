package com.system.design.tagging.data;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.sql.Timestamp;

//@Table(value = "tags")
public class Tag implements Serializable {

    private static final long serialVersionUID = -1764970284520387975L;

    //@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int productId;
    //@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private String contentId;
    //@PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private String tagName;
    private Timestamp timestamp;

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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
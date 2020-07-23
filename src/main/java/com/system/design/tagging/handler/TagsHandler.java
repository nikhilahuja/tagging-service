package com.system.design.tagging.handler;

import com.system.design.tagging.data.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

//@Component
public class TagsHandler {

    //@Autowired
    private CassandraOperations cassandraOperations;

    public List<Tag> getAllTagsForContent(int productId, String contentId) {
        String sql = "SELECT * FROM tags WHERE product_id = " + productId + " and content_id = '" + contentId + "';";
        return cassandraOperations.select(sql, Tag.class);
    }

    public Tag addTag(Tag tag) {
        tag.setTimestamp(new Timestamp(Instant.now().toEpochMilli()));
        return cassandraOperations.insert(tag);
    }
}

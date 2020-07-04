package com.system.design.tagging.service;

import com.system.design.tagging.data.Tag;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@RestController
public class TagsService {

    @GetMapping("/tags")
    public List<Tag> getTags(@RequestParam(value = "productId") int productId,
                             @RequestParam(value = "contentId") String contentId) {
        return new LinkedList<>();
    }

    @PostMapping("/tags")
    public Tag createTag(@RequestBody Tag tag) {
        tag.setTimestamp(new Timestamp(Instant.now().toEpochMilli()));
        return tag;
    }
}

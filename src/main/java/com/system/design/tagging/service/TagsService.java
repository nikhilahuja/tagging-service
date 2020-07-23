package com.system.design.tagging.service;

import com.system.design.tagging.data.Product;
import com.system.design.tagging.data.Tag;
import com.system.design.tagging.db.ProductRepository;
import com.system.design.tagging.handler.ProductsHandler;
import com.system.design.tagging.handler.TagsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController
public class TagsService {

    @Autowired
    private TagsHandler tagsHandler;
    @Autowired
    private ProductsHandler productsHandler;

    @GetMapping("/tags")
    public List<Tag> getTags(@RequestParam(value = "productId") int productId,
                             @RequestParam(value = "contentId") String contentId) {
        return tagsHandler.getAllTagsForContent(productId, contentId);
    }

    @PostMapping("/tags")
    public Tag createTag(@RequestBody Tag tag) {
        return tagsHandler.addTag(tag);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productsHandler.getProducts();
    }
}

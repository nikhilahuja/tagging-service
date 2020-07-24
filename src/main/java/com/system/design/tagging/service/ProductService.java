package com.system.design.tagging.service;

import com.system.design.tagging.data.Product;
import com.system.design.tagging.db.ProductRepository;
import com.system.design.tagging.handler.ProductsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductService {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private ProductsHandler productsHandler;

    @GetMapping
    public List<Product> getAll() {
        return productsHandler.getProducts();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productsHandler.addNewProduct(product);
    }

    @GetMapping("/cache")
    public Map getCache() {
        return (Map) cacheManager.getCache("productsByName").getNativeCache();
    }
}

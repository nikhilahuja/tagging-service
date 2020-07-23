package com.system.design.tagging.handler;

import com.system.design.tagging.data.Product;
import com.system.design.tagging.db.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//@Component
public class ProductsHandler {

    //@Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        Iterable<Product> products = productRepository.findAll();
        return StreamSupport.stream(products.spliterator(), true).collect(Collectors.toList());
    }
}

package com.system.design.tagging.handler;

import com.system.design.tagging.data.Product;
import com.system.design.tagging.db.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductsHandler {

    @Autowired
    private ProductRepository productRepository;

    private static int NEXT_PRODUCT_ID = 1;

    @Cacheable(value = "products")
    public List<Product> getProducts() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productRepository.findAll();
    }

    @Cacheable(value = "productsByName", key = "#name.toLowerCase()", unless = "#result == null")
    public Product getProductByName(String name) {
        Optional<Product> product =
                getProducts().parallelStream().filter(p -> p.getProductName().equalsIgnoreCase(name)).findFirst();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return product.orElse(null);
    }

    @Cacheable(value = "productsByName", key = "#product.productName.toLowerCase()", unless = "#result == null")
    @CacheEvict(value = "products", allEntries = true, condition = "#result != null")
    public Product addNewProduct(Product product) {
        if (product.getProductName() != null && !product.getProductName().isEmpty()) {
            Product existingProduct = getProductByName(product.getProductName());
            if (existingProduct == null) {
                product.setProductId(NEXT_PRODUCT_ID);
                product = productRepository.save(product);
                NEXT_PRODUCT_ID++;
                return product;
            } else {
                return existingProduct;
            }
        }
        return null;
    }
}

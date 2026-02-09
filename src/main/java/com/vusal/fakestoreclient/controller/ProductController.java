package com.vusal.fakestoreclient.controller;

import com.vusal.fakestoreclient.dto.ProductDto;
import com.vusal.fakestoreclient.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.getProductById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/category/{category}")
    public List<ProductDto> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/filter-price")
    public List<ProductDto> filterPriceByPriceRange(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
        return productService.filterByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/search")
    public List<ProductDto> searchProducts(@RequestParam String keyword) {
        return productService.searchProduct(keyword);
    }

    @GetMapping("/top-rated")
    public List<ProductDto> getTopRatedProducts(@RequestParam Double minRate) {
        return productService.getTopRatedProducts(minRate);

    }
}

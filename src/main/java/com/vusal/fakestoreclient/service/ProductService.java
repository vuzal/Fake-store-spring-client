package com.vusal.fakestoreclient.service;

import com.vusal.fakestoreclient.dto.ProductDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    List<ProductDto> getProductsByCategory(String category);

    List<ProductDto> filterByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    List<ProductDto> searchProduct(String keyword);

    List<ProductDto> getTopRatedProducts(Double minRate);
}

package com.vusal.fakestoreclient.service;

import com.vusal.fakestoreclient.dto.ProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    String baseUrl="https://fakestoreapi.com/";
    private final RestTemplate restTemplate ;

    public ProductServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        String url=baseUrl+"/products";
        return Arrays.asList(restTemplate.getForObject(url, ProductDto[].class));
    }

    @Override
    public ProductDto getProductById(Long id) {
            String url = baseUrl + "/products/" + id;
            ProductDto product= restTemplate.getForObject(url, ProductDto.class);
            if (product==null){
                throw new RuntimeException("Product not found");
            }
            return product;

    }

    @Override
    public List<ProductDto> getProductsByCategory(String category) {
        String url=baseUrl+"/products/category/"+category;
        return Arrays.asList(restTemplate.getForObject(url, ProductDto[].class));
    }

    @Override
    public List<ProductDto> filterByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        String url=baseUrl+"/filter-price";
        return getAllProducts().stream()
                .filter(productDto -> productDto.getPrice().compareTo(minPrice)>=0&&productDto.getPrice().compareTo(maxPrice)<=0)
                .toList();
    }

    @Override
    public List<ProductDto> searchProduct(String keyword) {
        String url=baseUrl+"/search";
        return getAllProducts().stream()
                .filter(productDto -> productDto.getTitle().contains(keyword))
                .toList();
    }

    @Override
    public List<ProductDto> getTopRatedProducts(Double minRate) {
        String url=baseUrl+"/top-rated";
        return getAllProducts().stream()
                .filter(productDto -> productDto.getRating().getRate()>minRate)
                .toList();
    }
}

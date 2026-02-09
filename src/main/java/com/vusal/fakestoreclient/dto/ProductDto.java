package com.vusal.fakestoreclient.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {
    String id;
    String title;
    BigDecimal price;
    String description;
    String category;
    String image;
    RatingDto rating;
}

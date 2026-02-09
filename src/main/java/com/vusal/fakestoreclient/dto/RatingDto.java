package com.vusal.fakestoreclient.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RatingDto {
    Double rate;
    Integer count;
}

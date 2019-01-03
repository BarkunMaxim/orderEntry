package com.netcracker.barkun.web.dto.catalog;

import com.netcracker.barkun.web.dto.BaseDto;

import java.util.HashSet;
import java.util.Set;

public class OfferDto extends BaseDto {

    private Price price;

    private CategoryDto categoryDto;

    private String name;

    private String description;

    private Set<TagDto> tagSet = new HashSet<>();

    public OfferDto() {
    }


}

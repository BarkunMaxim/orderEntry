package com.netcracker.barkun.web.controller.dto;

import com.netcracker.barkun.entity.Offer;
import com.netcracker.barkun.entity.Price;
import com.netcracker.barkun.entity.Tag;

import java.util.*;
import java.util.stream.Collectors;

public class OfferDto extends BaseDto {

    private Price price;

    private CategoryDto categoryDto;

    private String name;

    private String description;

    private Set<TagDto> tagDtoSet = new HashSet<>();

    public OfferDto() {
    }

    private OfferDto(Offer offer) {
        this.setId(offer.getId());
        this.price = offer.getPrice();
        this.categoryDto = CategoryDto.convertFromCategory(offer.getCategory());
        this.name = offer.getName();
        this.description = offer.getDescription();
        this.tagDtoSet = convertFromTag(offer.getTagSet());

    }

    private Set<TagDto> convertFromTag(Set<Tag> tags) {
        if (tags != null) {
            return tags.stream()
                    .map(tag -> TagDto.convertFromTag(tag))
                    .collect(Collectors.toSet());
        }
        return null;
    }

    public static OfferDto convertFromOffer(Offer offer) {
        return new OfferDto(offer);
    }

    public static List<OfferDto> convertFromOffer(List<Offer> offers) {
        return offers.stream()
                .map(offer -> OfferDto.convertFromOffer(offer))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Price getPrice() {
        return price;
    }

    public CategoryDto getCategory() {
        return categoryDto;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<TagDto> getTagDtoSet() {
        return tagDtoSet;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setCategory(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTagDtoSet(Set<TagDto> tagDtoSet) {
        this.tagDtoSet = tagDtoSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OfferDto offerDto = (OfferDto) o;
        return Objects.equals(price, offerDto.price) &&
                Objects.equals(categoryDto, offerDto.categoryDto) &&
                Objects.equals(name, offerDto.name) &&
                Objects.equals(description, offerDto.description) &&
                Objects.equals(tagDtoSet, offerDto.tagDtoSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price, categoryDto, name, description, tagDtoSet);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OfferDto.class.getSimpleName() + "[", "]")
                .add("price=" + price)
                .add("categoryDto=" + categoryDto)
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("tagDtoSet=" + tagDtoSet)
                .toString();
    }
}

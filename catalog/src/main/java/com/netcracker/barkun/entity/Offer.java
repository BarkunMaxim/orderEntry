package com.netcracker.barkun.entity;

import com.netcracker.barkun.web.controller.dto.OfferDto;
import com.netcracker.barkun.web.controller.dto.TagDto;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "offer")
public class Offer extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private Price price;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    private String name;

    private String description;

    @ManyToMany(cascade = {CascadeType.ALL, CascadeType.ALL})
    @JoinTable(
            name = "offer_tag",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tagSet = new HashSet<>();

    public Offer() {

    }

    private Offer(OfferDto offerDto) {
        this.setId(offerDto.getId());
        this.price = offerDto.getPrice();
        this.category = Category.convertFromCategoryDto(offerDto.getCategory());
        this.name = offerDto.getName();
        this.description = offerDto.getDescription();
        this.tagSet = convertSetTagFromTagDto(offerDto.getTagDtoSet());
    }

    public Offer(Price price, Category category, String name, String description, Tag tag) {
        this.price = price;
        this.category = category;
        this.name = name;
        this.description = description;
        this.tagSet.add(tag);
    }

    public Offer(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private Set<Tag> convertSetTagFromTagDto(Set<TagDto> dtoSet) {
        if (dtoSet != null) {
            return dtoSet.stream()
                    .map(tagDto -> Tag.convertFromTagDto(tagDto))
                    .collect(Collectors.toSet());
        }
        return null;
    }

    public static Offer convertFromOfferDto(OfferDto offerDto) {
        return new Offer(offerDto);
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Tag> getTagSet() {
        return tagSet;
    }

    public void setTagSet(Set tagList) {
        this.tagSet = tagList;
    }

    public void addTag(Tag tag) {
        this.tagSet.add(tag);
        if (!checkTagOfferList(tag.getOfferList())) {
            tag.getOfferList().add(this);
        }
    }

    private boolean checkTagOfferList(List<Offer> offers) {
        return offers.stream().anyMatch(offer -> offer == this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Offer offer = (Offer) obj;
        return Objects.equals(name, offer.getName()) &&
                Objects.equals(description, offer.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Offer{");
        sb.append("price=").append(price);
        sb.append(", category=").append(category);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", tagList=").append(tagSet);
        sb.append('}');
        return sb.toString();
    }
}

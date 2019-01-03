package com.netcracker.barkun.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcracker.barkun.web.controller.dto.TagDto;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "tag")
public class Tag extends BaseEntity {

    private String tittle;

    @ManyToMany(mappedBy = "tagSet")
    @JsonIgnore
    private List<Offer> offerList = new ArrayList<>();

    public Tag() {
    }

    private Tag(TagDto tagDto ){
        this.setId(tagDto.getId());
        this.tittle = tagDto.getTittle();
    }

    public static Tag convertFromTagDto(TagDto tagDto){
        return new Tag(tagDto);
    }

    public static List<Tag> convertFromTagDto(List<TagDto> tagDto){
        return tagDto.stream()
                .map(o -> Tag.convertFromTagDto(o))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Tag(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public List<Offer> getOfferList() {
        return offerList;
    }

    public void setOfferList(List<Offer> offerList) {
        this.offerList = offerList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Tag tag = (Tag) obj;
        return Objects.equals(tittle, tag.tittle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tittle);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tittle=" + tittle + "\'" +
                ", offerList=" + offerList +
                '}';

    }

}

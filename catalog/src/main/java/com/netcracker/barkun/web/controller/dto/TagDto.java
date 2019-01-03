package com.netcracker.barkun.web.controller.dto;

import com.netcracker.barkun.entity.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class TagDto extends BaseDto {

    private String tittle;

    public TagDto() {
    }

    public TagDto(String tittle) {
        this.tittle = tittle;
    }

    private TagDto(Tag tag) {
        this.setId(tag.getId());
        this.tittle = tag.getTittle();
    }

    public static TagDto convertFromTag(Tag tag) {
        return new TagDto(tag);
    }

    public static List<TagDto> convertFromTag(List<Tag> tagList) {
        return tagList.stream()
                .map(o -> TagDto.convertFromTag(o))
                .collect(Collectors.toCollection(ArrayList::new));

    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TagDto tagDto = (TagDto) o;
        return Objects.equals(tittle, tagDto.tittle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tittle);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TagDto.class.getSimpleName() + "[", "]")
                .add("tittle='" + tittle + "'")
                .toString();
    }
}

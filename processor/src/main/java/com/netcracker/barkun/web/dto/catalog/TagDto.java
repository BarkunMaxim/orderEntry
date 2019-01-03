package com.netcracker.barkun.web.dto.catalog;

import com.netcracker.barkun.web.dto.BaseDto;

import java.util.Objects;
import java.util.StringJoiner;

public class TagDto extends BaseDto {

    private String tittle;

    public TagDto() {
    }

    public TagDto(String tittle) {
        this.tittle = tittle;
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

package com.netcracker.barkun.web.dto;

import java.util.Objects;
import java.util.StringJoiner;

public abstract class BaseDto {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseDto baseDto = (BaseDto) o;
        return Objects.equals(id, baseDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .toString();
    }
}

package com.netcracker.barkun.web.dto.inventory;

import com.netcracker.barkun.web.dto.BaseDto;

import java.util.Objects;
import java.util.StringJoiner;

public class OrderStatusDto extends BaseDto {

    private String title;

    public OrderStatusDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatusDto that = (OrderStatusDto) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderStatusDto.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .toString();
    }
}

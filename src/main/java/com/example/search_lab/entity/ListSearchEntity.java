package com.example.search_lab.entity;

import java.util.List;
import java.util.Objects;

public final class ListSearchEntity {

    private List<Integer> data;
    private Integer element;

    public ListSearchEntity() {
    }

    public ListSearchEntity(List<Integer> data, Integer element) {
        this.data = data;
        this.element = element;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    public Integer getElement() {
        return element;
    }

    public void setElement(Integer element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSearchEntity that = (ListSearchEntity) o;
        return Objects.equals(data, that.data) &&
                Objects.equals(element, that.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, element);
    }

    @Override
    public String toString() {
        return "ListSearchEntity{" +
                "data=" + data +
                ", element=" + element +
                '}';
    }
}

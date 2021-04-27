package com.example.search_lab.entity;

import java.util.List;
import java.util.Objects;

public final class ListCommonEntity {

    private List<Integer> first;
    private List<Integer> second;

    public ListCommonEntity() {
    }

    public ListCommonEntity(List<Integer> first, List<Integer> second) {
        this.first = first;
        this.second = second;
    }

    public List<Integer> getFirst() {
        return first;
    }

    public void setFirst(List<Integer> first) {
        this.first = first;
    }

    public List<Integer> getSecond() {
        return second;
    }

    public void setSecond(List<Integer> second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListCommonEntity that = (ListCommonEntity) o;
        return Objects.equals(first, that.first) &&
                Objects.equals(second, that.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "ListCommonEntity{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}

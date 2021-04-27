package com.example.search_lab.entity;

import java.util.Objects;

public final class StringSearchEntity {

    private String text;
    private String sample;

    public StringSearchEntity() {
    }

    public StringSearchEntity(String text, String sample) {
        this.text = text;
        this.sample = sample;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringSearchEntity that = (StringSearchEntity) o;
        return Objects.equals(text, that.text) &&
                Objects.equals(sample, that.sample);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, sample);
    }

    @Override
    public String toString() {
        return "StringSearchEntity{" +
                "text='" + text + '\'' +
                ", sample='" + sample + '\'' +
                '}';
    }
}

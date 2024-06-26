package com.deliveryhero.usersearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(indexName = "products")
public class ProductDocument {

    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String taste;

    @Field(type = FieldType.Double)
    private BigDecimal price;

    @Field(type = FieldType.Boolean)
    private Boolean isDiscounted;

    @Field(type = FieldType.Boolean)
    private Boolean isTrending;

    @Field(type = FieldType.Text)
    private String category;

//    @Field(type = FieldType.Date, format = DateFormat.date_time)
//    private LocalDateTime createdAt;
//
//    @Field(type = FieldType.Date, format = DateFormat.date_time)
//    private LocalDateTime updatedAt;

    @Field(type = FieldType.Double)
    private Double rating;

    @Field(type = FieldType.Integer)
    private Integer reviews;

    @Field(type = FieldType.Boolean)
    private Boolean availability;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getIsDiscounted() {
        return isDiscounted;
    }

    public void setIsDiscounted(Boolean isDiscounted) {
        this.isDiscounted = isDiscounted;
    }

    public Boolean getIsTrending() {
        return isTrending;
    }

    public void setIsTrending(Boolean isTrending) {
        this.isTrending = isTrending;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }

//    public LocalDateTime getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(LocalDateTime updatedAt) {
//        this.updatedAt = updatedAt;
//    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
package com.sample.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    @NotNull
    @Size(min = 1, max = 200)
    private String title;

    @Column(name = "description")
    @Size(max = 500)
    private String description;

    @Column(name = "price")
    @Min(0)
    private Long price;

    @Column(name = "image_url")
    private String imageUrl;

}
package com.loyalty3.loyalty3.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;
    @Column(nullable = false, unique = true)
    private String nameCategory;
}

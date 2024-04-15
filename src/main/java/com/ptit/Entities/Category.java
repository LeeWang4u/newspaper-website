package com.ptit.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Categories")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    @Id
    @Column(name="ID_Category")
    private int idCategory;

    @Column(name = "Category_Name")
    private String categoryName;

    @Column(name = "Describe")
    private String describe;

//    @OneToMany(mappedBy= "idCategory")
//    private Set<Post> posts;


    public Category(String category_Name, String describe) {
        this.categoryName = category_Name;
        this.describe = describe;
    }
}
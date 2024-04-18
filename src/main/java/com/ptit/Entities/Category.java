package com.ptit.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Categories")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_Category")
    private int idCategory;

    @Column(name = "Category_Name")
    private String categoryName;

    @Column(name = "Describe")
    private String describe;

//    @OneToMany
//    @JoinColumn(name="ID_Post")
//    // @Column(name = "ID_Post")
//    private Post idPost;
//

    public Category(String category_Name, String describe) {
        this.categoryName = category_Name;
        this.describe = describe;
    }
}
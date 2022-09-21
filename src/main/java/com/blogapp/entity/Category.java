package com.blogapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "category_id")
        private Long id;

        @Column(name = "category_title",length = 100, nullable = false)
        private String categoryTitle;

        @Column(name = "category_description")
        private String categoryDescription;
}

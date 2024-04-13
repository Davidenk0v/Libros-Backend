package com.backend.libros.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "id_author", nullable = false)
    private Author author;
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;
    private String urlImg;

    @Override
    public String toString(){
        return "Author: " + author + " Title: " + title + " Category: " + category + " UrlImg: " + urlImg;
    }
}

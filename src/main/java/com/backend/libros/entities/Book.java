package com.backend.libros.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
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
}

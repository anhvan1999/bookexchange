package com.scrum.bookexchange.book.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Setter(value=AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "book")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;

    private String path;
    
}

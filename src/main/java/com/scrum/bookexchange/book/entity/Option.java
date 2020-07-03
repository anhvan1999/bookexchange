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
public class Option {
    @Setter(value= AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "book")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;

    @Column(nullable = false)
    private String option;
}

package com.scrum.bookexchange.book.entity;

import com.scrum.bookexchange.security.entity.User;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Setter(value=AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private User owner;

    @OneToMany(mappedBy = "book")
    private Set<Image> images;

    @OneToMany(mappedBy = "book")
    private Set<BookOption> options;
}

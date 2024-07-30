package com.bookstore.jpa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TB_BOOK")
public class BookModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToOne // Muitos livros para uma editora
    @JoinColumn(name = "publisher") // especificar a chave estrangeira relacionado a tabela publisher
    private PublisherModel publisher;

    @ManyToMany
    @JoinTable(
            name = "tb_book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<AuthorModel> authors = new HashSet<>();

    // O book referencia esse mapeamento
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL) //Replicado para os relacionamernstos que estiverem considerando essa cascata
    private ReviewModel review;
}

package training.test.demo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "user_borrowed_books", // Nom de la table d'association
            joinColumns = @JoinColumn(name = "user_id"), // Colonne pour l'utilisateur
            inverseJoinColumns = @JoinColumn(name = "book_id") // Colonne pour le livre
    )

    private List<Book> borrowedBooks = new ArrayList<>();
}

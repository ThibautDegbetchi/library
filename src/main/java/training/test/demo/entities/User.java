package training.test.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
//    private Boolean connected;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

//    public Boolean getConnected() {
//        return connected;
//    }
//
//    public void setConnected(Boolean connected) {
//        this.connected = connected;
//    }



    @ManyToMany
    @JoinTable(
            name = "user_borrowed_books", // Nom de la table d'association
            joinColumns = @JoinColumn(name = "user_id"), // Colonne pour l'utilisateur
            inverseJoinColumns = @JoinColumn(name = "book_id") // Colonne pour le livre
    )

    private List<Book> borrowedBooks = new ArrayList<>();
}

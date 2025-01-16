package training.test.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import training.test.demo.entities.Book;

@Repository
public interface BookRepositrory extends JpaRepository<Book, Long> {

    @Query("Select b from Book b where b.title =:title")
    public Book findByTitle(@Param("title") String title);
}

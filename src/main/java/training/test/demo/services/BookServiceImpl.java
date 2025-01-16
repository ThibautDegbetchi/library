package training.test.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.test.demo.entities.Book;
import training.test.demo.repositories.BookRepositrory;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements  BookService {

    @Autowired
    private BookRepositrory bookRepositrory;
    public BookServiceImpl(BookRepositrory bookRepositrory){
        this.bookRepositrory=bookRepositrory;
    }
    @Override
    public Book save(Book book) {
        if (book.getId()!=null){
            Optional<Book> foundBook = bookRepositrory.findById(book.getId());
            if (foundBook.isPresent()){
                Book bookTamp=foundBook.get();
                bookTamp.setAuthor(book.getAuthor());
                bookTamp.setTitle(book.getTitle());
                bookTamp.setDescription(book.getDescription());
                return bookRepositrory.save(bookTamp);
            }
        }
        return bookRepositrory.save(book);
    }

    @Override
    public List<Book> getList() {
        return bookRepositrory.findAll();
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepositrory.findByTitle(title);
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> foundBook=bookRepositrory.findById(id);
        if (foundBook.isPresent()){
            return foundBook.get();
        }
        return null;
    }

    @Override
    public Book update(Book book){
        Optional<Book> foundBook=bookRepositrory.findById(book.getId());
        if (foundBook.isPresent()){
            Book bookTamp=foundBook.get();
            book.setAuthor(bookTamp.getAuthor());
            book.setTitle(bookTamp.getTitle());
            book.setDescription(bookTamp.getDescription());
            return bookRepositrory.save(book);
        }
        return  null;
    };
    @Override
    public void delete(Long id) {
        Book book=bookRepositrory.findById(id).get();
        bookRepositrory.delete(book);
    }
}

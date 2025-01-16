package training.test.demo.services;


import training.test.demo.entities.Book;

import java.util.List;

public interface BookService {
    public Book save(Book book);
    public List<Book> getList();
    public Book findByTitle(String name);
    public Book findById(Long id);
    public Book update(Book book);
    public void delete(Long id);
}

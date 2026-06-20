package book;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    Book findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);

    void deleteByIsbn(String isbn);

    List<Book> findAll();

    int count();

}

package book;

import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void register(Book book) {
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new DuplicateBookException("이미 등록된 책");
        } else {
            bookRepository.save(book);
        }
    }

    public Book findByIsbn(String isbn) {
        if (bookRepository.existsByIsbn(isbn)) {
            return bookRepository.findByIsbn(isbn);
        } else {
            throw new BookNotFoundException("책을 찾을 수 없음");
        }
    }

    public void changePrice(String isbn, int newPrice) {
        Book book = bookRepository.findByIsbn(isbn);
        book.changePrice(newPrice);
    }

    public void deleteByIsbn(String isbn) {
        if (bookRepository.existsByIsbn(isbn)) {
            bookRepository.deleteByIsbn(isbn);
        } else {
            throw new IllegalArgumentException("책을 찾을 수 없음");
        }
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public int count() {
        return bookRepository.count();
    }

}

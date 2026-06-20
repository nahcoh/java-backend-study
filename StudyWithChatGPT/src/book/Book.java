package book;

public class Book {

    private final String isbn;
    private final String title;
    private int price;

    public Book(String isbn, String title, int price) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN은 비어 있으면 안됨");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("제목이 비면 안됨");
        }
        if ((price <= 0)) {
            throw new IllegalArgumentException("가격은 음수가 불가");
        }

        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void changePrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("가격은 음수 불가");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
            "isbn='" + isbn + '\'' +
            ", title='" + title + '\'' +
            ", price=" + price +
            '}';
    }
}

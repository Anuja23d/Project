package Book;

public class Book extends BookItem {
    public Book(String title, String author, BookType type, String ISBN, int publicationYear) {
        super(title, author, type, ISBN, publicationYear);
    }

    // equals and hashCode based on ISBN
}
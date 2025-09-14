package Book;
public abstract class BookItem {
    private String title;
    private String author;
    private BookType type;
    private String ISBN;
    private int publicationYear;

    public BookItem(String title, String author, BookType type, String ISBN, int publicationYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
    }

    public BookType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }
}

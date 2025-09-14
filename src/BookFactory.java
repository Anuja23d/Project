import Book.Book;
import Book.BookType;

public class BookFactory {

	public static Book createBook(String title, String author, BookType type, String isbn, int publicationYear) {
// Future: you can add different subclasses if needed
		return new Book(title, author, type, isbn, publicationYear);
	}
}

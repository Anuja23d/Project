package Library;
import java.util.List;

import Book.BookItem;

public interface Searchable {
	List<BookItem> searchByTitle(String title);
    List<BookItem> searchByAuthor(String author);
    BookItem searchByISBN(String isbn);
}

package Library;

import java.util.List;

import Book.BookItem;
import Transaction.Patron;

public interface InventoryManagement {
	
	void addPatron(Patron patron);
	
	void addItem(BookItem item);

	void removeItem(BookItem item);

	void updateItem(BookItem oldItem, BookItem newItem);

	boolean isAvailable(BookItem item);

	List<BookItem> getAvailableItems();
}

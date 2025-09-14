package Library;
import java.util.*;

import Book.BookType;
import Transaction.Patron;
import Book.BookItem;

public class LibraryInventory implements InventoryManagement, Searchable {

	private Map<BookType, Set<BookItem>> books;

	private Map<String, Patron> patrons ;

	public LibraryInventory() {
		books = new HashMap<>();
		for (BookType type : BookType.values()) {
			books.put(type, new HashSet<>());
		}
	}

	public void addItem(BookItem item) {
		books.get(item.getType()).add(item);
	}

	public void removeItem(BookItem item) {
		books.get(item.getType()).remove(item);
	}

	public void updateItem(BookItem oldItem, BookItem newItem) {
		removeItem(oldItem);
		addItem(newItem);
	}

	public boolean isAvailable(BookItem item) {
		return books.get(item.getType()).contains(item);
	}

	public List<BookItem> getAvailableItems() {
		List<BookItem> result = new ArrayList<>();
		for (Set<BookItem> items : books.values()) {
			result.addAll(items);
		}
		return result;
	}

	// --- Search methods ---
	public List<BookItem> searchByTitle(String title) {
		return getAvailableItems().stream().filter(item -> item.getTitle().equalsIgnoreCase(title)).toList();
	}

	public BookItem searchByISBN(String isbn) {
		return getAvailableItems().stream().filter(item -> item.getISBN().equals(isbn)).findFirst().orElse(null);
	}

	@Override
	public List<BookItem> searchByAuthor(String author) {
		return getAvailableItems().stream().filter(item -> item.getAuthor().equals(author)).toList();
	}

	@Override
	public void addPatron(Patron newPatron) {
		String patronId = newPatron.getId();

		if (!patrons.containsKey(patronId)) {
			patrons.put(patronId, newPatron);
			System.out.println("Patron added: " + newPatron.getName());
		} else {
			Patron existing = patrons.get(patronId);

			if (existing.isInfoDifferentFrom(newPatron)) {
				existing.setName(newPatron.getName());
				existing.setAddress(newPatron.getAddress());
				System.out.println(" Patron info updated: " + existing.getName());
			} else {
				System.out.println("Patron already exists. No changes needed.");
			}
		}
	}

	
}

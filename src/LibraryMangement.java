import Book.Book;
import Book.BookType;
import Library.Library;
import Library.LibraryInventory;
import Transaction.Patron;

public class LibraryMangement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Library library = new Library(1, "library1", "mumbai", new LibraryInventory());
		// Add books
		Book book1 = new Book("Title1", "Author1", BookType.FICTION, "ISBN001", 2020);

		Book book2 = new Book("Title2", "Author2", BookType.FICTION, "ISBN002", 2021);
		library.getLibraryInventory().addItem(book1);
		// using factory design
		// Create Book using Factory Method
		Book b1 = BookFactory.createBook("Effective Java", "Joshua Bloch", BookType.SCIENCE, "12345", 2018);
		library.getLibraryInventory().addItem(b1);

		// Add patrons
		Patron patron1 = new Patron("Alice", "P001", "123 Main St");

		patron1.checkoutItem(b1, library.getLibraryInventory());
		Patron patron2 = new Patron("Ana", "P002", "127 Main St");

	}

}

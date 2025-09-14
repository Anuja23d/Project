package Transaction;

import java.util.*;

import Book.BookItem;
import Book.BookType;
import Library.InventoryManagement;

public class Patron {
    private String name;
    private String id;
    private String address;
    private Map<BookType, Set<BookItem>> borrowedItems;
    private List<Transaction> borrowingHistory;

    public List<Transaction> getBorrowingHistory() {
		return borrowingHistory;
	}

	public Patron(String name, String id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
        borrowedItems = new HashMap<>();
        for (BookType type : BookType.values()) {
            borrowedItems.put(type, new HashSet<>());
        }
    }

    public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public Map<BookType, Set<BookItem>> getBorrowedItems() {
		return borrowedItems;
	}
	
	 public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isInfoDifferentFrom(Patron other) {
	        return !this.name.equals(other.getName()) ||
	               !this.address.equals(other.getAddress());
	    }

	public void checkoutItem(BookItem item, InventoryManagement inventory) {
        if (inventory.isAvailable(item)) {
            borrowedItems.get(item.getType()).add(item);
            inventory.removeItem(item);
            System.out.println("Checked out: " + item.getTitle());
        } else {
            System.out.println("Item not available.");
        }
    }

    public void returnItem(BookItem item, InventoryManagement inventory) {
        if (borrowedItems.get(item.getType()).remove(item)) {
            inventory.addItem(item);
            System.out.println("Returned: " + item.getTitle());
        } else {
            System.out.println("Item not borrowed by this patron.");
        }
    }
}


package Library;

public class Library {

	private int id;
	private String name;
	private String address;
	private LibraryInventory libraryInventory;
	
	public Library(int id, String name, String address, LibraryInventory libraryInventory) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.libraryInventory = libraryInventory;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public LibraryInventory getLibraryInventory() {
		return libraryInventory;
	}
	
	 
	
	
}

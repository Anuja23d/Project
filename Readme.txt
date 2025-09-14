+--------------------+          +----------------------+
|      Library       |1        1|   LibraryInventory   |
+--------------------+---has a-------+----------------------+
| - name: String     |          | - books: Map<BookType,|
| - libraryId: String|          |          Set<BookItem>>|
| - address: String  |          | - patrons: Map<String,|
|                    |          |          Patron>      |
+--------------------+          +----------------------+
                               /|\ implements
                                |
        +-----------------------+-------------------------+
        |                                                 |
+---------------------------+           +---------------------------+
|   InventoryManagement     |           |        Searchable         |
+---------------------------+           +---------------------------+
| + addPatron(p: Patron)   |           | + searchByTitle(t:String) |
| + addItem(i: BookItem)   |           | + searchByAuthor(a:String)|
| + removeItem(i: BookItem)|           | + searchByISBN(i:String)  |
| + updateItem(o:BookItem, |           +---------------------------+
|        n:BookItem)       |
| + isAvailable(i:BookItem):boolean    |
| + getAvailableItems():List<BookItem> |
+--------------------------------------+

+---------------------------+
|         BookItem          |<<abstract>>
+---------------------------+
| - ISBN: String            |
| - publicationYear: int    |
| - title: String           |
| - author: String          |
| - bookType: BookType      |
+---------------------------+

+---------------------------+
|          Patron           |
+---------------------------+
| - name: String            |
| - id: String              |
| - address: String         |
| - borrowedItems: Map<BookType,|
|                  Set<BookItem>>|
| - borrowingHistory: List<Transaction>|
+---------------------------+

+---------------------------+
|        Transaction        |
+---------------------------+
| // details of borrow/return|
+---------------------------+

+---------------------------+
|         BookType          |
+---------------------------+
| <<enumeration>>           |
| e.g., FICTION, NONFICTION |
|        SCIENCE, etc.      |
+---------------------------+

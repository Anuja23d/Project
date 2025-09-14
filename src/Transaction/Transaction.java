package Transaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import Book.Book;

public class Transaction {
    private String transactionId;
    private Patron patron;
    private List<Book> books;
    private Date issueDate;
    private Date dueDate;
    private Date returnDate;
    private BookStatus status;

    public Transaction(String transactionId, Patron patron, List<Book> books, Date issueDate, Date dueDate) {
        this.transactionId = transactionId;
        this.patron = patron;
        this.books = new ArrayList<>(books);
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.status = BookStatus.CHECKOUT;
    }

    public void markReturned(Date returnDate) {
        this.returnDate = returnDate;
        this.status = BookStatus.RETURNED;
    }

    public boolean isOverdue() {
        return returnDate != null && returnDate.after(dueDate);
    }

    public double calculateFine() {
        if (isOverdue()) {
            long daysLate = (returnDate.getTime() - dueDate.getTime()) / (1000 * 60 * 60 * 24);
            return daysLate * 2.0; // $2 per day late
        }
        return 0;
    }

    public Patron getPatron() {
        return patron;
    }

    public List<Book> getbooks() {
        return Collections.unmodifiableList(books);
    }

    public BookStatus getStatus() {
        return status;
    }
}

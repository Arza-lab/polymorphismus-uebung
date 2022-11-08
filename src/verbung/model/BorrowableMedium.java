package verbung.model;

import java.util.Date;

public class BorrowableMedium {

    boolean isBorrowed;
    Date borrowedUntil;

    public static final int MAX_BORROWING_DURATION = 30;

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public Date getBorrowedUntil() {
        return borrowedUntil;
    }

    public void setBorrowedUntil(Date borrowedUntil) {
        this.borrowedUntil = borrowedUntil;
    }

    public void borrowUntil(Date untilDate){
        this.isBorrowed = true;
        this.borrowedUntil = untilDate;
    };

    public boolean canBeBorrowed(Date date){
        return !isBorrowed && !date.after(borrowedUntil);
    };

    // public abstract void returnMedium();
}

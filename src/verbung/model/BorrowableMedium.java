package verbung.model;

import java.util.Date;

public class BorrowableMedium {

    boolean isBorrowed;
    Date borrowedUntil = new Date();

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
        if (borrowedUntil == null){
            return true;
        }

        // check if date exceeds the maximum borrowing duration
        long diff = date.getTime() - borrowedUntil.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        if (diffDays > MAX_BORROWING_DURATION){
            return false;
        }

        return !this.isBorrowed && borrowedUntil.before(date);
    };

    // public abstract void returnMedium();
}

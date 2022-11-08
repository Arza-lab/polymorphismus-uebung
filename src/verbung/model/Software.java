package verbung.model;

public class Software extends BorrowableMedium {

    public static final int MAX_BORROWING_DURATION = 7;

    @Override
    protected int getMaximumBorrowingDuration() {
        return MAX_BORROWING_DURATION;
    }
}

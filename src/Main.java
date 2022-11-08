import verbung.model.BorrowableMedium;

import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        testBorrowableMedium();
        testVideo();

    }

    public static void testBorrowableMedium(){
        BorrowableMedium medium = new BorrowableMedium();

        // heute in 15 Tagen
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 15);

        System.out.println("Heute in 15 Tagen. Medium kann ausgeliehen werden: " + medium.canBeBorrowed(cal.getTime()));

        // heute in 30 Tagen
        cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);

        System.out.println("Heute in 30 Tagen. Medium kann ausgeliehen werden: " + medium.canBeBorrowed(cal.getTime()));


        // heute in 31 Tagen
        cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 31);

        System.out.println("Heute in 31 Tagen. Medium kann ausgeliehen werden: " + medium.canBeBorrowed(cal.getTime()));
    }

    public static void testVideo (){
        Video video = new Video();
        video.setProducer("Hans Meier");
        System.out.println("Producer: " + video.getProducer());

        // borrow video until 15 days
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 15);
        video.borrowUntil(cal.getTime());

        System.out.println("Medium ist ausgeliehen: " + video.isBorrowed());
    }

}

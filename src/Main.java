import verbung.model.BorrowableMedium;
import verbung.model.Software;
import verbung.model.Video;

import java.util.ArrayList;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        testBorrowableMedium();
        testVideo();
        testSoftware();
        testPolymorphie();

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

    public static void testSoftware (){
        Software software = new Software();

        // borrow software until 15 days
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 15);

        System.out.println("Software kann ausgeliehen werden (15 Tage): " + software.canBeBorrowed(cal.getTime()));
    }

    public static void testPolymorphie(){
        // arraylist of borrowable media
        ArrayList<BorrowableMedium> media = new ArrayList<BorrowableMedium>();

        // add video
        Video video = new Video();
        video.setProducer("Hans Meier");
        media.add(video);

        // add software
        Software software = new Software();
        media.add(software);

        // for each borrowable medium
        for (BorrowableMedium medium : media){
            // borrow medium until 15 days
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, 5);

            //type of medium
            String type = medium.getClass().getSimpleName();

            System.out.println("Polymorphie:" + type);
            System.out.println("(5 Tage)Medium kann ausgeliehen werden: " + medium.canBeBorrowed(cal.getTime()));

            // borrow medium until 9 days
            cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, 9);

            System.out.println("(9 Tage)Medium kann ausgeliehen werden: " + medium.canBeBorrowed(cal.getTime()));

            // borrow medium until 27 days
            cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, 27);

            System.out.println("(27 Tage)Medium kann ausgeliehen werden: " + medium.canBeBorrowed(cal.getTime()));

            // borrow medium until 50 days
            cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, 50);

            System.out.println("(50 Tage)Medium kann ausgeliehen werden: " + medium.canBeBorrowed(cal.getTime()));
        }
    }

}

package MP1;

import java.awt.print.Book;
import java.io.*;
import java.time.LocalDate;

public class MainRead {

    public static void main(String[] args) throws Exception {

        WorkerExtent workerExtent = new WorkerExtent();
        Booking booking = new Booking();


        try {

            ObjectInputStream workers = new ObjectInputStream(new FileInputStream("workers.txt"));
            workerExtent.readExtent(workers);
            workers.close();

            ObjectInputStream bookings = new ObjectInputStream(new FileInputStream("bookings.txt"));
            booking.readExtent(bookings);
            bookings.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        workerExtent.showExtent();
        workerExtent.showSalary();

        booking.showExtent();


    }
}

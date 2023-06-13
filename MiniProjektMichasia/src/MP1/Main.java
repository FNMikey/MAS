package MP1;

import javax.swing.*;
import java.awt.print.Book;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        Client client = new Client(
                new ArrayList<String>(List.of("Michał")),
                "Konieczny",
                LocalDate.of(1998, 05, 11),
                "mail",
                "slabeHaslo",
                10);

        Client client2 = new Client(
                new ArrayList<String>(List.of("Michał")),
                "Konieczny",
                LocalDate.of(1998, 05, 11),
                "innyMail",
                "slabeHaslo",
                10);

        Booking bookingExtent = new Booking();

        Hotel hotel = new Hotel("LAS", "Koszykowa 82", 123, 5, "bardzo fajny hotel");

        Booking booking = new Booking(1, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 1000, hotel);
        Booking booking1 = new Booking(2, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 2000, hotel);
        Booking booking2 = new Booking(3, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 2000, hotel);

        //Booking.addToExtent(booking);
        //Booking.addToExtent(booking1);
        //Booking.addToExtent(booking2);

        booking.addClient(client);
        booking1.addClient(client);
        booking2.addClient(client2);

        WorkerExtent workerExtent = new WorkerExtent();

        Hotel.Room room = hotel.addRoom(1, 2, 3, 4, "over sea", "b", true, false);

        room.toString();

        Worker w = new Worker(
                new ArrayList<String>(List.of("Jakub", "Filip")),
                "Konieczny",
                LocalDate.of(1996, 05, 11),
                1,
                3000,
                "bartender",
                "jest",
                LocalDate.of(2018, 05, 11),
                20,
                hotel);

        WorkerBooking workerBooking = new WorkerBooking(LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), w, booking);


        w.addWorkerBooking(workerBooking);
        booking.addWorkerBooking(workerBooking);


        Worker w2 = new Worker(
                new ArrayList<String>(List.of("Michał", "Tomasz")),
                "Konieczny",
                LocalDate.of(1998, 05, 11),
                2,
                6000,
                "recepcjonista",
                "jest",
                LocalDate.of(2018, 05, 11),
                20,
                5000, hotel);


        Worker w3 = new Worker(
                new ArrayList<String>(List.of("Jan", "Adam", "Mariusz")),
                "Konieczny",
                LocalDate.of(1998, 05, 11),
                3,
                2000,
                "director",
                "jest",
                LocalDate.of(2018, 05, 11),
                20,
                7000, hotel);

        workerExtent.addWorker(w);
        workerExtent.addWorker(w2);
        workerExtent.addWorker(w3);


        try {

            ObjectOutputStream workers = new ObjectOutputStream(new FileOutputStream("workers.txt"));
            workerExtent.writeExtent(workers);
            workers.close();

            ObjectOutputStream bookings = new ObjectOutputStream(new FileOutputStream("bookings.txt"));
            Booking.writeExtent(bookings);
            bookings.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


        workerExtent.showExtent();
        workerExtent.showSalary();

        System.out.println("----------------------------------------------");

        Booking.showExtent();


    }

}

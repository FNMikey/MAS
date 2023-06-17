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
                "haslo",
                10);

        Client client2 = new Client(
                new ArrayList<String>(List.of("Michał")),
                "Konieczny",
                LocalDate.of(1998, 05, 11),
                "innyMail",
                "haslo",
                10);

        Hotel hotel = new Hotel("LAS", "Koszykowa 82", 123, 5, "bardzo fajny hotel");

        Booking booking = new Booking(1, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 1000, hotel, "w trakcie");
        Booking booking1 = new Booking(2, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 3000, hotel, "w trakcie");
        Booking booking2 = new Booking(3, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 500, hotel, "w trakcie");
        Booking booking3 = new Booking(4, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 1000, hotel, "w trakcie");
        Booking booking4 = new Booking(5, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 2345, hotel, "w trakcie");
        Booking booking5 = new Booking(6, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 1908, hotel, "w trakcie");
        Booking booking6 = new Booking(7, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 1999, hotel, "w trakcie");
        Booking booking7 = new Booking(8, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 6000, hotel, "w trakcie");
        Booking booking8 = new Booking(9, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 7500, hotel, "w trakcie");
        Booking booking9 = new Booking(10, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 800, hotel, "w trakcie");
        Booking booking10 = new Booking(11, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 2000, hotel, "w trakcie");
        Booking booking11 = new Booking(12, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 2000, hotel, "w trakcie");
        Booking booking12 = new Booking(13, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 2000, hotel, "w trakcie");
        Booking booking13 = new Booking(14, LocalDate.of(1998, 05, 11), LocalDate.of(1998, 05, 11), 2000, hotel, "w trakcie");

        booking.addClient(client);
        booking1.addClient(client);
        booking2.addClient(client);
        booking3.addClient(client);
        booking4.addClient(client);
        booking5.addClient(client);
        booking6.addClient(client);
        booking7.addClient(client);
        booking8.addClient(client);
        booking9.addClient(client);
        booking10.addClient(client);
        booking11.addClient(client2);
        booking12.addClient(client2);
        booking13.addClient(client2);

        WorkerExtent workerExtent = new WorkerExtent();

        Hotel.Room room = hotel.addRoom(1, 2, 3, 4,1000, "over sea", "b", true, false);

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

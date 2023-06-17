package MP1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Booking implements Serializable {

    private int id;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private int price;
    private Client client;
    public List<WorkerBooking> workerBookings = new ArrayList<>();
    public static List<Booking> bookings = new ArrayList<>();
    private Hotel hotel;

    private String status;

    public Booking() {

    }
    public Booking(int ID, LocalDate dateFrom, LocalDate dateTo, int price, Hotel hotel, String status) throws Exception {

        if (!isUnique(ID)) throw new Exception("Booking ID has to be unique");
        this.id = ID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        bookings.add(this);
        this.hotel = hotel;
        hotel.addBooking(this);
        this.status = status;
    }

    //asocjacja kwalifikowana
    public void addClient(Client newClient) throws Exception {
        if (Objects.isNull(newClient)) {
            throw new Exception("Client can't be a null");
        }

        if (client != (newClient)) {
            this.client = (newClient);

            System.out.println("Client added correctly");

            //polaczenie zwrotne
            newClient.addBooking(this);
        }
    }

    public void removeClient(Client client) throws Exception{

        if (Objects.isNull(client)) {
            throw new Exception("Client can't be a null");
        }

        if (this.client == null) {
            throw new Exception("There is no client assigned to this booking");
        }

        this.client = null;
        //polaczenie zwrotne
        client.removeBooking(this);

    }

    //asocjacja z atrybutem
    public void addWorkerBooking(WorkerBooking workerBooking) throws Exception {
        if (Objects.isNull(workerBooking)) {
            throw new Exception("WorkerBooking can't be a null");
        }
        if (!workerBookings.contains(workerBooking)) {

            workerBookings.add(workerBooking);
            workerBooking.addBooking(this);

        }

    }

    public void removeWorkerBooking(WorkerBooking workerBooking) throws Exception{

        if (Objects.isNull(workerBooking)) {
            throw new Exception("WorkerBooking can't be a null");
        }
        if (!workerBookings.contains(workerBooking)) {
            throw new Exception("There is no working booking like that");
        }

        workerBookings.remove(workerBooking);
        workerBooking.removeBooking(this);

    }

    public boolean isUnique(int ID) {

        for (Booking b : bookings) {
            if (b.id == ID) {
                return false;
            }
        }
        return true;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public Client getClient() {
        return client;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public static List<Booking> getBookings() {
        return bookings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(bookings);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        bookings = (ArrayList<Booking>) stream.readObject();
    }

    public static void addToExtent (Booking booking){

        bookings.add(booking);

    }

    public static void showExtent() {

        System.out.println("Extent of the class: " + Booking.class.getName());

        for (Booking booking : bookings) {
            System.out.println(
                    "ID: " + booking.id +
                    ", Price: " + booking.price +
                    ", Date to: " + booking.getDateTo().toString()
            );
        }

    }

    @Override
    public String toString() {
        return  "Start date= " + dateFrom +
                ", End date= " + dateTo +
                ", Cost= " + price +
                ", Hotel= " + hotel.getName() +
                ", Status= " + status;
    }

}

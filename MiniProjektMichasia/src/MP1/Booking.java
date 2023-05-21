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
    private List<Client> clients = new ArrayList<>();
    public List<WorkerBooking> workerBookings = new ArrayList<>();
    public static List<Booking> BOOKINGS = new ArrayList<>();

    public Booking(int ID, LocalDate dateFrom, LocalDate dateTo, int price) throws Exception {

        if (!isUnique(ID)) throw new Exception("Booking ID has to be unique");
        this.id = ID;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        BOOKINGS.add(this);
    }

    //asocjacja kwalifikowana
    public void addClient(Client newClient) throws Exception {
        if (Objects.isNull(newClient)) {
            throw new Exception("Client can't be a null");
        }

        if (!clients.contains(newClient)) {
            clients.add(newClient);

            System.out.println("Client added correctly");

            //polaczenie zwrotne
            newClient.addBooking(this);
        }
    }

    public void removeClient(Client client) throws Exception{

        if (Objects.isNull(client)) {
            throw new Exception("Client can't be a null");
        }

        if (!clients.contains(client)) {
            throw new Exception("There is no client assigned to this booking");
        }

        clients.remove(client);
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

        for (Booking b : BOOKINGS) {
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

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(BOOKINGS);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        BOOKINGS = (ArrayList<Booking>) stream.readObject();
    }

    public static void showExtent() {

        System.out.println("Extent of the class: " + Booking.class.getName());

        for (Booking booking : BOOKINGS) {
            System.out.println(
                    "ID: " + booking.id +
                    ", Price: " + booking.price +
                    ", Date to: " + booking.getDateTo().toString()
            );
        }

    }
}

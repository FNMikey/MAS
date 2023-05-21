package MP1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Client extends Person implements Serializable {

    private String mail;
    private String password;
    private int discount;
    private Map<Integer, Booking> map = new TreeMap<>();

    public Client(ArrayList<String> names, String surname, LocalDate birthDate, String mail, String password, int discount) {
        super(names, surname, birthDate);
        this.mail = mail;
        this.password = password;
        this.discount = discount;
    }

    public Client(ArrayList<String> names, String surname, LocalDate birthDate, String mail, String password) {
        super(names, surname, birthDate);
        this.mail = mail;
        this.password = password;
    }

    //asocjacja kwalifikowana
    public void addBooking(Booking newBooking) throws Exception {
        if (Objects.isNull(newBooking)) {
            throw new Exception("Booking can't be a null");
        }
        if (!map.containsKey(newBooking.getID())) {
            map.put(newBooking.getID(), newBooking);

            System.out.println("Booking added correctly");

            //połączenie zwrotne
            newBooking.addClient(this);

        }
    }

    public void removeBooking(Booking booking) throws Exception{

        if (Objects.isNull(booking)) {
            throw new Exception("Booking can't be a null");
        }
        if (!map.containsKey(booking.getID())){

            throw new Exception("There is no booking assigned to this client");
        }

        map.remove(booking.getID());

        booking.removeClient(this);

    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}

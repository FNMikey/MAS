import MP1.Booking;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GUI extends JFrame {

    private JPanel MainPanel;
    private JList list;
    private JPanel RootPanel;
    private JPanel PanelTop;
    private JPanel PanelRight;
    private JPanel PanelLeft;
    private JPanel PanelCenter;
    private JPanel PanelCBottom;

    public GUI () {
        Booking bookingExtent = new Booking();

        try {
            ObjectInputStream bookings = new ObjectInputStream(new FileInputStream("bookings.txt"));
            bookingExtent.readExtent(bookings);
            bookings.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        DefaultListModel<String> bookingList = new DefaultListModel<>();

        for ( Booking booking : bookingExtent.BOOKINGS) {
            bookingList.addElement(Integer.toString(booking.getID()) +  " " + booking.getDateFrom() + " " + booking.getDateTo());
        }


        list.setModel(bookingList);
        list.setSelectionMode(1);

        setContentPane(MainPanel);

        setTitle("Window");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        setVisible(true);

    }

    public static void main(String[] args) {

        new GUI();

    }

}

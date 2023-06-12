package MP1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MyApp extends JFrame{
    private JPanel MainPanel;
    private JPanel RootPanel;
    private JPanel LeftPanel;
    private JPanel RightPanel;
    private JPanel TopPanel;
    private JPanel DownPanel;
    private JPanel CenterPanel;
    private JButton LoginButton;
    private JButton ViewBooking;
    private JPanel LoginPane;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel BookingsPane;
    private JList bookingList;
    private JPanel DetailsPane;
    private JButton ViewDetailsButton;
    private JButton DeleteButton;
    private JButton SaveButton;

    private final CardLayout cardLayout = (CardLayout)CenterPanel.getLayout();


    public MyApp(){

        Dimension minSize = new Dimension(1000, 500);

        setContentPane(MainPanel);

        setTitle("App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setResizable(true);
        setVisible(true);
        setMinimumSize(minSize);

        Booking bookingExtent = new Booking();
        try {
            ObjectInputStream bookings = new ObjectInputStream(new FileInputStream("bookings.txt"));
            bookingExtent.readExtent(bookings);
            bookings.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        DefaultListModel<Booking> model = new DefaultListModel<>();

        for (Booking booking : bookingExtent.BOOKINGS) {
            model.addElement(booking);
        }

        bookingList.setModel(model);

        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(CenterPanel, "BookingsCard");

            }
        });

    }


    public static void main(String[] args) {
        new MyApp();


    }

}

package MP1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoginScreen extends  JFrame{
    private JPanel MainPanel;
    private JPanel RootPanel;
    private JTextField mailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private HashMap<String, String> accounts = new HashMap<>();

    public LoginScreen(){

        setContentPane(RootPanel);

        setTitle("Login Screen");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setResizable(false);
        setVisible(true);

        Booking bookingExtent = new Booking();
        try {
            ObjectInputStream bookings = new ObjectInputStream(new FileInputStream("bookings.txt"));
            bookingExtent.readExtent(bookings);
            bookings.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (Booking booking: bookingExtent.bookings) {

            accounts.put(booking.getClient().getMail(), booking.getClient().getPassword());

        }

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String pwd = new String(passwordField.getPassword());

                if (accounts.containsKey(mailField.getText()) && accounts.get(mailField.getText()).equals(pwd)) {

                    dispose();
                    new MyApp(mailField.getText(), bookingExtent);

                }else {

                    JOptionPane.showMessageDialog(new JFrame(), "Wrong mail or password");


                }



            }
        });


    }


    public static void main(String[] args) {
        new LoginScreen();
    }
}

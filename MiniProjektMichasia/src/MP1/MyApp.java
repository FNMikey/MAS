package MP1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MyApp extends JFrame{
    private JPanel MainPanel;
    private JPanel RootPanel;
    private JPanel LeftPanel;
    private JPanel RightPanel;
    private JPanel TopPanel;
    private JPanel DownPanel;
    private JPanel CenterPanel;
    private JButton ViewBooking;
    private JPanel BookingsPane;
    private JList bookingJList;
    private JPanel DetailsPane;
    private JButton ViewDetailsButton;
    private JButton DeleteButton;
    private JButton SaveButton;
    private JButton LogoutButton;
    private JLabel yourBookingLabel;
    private JPanel TopRightPanel;
    private JLabel spacer;
    private JLabel youBookingsLabel;
    private JLabel bookingStatus;
    private JLabel bookingDateFrom;
    private JLabel bookingDateTo;
    private JLabel bookingPrice;
    private final CardLayout cardLayout = (CardLayout)CenterPanel.getLayout();
    private Booking selectedItem = new Booking();

    private ArrayList<Booking> bookingArrayList= new ArrayList();

    public MyApp(String mail, Booking bookingExtent){



        Dimension minSize = new Dimension(1000, 500);

        setContentPane(MainPanel);

        setTitle("App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setResizable(true);
        setVisible(true);
        setMinimumSize(minSize);

        DefaultListModel<Booking> model = new DefaultListModel<>();

        for (Booking booking : bookingExtent.bookings) {

            if(mail.equals(booking.getClient().getMail())){

            model.addElement(booking);

            }
        }
        bookingJList.setModel(model);

        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginScreen();
            }
        });
        ViewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               selectedItem =  model.get(bookingJList.getSelectedIndex());


               bookingDateFrom.setText("Date from: " + selectedItem.getDateFrom().toString());
               bookingDateTo.setText("Date to: " + selectedItem.getDateTo().toString());
               bookingPrice.setText("Price : " + selectedItem.getPrice());
               bookingStatus.setText("Status: " + selectedItem.getStatus());

               yourBookingLabel.setText("Your booking at the Hotel: " + selectedItem.getHotel().getName() + " status: ");

               cardLayout.show(CenterPanel, "DetailsCard");

            }
        });
        ViewBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(CenterPanel, "BookingsCard");

                selectedItem.setStatus(bookingStatus.getText());

                bookingJList.setModel(model);


            }
        });
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < bookingJList.getModel().getSize(); i++) {

                    bookingArrayList.add((Booking)bookingJList.getModel().getElementAt(i));

                }

                try {

                    ObjectOutputStream bookings = new ObjectOutputStream(new FileOutputStream("bookings.txt"));
                    Booking.writeExtent(bookings);
                    bookings.close();


                } catch (IOException exception) {
                    exception.printStackTrace();
                }

                JOptionPane.showMessageDialog(new JFrame(), "Changes succesfully saved", "Saved", JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }


    public static void main(String[] args){

        new MyApp("a", new Booking());


    }

}

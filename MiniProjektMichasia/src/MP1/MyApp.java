package MP1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JList bookingList;
    private JPanel DetailsPane;
    private JButton ViewDetailsButton;
    private JButton DeleteButton;
    private JButton SaveButton;
    private JButton LogoutButton;
    private JTextField bookingPrice;

    private final CardLayout cardLayout = (CardLayout)CenterPanel.getLayout();

    private Booking selectedItem = new Booking();

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
        bookingList.setModel(model);

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
               selectedItem =  model.get(bookingList.getSelectedIndex());


               bookingPrice.setText(Integer.toString(selectedItem.getPrice()));

               cardLayout.show(CenterPanel, "DetailsCard");

            }
        });
        ViewBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(CenterPanel, "BookingsCard");

                selectedItem.setPrice(Integer.parseInt(bookingPrice.getText()));

                bookingList.setModel(model);
            }
        });
    }


    public static void main(String[] args){

        new MyApp("a", new Booking());


    }

}

package MP1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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

    private final CardLayout cardLayout = (CardLayout)CenterPanel.getLayout();

    public MyApp(String mail, Booking bookingExtent){

        Dimension minSize = new Dimension(1000, 500);

        setContentPane(MainPanel);

        setTitle("App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
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

        String[] columns = new String[] {"a", "b"};
        String[][] values = new String[][] {{"A", "B"}, {"C", "D"}};


        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginScreen();
            }
        });
    }


    public static void main(String[] args) {
        new MyApp("A", new Booking());


    }

}

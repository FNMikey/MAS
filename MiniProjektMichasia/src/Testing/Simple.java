package Testing;

import javax.swing.*;
public class Simple {
    JFrame f;

    public Simple() {
        f = new JFrame();//creating instance of JFrame

        JButton b = new JButton("click");//creating instance of JButton
        b.setBounds(130, 100, 100, 40);

        f.add(b);//adding button in JFrame

        f.setSize(400, 500);//400 width and 500 height
        f.setResizable(false);
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }
}
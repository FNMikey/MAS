package Testing;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main extends JFrame {
    public static void main(String[] args) {
        // Sample ArrayList of custom objects
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("John", 25, LocalDate.of(1998, 5, 15)));
        personList.add(new Person("Jane", 30, LocalDate.of(1993, 10, 22)));
        personList.add(new Person("Alice", 35, LocalDate.of(1988, 3, 8)));

        JFrame jFrame = new JFrame();

        jFrame.setSize(400, 500);//400 width and 500 height
        jFrame.setResizable(false);
        jFrame.setLayout(null);//using no layout managers
        jFrame.setVisible(true);//making the frame visible

        JPanel jPanel = new JPanel();
        jFrame.setContentPane(jPanel);


        // Convert ArrayList to DefaultListModel
        DefaultListModel<Person> model = new DefaultListModel<>();
        for (Person person : personList) {
            model.addElement(person);
        }

        // Create JList and set the model
        JList<Person> jList = new JList<>(model);

        jPanel.add(jList);

        // Select a particular item
        int selectedIndex = 1; // Index of the item to be selected
        jList.setSelectedIndex(selectedIndex);

        // Get the selected item
        Person selectedPerson = jList.getSelectedValue();

        // Edit the selected item
        selectedPerson.setName("Updated Name");
        selectedPerson.setAge(40);

        // Update the JList display
        model.set(selectedIndex, selectedPerson);
    }
}

class Person {
    private String name;
    private int age;
    private LocalDate birthDate;

    public Person(String name, int age, LocalDate birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Birth Date: " + birthDate;
    }
}

package MP1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkerExtent implements Serializable {

    private static int minimalAge = 18; //atrybut klasowy
    private static List<Worker> workers = new ArrayList();  //ekstensja


    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(workers);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        workers = (ArrayList<Worker>) stream.readObject();
    }


    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void removeWorker(Worker worker) {
        workers.remove(worker);
    }


    public void showExtent() {

        System.out.println("Extent of the class: " + Worker.class.getName());

        for (Worker worker : workers) {
            System.out.println(worker);
        }

        System.out.println("Minimal age is: " + minimalAge);

    }


    //metoda klasowa
    public static void showSalary() {

        for (Worker w : workers) {

            if (w.getBonus() != 0) {

                System.out.println("Salary of " + w.getNames() + " is " + w.getSalary() + "PLN of which: " + w.getBonus() + "PLN is bonus and " + (w.getSalary() - w.getBonus()) + "PLN is regular salary");
            } else {

                System.out.println("Salary of " + w.getNames() + " is " + w.getSalary() + "PLN");
            }

        }

    }


}

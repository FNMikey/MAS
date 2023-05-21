package MP1;

import java.io.*;
import java.time.LocalDate;

public class MainRead {

    public static void main(String[] args) throws Exception {

        WorkerExtent workerExtent = new WorkerExtent();


        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("extent.txt"));
            workerExtent.readExtent(in);
            in.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        workerExtent.showExtent();
        workerExtent.showSalary();


    }
}

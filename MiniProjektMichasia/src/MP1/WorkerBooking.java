package MP1;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class WorkerBooking implements Serializable {

    private LocalDate Od;
    private LocalDate Do;

    private Worker worker;
    private Booking booking;

    public WorkerBooking(LocalDate od, LocalDate Do, Worker worker, Booking booking) throws Exception {
        this.Od = od;
        this.Do = Do;
        addWorker(worker);
        addBooking(booking);
    }

    //asocjacja z atrybutem
    public void addWorker(Worker newWorker) throws Exception {
        if(Objects.isNull(newWorker)) {
            throw new Exception("Worker can't be a null");
        }
        if (Objects.isNull(worker)){
            worker = newWorker;
            newWorker.addWorkerBooking(this);
        }

    };

    public void removeWorker(Worker oldWorker) throws Exception{

        if(Objects.isNull(oldWorker)) {
            throw new Exception("Booking can't be a null");
        }
        if (!booking.equals(oldWorker)){
            throw new Exception("This booking is not assigned to this worker");
        }

        booking = null;
        oldWorker.removeWorkerBooking(this);

    }

    //asocjacja z atrybutem
    public void addBooking(Booking newBooking) throws Exception {
        if(Objects.isNull(newBooking)) {
            throw new Exception("Booking can't be a null");
        }
        if (Objects.isNull(booking)){
            booking = newBooking;
            newBooking.addWorkerBooking(this);
        }

    };


    public void removeBooking(Booking oldBooking) throws Exception{

        if(Objects.isNull(oldBooking)) {
            throw new Exception("Booking can't be a null");
        }
        if (!booking.equals(oldBooking)){
            throw new Exception("This booking is not assigned to this worker");
        }

        booking = null;
        oldBooking.removeWorkerBooking(this);

    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}

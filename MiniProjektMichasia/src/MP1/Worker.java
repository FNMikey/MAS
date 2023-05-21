package MP1;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

enum WorkerType {Worker, Receptionist, Director, Technician}

public class Worker extends Person implements Serializable {

    private int ID;
    private int salary;
    private String jobType;
    private String jobStatus;
    private LocalDate startDate; //atrybut złożony
    private int vacationDays;
    private int bonus; //atrybut opcjonalny
    private Hotel hotel;


    //asocjacja z atrybutem
    public List<WorkerBooking> workerBookings = new ArrayList<>();

//    {
//        workerExtent.addWorker(this);
//    }

    public Worker(List<String> names, String surname, LocalDate birthDate, int ID, int salary, String jobType, String jobStatus, LocalDate startDate, int vacationDays, int bonus, Hotel hotel) {
        super(names, surname, birthDate);
        this.ID = ID;
        this.salary = salary + bonus;
        this.jobType = jobType;
        this.jobStatus = jobStatus;
        this.startDate = startDate;
        this.vacationDays = vacationDays;
        this.bonus = bonus;
        this.hotel = hotel;
    }

    public Worker(List<String> names, String surname, LocalDate birthDate, int ID, int salary, String jobType, String jobStatus, LocalDate startDate, int vacationDays, Hotel hotel) {
        this(names, surname, birthDate, ID, salary, jobType, jobStatus, startDate, vacationDays, 0, hotel);
    }



    //asocjacja "zwykła"
    public void setHotel(Hotel newHotel) throws Exception {
        if (Objects.isNull(newHotel)) {
            throw new Exception("Hotel can't be a null");
        }
        if (hotel != newHotel) {
            hotel = newHotel;
            System.out.println("Hotel added correctly");

            //polaczenie zwrotne
            hotel.addWorker(this);
        }

    }

    public void removeHotel(Hotel oldHotel) throws Exception{

        if(Objects.isNull(hotel)) {
            throw new Exception("Hotel can't be a null");
        }
        if (!hotel.equals(oldHotel)) {
            throw new Exception("This worker is not working at this hotel");
        }

        hotel = null;
        //polaczenie zwrotne
        oldHotel.removeWorker(this);

    }

    //asocjacja z atrybutem
    public void addWorkerBooking(WorkerBooking workerBooking) throws Exception {

        if (Objects.isNull(workerBooking)) {
            throw new Exception("WorkerBooking can't be a null");
        }

        if (!workerBookings.contains(workerBooking)) {

            workerBookings.add(workerBooking);
            workerBooking.addWorker(this);

        }

    }

    public void removeWorkerBooking(WorkerBooking workerBooking) throws Exception{

        if (Objects.isNull(workerBooking)) {
            throw new Exception("WorkerBooking can't be a null");
        }
        if (!workerBookings.contains(workerBooking)) {
            throw new Exception("There is no working booking like that");
        }

        workerBookings.remove(workerBooking);
        workerBooking.removeWorker(this);

    }


    @Override
    public String toString() {

        if (bonus != 0) {

            return "Worker{" +
                    "name(s)='" + super.getNames() + '\'' +
                    ", surname='" + super.getSurname() + '\'' +
                    ", birthDate=" + super.getBirthDate() +
                    ", age=" + super.getAge() +
                    ", ID=" + ID +
                    ", income=" + salary +
                    ", jobType='" + jobType + '\'' +
                    ", jobStatus='" + jobStatus + '\'' +
                    ", startDate=" + startDate +
                    ", vacationDays=" + vacationDays +
                    ", bonus=" + bonus +
                    '}';
        } else {

            return "Worker{" +
                    "name(s)='" + super.getNames() + '\'' +
                    ", surname='" + super.getSurname() + '\'' +
                    ", birthDate=" + super.getBirthDate() +
                    ", age=" + super.getAge() +
                    ", ID=" + ID +
                    ", income=" + salary +
                    ", jobType='" + jobType + '\'' +
                    ", jobStatus='" + jobStatus + '\'' +
                    ", startDate=" + startDate +
                    ", vacationDays=" + vacationDays +
                    '}';
        }
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSalary() {
        return salary;
    }

    public void changeSalary(int salary) {
        this.salary = salary;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Hotel getHotel() {
        return hotel;
    }

}

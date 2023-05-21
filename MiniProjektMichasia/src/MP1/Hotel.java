package MP1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Hotel implements Serializable {

    private String name;
    private String adres;
    private int roomsCount;
    private int stars;
    private String description;
    private List<Worker> workers = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    public Hotel(String name, String adres, int roomsCount, int stars, String description) {
        this.name = name;
        this.adres = adres;
        this.roomsCount = roomsCount;
        this.stars = stars;
        this.description = description;
    }

    public Room addRoom(int area, int bedCount, int bathroomCount, int price, String description, String view, boolean isForSmokers, boolean hasKitchen) {

        Room room = new Room(area, bedCount, bathroomCount, price, description, view, isForSmokers, hasKitchen);
        rooms.add(room);

        return room;
    }

    public void removeRoom(Room room) throws Exception{

        if (Objects.isNull(room)) {
            throw new Exception("Room can't be a null");
        }

        rooms.remove(room);

    }

    //asocjacja "zwykła"
    public void addWorker(Worker newWorker) throws Exception {
        if(Objects.isNull(newWorker)) {
            throw new Exception("Worker can't be a null");
        }
        if (!workers.contains(newWorker)) {
            workers.add(newWorker);

            System.out.println("Worker added correctly");

            //polaczenie zwrotne
            newWorker.setHotel(this);
        }
    }

    public void removeWorker(Worker worker) throws Exception {

        if(Objects.isNull(worker)) {
            throw new Exception("Worker can't be a null");
        }
        if (!workers.contains(worker)) {
            throw new Exception("This worker is not working at this hotel");
        }

        workers.remove(worker);
        worker.removeHotel(this);

        System.out.println("Worker removed successfully");

    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", adres='" + adres + '\'' +
                ", roomsCount=" + roomsCount +
                ", stars=" + stars +
                ", description='" + description + '\'' +
                ", workers=" + workers +
                ", rooms=" + rooms +
                '}';
    }

    //kompozycja
    public class Room implements Serializable{

        private int area;
        private int bedCount;
        private int bathroomCount;
        private int price;
        private String description;
        private String view;
        private boolean isForSmokers;
        private boolean hasKitchen;


        public Room(int area, int bedCount, int bathroomCount, int price, String description, String view, boolean isForSmokers, boolean hasKitchen) {
            this.area = area;
            this.bedCount = bedCount;
            this.bathroomCount = bathroomCount;
            this.price = price;
            this.description = description;
            this.view = view;
            this.isForSmokers = isForSmokers;
            this.hasKitchen = hasKitchen;
        }

        public Hotel getHotel(){
            return Hotel.this;
        }

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public int getBedCount() {
            return bedCount;
        }

        public void setBedCount(int bedCount) {
            this.bedCount = bedCount;
        }

        public int getBathroomCount() {
            return bathroomCount;
        }

        public void setBathroomCount(int bathroomCount) {
            this.bathroomCount = bathroomCount;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getView() {
            return view;
        }

        public void setView(String view) {
            this.view = view;
        }

        public boolean isForSmokers() {
            return isForSmokers;
        }

        public void setForSmokers(boolean forSmokers) {
            isForSmokers = forSmokers;
        }

        public boolean isHasKitchen() {
            return hasKitchen;
        }

        public void setHasKitchen(boolean hasKitchen) {
            this.hasKitchen = hasKitchen;
        }
    }

}

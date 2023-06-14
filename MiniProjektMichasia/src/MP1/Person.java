package MP1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


public abstract class Person implements Serializable {

    private List<String> names; //atrybut powtarzalny
    private String surname;
    private LocalDate birthDate; //atrybut zlozony


    public Person(List<String> names, String surname, LocalDate birthDate) {
        this.names = names;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }


    public List<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + names + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + this.getAge() +
                '}';
    }

}

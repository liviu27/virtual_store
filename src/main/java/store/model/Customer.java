package store.model;

import java.util.Objects;

public class Customer {
    private String name;
    private String address;
    private int registrationYear;
    Birthday bday;

    public Customer(String name, String address, Birthday bday, int registrationYear) {
        this.name = name;
        this.address = address;
        this.bday = bday;
        this.registrationYear = registrationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return registrationYear == customer.registrationYear &&
                Objects.equals(name, customer.name) &&
                Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, registrationYear);
    }

    @Override
    public String toString() {
        return "Client [" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + bday + '\'' +
                ", registrationYear=" + registrationYear +
                ']';
    }

}

class Birthday {
    private int day;
    private int month;
    private int year;

    public Birthday(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}

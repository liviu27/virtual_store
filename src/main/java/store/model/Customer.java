package store.model;

import java.util.Objects;

public class Customer {
    private String name;
    private String address;
    private int registrationYear;
    Birthday bday;
    public final int ID;
    private static int counter = 0;

    public Customer(String name, String address, Birthday bday, int registrationYear) {
        this.name = name;
        this.address = address;
        this.bday = bday;
        this.registrationYear = registrationYear;
        this.ID = ++counter;
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
        return "Customer " + ID +" [" +
                "name: '" + name + '\'' +
                ", address: '" + address + '\'' +
                ", birthday: '" + bday + '\'' +
                ", registration year: " + registrationYear +
                ']';
    }

}


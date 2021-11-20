package com.bridgelabz;

public class Contact {
    private String first_name;
    private String last_name;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phone_number;
    private String email;


    Contact(String firstname, String lastname, String address, String city, String state, int zip, long phone_number, String email) {
        this.first_name = firstname;
        this.last_name = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone_number = phone_number;
        this.email = email;
    }


    public String getFirst_name() {
        return first_name;
    }

    public String setFirstname(String firstname) {
        this.first_name = firstname;
        return firstname;
    }

    public String getLast_name() {
        return last_name;
    }

    public String setLastname(String lastname) {
        this.last_name = lastname;
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        this.address = address;
        return address;
    }

    public String getCity() {
        return city;
    }

    public String setCity(String city) {
        this.city = city;
        return city;
    }

    public String getState() {
        return state;
    }

    public String setState(String state) {
        this.state = state;
        return state;
    }

    public int getZip() {
        return zip;
    }

    public int setZip(int zip) {
        this.zip = zip;
        return zip;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public long setPhone_number(long phone_number) {
        this.phone_number = phone_number;
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        this.email = email;
        return email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phone_number=" + phone_number +
                ", email='" + email + '\'' +
                '}';
    }
}

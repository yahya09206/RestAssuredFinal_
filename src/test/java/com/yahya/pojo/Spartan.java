package com.yahya.pojo;

public class Spartan {

    private String name;
    private String gender;
    private long phone;

    public Spartan() {
    }

    public Spartan(String name, String gender, long phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.phone = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhoneNumber(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Spartan{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber=" + phone +
                '}';
    }
}

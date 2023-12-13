package com.example.mainpage;

import java.util.ArrayList;

public class barber {
    int ammount;
    String barberName;
  ArrayList <Boolean> appointments;

  ArrayList <String> booking;

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }

    public ArrayList getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList appointments) {
        this.appointments = appointments;
    }

    public ArrayList getBooking() {
        return booking;
    }

    public void setBooking(ArrayList booking) {
        this.booking = booking;
    }

    public barber(int ammount, String barberName, ArrayList appointments, ArrayList booking) {
        this.ammount = ammount;
        this.barberName = barberName;
        this.appointments = appointments;
        this.booking = booking;
    }

    public barber() {
    }

}

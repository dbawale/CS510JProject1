package edu.pdx.cs410J.dbawale;

import edu.pdx.cs410J.AbstractAppointment;
import edu.pdx.cs410J.AbstractAppointmentBook;

import java.util.ArrayList;
import java.util.Collection;


public class AppointmentBook extends AbstractAppointmentBook {
    String owner;
    ArrayList<Appointment> appointmentList;

    public AppointmentBook(String owner) {
        this.owner=owner;
        appointmentList = new ArrayList<Appointment>();
    }

    @Override
    public String getOwnerName() {
        return this.owner;
    }

    @Override
    public Collection getAppointments() {
        return this.appointmentList;
    }

    @Override
    public void addAppointment(AbstractAppointment abstractAppointment) {
        this.appointmentList.add((Appointment) abstractAppointment);
    }
}

package edu.pdx.cs410J.dbawale;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Deven on 6/28/2016.
 */
public class AppointmentBookTest {

    @Test
    public void createAppointmentBookWithOwnerName() throws Exception {
        AppointmentBook appointmentBook = new AppointmentBook("deven");
        assertEquals(appointmentBook.getOwnerName(),"deven");
    }

    @Test
    public void addNewAppointmentToAppointementBook() throws Exception{
        AppointmentBook appointmentBook = new AppointmentBook("deven");
        appointmentBook.addAppointment(new Appointment("meeting","00","01"));
        assertEquals(appointmentBook.getOwnerName(),"deven");
        assertEquals(appointmentBook.getAppointments().size(),1);
        assertEquals(appointmentBook.getAppointments().getClass(),java.util.ArrayList.class);
        ArrayList<Appointment> mylist = new ArrayList<Appointment>();
        mylist = (ArrayList)appointmentBook.getAppointments();
        assertEquals(mylist.get(0).description,"meeting");
        assertEquals(mylist.get(0).getEndTimeString(),"01");
        assertEquals(mylist.get(0).getBeginTimeString(),"00");
    }
}
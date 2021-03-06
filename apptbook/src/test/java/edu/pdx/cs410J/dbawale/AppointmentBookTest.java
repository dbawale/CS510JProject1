package edu.pdx.cs410J.dbawale;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public class AppointmentBookTest {

    @Test
    public void apptsSortTestBeginDate()
    {
        AppointmentBook appointmentBook = new AppointmentBook("deven");
        //appointmentBook.addAppointment(new Appointment("meeting","00","01"));
        appointmentBook.addAppointment(new Appointment("meeting2",new Date("7/16/2016 12:37 pm"),new Date("7/16/2016 01:37 pm")));
        appointmentBook.addAppointment(new Appointment("meeting3",new Date("7/17/2016 12:37 pm"),new Date("7/16/2016 01:37 pm")));
        appointmentBook.addAppointment(new Appointment("meeting1",new Date("7/15/2016 12:37 pm"),new Date("7/16/2016 01:37 pm")));
        for(Appointment appt : (ArrayList<Appointment>)appointmentBook.getAppointments())
        {
            System.out.println(appt.description);
        }
        System.out.println("After sorting: ");
        appointmentBook.sort();
        for(Appointment appt : (ArrayList<Appointment>)appointmentBook.getAppointments())
        {
            System.out.println(appt.description);
        }

    }

    @Test
    public void apptsSortTestEndDate()
    {
        AppointmentBook appointmentBook = new AppointmentBook("deven");
        //appointmentBook.addAppointment(new Appointment("meeting","00","01"));
        appointmentBook.addAppointment(new Appointment("meeting3",new Date("7/16/2016 12:37 pm"),new Date("7/17/2016 01:37 pm")));
        appointmentBook.addAppointment(new Appointment("meeting1",new Date("7/16/2016 12:37 pm"),new Date("7/15/2016 01:37 pm")));
        appointmentBook.addAppointment(new Appointment("meeting2",new Date("7/16/2016 12:37 pm"),new Date("7/16/2016 01:37 pm")));
        for(Appointment appt : (ArrayList<Appointment>)appointmentBook.getAppointments())
        {
            System.out.println(appt.description);
        }
        System.out.println("After sorting: ");
        appointmentBook.sort();
        for(Appointment appt : (ArrayList<Appointment>)appointmentBook.getAppointments())
        {
            System.out.println(appt.description);
        }
    }

    @Test
    public void apptsSortTestDescription()
    {
        AppointmentBook appointmentBook = new AppointmentBook("deven");
        //appointmentBook.addAppointment(new Appointment("meeting","00","01"));
        appointmentBook.addAppointment(new Appointment("meeting3",new Date("7/16/2016 12:37 pm"),new Date("7/16/2016 01:37 pm")));
        appointmentBook.addAppointment(new Appointment("meeting1",new Date("7/16/2016 12:37 pm"),new Date("7/16/2016 01:37 pm")));
        appointmentBook.addAppointment(new Appointment("meeting2",new Date("7/16/2016 12:37 pm"),new Date("7/16/2016 01:37 pm")));
        for(Appointment appt : (ArrayList<Appointment>)appointmentBook.getAppointments())
        {
            System.out.println(appt.description);
        }
        System.out.println("After sorting: ");
        appointmentBook.sort();
        for(Appointment appt : (ArrayList<Appointment>)appointmentBook.getAppointments())
        {
            System.out.println(appt.description);
        }
    }

//    @Test
//    public void createAppointmentBookWithOwnerName() throws Exception {
//        AppointmentBook appointmentBook = new AppointmentBook("deven");
//        assertEquals(appointmentBook.getOwnerName(),"deven");
//    }
//
//    @Test
//    public void addNewAppointmentToAppointementBook() throws Exception{
//        AppointmentBook appointmentBook = createAppointmentBookWithDevenAndMeeting();
//        assertEquals(appointmentBook.getOwnerName(),"deven");
//        assertEquals(appointmentBook.getAppointments().size(),1);
//        assertEquals(appointmentBook.getAppointments().getClass(),java.util.ArrayList.class);
//        List<Appointment> mylist;
//
//        mylist = (ArrayList)appointmentBook.getAppointments();
//        assertEquals(mylist.get(0).description,"meeting");
//        assertEquals(mylist.get(0).getEndTimeString(),"01");
//        assertEquals(mylist.get(0).getBeginTimeString(),"00");
//    }
//
//    private AppointmentBook createAppointmentBookWithDevenAndMeeting() {
//        AppointmentBook appointmentBook = new AppointmentBook("deven");
//        appointmentBook.addAppointment(new Appointment("meeting","00","01"));
//        return appointmentBook;
//    }
//
//    @Test
//    public void addAnotherAppointmentToAppointmentBook() throws Exception{
//        AppointmentBook appointmentBook = new AppointmentBook("deven");
//        appointmentBook.addAppointment(new Appointment("anothermeeting","02","03"));
//        ArrayList<Appointment>mylist = (ArrayList)appointmentBook.getAppointments();
//        assertEquals(mylist.get(0).description,"anothermeeting");
//        assertEquals(mylist.get(0).getBeginTimeString(),"02");
//        assertEquals("03", mylist.get(0).getEndTimeString());
//    }
//
//    @Test
//    public void addTwoAppointments() throws Exception {
//        AppointmentBook appointmentBook = createAppointmentBookWithDevenAndMeeting();
//        appointmentBook.addAppointment(new Appointment("lunch","02","03"));
//        ArrayList<Appointment>mylist = (ArrayList)appointmentBook.getAppointments();
//        assertEquals(mylist.get(0).getDescription(),"meeting");
//        assertEquals(mylist.get(1).getDescription(),"lunch");
//
//    }
}
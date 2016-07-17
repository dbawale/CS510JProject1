package edu.pdx.cs410J.dbawale;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.System.exit;
import static org.junit.Assert.*;

public class PrettyPrinterTest {
    @Test
    public void TestPrettyPrinterWithOneAppt()
    {
        AppointmentBook book = new AppointmentBook("deven");
        Appointment appt =createAppointmentWithHello();
        book.addAppointment(appt);
        PrettyPrinter pretty = new PrettyPrinter("pretty.txt");
        try {
            pretty.dump(book);
        } catch (IOException e) {
            System.out.println("Error with file\n");
            exit(1);
        }
    }

    @Test
    public void TestPrettyPrinterWithTwoAppts()
    {
        AppointmentBook book = new AppointmentBook("deven");
        Appointment appt =createAppointmentWithHello();
        Appointment appt1 = new Appointment("hello2",new Date("7/14/2016 11:24 am"),new Date("7/17/2016 11:00 am"));
        book.addAppointment(appt);
        book.addAppointment(appt1);
        PrettyPrinter pretty = new PrettyPrinter("pretty.txt");
        try {
            pretty.dump(book);
        } catch (IOException e) {
            System.out.println("Error with file\n");
            exit(1);
        }
    }

    @Test
    public void TestToStdOut()
    {
        AppointmentBook book = new AppointmentBook("deven");
        Appointment appt =createAppointmentWithHello();
        Appointment appt1 = new Appointment("hello2",new Date("7/14/2016 11:24 am"),new Date("7/17/2016 11:00 am"));
        book.addAppointment(appt);
        book.addAppointment(appt1);
        PrettyPrinter pretty = new PrettyPrinter("pretty.txt");

            pretty.printtostdout(book);
    }

    private Appointment createAppointmentWithHello() {
        return new Appointment("hello",new Date("7/16/2016 11:24 am"), new Date("7/17/2016 11:24 am"));
    }
}

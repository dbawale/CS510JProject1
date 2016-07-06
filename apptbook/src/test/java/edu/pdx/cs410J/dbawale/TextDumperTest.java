package edu.pdx.cs410J.dbawale;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


public class TextDumperTest {

    @Test
    public void fileWriteSingleAppointmentTest(){
        TextDumper dumper = new TextDumper();
        FileInputStream inputStream;
        String fromfile="";
        int c;
        AppointmentBook book = new AppointmentBook("deven");
        Appointment appointment = new Appointment("lunch" , "7/5/2016 08:57","7/5/2016 09:00");
        book.addAppointment(appointment);
        try {
            dumper.dump(book);
            try {
                inputStream = new FileInputStream(book.getOwnerName());
                while((c = inputStream.read()) !=-1)
                {
                    fromfile +=(char)c;
                }

            } catch (FileNotFoundException e) {
                System.err.println("File not found");
            }
        }
        catch (IOException e)
        {
            System.err.println("File error");
        }
        assertEquals(fromfile,"deven\nlunch*#*7/5/2016 08:57*#*7/5/2016 09:00\n");
    }

    @Test
    public void fileWriteMultipleAppointmentTest(){
        TextDumper dumper = new TextDumper();
        FileInputStream inputStream;
        String fromfile="";
        int c;
        AppointmentBook book = new AppointmentBook("deven");
        Appointment appointment = new Appointment("lunch" , "7/5/2016 08:57","7/5/2016 09:00");
        Appointment appointment1 = new Appointment("dinner", "7/5/2016 08:57","7/5/2016 09:00");
        book.addAppointment(appointment);
        book.addAppointment(appointment1);
        try {
            dumper.dump(book);
            try {
                inputStream = new FileInputStream(book.getOwnerName());
                while((c = inputStream.read()) !=-1)
                {
                    fromfile +=(char)c;
                }

            } catch (FileNotFoundException e) {
                System.err.println("File not found");
            }
        }
        catch (IOException e)
        {
            System.err.println("File error");
        }
        assertEquals(fromfile,"deven\nlunch*#*7/5/2016 08:57*#*7/5/2016 09:00\ndinner*#*7/5/2016 08:57*#*7/5/2016 09:00\n");
    }
}

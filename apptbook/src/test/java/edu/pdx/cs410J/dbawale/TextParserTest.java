package edu.pdx.cs410J.dbawale;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.ParserException;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TextParserTest {

    @Test
    public void outputToStdOutTest () throws ParserException {
        TextParser parser = new TextParser("deven");
        parser.setOwner("deven");
        AbstractAppointmentBook apptbook = (AppointmentBook)parser.parse();
        ArrayList<Appointment> appts;
        appts = (ArrayList<Appointment>) apptbook.getAppointments();
        for( Appointment appt: appts)
        {
            System.out.println(appt.toString());
        }
    }

    @Test
    public void outputToStdOutAnotherTest () throws ParserException {
        TextParser parser = new TextParser("deven bawale");
        parser.setOwner("deven bawale");
        AbstractAppointmentBook apptbook = (AppointmentBook)parser.parse();
        ArrayList<Appointment> appts;
        appts = (ArrayList<Appointment>) apptbook.getAppointments();
        for( Appointment appt: appts)
        {
            System.out.println(appt.toString());
        }
    }

    @Test (expected = ParserException.class)
    public void emptyFileTest () throws ParserException {
        TextParser parser = new TextParser("test");
        AbstractAppointmentBook apptbook = (AppointmentBook)parser.parse();
        ArrayList<Appointment> appts;
        appts = (ArrayList<Appointment>) apptbook.getAppointments();
        for( Appointment appt: appts)
        {
            System.out.println(appt.toString());
        }
    }

    @Test (expected = ParserException.class)
    public void malformedFileTest () throws ParserException {
        TextParser parser = new TextParser("test1.txt");
        AbstractAppointmentBook apptbook = (AppointmentBook)parser.parse();
        ArrayList<Appointment> appts;
        appts = (ArrayList<Appointment>) apptbook.getAppointments();
        for( Appointment appt: appts)
        {
            System.out.println(appt.toString());
        }
    }

    @Test (expected = ParserException.class)
    public void anotherMalformedFileTest () throws ParserException {
        TextParser parser = new TextParser("test2.txt");
        AbstractAppointmentBook apptbook = (AppointmentBook)parser.parse();
        ArrayList<Appointment> appts;
        appts = (ArrayList<Appointment>) apptbook.getAppointments();
        for( Appointment appt: appts)
        {
            System.out.println(appt.toString());
        }
    }

    @Test
    @Ignore
    public void aFileThatDoesntExistTest () throws ParserException {
        TextParser parser = new TextParser("some random file");
        AbstractAppointmentBook apptbook = (AppointmentBook)parser.parse();
        assertThat(apptbook.getOwnerName(),equalTo(null));
        assertThat(apptbook.getAppointments(),equalTo(null));
    }


}

package edu.pdx.cs410J.dbawale;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.ParserException;
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
        AbstractAppointmentBook apptbook = (AppointmentBook)parser.parse();
        ArrayList<Appointment> appts;
        appts = (ArrayList<Appointment>) apptbook.getAppointments();
        for( Appointment appt: appts)
        {
            System.out.println(appt.toString());
        }
    }
}

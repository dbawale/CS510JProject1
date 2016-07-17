package edu.pdx.cs410J.dbawale;

import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.AppointmentBookDumper;

import java.io.IOException;

/**
 * Pretty printer class for Appointment Book project.
 * Creates a nicely-formatted textual presentation of an appointment book
 * that includes the duration of each appointment in minutes.
 */
public class PrettyPrinter implements AppointmentBookDumper {
    private String filename;

    /**
     * Pretty prints the appointment book to the file specified.
     *
     * @param abstractAppointmentBook The appointment book to be pretty printed
     * @throws IOException If file not found on disk
     */
    @Override
    public void dump(AbstractAppointmentBook abstractAppointmentBook) throws IOException {

    }
}

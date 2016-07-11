package edu.pdx.cs410J.dbawale;

import edu.pdx.cs410J.AbstractAppointmentBook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The TextDumper class. Contains implementation for writing the current data to a file
 * in a pre-specified format.
 */
public class TextDumper implements edu.pdx.cs410J.AppointmentBookDumper
{
    /**
     * Dumps the data specified on the command line to a file with a pre-specified format
     * @param abstractAppointmentBook The appointment book to be dumped to file
     * @throws IOException If the file was not found, or there was any problem writing to file
     */
    @Override
    public void dump(AbstractAppointmentBook abstractAppointmentBook) throws IOException {
        FileOutputStream ostream = new FileOutputStream(abstractAppointmentBook.getOwnerName());
        ostream.write(abstractAppointmentBook.getOwnerName().getBytes());
        ostream.write("\n".getBytes());
        ArrayList<Appointment> currentappointments = new ArrayList<Appointment>();
        currentappointments = (ArrayList)abstractAppointmentBook.getAppointments();
        for (Appointment appointment : currentappointments) {
            ostream.write(appointment.description.getBytes());
            ostream.write("*#*".getBytes());
            ostream.write(appointment.beginTime.getBytes());
            ostream.write("*#*".getBytes());
            ostream.write(appointment.endTime.getBytes());
            ostream.write("\n".getBytes());
        }
    }
}

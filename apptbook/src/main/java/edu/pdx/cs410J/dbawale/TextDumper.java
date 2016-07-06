package edu.pdx.cs410J.dbawale;

import edu.pdx.cs410J.AbstractAppointmentBook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TextDumper implements edu.pdx.cs410J.AppointmentBookDumper
{
    @Override
    public void dump(AbstractAppointmentBook abstractAppointmentBook) throws IOException {
        FileOutputStream ostream = new FileOutputStream(abstractAppointmentBook.getOwnerName());
        ostream.write(abstractAppointmentBook.getOwnerName().getBytes());
        ostream.write("\n".getBytes());
        ArrayList<Appointment> currentappointments = new ArrayList<Appointment>();
        currentappointments = (ArrayList)abstractAppointmentBook.getAppointments();
        for(int i=0;i<currentappointments.size();i++)
        {
            Appointment appointment = currentappointments.get(i);
            ostream.write(appointment.description.getBytes());
            ostream.write("*#*".getBytes());
            ostream.write(appointment.beginTime.getBytes());
            ostream.write("*#*".getBytes());
            ostream.write(appointment.endTime.getBytes());
            ostream.write("\n".getBytes());
        }
    }
}

package edu.pdx.cs410J.dbawale;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the {@link Appointment} class.
 */
public class AppointmentTest {
  @Test
  public void getBeginTimeStringShouldReturnCorrectBeginTime()
  {
    Appointment appointment = new Appointment("hello","00","01");
    assertEquals(appointment.getBeginTimeString(),"00");
  }

  @Test
  public void newAppointmentConstructorTest()
  {
    Appointment appointment = new Appointment("hello","00","01");
    assertEquals(appointment.beginTime,"00");
    assertEquals(appointment.endTime,"01");
    assertEquals(appointment.description,"hello");
  }

  @Test
  public void getEndTimeStringShouldReturnCorrectBeginTime()
  {
    Appointment appointment = new Appointment("hello","00","01");
    assertEquals(appointment.getEndTimeString(),"01");
  }

  @Test
  public void getAppointmentDescription()
  {
    Appointment appointment = new Appointment("hello","00","01");
    assertEquals(appointment.getDescription(),"hello");
  }

}

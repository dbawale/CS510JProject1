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
    Appointment appointment = createAppointmentWithHello();
    assertEquals(appointment.getBeginTimeString(),"00");
  }

  @Test
  public void newAppointmentConstructorTest()
  {
    Appointment appointment = createAppointmentWithHello();
    assertEquals(appointment.beginTime,"00");
    assertEquals(appointment.endTime,"01");
    assertEquals(appointment.description,"hello");
  }

  @Test
  public void getEndTimeStringShouldReturnCorrectBeginTime()
  {
    Appointment appointment = createAppointmentWithHello();
    assertEquals(appointment.getEndTimeString(),"01");
  }

  @Test
  public void getAppointmentDescription()
  {
    Appointment appointment = createAppointmentWithHello();
    assertEquals(appointment.getDescription(),"hello");
  }

  @Test
  public void appointmentToStringContainsFrom()
  {
    Appointment appointment = createAppointmentWithHello();
    assertThat(appointment.toString(),containsString("from"));
  }

  @Test
  public void appointmentToStringContainsUntil()
  {
    Appointment appointment = createAppointmentWithHello();
    assertThat(appointment.toString(),containsString("until"));
  }

  private Appointment createAppointmentWithHello() {
    return new Appointment("hello","00","01");
  }

  @Test
  public void appointmentToStringContainsDescription (){
    Appointment appointment = createAppointmentWithHello();
    assertThat(appointment.toString(),containsString("hello"));
  }

  @Test
  public void appointmentToStringContainsTimeFrom(){
    Appointment appointment = createAppointmentWithHello();
    assertThat(appointment.toString(),containsString("00"));
  }

  @Test
  public void appointmentToStringContainsTimeTo(){
    Appointment appointment = createAppointmentWithHello();
    assertThat(appointment.toString(),containsString("01"));
  }

  @Test
  public void appoinmentToStringReturnsCorrectString(){
    Appointment appointment = createAppointmentWithHello();
    assertEquals(appointment.toString(),"hello from 00 until 01");
  }
}

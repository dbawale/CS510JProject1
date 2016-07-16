package edu.pdx.cs410J.dbawale;


import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for the {@link Appointment} class.
 */
public class AppointmentTest {
    @Test (expected = NullPointerException.class)
    public void firstNullObjectToCompare()
    {
        Appointment appointment = createAppointmentWithHello();
        //Appointment appointment1 = new Appointment("hello",new Date("7/16/2016 11:24 am"), new Date("7/16/2016 11:24 am"));'
        Appointment appointment1=null;
        int cmp= appointment.compareTo(appointment1);
       // assertThat(cmp,equalTo(0));
    }

    @Test
    public void compareApptsWithDifferentStartDates()
    {
        Appointment appointment = createAppointmentWithHello();
        Appointment appointment1 = new Appointment("hello",new Date("7/13/2016 11:24 am"), new Date("7/16/2016 11:24 am"));
        int cmp = appointment.compareTo(appointment1);
        assertThat(cmp,equalTo(1));
    }

    @Test
    public void compareApptsWithDifferentStartDates2()
    {
        Appointment appointment = createAppointmentWithHello();
        Appointment appointment1 = new Appointment("hello",new Date("7/17/2016 11:24 am"), new Date("7/16/2016 11:24 am"));
        int cmp = appointment.compareTo(appointment1);
        assertThat(cmp,equalTo(-1));
    }

    @Test
    public void compareApptsWithSameStartDatesDifferentEndDates()
    {
        Appointment appointment = createAppointmentWithHello();
        Appointment appointment1 = new Appointment("hello",new Date("7/16/2016 11:24 am"), new Date("7/13/2016 11:24 am"));
        int cmp = appointment.compareTo(appointment1);
        assertThat(cmp,equalTo(1));
    }

    @Test
    public void compareApptsWithSameStartDatesDifferentEndDates2()
    {
        Appointment appointment = createAppointmentWithHello();
        Appointment appointment1 = new Appointment("hello",new Date("7/16/2016 11:24 am"), new Date("7/17/2016 11:24 am"));
        int cmp = appointment.compareTo(appointment1);
        assertThat(cmp,equalTo(-1));
    }

    @Test
    public void compareApptsWithEverythingSame()
    {
        Appointment appointment = createAppointmentWithHello();
        Appointment appointment1 = new Appointment("hello",new Date("7/16/2016 11:24 am"), new Date("7/16/2016 11:24 am"));
        int cmp = appointment.compareTo(appointment1);
        assertThat(cmp,equalTo(0));
    }

    @Test
    public void compareApptsWithSameDatesDifferentDescription()
    {
        Appointment appointment = createAppointmentWithHello();
        Appointment appointment1 = new Appointment("hello1",new Date("7/16/2016 11:24 am"), new Date("7/16/2016 11:24 am"));
        int cmp = appointment.compareTo(appointment1);
        assertThat(cmp,equalTo(-1));
    }

    @Test
    public void compareApptsWithSameDatesDifferentDescription2()
    {
        Appointment appointment = createAppointmentWithHello();
        Appointment appointment1 = new Appointment("hello1",new Date("7/16/2016 11:24 am"), new Date("7/16/2016 11:24 am"));
        int cmp = appointment1.compareTo(appointment);
        assertThat(cmp,equalTo(1));
    }


//  @Test
//  public void getBeginTimeStringShouldReturnCorrectBeginTime()
//  {
//    Appointment appointment = createAppointmentWithHello();
//    assertEquals(appointment.getBeginTimeString(),"00");
//  }
//
//  @Test
//  public void newAppointmentConstructorTest()
//  {
//    Appointment appointment = createAppointmentWithHello();
//    assertEquals(appointment.beginTime,"00");
//    assertEquals(appointment.endTime,"01");
//    assertEquals(appointment.description,"hello");
//  }
//
//  @Test
//  public void getEndTimeStringShouldReturnCorrectBeginTime()
//  {
//    Appointment appointment = createAppointmentWithHello();
//    assertEquals(appointment.getEndTimeString(),"01");
//  }
//
//  @Test
//  public void getAppointmentDescription()
//  {
//    Appointment appointment = createAppointmentWithHello();
//    assertEquals(appointment.getDescription(),"hello");
//  }
//
//  @Test
//  public void appointmentToStringContainsFrom()
//  {
//    Appointment appointment = createAppointmentWithHello();
//    assertThat(appointment.toString(),containsString("from"));
//  }
//
//  @Test
//  public void appointmentToStringContainsUntil()
//  {
//    Appointment appointment = createAppointmentWithHello();
//    assertThat(appointment.toString(),containsString("until"));
//  }
//
  private Appointment createAppointmentWithHello() {
    return new Appointment("hello",new Date("7/16/2016 11:24 am"), new Date("7/16/2016 11:24 am"));
  }
//
//  @Test
//  public void appointmentToStringContainsDescription (){
//    Appointment appointment = createAppointmentWithHello();
//    assertThat(appointment.toString(),containsString("hello"));
//  }
//
//  @Test
//  public void appointmentToStringContainsTimeFrom(){
//    Appointment appointment = createAppointmentWithHello();
//    assertThat(appointment.toString(),containsString("00"));
//  }
//
//  @Test
//  public void appointmentToStringContainsTimeTo(){
//    Appointment appointment = createAppointmentWithHello();
//    assertThat(appointment.toString(),containsString("01"));
//  }
//
//  @Test
//  public void appoinmentToStringReturnsCorrectString(){
//    Appointment appointment = createAppointmentWithHello();
//    assertEquals(appointment.toString(),"hello from 00 until 01");
//  }
}

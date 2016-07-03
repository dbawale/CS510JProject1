package edu.pdx.cs410J.dbawale;

import edu.pdx.cs410J.AbstractAppointment;

/**
 * Concrete implementation of the {@link AbstractAppointment} class
 * description is the description of the appointment, such as "lunch"
 * begintTime is the time at which the appointment starts
 * endTime is the time at which the appointment ends
 */
public class Appointment extends AbstractAppointment {
  String description;
  String beginTime;
  String endTime;

  /**
   * Constructor for the Appointment class
   * @param description The description of the appointment
   * @param beginTime The time at which the appointment begins
   * @param endTime The time at which the appointment ends
     */
  public Appointment(String description, String beginTime, String endTime) {
    this.description=description;
    this.beginTime=beginTime;
    this.endTime=endTime;
  }

  /**
   * Returns the beginTime of the appointment
   * @return The time at which the appointment begins
     */
  @Override
  public String getBeginTimeString() {
    return this.beginTime;
  }

  /**
   * Returns the endTime of the appointment
   * @return The time at which the appointment ends
     */
  @Override
  public String getEndTimeString() {
    return this.endTime;
  }

  /**
   * Returns the description of the appointment
   * @return The description of the appointment
     */
  @Override
  public String getDescription() {
    return this.description;
  }
}

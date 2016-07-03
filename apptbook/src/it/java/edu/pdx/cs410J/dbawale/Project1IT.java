package edu.pdx.cs410J.dbawale;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Integration tests for the {@link Project1} main class.
 */
public class Project1IT extends InvokeMainTestCase {

  /**
   * Invokes the main method of {@link Project1} with the given arguments.
   */
  private MainMethodResult invokeMain(String... args) {
    return invokeMain( Project1.class, args );
  }

  /**
   * Tests that invoking the main method with no arguments issues an error
   */
  @Test
  public void testNoCommandLineArguments() {
    MainMethodResult result = invokeMain();
    assertThat(result.getExitCode(), equalTo(1));
    assertThat(result.getErr(), containsString("Missing command line arguments"));
  }

  @Test
  public void testNormalOperationWithPrint()
  {
    MainMethodResult result = invokeMain("deven", "lunch", "7/2/2016", "5:30", "7/2/2016", "8:30", "-print");
    assertThat(result.getExitCode(),equalTo(0));
    assertThat(result.getOut().trim(),equalTo("lunch from 7/2/2016 5:30 until 7/2/2016 8:30"));
  }

  @Test
  public void testWithReadmeAtTheEnd()
  {
    MainMethodResult result = invokeMain("deven", "lunch", "7/2/2016", "5:30", "7/2/2016", "8:30", "-print","-README");
    assertThat(result.getExitCode(),equalTo(0));
    assertThat(result.getOut().trim(),equalTo("This program creates a new appointment for the owner specified and saves it in the\n" +
            "Appointment class. It can also optionally print the appointment details."));
  }

  @Test
  public void testWithReadmeAtTheSecondToLast()
  {
    MainMethodResult result = invokeMain("deven", "lunch", "7/2/2016", "5:30", "7/2/2016", "8:30", "-README","-print");
    assertThat(result.getExitCode(),equalTo(0));
    assertThat(result.getOut().trim(),equalTo("This program creates a new appointment for the owner specified and saves it in the\n" +
            "Appointment class. It can also optionally print the appointment details."));
  }

  @Test
  public void testWithOnlyReadmeOptionAndAllArgs()
  {
    MainMethodResult result = invokeMain("deven", "lunch", "7/2/2016", "5:30", "7/2/2016", "8:30","-README");
    assertThat(result.getExitCode(),equalTo(0));
    assertThat(result.getOut().trim(),equalTo("This program creates a new appointment for the owner specified and saves it in the\n" +
            "Appointment class. It can also optionally print the appointment details."));
  }

  @Test
  @Ignore
  public void testWithOnlyReadmeOption()
  {
    MainMethodResult result = invokeMain("-README");
    System.out.println(result.getExitCode());
    assertThat(result.getExitCode(),equalTo(0));
    assertThat(result.getOut().trim(),equalTo("This program creates a new appointment for the owner specified and saves it in the\n" +
            "Appointment class. It can also optionally print the appointment details."));
  }

  @Test
  public void testWithMutliWordArguments()
  {
    MainMethodResult result = invokeMain("deven bawale", "lunch with abhishek", "7/2/2016", "5:30", "7/2/2016", "8:30","-print");
    assertThat(result.getExitCode(),equalTo(0));
    assertThat(result.getOut().trim(),equalTo("lunch with abhishek from 7/2/2016 5:30 until 7/2/2016 8:30"));
  }

  @Test
  public void testWithDateTimeInName()
  {
    MainMethodResult result = invokeMain("7/2/2016", "lunch with abhishek", "7/2/2016", "5:30", "7/2/2016", "8:30","-print");
    assertThat(result.getExitCode(),equalTo(1));
    assertThat(result.getErr().trim(),containsString("Either owner or description are of the format DATE or TIME"));
  }

  @Test
  public void testWithDateTimeInDesc()
  {
    MainMethodResult result = invokeMain("deven", "7/2/2016", "7/2/2016", "5:30", "7/2/2016", "8:30","-print");
    assertThat(result.getExitCode(),equalTo(1));
    assertThat(result.getErr().trim(),containsString("Either owner or description are of the format DATE or TIME"));
  }

  @Test
  public void testWithEmptyDesc()
  {
    MainMethodResult result = invokeMain("deven", "", "7/2/2016", "5:30", "7/2/2016", "8:30","-print");
    assertThat(result.getExitCode(),equalTo(1));
    assertThat(result.getErr().trim(),containsString("Description must not be empty"));
  }
}
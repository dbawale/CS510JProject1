package edu.pdx.cs410J.dbawale;

import static java.lang.System.exit;

/**
 * The main class for the CS410J appointment book Project
 */
public class Project1 {
  private static String owner = "";
  private static String descrption = "";
  private static String begindate= "";
  private static String begintime= "";
  private static String enddate= "";
  private static String endtime= "";
  private static String option1= "";
  private static String option2= "";
  private static String begin= "",end= "";
  private static int length=0;
  private static Boolean processoptions=false;
  private static AppointmentBook book;
  private static Appointment appointment;

  /**
   * The main method for the appointment book Project. Creates an appointment specified by
   * the command line arguments and optionally prints a description of the created appointment.
   * @param args the command line arguments
     */
  public static void main(String[] args) {

    try {
       length = checkargumentlength(args);
    } catch (Exception e) {
      System.err.println("Invalid number of arguments detected. Please try again. Missing command line arguments");
      exit(1);
    }

    for(String arg: args)
    {
      if(arg.equals("-README"))
      {
        System.out.println("This program creates a new appointment for the owner specified and saves it in the\n" +
                "Appointment class. It can also optionally print the appointment details.");
        exit(0);
      }
    }

    for(int i=0;i<args.length;i++)
    {
      if(args[i].charAt(0)=='-')
      {
        try {
          checkcurrentoption(args[i]);
        } catch (Exception e) {
          System.err.println("Incorrect option detected. Please try again.");
          exit(1);
        }
      }
      else
      {
        try {
          processcurrentargs(args,i);
          i+=5;
        } catch (Exception e) {
          System.err.println("Arguments incorrect");
          exit(1);
        }
      }
      if (processoptions) {
        System.out.println(appointment.toString());
      }

    }
//    if(length>6) {
//      checkforreadme(args);
//    }
//
//    if(length>6) {
//      try {
//        checkoptions(args);
//      } catch (Exception e) {
//        System.err.println("Please check the provided options again\n");
//        exit(1);
//      }
//    }
//
//    try {
//      processargs(args);
//    } catch (Exception e) {
//      System.err.println("Description must not be empty");
//      exit(1);
//    }

    exit(0);

  }

  /**
   * Processes a set of given arguments that are previously checked for validiy.
   * Checks whether the arguments at position 0 and 1 are not dates or times.
   * Checks whether the arguments at position 2 and 4 are dates.
   * Checks whether the arguments at position 3 and 5 are times.
   * Creates the appointment and prints description if processoptions flag is set
   * @param args A set of arguments that have been checked for validity
   * @throws Exception Throws an exception if the description is found to be empty.
     */
  private static void processargs(String[] args) throws Exception {
    try {
      if (!checkdate(args[0]) && !checkdate(args[1])) {
        if (checkdate(args[2]) && checkdate(args[4])) {
          if (checktime(args[3]) && checktime(args[5])) {
            owner = args[0];
            descrption = args[1];
            if(descrption=="")
            {
              throw new Exception();
            }
            begindate = args[2];
            begintime = args[3];
            enddate = args[4];
            endtime = args[5];
            begin = begindate + " " + begintime;
            end = enddate + " " + endtime;
            AppointmentBook book = new AppointmentBook(owner);
            //Appointment appointment = new Appointment(descrption, begin, end);
            book.addAppointment(appointment);
            if (processoptions) {
              System.out.println(appointment.toString());
            } else {
              System.out.println("Appointment created!");
            }
          } else {
            System.err.println("Please check format of time and try again\n");
            exit(1);
          }
        } else {
          System.err.println("Please check format of date and try again\n");
          exit(1);
        }
      } else {
        System.err.println("Either owner or description are of the format DATE or TIME. Please enter correct format.\n");
        exit(1);
      }
    }
    catch (NumberFormatException e)
    {
      System.err.println("Check command format and try again.");
      exit(1);
    }
  }

  /**
   * Processes a set of given arguments that are previously checked for validiy.
   * Checks whether the arguments at position index and index + 1 are not dates or times.
   * Checks whether the arguments at position index + 2 and index + 4 are dates.
   * Checks whether the arguments at position index + 3 and index + 5 are times.
   * Creates the appointment and prints description if processoptions flag is set
   * @param args A set of arguments that have been checked for validity
   * @param index The starting index at which options are present in args[]
   * @throws Exception Throws an exception if the description is found to be empty.
   */
  private static void processcurrentargs(String[] args, int index) throws Exception {
    try {
      if (!checkdate(args[index]) && !checkdate(args[index+1])) {
        if (checkdate(args[index + 2]) && checkdate(args[index + 4])) {
          if (checktime(args[index + 3]) && checktime(args[index + 5])) {
            owner = args[index];
            descrption = args[index + 1];
            if(descrption=="")
            {
              throw new Exception();
            }
            begindate = args[index + 2];
            begintime = args[index + 3];
            enddate = args[index + 4];
            endtime = args[index + 5];
            begin = begindate + " " + begintime;
            end = enddate + " " + endtime;
            book = new AppointmentBook(owner);
            //appointment = new Appointment(descrption, begin, end);
            book.addAppointment(appointment);
            if (processoptions) {
              System.out.println(appointment.toString());
            } else {
              System.out.println("Appointment created!");
            }
          } else {
            System.err.println("Please check format of time and try again\n");
            exit(1);
          }
        } else {
          System.err.println("Please check format of date and try again\n");
          exit(1);
        }
      } else {
        System.err.println("Either owner or description are of the format DATE or TIME. Please enter correct format.\n");
        exit(1);
      }
    }
    catch (NumberFormatException e)
    {
      System.err.println("Check command format and try again.");
      exit(1);
    }
  }

  /**
   * Takes a set of arguments and checks their number for validation
   * @param args A set of arguments from commmand line
   * @return The number of arguments
   * @throws Exception Throws an exception if the number is less than 6 or more than 8
     */
  private static int checkargumentlength(String[] args) throws Exception
  {
//    if(args.length==1&&args[0].equals("-README"))
//    {
//      System.out.println("This program creates a new appointment for the owner specified and saves it in the\n" +
//              "Appointment class. It can also optionally print the appointment details.");
//      exit(0);
//    }
    /*else*/ if(args.length<6&&args.length!=1)
    {
      throw new Exception();
    }
    else if(args.length>8)
    {
      throw new Exception();
    }
    return args.length;
  }

  /**
   * Checks if the current argument array has '-print' as an option
   * and sets the processoptions flag accordingly
   * @param arg The set of command line arguments
   * @throws Exception Throws an exception if anything other than -print is present in the options
     */
  private static void checkoptions(String[] arg) throws Exception
  {
    if(arg[arg.length-1].equals("-print")||arg[arg.length-2].equals("-print"))
    {
      processoptions=true;
    }
    else
    {
      throw new Exception();
    }
  }

  /**
   * Checks the current option being processed and takes appropriate action.
   * Throws an exception if an illegal option was specified.
   * @param option The current option being processed
   * @throws Exception If an illegal option was specified on the command line
     */
  private static void checkcurrentoption(String option) throws Exception
  {
    switch(option)
    {
      case "-print":
        processoptions=true;
      break;
      case "-README":
        System.out.println("This program creates a new appointment for the owner specified and saves it in the\n" +
                "Appointment class. It can also optionally print the appointment details.");
        exit(0);
      break;
       default:
         throw new Exception();
    }
  }

  /**
   * Checks if a given argument array has the -README flag set
   * @param arg The set of arguments
     */
  private static void checkforreadme(String[] arg)
  {
      if(arg[arg.length-1].equals("-README")||arg[arg.length-2].equals("-README"))
      {
        System.out.println("This program creates a new appointment for the owner specified and saves it in the\n" +
                "Appointment class. It can also optionally print the appointment details.");
        exit(0);
      }
  }

  /**
   * Checks if a given string is in the appropriate date format. Returns true if so, false if not.
   * @param tocheck The string to be checked
   * @return True if appropriate, false if not
   * @throws NumberFormatException Throws NumberFormatException if characters are present instead of numbers.
     */
  public static Boolean checkdate(String tocheck) throws NumberFormatException
  {
    String [] split;
    split = tocheck.split("/");
    if (split.length!=3)
      return false;
    if(split[0].length()<1||Integer.parseInt(split[0])>12||split[0].length()>2)
      return false;
    if(split[1].length()<1||Integer.parseInt(split[1])>31||split[0].length()>2)
      return false;
    if(split[2].length()<1||Integer.parseInt(split[2])<1900||split[2].length()>4||Integer.parseInt(split[2])>2016)
      return false;
    return true;
  }

  /**
   * Checks if a given string is in the appropriate time format. Returns true if so, false if not.
   * @param tocheck The string to be checked
   * @return True if appropriate, false if not
   * @throws NumberFormatException Throws NumberFormatException if characters are present instead of numbers.
     */
  public static Boolean checktime(String tocheck) throws NumberFormatException
  {
    String [] split;
    split = tocheck.split(":");
    if(split.length!=2)
      return false;
    if(split[0].length()==0||split[1].length()==0)
      return false;
    if(split[0].length()>2||split[1].length()>2)
      return false;
    if(Integer.parseInt(split[0])>23||Integer.parseInt(split[1])>59)
      return false;
    return true;
  }
}
package edu.pdx.cs410J.dbawale;

import static java.lang.System.exit;

/**
 * The main class for the CS410J appointment book Project
 */
public class Project1 {
  private static String owner;
  private static String descrption;
  private static String begindate;
  private static String begintime;
  private static String enddate;
  private static String endtime;
  private static String option1;
  private static String option2;
  private static int length=0;
  private static Boolean processoptions;
  public static void main(String[] args) {

    try {
       length = checkargumentlength(args);
    } catch (Exception e) {
      System.out.println("Invalid number of arguments detected. Please try again");
      exit(1);
    }
    if(length>6) {
      checkforreadme(args);
    }

    try {
      checkoptions(args);
    } catch (Exception e) {
      System.out.println("Please check the provided options again\n");
      exit(1);
    }




    printarguments(args);
  }

  private static void processargs(String[] args) {
    //check 0 is not date/time
    //check 1 is not date/time
    //check 2,4 is date
    //check 3,5 is time
  }

  private static int checkargumentlength(String[] args) throws Exception
  {
    if(args.length<6)
    {
      throw new Exception();
    }
    else if(args.length>8)
    {
      throw new Exception();
    }
    return args.length;
  }

  private static void printarguments(String[] arguments)
  {
    System.out.println(arguments.length);
    for(String arg:arguments)
    {
      System.out.println(arg);
    }
  }

  public static void checkarguments(String [] argument) throws Exception
  {
    if(length>6)
    {
      checkoptions(argument);
    }
  }

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

  private static void checkforreadme(String[] arg)
  {
      if(arg[arg.length-1].equals("-README")||arg[arg.length-2].equals("-README"))
      {
        System.out.println("This program creates a new appointment for the owner specified and saves it in the\n" +
                "Appointment class. It can also optionally print the appointment details.\n");
        exit(0);
      }
  }

  public Boolean checkdate(String tocheck) throws NumberFormatException
  {
    String [] split;
    split = tocheck.split("/");
    if (split.length<3)
      return false;
    if(split[0].length()<1||Integer.parseInt(split[0])>12)
      return false;
    if(split[1].length()<1||Integer.parseInt(split[1])>31)
      return false;
    if(split[2].length()<1||Integer.parseInt(split[2])<1900||split[2].length()>4||Integer.parseInt(split[2])>2016)
      return false;
    return true;
  }
}




//    Class c = AbstractAppointmentBook.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
//    System.err.println("Missing command line arguments");
//    for (String arg : args) {
//      System.out.println(arg);
//    }
//    System.exit(1);
//
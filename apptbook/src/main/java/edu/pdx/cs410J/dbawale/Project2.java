package edu.pdx.cs410J.dbawale;

import edu.pdx.cs410J.ParserException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import static java.lang.System.exit;

/**
 * The main class for the CS410J appointment book Project
 */
public class Project2 {
    private static String owner = "";
    private static String descrption = "";
    private static String begindate= "";
    private static String begintime= "";
    private static String enddate= "";
    private static String endtime= "";
    private static String textFile="";
    private static String option1= "";
    private static String option2= "";
    private static String begin= "",end= "";
    private static int length=0;
    private static Boolean processprint =false;
    private static Boolean processfile =false;
    private static Boolean appointmentadded=false;
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
                        "Appointment class. It can also optionally print the appointment details.\n" +
                "It can optionally read and write appointments to an appointment book present in a file.");
                exit(0);
            }
        }

        for(int i=0;i<args.length;i++)
        {
            if(args[i].charAt(0)=='-')
            {
                try {
                    checkcurrentoption(args[i],args,i);
                    if(processfile && !args[i].equals("-print"))
                    {
                        i+=1;
                        textFile=args[i];
                    }
                } catch (Exception e) {
                    System.err.println("Incorrect option detected. Please try again.");
                    exit(1);
                }
            }
            else {
                try {
                    processcurrentargs(args, i);
                    i += 7;
                } catch (Exception e) {
                    System.err.println("Arguments incorrect");
                    exit(1);
                }
            }
        }
        if (processprint) {
            System.out.println(appointment.toString());
        }
        if(appointmentadded && processfile){
            readandaddappointments(textFile,owner);
        }


        exit(0);

    }


    /**
     * Processes a set of given arguments that are previously checked for validiy.
     * Checks whether the arguments at position index and index + 1 are not dates or times.
     * Checks whether the arguments at position index + 2 and index + 4 are dates.
     * Checks whether the arguments at position index + 3 and index + 5 are times.
     * Creates the appointment and prints description if processprint flag is set
     * @param args A set of arguments that have been checked for validity
     * @param index The starting index at which options are present in args[]
     * @throws Exception Throws an exception if the description is found to be empty.
     */
    private static void processcurrentargs(String[] args, int index) throws Exception {
        try {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
            //df.setLenient(true);
            if (!checkdate(args[index]) && !checkdate(args[index+1])) {
                if (checkdate(args[index + 2]) && checkdate(args[index + 5])) {
                    if (checktime(args[index + 3]) && checktime(args[index + 6])) {
                        owner = args[index];
                        descrption = args[index + 1];
                        if(descrption=="")
                        {
                            throw new Exception();
                        }
//                        begindate = args[index + 2];
//                        begintime = args[index + 3];
//                        enddate = args[index + 4];
//                        endtime = args[index + 5];
//                        begin = begindate + " " + begintime;
//                        end = enddate + " " + endtime;
                        begindate = args[index+2] + " " + args[index + 3] + " " +args[index + 4];
                        enddate = args[index+5] + " " + args[index + 6] + " " +args[index + 7];

                        book = new AppointmentBook(owner);

                        try {
                            Date begindt = df.parse(begindate);
                            Date enddt = df.parse(enddate);
                            appointment = new Appointment(descrption, begindt, enddt);
                        }
                        catch (ParseException e)
                        {
                            System.err.println("Error parsing datetime format");
                            exit(1);
                        }
                        book.addAppointment(appointment);
                        appointmentadded=true;
                        if (processprint) {
                            System.out.println(appointment.toString());
                            processprint =false;
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
     if(args.length<6&&args.length!=1)
    {
        throw new Exception();
    }
    else if(args.length>12)
    {
        throw new Exception();
    }
        return args.length;
    }

    /**
     * Checks if the current argument array has '-print' as an option
     * and sets the processprint flag accordingly
     * @param arg The set of command line arguments
     * @throws Exception Throws an exception if anything other than -print is present in the options
     */
    private static void checkoptions(String[] arg) throws Exception
    {
        if(arg[arg.length-1].equals("-print")||arg[arg.length-2].equals("-print"))
        {
            processprint =true;
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
    private static void checkcurrentoption(String option, String args[], int index) throws Exception
    {
        switch(option)
        {
            case "-print":
                processprint =true;
                break;
            case "-README":
                System.out.println("This program creates a new appointment for the owner specified and saves it in the\n" +
                        "Appointment class. It can also optionally print the appointment details.");
                exit(0);
                break;
            case "-textFile":
                processfile=true;
                //readandaddappointments(args[index+1]);
                textFile=args[index+1];
                break;
            default:
                throw new Exception();
        }
    }

    /**
     * Reads appointment book from file specified, adds the current appointment to the
     * appointmentbook and writes all data back.
     * Also passes the owner name to the parser.
     * @param filename The name of the file where appointemnts are stored
     * @param owner The name of the owner as specified on the command line
     */
    private static void readandaddappointments(String filename, String owner)
    {
        try {
        TextParser parser = new TextParser(filename);
            parser.setOwner(owner);
           book = (AppointmentBook) parser.parse();
            if(appointmentadded) {
                appointmentadded=false;
                book.addAppointment(appointment);
            }
            TextDumper dumper = new TextDumper(filename);
            dumper.dump(book);

        } catch (ParserException e) {
            System.err.println("There was a problem in the file:");
            System.err.println(e.getMessage());
            exit(1);
        } catch (IOException e) {
            System.err.println("Error writing appointmentbook to file.");
            exit(1);
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
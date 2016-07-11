package edu.pdx.cs410J.dbawale;


import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.ParserException;

import javax.xml.soap.Text;
import java.io.*;

import static java.lang.System.exit;

/**
 * The TextParser class. This class implements the AppointmentBookParser interface.
 * filename is the name of the file specified on command line. It is passed to the constructor
 */
public class TextParser implements edu.pdx.cs410J.AppointmentBookParser {
    String filename;

    /**
     * Constructor for TextParser class.
     * Assigns the file given on the command line to this.filename.
     * @param file The name of the file as specified on the command line
     */
    public TextParser(String file){
        this.filename=file;
    }


    /**
     * Parses the input file specified on the command line and creates appointment if successful.
     * @return The appointment book created if parsing was successful, an appointmentbook with null data if file was not found
     * @throws ParserException If the file or data is malformatted
     */
    @Override
    public AbstractAppointmentBook parse() throws ParserException {
        String readfromfile="";
        AppointmentBook apptbook = new AppointmentBook();
        try {
            FileInputStream inputStream = new FileInputStream(filename);

            int c;
            while((c=inputStream.read())!=-1)
            {
                readfromfile+=(char)c;
            }
            if(readfromfile.equals(""))
            {
                throw new ParserException("Cannot read from empty file");
            }
            String[]lines=readfromfile.split("\n");
//            for(int i=0;i<lines.length;i++)
//            {
//                System.out.println(lines[i]);
//            }
            if(lines[0].equals(this.filename))
            {
                apptbook = new AppointmentBook(lines[0]);
            }
            else
            {
                throw new ParserException("Owner name not found in file\n");
            }
            for(int i=1;i<lines.length;i++)
            {
                String[]apptline=lines[i].split("\\*#*");
                if(apptline.length!=5) {
                    throw new ParserException("Wrong format in file");
                }
                if(checkdate(apptline[0])==false&&checktime(apptline[0])==false)
                {
                    String startTime[]=apptline[2].split(" ");
                    if(checkdate(startTime[0])&&checktime(startTime[1]))
                    {
                        String endTime[]=apptline[4].split(" ");
                        if(checkdate(endTime[0])&&checktime(endTime[1]))
                        {
                            Appointment appt = new Appointment(apptline[0],apptline[2],apptline[4]);
                            apptbook.addAppointment(appt);
                            System.out.println(apptbook.toString());
                        }
                    }
                    else
                    {
                        throw new ParserException("Error in date format");
                    }
                }

            }

        } catch (FileNotFoundException e) {
//            try {
//                FileOutputStream outputStream = new FileOutputStream(filename);
//            } catch (FileNotFoundException e1) {
//                System.err.println("Error creating file. Please try again.");
//                return new AppointmentBook();
//            }
            System.err.println("Could not find file: " + filename + ". Creating empty appointment book with null objects.");
            return new AppointmentBook();
        } catch (IOException e) {
            throw new ParserException("Error parsing file",e);
        }


        return apptbook;
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



//constructor of ParserException as the second argument.
//        String readfromfile="";
//        try {
//            FileInputStream inputStream = new FileInputStream(filename);
//            int c;
//            while((c= inputStream.read())!=-1)
//            {
//                readfromfile += (char)c;
//            }
//            String[] lines = readfromfile.split("\n");
//
//        } catch (FileNotFoundException e) {
//            try {
//                FileOutputStream outputStream = new FileOutputStream(filename);
//            } catch (FileNotFoundException e1) {
//                System.err.println("Error creating file");
//            }
//        } catch (IOException e) {
//            throw new ParserException("Error parsing the file",e);
//        }
//
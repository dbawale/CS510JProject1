package edu.pdx.cs410J.dbawale;


import edu.pdx.cs410J.AbstractAppointmentBook;
import edu.pdx.cs410J.ParserException;

import javax.xml.soap.Text;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextParser implements edu.pdx.cs410J.AppointmentBookParser {
    String filename;

    public TextParser(String file){
        this.filename=file;
    }


    @Override
    public AbstractAppointmentBook parse() throws ParserException {
        //wrap IOException and make it throw ParserException, pass IOException to second
        //constructor of ParserException as the second argument.
        String readfromfile="";
        try {
            FileInputStream inputStream = new FileInputStream(filename);
            int c;
            while((c= inputStream.read())!=-1)
            {
                readfromfile += (char)c;
            }
            System.out.println(readfromfile);
        } catch (FileNotFoundException e) {
            try {
                FileOutputStream outputStream = new FileOutputStream(filename);
            } catch (FileNotFoundException e1) {
                System.err.println("Error creating file");
            }
        } catch (IOException e) {
            throw new ParserException("Error parsing the file",e);
        }

        return null;
    }
}

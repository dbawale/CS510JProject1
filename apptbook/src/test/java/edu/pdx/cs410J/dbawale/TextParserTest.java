package edu.pdx.cs410J.dbawale;

import edu.pdx.cs410J.ParserException;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class TextParserTest {

    @Test
    public void outputToStdOutTest () throws ParserException {
        TextParser parser = new TextParser("deven");
        parser.parse();
    }
}

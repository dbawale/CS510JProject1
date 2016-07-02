package edu.pdx.cs410J.dbawale;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
/**
 * Created by Deven on 6/30/2016.
 */
public class Project1Test {
    @Test
    public void checkdatetest(){
        Project1 project1 = new Project1();
        assertEquals(project1.checkdate("7/15/2016"),true);
    }

    @Test
    public void checkdatetest2(){
        Project1 project1 = new Project1();
        assertEquals(project1.checkdate("hello"),false);
    }

    @Test
    public void checkdatetest3(){
        Project1 project1 = new Project1();
        assertEquals(project1.checkdate("/0/2016"),false);
    }

    @Test
    public void checkdatetest4(){
        Project1 project1 = new Project1();
        assertEquals(project1.checkdate("1/1/2016"),true);
    }

    @Test
    public void checkdatetest5(){
        Project1 project1 = new Project1();
        assertEquals(project1.checkdate("1/1/2017"),false);
    }

    @Test (expected = NumberFormatException.class)
    public void checkdatetest6(){
        Project1 project1 = new Project1();
        assertEquals(project1.checkdate("a/b/c"),false);
    }
}

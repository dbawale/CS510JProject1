package edu.pdx.cs410J.dbawale;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

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

    @Test
    public void checkdatetest7(){
        Project1 project1 = new Project1();
        assertEquals(project1.checkdate("32/13/2016"),false);
    }

    @Test
    public void checkdatetest8(){
        Project1 project1 = new Project1();
        assertEquals(project1.checkdate("  "),false);
    }

    @Test
    public void checkdatetest9(){
        Project1 project1 = new Project1();
        assertEquals(project1.checkdate("-32/-13/2016"),false);
    }

    @Test
    public void checktimetest1(){
        Project1 project1 = new Project1();
        assertEquals(project1.checktime("00:00"),true);
    }

    @Test
    public void checktimetest2(){
        Project1 project1 = new Project1();
        assertEquals(project1.checktime("0000"),false);
    }

    @Test
    public void checktimetest3(){
        Project1 project1 = new Project1();
        assertEquals(project1.checktime(""),false);
    }

    @Test
    public void checktimetest4(){
        Project1 project1 = new Project1();
        assertEquals(project1.checktime(" "),false);
    }

    @Test
    public void checktimetest5(){
        Project1 project1 = new Project1();
        assertEquals(project1.checktime(":"),false);
    }

    @Test
    public void checktimetest6(){
        Project1 project1 = new Project1();
        assertEquals(project1.checktime("45:23"),false);
    }

    @Test
    public void checktimetest7(){
        Project1 project1 = new Project1();
        assertEquals(project1.checktime("03:23"),true);
    }

    @Test
    public void checktimetest8(){
        Project1 project1 = new Project1();
        assertEquals(project1.checktime("323:23"),false);
    }

    @Test
    public void checktimetest9(){
        Project1 project1 = new Project1();
        assertEquals(project1.checktime("023:023"),false);
    }

}

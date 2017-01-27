import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by NickNatali on 1/25/17.
 * This class tests the Course class.
 */

public class TestCourse {

    @Test
    public static void testEquals() {
        //Arrange
        Time timeObj = new Time(1, 20 , true);
        Course courseObject = new Course("EGR405", 3, null , timeObj, 1);

        //Act
        boolean testCourse = timeObj.equals(courseObject);

        //Assert
        Assert.assertEquals("Invalid equal", testCourse, true);
    }

    // Tests getEndTime()
    @Test
    public static void testGetEndTime() {
        //Arrange
        Time timeObj = new Time(1, 20 , true);
        Course courseObject = new Course("EGR405", 3, null , timeObj, 1);

        //Act
        Time timeObject = courseObject.getEndTime();

        //Assert
        Assert.assertEquals("Invalid end time", timeObj, timeObject);
    }

    // Tests contains
    @Test
    public static void testContains() {
        //Arrange
        Time timeObj = new Time(2, 35 , true);
        Course courseObject = new Course("EGR405", 3, null , timeObj, 2);

        //Act
        boolean testObj = courseObject.contains(Weekday.MONDAY, timeObj);

        //Assert
        Assert.assertEquals("Invalid contains function", false, timeObj);
    }

    // Tests conflictsWith
    @Test
    public static void testConflictsWith() {
        //Arrange
        Time timeObj = new Time(2, 35 , true);
        Course courseObject = new Course("EGR405", 3, null , timeObj, 2);

        //Act
        boolean testObj = courseObject.conflictsWith(courseObject);

        //Assert
        Assert.assertEquals("Invalid contains function", false, testObj);
    }

}

import org.junit.Assert;
import org.junit.Test;
import java.util.EnumSet;
import java.util.Set;

///**
// * Created by NickNatali on 1/25/17.
// * This class tests the Course class.
// */

public class TestCourse {

    /**
     * Constructor
     */
    @Test
    public void constructorTest(){
        //Arrange

        String courseName = "EGR 302";
        int credits = 3;
        Set<Weekday> set = EnumSet.of(Weekday.MONDAY);
        Time startTime = new Time(11, 20, true);
        int duration = 11;

        //Act
        Course course = new Course(courseName, credits, set, startTime, duration);

        //Assert
        Assert.assertEquals("Incorrect Name", courseName, course.getName());
        Assert.assertEquals("Incorrect Credits", credits, course.getCredits());
        Assert.assertEquals("Incorrect Start Time", startTime, course.getStartTime());
        Assert.assertEquals("Incorrect Duration", duration, course.getDuration());

        //Negative Assert
        Assert.assertNotEquals("Correct Name", courseName, course.getName());
        Assert.assertNotEquals("Correct Credits", credits, course.getCredits());
        Assert.assertNotEquals("Correct Start Time", startTime, course.getStartTime());
        Assert.assertNotEquals("Correct Duration", duration, course.getDuration());
    }

    /**
     * Test conflict method
     */
    @Test
    public void conflictsTest(){
        //Arrange
        String courseName = "EGR 305";
        int credits = 3;
        Set<Weekday> set = EnumSet.of(Weekday.FRIDAY);
        Time startTime = new Time(01, 21, true);
        int duration = 10;

        String courseName2 = "EGR 405";
        int credits2 = 3;
        Set<Weekday> set2 = EnumSet.of(Weekday.FRIDAY);
        Time startTime2 = new Time(01, 21, true);
        int duration2 = 10;

        //Act
        Course course = new Course(courseName, credits, set, startTime, duration);
        Course course2 = new Course(courseName2, credits2, set2, startTime2, duration2);

        //Assert
        Assert.assertEquals("Incorrect Name", true, course.conflictsWith(course2));

        //Negative Assert
        Assert.assertNotEquals("Correct Name", true, course.conflictsWith(course2));
    }

    /**
     * Test the contains method
     */
    @Test
    public void containsTest(){
        //Arrange
        String courseName = "EGR 345";
        int credits = 3;
        Set<Weekday> set = EnumSet.of(Weekday.FRIDAY);
        Time startTime = new Time(12, 23, true);
        int duration = 10;

        //Act
        Course course = new Course(courseName, credits, set, startTime, duration);

        //Assert
        Assert.assertEquals("Incorrect Name", true, course.contains(Weekday.FRIDAY, new Time(12, 23, true)));

        //Negative Assert
        Assert.assertNotEquals("Correct Name", true, course.contains(Weekday.FRIDAY, new Time(12, 23, true)));
    }

    /**
     * Test the equals method
     */
    @Test
    public void equalsTest(){
        //Arrange
        String courseName = "EGR 405";
        int credits = 4;
        Set<Weekday> set = EnumSet.of(Weekday.FRIDAY);
        Time startTime = new Time(12, 23, true);
        int duration = 50;

        String courseName2 = "EGR 405";
        int credits2 = 4;
        Set<Weekday> set2 = EnumSet.of(Weekday.FRIDAY);
        Time startTime2 = new Time(12, 23, true);
        int duration2 = 50;

        //Act
        Course course = new Course(courseName, credits, set, startTime, duration);
        Course course2 = new Course(courseName2, credits2, set2, startTime2, duration2);

        //Assert
        Assert.assertEquals("Incorrect Name", true, course.equals(course2));

        //Negative Assert
        Assert.assertNotEquals("Incorrect Name", true, course.equals(course2));
    }

    /**
     * Test the hashcode method
     */
    @Test
    public void testHashCode() {
        //Arrange
        String courseName = "EGR 405";
        int credits = 4;
        Set<Weekday> set = EnumSet.of(Weekday.FRIDAY);
        Time startTime = new Time(12, 23, true);
        int duration = 50;

        String courseName2 = "EGR 405";
        int credits2 = 4;
        Set<Weekday> set2 = EnumSet.of(Weekday.FRIDAY);
        Time startTime2 = new Time(12, 23, true);
        int duration2 = 50;

        //Act
        Course course = new Course(courseName, credits, set, startTime, duration);
        Course course2 = new Course(courseName2, credits2, set2, startTime2, duration2);

        //Assert
        Assert.assertEquals("Incorrect hash code", course.hashCode(), course2.hashCode());

        //Negative Assert
        Assert.assertNotEquals("Correct hash code", course.hashCode(), course2.hashCode());
    }

    /**
     * Test get end time
     */
    @Test
    public void testGetEndTime() {
        //Arrange
        String courseName = "EGR 405";
        int hour = 12;
        int minute = 23;
        boolean pm = true;
        int credits = 4;
        Set<Weekday> set = EnumSet.of(Weekday.FRIDAY);
        Time startTime = new Time(hour, minute, pm);
        int duration = 50;

        //Act
        Course course = new Course(courseName, credits, set, startTime, duration);

        //Assert
        Assert.assertEquals("Incorrect get end time", startTime, course.getEndTime());

        //Negative Assert
        Assert.assertNotEquals("Correct get end time", startTime, course.getEndTime());
    }

    /**
     * Test to string
     */
    @Test
    public void testToString() {
        //Arrange
        String courseName = "EGR 405";
        int hour = 12;
        int minute = 23;
        boolean pm = true;
        int credits = 4;
        Set<Weekday> set = EnumSet.of(Weekday.FRIDAY);
        Time startTime = new Time(hour, minute, pm);
        int duration = 50;

        //Act
        Course course = new Course(courseName, credits, set, startTime, duration);

        //Assert
        Assert.assertEquals("Incorrect string conversion", "EGR 405,4,F,12:23 PM,50", course.toString());

        //Negative Assert
        Assert.assertNotEquals("Correct string conversion", "EGR 405,4,F,12:23 PM,50", course.toString());
    }

    /**
     * Test clone
     */
    @Test
    public void testClone() {
        //Arrange
        String courseName = "EGR 405";
        int hour = 12;
        int minute = 23;
        boolean pm = true;
        int credits = 4;
        Set<Weekday> set = EnumSet.of(Weekday.FRIDAY);
        Time startTime = new Time(hour, minute, pm);
        int duration = 50;

        //Act
        Course course = new Course(courseName, credits, set, startTime, duration);
        Course courseClone = course.clone();

        //Assert
        Assert.assertEquals("Incorrect clone", course, courseClone);

        //Negative Assert
        Assert.assertNotEquals("Correct clone", course, courseClone);
    }




}

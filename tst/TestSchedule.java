import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by NickNatali on 1/29/17.
 */
public class TestSchedule {

    /**
     * Test the Add method
     */
    @Test
    public void testAdd() {
        //Arrange
        Time time1 = new Time(12, 30, true);
        Time time2 = new Time(11, 30, false);
        Time time3 = new Time(9, 30, false);
        Set<Weekday> d1 = new TreeSet<Weekday>();
        d1.add(Weekday.MONDAY);
        d1.add(Weekday.WEDNESDAY);
        d1.add(Weekday.FRIDAY);

        //Act
        Course course1 = new Course("EGR 405", 3, d1, time1, 50);
        Course course2 = new Course("EGR 302", 3, d1, time2, 50);

        Schedule s = new Schedule();
        Schedule s1 = new Schedule();
        Schedule s2 = new Schedule();
        s.add(course1);
        s1.add(course2);
        s2.add(course1);

        Assert.assertNotEquals("Invalid", s, s1);
        Assert.assertEquals("Valid",s,s2);
    }



    /**
     * Test clone
     */
    @Test
    public void TestClone() {
        //Act
        Schedule schedule = new Schedule();
        Schedule scheduleClone = schedule.clone();

        //Assert
        Assert.assertEquals("Incorrect clone", schedule, scheduleClone);

        //Negative Assert
        Assert.assertNotEquals("Correct clone", schedule, scheduleClone);
    }

    /**
     * Test get course
     */
    @Test
    public void testGetCourse() {
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
        Schedule s = new Schedule();
        Course course = new Course(courseName, credits, set, startTime, duration);

        //Assert
        Assert.assertEquals("Incorrect course", course, s.getCourse(Weekday.FRIDAY,startTime));

        //Negative Assert
        Assert.assertNotEquals("Correct course", course, s.getCourse(Weekday.FRIDAY, startTime));
    }

    /**
     * Test Remove
     */
    @Test
    public void testRemove() {
        //Arrange
        int hour = 5;
        int minute = 0;
        boolean pm = true;
        int credits = 4;
        Set<Weekday> set = EnumSet.of(Weekday.FRIDAY);
        Time startTime = new Time(hour, minute, pm);
        int duration = 50;

        //Act
        String[] courseStrings = {
                "EGR 222,3,MWF,05:00 PM,60",
                "EGR 333,3,MWF,04:30 PM,30",
                "EGR 444,1,R,12:00 PM,60",
                "EGR 555,2,RF,02:00 AM,15"
        };
        Course course = new Course(courseStrings[0], credits, set, startTime, duration);
        Course course2 = new Course(courseStrings[1], credits, set, startTime, duration);

        Schedule s = new Schedule();

        s.remove(Weekday.WEDNESDAY, new Time (5, 0, true));
        Assert.assertFalse(s.getAllCourses().contains(course));

        s.remove(Weekday.THURSDAY, new Time (4, 30, true));
        Assert.assertTrue(s.getAllCourses().contains(course2));
    }

}

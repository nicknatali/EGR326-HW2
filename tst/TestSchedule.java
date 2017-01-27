import org.junit.Assert;
import org.junit.Test;

/**
 * Created by NickNatali on 1/25/17.
 * This class tests the Schedule class.
 */
public class TestSchedule {


    // Tests getCourse
    @Test
    public static void testGetCourse(Schedule s) {
        //Assert
        Time timeObj1 = new Time(10, 38, true);
        Schedule scheduleObj = new Schedule();

        //Act
        String weekday = "F";
        Weekday weekdayObj1 = Weekday.valueOf(weekday);

        //Arrange
        Assert.assertEquals("Cannot get course", null, scheduleObj.getCourse(weekdayObj1, timeObj1));
    }

    // Tests remove
    @Test
    public static void testRemove() {


    }


}

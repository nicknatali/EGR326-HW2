import org.junit.Assert;
import org.junit.Test;

/**
 * Created by NickNatali on 1/25/17.
 * This class tests the weekday class
 */
public class TestWeekday {


    @Test
    public void testToShortName() {
        //Arrange
        Weekday weekdayObject = Weekday.MONDAY;

        //Act
        String monday = "M";

        //Assert
        Assert.assertEquals("Invalid weekday", monday, weekdayObject.toShortName());
    }


}

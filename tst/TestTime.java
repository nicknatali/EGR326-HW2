import org.junit.Assert;
import org.junit.Test;

/**
 * Created by NickNatali on 1/25/17.
 * This class tests the Time class.
 */
public class TestTime {

    // Test toString()
    @Test
    public void testToString() {
        //Arrange
       Time timeObj = new Time(1, 23, true);

       //Assert
       Assert.assertEquals("Invalid toString", "", timeObj.toString() );
    }

    // Test fromString method
    @Test
    public void testFromString() {
        //Arrange
        Time timeTest = new Time(1, 23, true);
        Time string = timeTest.fromString("");

        //Act
        String fromStringTest = "12:00AM";
        timeTest.fromString(fromStringTest);

        //Act
        Assert.assertEquals("Incorrect from String conversion", fromStringTest, timeTest.fromString("12:00AM"));

    }

    // Test equals
    @Test
    public void checkEquals() {
        //Arrange
        Time timeObj1 = new Time(11, 20, true);
        Time timeObj2 = new Time(12, 30, false);

        //Act
        boolean checkEqualsTest = true;
        timeObj2.equals(checkEqualsTest);

        //Assert
        Assert.assertEquals("Invalid", checkEqualsTest, timeObj1.equals(timeObj2));
    }

    // Test compareTo
    @Test
    public void testCompareTo() {
        //Arrange
        Time timeObj1 = new Time(11, 20, true);
        Time timeObj2 = new Time(12, 30, false);

        //Act
        timeObj1.compareTo(timeObj2);

        //Assert
        Assert.assertEquals("Invalid", timeObj2.compareTo(timeObj1), timeObj1.compareTo(timeObj2));
    }

    // Test shift
    @Test
    public void testShift() {
        Time timeObject1 = new Time(11, 31, true);
        timeObject1.shift(20);
        Assert.assertEquals("incorrect shift", timeObject1,"11:51PM");

        Time timeObject2 = new Time(11, 31, false);
        timeObject2.shift(120);
        Assert.assertEquals("incorrect shift", timeObject2,"1:31PM");

        Time timeObject3 = new Time(10, 32, true);
        timeObject3.shift(120);
        Assert.assertEquals("incorrect shift", timeObject3,"1:31PM");

        Time timeObject4 = new Time(12, 32, true);
        timeObject4.shift(30);
        Assert.assertEquals("incorrect shift", timeObject4,"1:02PM");

        Time timeObject5 = new Time(11, 59, true);
        timeObject5.shift(30);
        Assert.assertEquals("incorrect shift", timeObject5,"12:29AM");

        Time timeObject6 = new Time(9, 20, false);
        timeObject6.shift(45);
        Assert.assertEquals("incorrect shift", timeObject6,"10:05AM");

    }


}

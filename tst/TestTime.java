import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Nick Natali on 1/25/17.
 * This class tests the Time class.
 */
public class TestTime {

    /**
     * Test toString()
     */
    @Test
    public void testToString() {
        //Arrange
        int hour = 9;
        int minute = 23;
        boolean pm = true;

        //Act
        Time timeObj = new Time(hour, minute, pm);

       //Assert
       Assert.assertEquals("Invalid toString", "09:23 PM", timeObj.toString());

       //Negative Testing
       Assert.assertNotEquals("Valid String", "09:23 PM", timeObj.toString());
    }

    /**
     * Test fromString method
     */
    @Test
    public void testFromString() {
        //Arrange
        int hour = 1;
        int minute = 23;
        boolean pm = true;
        String fromStringTest = "12:01 AM";
        Time timeTest = new Time(hour, minute, pm);


        //Act
        Time string = timeTest.fromString(fromStringTest);

        //Assert
        Assert.assertEquals("Incorrect from String conversion", string, timeTest.fromString("12:01 AM"));

        //Negative Testing
        Assert.assertNotEquals("Correct from String conversion", string, timeTest.fromString("12:01 AM"));
    }

    /**
     * Test equals
     */
    @Test
    public void checkEquals() {
        //Arrange
        int hour = 11;
        int minute = 30;
        boolean pm = true;
        boolean checkEqualsTest = true;


        //Act
        Time timeObj1 = new Time(hour, minute, pm);
        Time timeObj2 = new Time(hour, minute, pm);

        timeObj2.equals(checkEqualsTest);

        //Assert
        Assert.assertEquals("Invalid", checkEqualsTest, timeObj1.equals(timeObj2));

        //Negative Testing
        Assert.assertNotEquals("Valid", checkEqualsTest, timeObj1.equals(timeObj2));
    }

    /**
     * Test compareTo
     */
    @Test
    public void testCompareTo() {
        //Arrange
        int hour = 1;
        int minute = 32;
        boolean pm = true;

        //Act
        Time timeObj1 = new Time(hour, minute, pm);
        Time timeObj2 = new Time(hour, minute, pm);

        //Assert
        Assert.assertEquals("Invalid", 0, timeObj2.compareTo(timeObj1));
        timeObj1.shift(30);
        Assert.assertEquals("Invalid", -1, timeObj2.compareTo(timeObj1));
        timeObj2.shift(40);
        Assert.assertEquals("Invalid", 1, timeObj2.compareTo(timeObj1));

        //Negative Testing
        timeObj1.shift(10);
        Assert.assertNotEquals("These are equal", 0, timeObj2.compareTo(timeObj1));
        timeObj1.shift(15);
        Assert.assertNotEquals("These are not equal", -1, timeObj2.compareTo(timeObj1));
        timeObj2.shift(16);
        Assert.assertNotEquals("These are not equal", 1, timeObj2.compareTo(timeObj1));
    }

    /**
     * Test shift
     */
    @Test
    public void testShift() {
        Time timeObject1 = new Time(11, 31, true);
        Time timeObj1 = new Time(11, 51, true);

        timeObject1.shift(20);
        Assert.assertEquals("incorrect shift", timeObject1, timeObj1);

        Time timeObject2 = new Time(11, 31, false);
        Time timeObj2 = new Time(1, 31, true);

        timeObject2.shift(120);
        Assert.assertEquals("incorrect shift", timeObject2, timeObj2);

        Time timeObject3 = new Time(10, 32, true);
        Time timeObj3 = new Time(12,32, false);
        timeObject3.shift(120);
        Assert.assertEquals("incorrect shift", timeObject3, timeObj3);

        Time timeObject4 = new Time(12, 32, true);
        Time timeObj4 = new Time(1, 02, true );

        timeObject4.shift(30);
        Assert.assertEquals("incorrect shift", timeObject4,timeObj4);

        Time timeObject5 = new Time(11, 59, true);
        Time timeObj5 = new Time(12, 29, false);
        timeObject5.shift(30);
        Assert.assertEquals("incorrect shift", timeObject5,timeObj5);

        Time timeObject6 = new Time(9, 20, false);
        Time timeObj6 = new Time(10, 05, false);
        timeObject6.shift(45);
        Assert.assertEquals("incorrect shift", timeObject6,timeObj6);

        //Negative testing
        int hour = 10;
        int minute = 23;
        boolean pm = false;

        Time timeObject7 = new Time(hour, minute, pm);
        Time timeObj7 = new Time(hour, minute, pm);

        timeObject7.shift(40);
        timeObj7.shift(40);

        Assert.assertNotEquals("The shift was correct", timeObject7, timeObj7);
    }
}

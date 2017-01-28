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
       Assert.assertEquals("Invalid toString", "01:23 PM", timeObj.toString() );
    }

    // Test fromString method
    @Test
    public void testFromString() {
        //Arrange
        Time timeTest = new Time(1, 23, true);
        String fromStringTest = "12:01 AM";

        //Act
        Time string = timeTest.fromString(fromStringTest);



        //Act
        Assert.assertEquals("Incorrect from String conversion", string, timeTest.fromString("12:01 AM"));

    }

    // Test equals
    @Test
    public void checkEquals() {
        //Arrange
        Time timeObj1 = new Time(11, 30, true);
        Time timeObj2 = new Time(11, 30, true);

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
        Time timeObj2 = new Time(11, 20, true);

        //Act
        timeObj1.compareTo(timeObj2);

        //Assert
        Assert.assertEquals("Invalid", timeObj2.compareTo(timeObj1), timeObj1.compareTo(timeObj2));
    }

    // Test shift
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

    }


}

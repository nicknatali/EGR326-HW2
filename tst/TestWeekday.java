import org.junit.Assert;
import org.junit.Test;

/**
 * Created by NickNatali on 1/25/17.
 * This class tests the weekday class
 */
public class TestWeekday {

    /**
     * Test the toShortName method
     */
    @Test
    public void testToShortName() {
        Assert.assertEquals("M", Weekday.MONDAY.toShortName());
        Assert.assertEquals("T", Weekday.TUESDAY.toShortName());
        Assert.assertEquals("W", Weekday.WEDNESDAY.toShortName());
        Assert.assertEquals("R", Weekday.THURSDAY.toShortName());
        Assert.assertEquals("F", Weekday.FRIDAY.toShortName());

        //Negative tests
        Assert.assertNotEquals("Not correct day","M",Weekday.TUESDAY.toString());
        Assert.assertNotEquals("Not correct day","T",Weekday.WEDNESDAY.toString());
        Assert.assertNotEquals("Not correct day","R",Weekday.FRIDAY.toString());
        Assert.assertNotEquals("Not correct day","F",Weekday.MONDAY.toString());
    }

    /**
     * Test the to String method
     */
    @Test
    public void toStringTest(){
        //Asserts
        Assert.assertEquals("Monday", Weekday.MONDAY.toString());
        Assert.assertEquals("Tuesday", Weekday.TUESDAY.toString());
        Assert.assertEquals("Wednesday", Weekday.WEDNESDAY.toString());
        Assert.assertEquals("Thursday", Weekday.THURSDAY.toString());
        Assert.assertEquals("Friday", Weekday.FRIDAY.toString());

        //Negative tests
        Assert.assertNotEquals("Not correct day","Monday",Weekday.TUESDAY.toString());
        Assert.assertNotEquals("Not correct day","Tuesday",Weekday.WEDNESDAY.toString());
        Assert.assertNotEquals("Not correct day","Thursday",Weekday.FRIDAY.toString());
        Assert.assertNotEquals("Not correct day","Friday",Weekday.MONDAY.toString());
    }

    /**
     * Test from String method
     *
     */
    @Test
    public void fromStringTest(){
        //Asserts
        Assert.assertEquals(Weekday.MONDAY, Weekday.fromString("MONdAY"));
        Assert.assertEquals(Weekday.MONDAY, Weekday.fromString("M"));
        Assert.assertEquals(Weekday.TUESDAY, Weekday.fromString("TUeSday"));
        Assert.assertEquals(Weekday.TUESDAY, Weekday.fromString("t"));
        Assert.assertEquals(Weekday.WEDNESDAY, Weekday.fromString("WEDnesDAY"));
        Assert.assertEquals(Weekday.WEDNESDAY, Weekday.fromString("w"));
        Assert.assertEquals(Weekday.THURSDAY, Weekday.fromString("r"));
        Assert.assertEquals(Weekday.THURSDAY, Weekday.fromString("THuRSDAY"));
        Assert.assertEquals(Weekday.FRIDAY, Weekday.fromString("FRIDay"));
        Assert.assertEquals(Weekday.FRIDAY, Weekday.fromString("f"));

        //Negative Tests
        Assert.assertNotEquals(Weekday.MONDAY, Weekday.fromString("TUeSday"));
        Assert.assertNotEquals(Weekday.MONDAY, Weekday.fromString("T"));
        Assert.assertNotEquals(Weekday.TUESDAY, Weekday.fromString("MONday"));
        Assert.assertNotEquals(Weekday.TUESDAY, Weekday.fromString("m"));
        Assert.assertNotEquals(Weekday.WEDNESDAY, Weekday.fromString("ThursDAY"));
        Assert.assertNotEquals(Weekday.WEDNESDAY, Weekday.fromString("r"));
        Assert.assertNotEquals(Weekday.THURSDAY, Weekday.fromString("w"));
        Assert.assertNotEquals(Weekday.THURSDAY, Weekday.fromString("Friday"));
        Assert.assertNotEquals(Weekday.FRIDAY, Weekday.fromString("WeDNesDay"));
        Assert.assertNotEquals(Weekday.FRIDAY, Weekday.fromString("f"));

    }

}

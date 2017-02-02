import com.sun.istack.internal.NotNull;

/**
 * Created by Nick Natali on 1/22/17.
 * The Time class represents a particular time of day such as 12:30 PM or 9:47 AM.
 * All Time objects always have a valid state.
 * @author: Nick Natali
 * @Version: SP17 Jan
 */
public class Time implements Cloneable, Comparable<Time>{
    //Private variables
    private int hour;
    private int minute;
    private boolean isPM;

    /**
     * Constructor
     * @param hour - intger representation for the hour
     * @param minute - integer representation for the minutes of the hour
     * @param isPM - true/false for meridiem.
     * @throws IllegalArgumentException
     */
    public Time(int hour, int minute, boolean isPM) throws IllegalArgumentException{
        //Throw an error if hour & minute are not formatted properly.
        if((hour <= 0 || hour > 12) || (minute < 0 || minute >= 60))
            throw new IllegalArgumentException();
        this.hour = hour;
        this.minute = minute;
        this.isPM = isPM;
    }

    /**
     * If in correct format, convert string to TimeObj
     * @param str - represents the time in a "12:00 AM" format
     * @return - Time object
     * @throws IllegalArgumentException
     */
    public static Time fromString(String str) throws IllegalArgumentException{
        //break string apart
        String[] timeFormat = str.split("[: ]");
        int hour = Integer.parseInt(timeFormat[0]);
        int minute = Integer.parseInt(timeFormat[1]);
        boolean isPm;
        //If parts are not the desired length
        if(timeFormat[0].length() != 2 || timeFormat[1].length() != 2 || timeFormat[2].length() != 2)
            throw new IllegalArgumentException();
        //Make sure part[2] is exactly PM or AM, else throw an error
        if(timeFormat[2].equals("PM"))
            isPm = true;
        else if(timeFormat[2].equals("AM"))
            isPm = false;
        else
            throw new IllegalArgumentException();
        //If an error hasn't been thrown yet, return the new Time object
        return new Time(hour, minute, isPm);
    }

    /**
     * Override equal function
     * @param o - object
     * @return boolean
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Time && o != null){
            Time t = (Time) o;
            return (hour == t.hour && minute == t.minute && isPM == t.isPM);
        }
        return false;
    }

    /**
     * Overrides hashcode function
     * @return int
     */
    @Override
    public int hashCode() {
        if(isPM)
            return hour * 347 + minute * 347;
        else
            return hour * 307 + minute * 307;
    }

    /**
     * Accessors
     */
    public int getHour() {return hour;}
    public int getMinute() {return minute;}
    public boolean isPM() {return isPM;}

    /**
     * Shifts time of Time object by desired amount given in minutes
     * @param mins - integer to detmine how much to shift the time by
     */
    public void shift(int mins){
        //If negative mins, throw an illegal argument error
        if(mins < 0)
            throw new IllegalArgumentException();
        //Create an index variable and a list of hours
        int hourIndex = 0;
        int [] hours = {12,1,2,3,4,5,6,7,8,9,10,11,12,1,2,3,4,5,6,7,8,9,10,11};
        //Check for special cases in which hour index needs a special or specific value
        if(!isPM && hour == 12)
            hourIndex = 0;
        else if(isPM && hour != 12)
            hourIndex = hour + 12;
        else
            hourIndex = hour;
        //Add to hour index the number of positions moved, or how many hours are being added
        hourIndex += ((mins + minute) / 60) % 24;
        //If hourIndex is 24, thats the same as saying index is 0
        if(hourIndex == 24)
            hourIndex = 0;
        //If hourIndex is in the upper half of the array of hours, its PM otherwise AM
        if(hourIndex >= 12)
            isPM = true;
        else
            isPM = false;
        //Officially set hour/minute to what it has been changed too
        hour = hours[hourIndex];
        minute = ((mins % 60) + minute) % 60;
    }

    /**
     * Change Time object variables to a formatted string
     * @return string
     */
    @Override
    public String toString() {
        if(isPM == false)
            return (String.format("%02d", hour) + ":" + String.format("%02d", minute) + " AM");
        else
            return (String.format("%02d", hour) + ":" + String.format("%02d", minute) + " PM");
    }

    /**
     * Override clone function
     * @return time object
     */
    @Override
    public Time clone() {
        try {
            return (Time) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Allow for two Time objects to be compared
     * @param o - time object
     * @return integer
     */
    @Override
    public int compareTo(@NotNull Time o) {
        //Variable to store total amount of minutes
        int thisTotalMins, otherTotalMins;
        //Special conditions for accounting for this objects minutes
        if(!isPM && hour == 12)
            thisTotalMins = minute;
        else if(isPM && hour != 12)
            thisTotalMins = (hour * 60) + minute + 720;
        else
            thisTotalMins = (hour * 60) + minute;
        //Special conditions for accounting for other objects minutes
        if(!o.isPM && o.hour == 12)
            otherTotalMins = o.minute;
        else if(o.isPM && o.hour != 12)
            otherTotalMins = (o.hour * 60) + o.minute + 720;
        else
            otherTotalMins = (o.hour * 60) + o.minute;
        //Return which has the most amount of minutes
        if(thisTotalMins > otherTotalMins)
            return 1;
        else if(thisTotalMins == otherTotalMins)
            return 0;
        else
            return -1;
    }
}

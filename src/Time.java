
/**
 * Created by NickNatali on 1/22/17.
 * The Time class represents a particular time of day such as 12:30 PM or 9:47 AM.
 * All Time objects always have a valid state.
 */
public class Time implements Cloneable, Comparable<Time> {

    int hour;
    int minute;
    boolean PM;

    /**
     * Constructor
     */
    public Time(int hour, int minute, boolean PM) {

        //Validate hour and minutes
        if(hour < 1 || hour > 12) {
            throw new IllegalArgumentException("The hour cannot be less than 1 or greater than 12");
        }

//        if(minute < 1 || minute > 59) {
//            throw new IllegalArgumentException("The minutes cannot be less than 1 or greater than 59");
//        }

        this.hour = hour;
        this.minute = minute;
        this.PM = PM;
    }

    /**
     * Accepts a string and converts it into a time object
     */
    public static Time fromString(String str) {
        //Check if str is null
        if(str.equals(null)) {
            throw new IllegalArgumentException();
        }

        //If the time is greater than 10
        if(str.subSequence(2,3).equals(":")) {
            String hour = str.substring(0,2);
            String minute = str.substring(3,5);
            String meridiem = str.substring(6,8).toUpperCase();
            boolean pm = true;

            if(meridiem.equals("AM")) {
                pm = false;
            }
            return new Time(Integer.parseInt(hour), Integer.parseInt(minute), pm);
        }

        //If the time is less than 10
        else if(str.subSequence(1,2).equals(":")) {
            String hour = "0" + str.substring(0,1);
            String minute = str.substring(2,4);
            String meridiem = str.substring(5,7).toUpperCase();
            boolean pm = true;

            if(meridiem.equals("AM")) {
                pm = false;
            }
            return new Time(Integer.parseInt(hour), Integer.parseInt(minute), pm);
        } else {
            throw new IllegalArgumentException("Please enter the time in the corrext format");
        }
    }


    /**
     * Returns a copy of the object, following the contract of clone from the Java API
     */
    @Override
    public Time clone() throws CloneNotSupportedException {

        // Must use try catch to call Object's clone method
        try {
            return clone();
        } catch (CloneNotSupportedException e) {
            //Dead code this will never happen because Cloneable is already implemented.
            System.out.println(e);
            return null;
        }
    }


    /**
     * Returns true if o refers to a Time object w/ exactly the same state as this one
     */
    public boolean equals(Time o) {
        return this.getHour() == o.getHour() && this.getMinute() == o.getMinute() && this.isPM() == o.isPM();
    }

    /**
     * Returns an integer indicating this time's placement in the natural ordering of times
     * relative to the given other time.
     */
    @Override
    public int compareTo(Time time) {

        int firstHour = 0;
        int secondHour = 0;

        //Convert to minutes, then compare

        //isPM = true, and after 12PM
        if(this.PM && this.hour != 12) {
            firstHour = (this.hour + 12) * 60;
        }

        if(time.PM && time.hour != 12) {
            secondHour = (time.hour + 12) * 60;
        }

        //Time is 12PM or isPM = false
        if(this.PM && this.hour == 12) {
            firstHour = (this.hour * 60);
        }

        if(time.PM && time.hour == 12) {
            secondHour = (time.hour * 60);
        }

        //Add in the minutes
        firstHour += this.minute;
        secondHour += time.minute;

        return (firstHour - secondHour);
    }


    /**
     *Acessors
     */
    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return  this.minute;
    }

    /**
     * Returns true if this time occurs between 12:00PM and 11:59PM
     * TODO: double check this function
     */
    public boolean isPM() {
        return this.PM;
    }

    /**
     * Adjusts this time object forward in time by the given number of minutes.
     */
    public void shift(int minutes) {

        //Check if minutes exists
        if (minutes < 0) {
            throw new IllegalArgumentException("Cannot have less than 0 minutes");
        }

        //Variables
        int newHour = this.hour;
        int newMinute = this.minute + minutes;

        if (newMinute < 60) {

            newMinute = this.minute + minutes;

        } else {

            //Convert 24 hour span
            if(this.PM) {
                newHour += 12;
            }

            //12AM
            if(newHour == 12 && !this.PM) {
                newHour = 0;
            }

            //Adding the new minutes to the subsequent hour
            while(newMinute >= 60) {
                    newHour += 1;
                    newMinute -= 60;
            }

            //Determining meridiem
            this.PM = newHour % 24 >= 12 || (this.hour == 12 && this.PM && newHour > 24);

            this.hour = newHour % 24;

            if(this.hour == 0) {
                this.hour = 12;
            }

            if(this.hour > 12) {
                this.hour = this.hour % 12;
            }

            this.minute = newMinute;

        }

    }

    /**
     * Returns a string for this time in HH:MM AM/PM format.
     */
    public String toString() {

        String hour = Integer.toString(this.hour);

        //If the hour is less than 10, preceed it with a 0
        if(this.hour < 10 ) {
            hour = "0" + this.hour;
        }

        String minute = Integer.toString(this.minute);

        //If the minutes are less than ten, preceed it with a 0
        if (this.minute < 10) {
            minute = "0" + this.minute;
        }

        //Meridiem
        if (this.PM) {
            return hour + ":" + minute + " PM";
        }

        return hour + ":" + minute + " AM";
    }


}

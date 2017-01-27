import java.util.Set;
import java.util.TreeSet;

/**
 * Created by NickNatali on 1/22/17.
 * This class contains information about a particular university course.
 */
public class Course {

    //Variables
    private String name;
    private int credits;
    private Set<Weekday> days;
    private Time startTime;
    private int duration;

    /**
     * Constructor
     */
    public Course(String name, int credits, Set<Weekday> days, Time startTime, int duration) {

        if(days.isEmpty()) {
            throw new IllegalArgumentException("Invalid amount of days.");
        }

        if(credits < 1 || credits > 5) {
            throw new IllegalArgumentException("Invalid amount of credits.");

        }

        if (duration < 1) {
            throw new IllegalArgumentException("Invalid duration");
        }

        this.name = name;
        this.credits = credits;
        this.days = new TreeSet<Weekday>(days);
        this.startTime = startTime;
        this.duration = duration;
    }

    /**
     * Returns true if this course is in session during any days and times that overlap
     * with the given course.
     */

    public boolean conflictsWith(Course course) {

        Time start = course.getStartTime();
        Time end = course.getEndTime();
        Set<Weekday> days = course.days;

        //Loop through each day classes are in session
        //Check for conflicts
        for (Weekday d : days) {
            // Check conflicts with start and end times
            boolean startTime = contains(d, start);
            boolean endTime = contains(d, end);

            if (startTime || endTime) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this course is in session during the given time on the given day.
     */
    public boolean contains(Weekday day, Time time) {

        Time timeObj = this.startTime;
        Time endTime = getEndTime();

        if (days.contains(day)) {
            // Check is starting times are equivalent
            if (timeObj.equals(time)) {
                return true;

                //Check within start and end times
            } else // If there aren't any matches
                return timeObj.compareTo(time) < 0 && endTime.compareTo(time) > 0;
        }
        return false;

    }

    /**
     * Returns true if and only if o refers to a Course object with exactly equivalent state as this one;
     * otherwise returns false;
     */
    public boolean equals (Course o) {
        return this.name.equals(o.getName()) && this.getCredits() == o.getCredits() &&
                this.days.equals(o.days) && this.startTime.equals(o.startTime) && this.duration == o.duration;
    }

    /**
     * Accessors for the course's various state as passed to the constructor
     */
    public int getCredits() {
        return this.credits;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getName() {
        return this.name;
    }

    public Time getStartTime() {
        return this.startTime;
    }

    /**
     * Returns the non-inclusive and end time for this course,
     * which differs in time by exactly duration minutes
     * from the course's start time.
     */
    public Time getEndTime() {
        int hour = this.startTime.getHour();
        int minute = this.startTime.getMinute();
        boolean period = this.startTime.isPM();

        Time timeObj = new Time(hour, minute, period);
        timeObj.shift(this.duration);
        return timeObj;
    }

    /**
     * Returns a string representation of this course. The string contains the course's name,
     * credits, days, start time, and duration separated by commas.
     */
    public String toString() {
        String days = "";

        for(Weekday day : this.days) {
            days += day.toShortName();
        }

        return this.name + ", " + this.credits + ", " + days + ", " + this.startTime + ", " + this.duration;
    }

}

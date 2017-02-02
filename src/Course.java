import java.util.Set;
/**
 * Created by NickNatali on 1/22/17.
 * This class contains information about a particular university course.
 * @author: Nick Natali
 * @Version: SP17 Jan
 */
import org.jetbrains.annotations.NotNull;

public class Course implements Cloneable, Comparable<Course>{
    //Private Variables
    private String name;
    private int credits;
    private Set<Weekday> days;
    private Time startTime;
    private int duration;


    /**
     * Constructor
     * @param name - String representation for course
     * @param credits - int representation for units of a course
     * @param days - days of the week that the course in class
     * @param startTime - Time object that represents the beginning time of the course
     * @param duration - int that represents how long a single course will be
     */
    public Course(String name, int credits, Set<Weekday> days, Time startTime, int duration){
        //Ensure that all entries are valid
        if(credits > 5 || credits <= 0 || days == null || days.isEmpty() || startTime == null
                || duration <= 0 || name == null || name.length() == 0 || !name.contains(" "))
            throw new IllegalArgumentException();
        this.name = name;
        this.credits = credits;
        this.days = days;
        this.startTime = startTime.clone();
        this.duration = duration;
    }

    /**
     * Checks for conflicts with other courses
     * @param course - course object to check if it conflicts with any other courses
     * @return
     */
    public boolean conflictsWith(Course course){
        //Loop through each day of this and other course
        for(Weekday each : days){
            if(course.days.contains(each)){
                //Calculate start and end times
                Time endTime = startTime.clone();
                endTime.shift(duration);
                Time otherEndTime = course.startTime.clone();
                otherEndTime.shift(course.duration);
                //If one course starts before the other and ends after the next one starts, return true
                if(endTime.compareTo(course.startTime) <= 0 || startTime.compareTo(otherEndTime) >= 0)
                    return false;
                else
                    return true;
            }
        }
        return false;
    }

    /**
     * Checks to see if a time is during a given class.
     * @param day - to get what day the course is on
     * @param time - to get information about start and end times
     * @return
     */
    public boolean contains(Weekday day, Time time){
        if(days.contains(day)){
            //Calculate start and end times
            Time endTime = startTime.clone();
            endTime.shift(duration);
            //If time is between start and end time, return true
            if(time.compareTo(startTime) >= 0 && time.compareTo(endTime) == -1)
                return true;
        }
        return false;
    }

    /**
     * Checks if two courses are equal
     * @param obj to override equals method
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == Course.class && obj != null){
            Course other = (Course) obj;
            return (name.equals(other.name) && credits == other.credits && days.equals(other.days)
                    && startTime.equals(other.startTime) && duration == other.duration);
        }
        return false;
    }

    /**
     * Overrides the hashcode method
     * @return an int
     */
    @Override
    public int hashCode() {
        int hashCode = 92821 * name.hashCode();
        hashCode *= credits;
        hashCode *= days.hashCode();
        hashCode *= startTime.hashCode();
        hashCode *= duration;
        return hashCode;
    }

    /**
     * Getters
     */
    public String getName() {return name;}
    public int getCredits() {return credits;}
    public Time getStartTime() {return startTime;}
    public int getDuration() {return duration;}
    public Time getEndTime(){
        Time endTime = startTime.clone();
        endTime.shift(duration);
        return (endTime);
    }

    /**
     * Converts object to string
     * @return a String
     */
    @Override
    public String toString() {
        String stringOfCourse = name + "," + credits + ",";
        for (Weekday each : days)
            stringOfCourse += each.toShortName();
        stringOfCourse += ("," + startTime.toString() + "," + duration);
        return stringOfCourse;
    }

    /**
     * Override compare function
     */
    @Override
    public int compareTo(@NotNull Course o) {
        return 0;
    }

    /**
     * Override clone function
     */
    @Override
    public Course clone() {
        return new Course(name, credits, days, startTime.clone(), duration);
    }
}

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.io.*;

/**
 * Created by NickNatali on 1/22/17.
 * The schedule class contains information about the
 * collection of courses in which a student is
 * enrolled.
 */
public class Schedule implements Cloneable {

    //Variables
    private List<Course> schedule;
    private int totalCredits;

    /**
     * Constructor
     */
    public Schedule() {
            this.schedule = new ArrayList<Course>();
            this.totalCredits = 0;
    }

    /**
     * Adds the given course to this schedule.
     */
    public void add(Course course) {
        //Check for conflicts
        for(Course course2 : this.schedule) {
            if(course2.conflictsWith(course)) {
                throw new ScheduleConflictException(course, course2);
            }
        }
        this.schedule.add(course);
        this.totalCredits += course.getCredits();
    }

    /**
     * Returns a copy of the object.
     */
    public Schedule clone() {
        // Must use try catch in order to call Object's clone method
        try {
            Schedule copyObj = (Schedule) super.clone();

            //deep copy
            copyObj.schedule = new ArrayList<Course>(schedule);

            return copyObj;

        } catch (CloneNotSupportedException e) {
            //Dead code this will never happen because Cloneable is already implemented.
            System.out.println(e);
            return null;
        }
    }

    /**
     * Returns the course, if any, in this schedule that takes place on the given weekday at the
     * given time.
     */
    public Course getCourse(Weekday day, Time time) {
        //Loop through schedule
        for (Course course : this.schedule) {
            if(course.contains(day, time)) {
                return course;
            }
        }
        return  null;
    }

    /**
     * Removes the course, if any, in this schedule that takes place
     * on the given weekday at the given time.
     */
    public void remove(Weekday day, Time time) {
        //Loop through the schedule
        for(int i = 0; i < this.schedule.size(); i++)  {
            Course course = this.schedule.get(i);

            if (course.contains(day,time)) {
                int credits = course.getCredits();
                this.totalCredits -= credits;
                this.schedule.remove(course);
                break;  //If the course is found, don't keep looping.
            }
        }
    }

    /**
     * Outputs the courses from this schedule to the given output file
     * in the ordering represented by the given course comparator.
     */
    public void save(PrintStream printStream, Comparator<Course> comparator) {
        //sort schedule by the comparator chosen by user
        Collections.sort(this.schedule, comparator);

        //output each course to file
        for(Course course : this.schedule) {
            printStream.println(course);
        }
        printStream.close();
    }

    /**
     * Returns the total number of credits for which
     * the student is enrolled in.
     */
    public int totalCredits() {
        return this.totalCredits;
    }

    /**
     * Returns a String representation of the schedule
     */
    public String toString() {
        return this.schedule.toString();
    }
}

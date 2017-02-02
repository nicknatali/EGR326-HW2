import java.util.Comparator;
import java.util.*;

/**
 * Created by NickNatali on 1/22/17.
 * This class is for sorting a schedule by days and times
 * @author: Nick Natali
 * @Version: SP17 Jan
 */
public class CourseTimeComparator implements Comparator<Course> {

    /**
     * Initializes a new CourseTimeComparator
     */
    public CourseTimeComparator() {

    }


    /**
     * Compares first by start time in ascending chronological order, breaking ties by
     * ending time in ascending chronological order, and finally breaking ties by name
     * in alphabetical order.
     * @param course1 - Course object to compare by time
     * @param course2 - Course object to compare by time
     * @return int
     */
    public int compare(Course course1, Course course2) {
        Time timeObj1 = course1.getStartTime();
        Time timeObj2 = course2.getStartTime();

        if(!timeObj1.equals(timeObj2)){
            return timeObj1.compareTo(timeObj2);
        } else if (course1.getDuration() != course2.getDuration()) {
            return course1.getDuration() - course2.getDuration();
        }

        return course1.getName().compareTo(course2.getName());

    }
}

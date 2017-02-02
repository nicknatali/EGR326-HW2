import java.util.Comparator;
import java.util.*;

/**
 * Created by NickNatali on 1/22/17.
 * This class is for sorting a schedule by number of credits for each
 course
 * @author: Nick Natali
 * @Version: SP17 Jan
 */
public class CourseCreditComparator implements Comparator<Course> {

    /**
     * Initializes new CourseCreditComparator
     */
    public CourseCreditComparator() {

    }


    /**
     * Compares the first by number of credits in ascending order, breaking ties by comparing names in
     * alphabetical order. If two courses have the same number of credits and same name, they are considered equal.
     * @param course1- Course object to compare with the second parameter
     * @param course2 - Course object to compare with the first parameter
     * @return int
     */
    public int compare(Course course1, Course course2){
        if(course1.getCredits() != course2.getCredits()) {
            return course1.getCredits() - course2.getCredits();
        }
        return course1.getName().compareTo(course2.getName());
    }

}

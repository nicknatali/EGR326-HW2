import java.util.Comparator;

/**
 * Created by NickNatali on 1/22/17.
 *  This class is for sorting a schedule by course name
 * @author: Nick Natali
 * @Version: SP17 Jan
 */
public class CourseNameComparator implements Comparator<Course> {

    /**
     * Initializes a new CourseNameComparator
     */
    public CourseNameComparator() {

    }

    /**
     * Constructor
     * @param course1 - Course object to compare by name with the second parameter
     * @param course2 - Course object to compare by name with the second parameter
     * @return int
     */
    public int compare(Course course1, Course course2) {

        return course1.getName().compareTo(course2.getName());
    }

}

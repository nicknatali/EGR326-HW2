import java.util.Comparator;

/**
 * Created by NickNatali on 1/22/17.
 * TODO: write what this class is about
 */
public class CourseNameComparator implements Comparator<Course> {

    /**
     * Initializes a new CourseNameComparator
     */
    public CourseNameComparator() {

    }

    /**
     * Constructor
     */
    public int compare(Course course1, Course course2) {
        return course1.getName().compareTo(course2.getName());
    }

}

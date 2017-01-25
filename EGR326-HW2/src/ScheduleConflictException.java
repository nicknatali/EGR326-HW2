/**
 * Created by NickNatali on 1/22/17.
 * The ScheduleConflictException class refers to a runtime exception, that indicates that the client
 * has attempted to introduce a conflict into a course schedule (overlapping courses).
 */
public class ScheduleConflictException extends RuntimeException {

    /**
     * Initializes a new ScheduleConflictException
     */
    public ScheduleConflictException() {
        super();
    }

    /**
     * Constructor
     */
    public ScheduleConflictException(Course course1, Course course2) {

        super(course1.getName() + " conflicts with " + course2.getName() + ".");



    }

}

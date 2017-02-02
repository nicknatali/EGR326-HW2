
/**
 * Created by NickNatali on 1/22/17.
 * The Weekday enumeration represents the five days of the week for courses
 * @author: Nick Natali
 * @Version: SP17 Jan
 */
public enum Weekday {
    //Enum
    MONDAY("M"),
    TUESDAY("T"), 
    WEDNESDAY("W"), 
    THURSDAY("R"),
    FRIDAY("F");

    //Variable(s)
    private String day;

    /**
     * Constructor
     */
    Weekday(String day) {
        if(day.equals(null)) {
            throw new IllegalArgumentException("Day must have a value!");
        }
        this.day = day;
    }


    /**
     * Converts a string representation of a weekday to an enum.
     * @param s - string that represents the day of the week s
     * @return a day of the week.
     */
    public static Weekday fromString(String s) {
        if (s.toLowerCase().equals("m") || s.toLowerCase().equals("monday")) {
            return MONDAY;
        } else if (s.toLowerCase().equals("t") || s.toLowerCase().equals("tuesday")) {
            return TUESDAY;
        } else if (s.toLowerCase().equals("w") || s.toLowerCase().equals("wednesday")) {
            return WEDNESDAY;
        } else if (s.toLowerCase().equals("r") || s.toLowerCase().equals("thursday")) {
            return THURSDAY;
        } else if (s.toLowerCase().equals("f") || s.toLowerCase().equals("friday")) {
            return FRIDAY;
        } else {
            throw new IllegalArgumentException("String does not match any weekday value.");
        }
    }

    /**
     * Converts an enum to an appreviated string representing the day of the week.
     * @return a short hand string of the day of the week
     */
    public String toShortName() {

        if( this == MONDAY) {
            return "M";
        } else if (this == TUESDAY) {
            return "T";
        } else if(this == WEDNESDAY){
            return "W";
        } else if(this == THURSDAY) {
            return "R";
        } else if(this == FRIDAY) {
            return "F";
        }

        return "";
    }

    /**
     * Converts an enum to a string.
     * @return a string.
     */
    public String toString() {

        if( this == MONDAY) {
            return "Monday";
        } else if (this == TUESDAY) {
            return "Tuesday";
        } else if(this == WEDNESDAY){
            return "Wednesday";
        } else if(this == THURSDAY) {
            return "Thursday";
        } else if(this == FRIDAY) {
            return "Friday";
        }

        return "";
    }
}

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.BitSet;
import java.util.List;
import java.util.Collections;

class Session implements Schedulable {
    // Constants
    private static final int WORK_HOURS_IN_DAY = 8;
    private static final int START_HOUR = 9;
    private static final int DEFAULT_SESSION_DURATION = 1;
    private static final List<Integer> startTimes =
            Collections.unmodifiableList(List.of(9, 10, 11, 12, 13, 14, 15, 16, 17));


    // Attributes
    private int duration;       // duration of session in minutes
    private int startTime;      // start time of session in minutes (from START_HOUR)
    private int endTime;        // end time of session in minutes
    private final Student student;    // student in session
    private final Tutors tutor;        // tutor conducting the session
    private Course course;      // lesson being taught
    private BitSet sessionTime = new BitSet(WORK_HOURS_IN_DAY);

    /** Constructor with specified duration */
    public Session(int duration, int startTime, Tutors tutor, Student student, Course course)
            throws IllegalArgumentException {
        if (!startTimes.contains(startTime) || startTime + duration > (WORK_HOURS_IN_DAY + START_HOUR)) {
            throw new IllegalArgumentException("Invalid session timing.");
        }

        if (!isAvailable(startTime, duration, tutor, student)) {
            throw new IllegalArgumentException("Tutor is not available at the requested time.");
        }

        this.duration = duration;
        this.startTime = startTime;
        this.endTime = startTime + duration;
        this.tutor = tutor;
        this.student = student;
        this.course = course;

        // Mark session time as occupied
        this.sessionTime = createNewAvailabilityBitSet(startTime, duration);
    }

    /** Constructor with default session duration */
    public Session(int startTime, Tutors tutor, Student student, Course course) {
        this.duration = DEFAULT_SESSION_DURATION;
        this.startTime = startTime;
        this.endTime = startTime + duration;
        this.tutor = tutor;
        this.student = student;
        this.course = course;
    }

    /** Views the session times in a human-readable format */
    public void viewSessionTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        boolean hasAppointment = false;

        for (int i = 0; i < WORK_HOURS_IN_DAY; i++) {
            if (sessionTime.get(i)) {
                hasAppointment = true;
                LocalTime time = LocalTime.of(START_HOUR + i, 0);
                System.out.println("Appointment at: " + time.format(formatter));
            }
        }

        if (!hasAppointment) {
            System.out.println("No scheduled appointments.");
        }
    }

    /** Checks if the session is valid, including tutor availability and subject compatibility */
    public boolean isAvailable(int startTime, int duration, Tutors tutor, Student student) {
        BitSet proposedSession = createNewAvailabilityBitSet(startTime, duration);
        BitSet tutorAvailability = tutor.getAvailability();

        boolean tutorAvailable = containsAllBits(proposedSession, tutorAvailability);
        boolean tutorCanTeachSubject = tutorTeachesSubject(tutor.getCourses(),this.course );

        return tutorAvailable && tutorCanTeachSubject;
    }

    /** Creates a BitSet for the session's availability based on start time and duration */
    public static BitSet createNewAvailabilityBitSet(int startTime, int duration) {
        BitSet newAvailabilityBitSet = new BitSet(WORK_HOURS_IN_DAY);
        newAvailabilityBitSet.set(startTime - START_HOUR, startTime - START_HOUR + duration); // Corrected time setting
        return newAvailabilityBitSet;
    }

    /** Checks if all bits in bitset1 are ON in bitset2 */
    public static boolean containsAllBits(BitSet bitset1, BitSet bitset2) {
        BitSet temp = (BitSet) bitset1.clone(); // Clone bitset1
        temp.and(bitset2); // AND with bitset2

        return temp.equals(bitset1); // If they are equal, all bits in bitset1 are in bitset2
    }

    /** Checks if the tutor teaches the student's current subject */
    public static boolean tutorTeachesSubject(List<Course> tutorCourses, Course targetCourse) {
        return tutorCourses.contains(targetCourse);
    }

    /** Prints details of the session */
    public void viewSessionDetails() {
        System.out.println(
                "Start Time: " + this.startTime +
                        " Duration: " + this.duration +
                        " End Time: " + this.endTime +
                        " Student: " + this.student.getStudentName() +
                        " Tutor: " + this.tutor.getFullName() +
                        " Course: " + this.course
        );
    }

    /** Getters and Setters */
    public int getStartTime(){
        return startTime;
    }
    public int getEndTime(){
        return endTime;
    }
    public Student getStudent(){
        return student;
    }
    public Tutors getTutor(){
        return tutor;
    }
    public Course getCourse() {
        return course;
    }
    public int getDuration() {
        return duration;
    }

    //Setters
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void reschedule(int startTime, int duration, Tutors tutor, Student student) {
        setStartTime(startTime);
        setDuration(duration);
    }

    /** Sets tutor availability */
    public void setAvailability(int timeStart, int duration, boolean isAvailable) {
        if (timeStart < START_HOUR || timeStart + duration > (WORK_HOURS_IN_DAY + START_HOUR)) {
            System.out.println("Invalid time slot.");
        }
        // Logic for setting tutor availability...
    }

    @Override
    public BitSet getAvailabilityBitSet(BitSet newSchedule) {
        // Implement method logic here
        return null;

    }
}

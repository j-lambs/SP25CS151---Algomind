import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.BitSet;

/**
 * Assume time is military time for simplicity of math.
 * Start Time: 9:00
 * Closing Time: 17:00
 */
public class Session implements Schedulable {
    // FINALS
    private static final int WORK_HOURS_IN_DAY = 8;
    private static final int START_HOUR = 9;
    private static final int DEFAULT_SESSION_DURATION = 1;

    // ATTRIBUTES
    private int duration;      // duration of session in seconds
    private int startTime;     // gets start time of session in standard format
    private int endTime;       // end time of session in standard format
    private Student student;    // student in session
    private Tutors tutor;
    private String lesson;      // lesson being taught
    private BitSet sessionTime = new BitSet(WORK_HOURS_IN_DAY);

    /** CONSTRUCTOR
     *
     * @param duration
     * @param startTime
     * @param tutor
     * @param student
     * @param lesson
     */
    public Session(int duration, int startTime, Tutors tutor, Student student, String lesson) throws Exception {
        if (startTime < START_HOUR || startTime + duration > (WORK_HOURS_IN_DAY + START_HOUR)) {
            throw new IllegalArgumentException("Invalid Session.");
        }
        if (!isAvailable(startTime, duration, tutor)) {
            throw new IllegalArgumentException("Invalid Session. Tutor not available.");
        } else {
            this.sessionTime = createNewAvailibilityBitSet(startTime, duration);
        }

        this.duration = duration;
        this.startTime = startTime;
        this.endTime = startTime + this.duration;
        this.tutor = tutor;
        this.student = student;
        this.lesson = lesson;
    }

    /**
     * Constructor, with default duration
     * @param startTime
     * @param tutor
     * @param student
     * @param lesson
     */
    public Session(int startTime, Tutors tutor, Student student, String lesson) {
        this.duration = DEFAULT_SESSION_DURATION;
        this.startTime = startTime;
        this.endTime = startTime + this.duration;
        this.student = student;
        this.lesson = lesson;
    }

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

    /**
     * Checks if session is a valid session.
     * Checks if tutor works during session time and duration.
     * Check Session declaration for time documentation.
     * @param startTime
     * @param duration
     * @return
     */
    @Override
    public boolean isAvailable(int startTime, int duration, Tutors tutor) {
        BitSet proposedSession = createNewAvailibilityBitSet(startTime, duration);
        BitSet tutorAvailibility = tutor.getAvailability();

        return containsAllBits(proposedSession, tutorAvailibility);
    }

    /**
     *
     * @param startTime
     * @param duration
     * @return
     */
    public static BitSet createNewAvailibilityBitSet(int startTime, int duration) {
        BitSet newAvailibilityBitSet = new BitSet(WORK_HOURS_IN_DAY);
        newAvailibilityBitSet.set(startTime, duration);
        return newAvailibilityBitSet;
    }

    /**
     * Checks if every bit in bitset1 are ON in bitset2
     * @param bitset1
     * @param bitset2
     * @return
     */
    public static boolean containsAllBits(BitSet bitset1, BitSet bitset2) {
        BitSet temp = (BitSet) bitset1.clone(); // Clone bitset1
        temp.and(bitset2); // AND with bitset2

        return temp.equals(bitset1); // If they are equal, all bits in bitset1 are in bitset2
    }

    /**
    Starts timer to start session, will end after duration of session
     */
//    public void startSession() {
//        printMilitaryTime(startTime);
//
//        Timer timer = new Timer();
//        // Schedule a task to run after 10 seconds (10000 milliseconds)
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                endSession(timer);
//                timer.cancel(); // Stop the timer after execution
//            }
//        }, this.duration * 1000L);
//
//        System.out.println("Timer started. Function will execute in " + DEFAULT_SESSION_DURATION + " seconds...");
//    }
//
//    /**
//     * Ends session
//     */
//    public void endSession(Timer timer) {
//        System.out.println(duration + " hours passed! Session finished.");
//        printMilitaryTime(endTime);
//        timer.cancel(); // Stop the timer
//        timer.purge(); //Remove cancelled tasks
//
//
//
//    }
//
//    /**
//     * Converts and prints milliseconds from midnight, myTime, and prints it in military time.
//     * @param myTime
//     */
//    public static void printMilitaryTime(long myTime) {
//        System.out.println(String.format("%1$TH:%1$TM:%1$TS", myTime));
//    }

    /**
     * Prints Attributes of Session
     */
    public void viewSessionDetails() {
        System.out.println(
                "Start Time: " + this.startTime +
                "Duration: " + this.duration +
                "End Time: " + this.endTime +
                "Student: " + this.student.getStudentName() +
                "Tutor: " + this.tutor.getFirstName() +
                "Lesson: " + this.lesson
                );
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getLessonName() {
        return lesson;
    }

    /**
     * Time ranges from 1 to 8
     * @param timeStart
     * @param duration
     * @param isAvailable
     */
    @Override
    public void setAvailability(int timeStart, int duration, boolean isAvailable) {
        BitSet newAvailability = new BitSet(WORK_HOURS_IN_DAY);
        int timeEnd = timeStart + duration;
        if (timeEnd <= WORK_HOURS_IN_DAY && timeStart < WORK_HOURS_IN_DAY && timeStart > 0) {
            newAvailability.set(timeStart, endTime);
        } else {
            System.out.println("Invalid time slot to work. Please try again.");
        }
    }

    @Override
    public BitSet getAvailabilityBitSet(BitSet newSchedule) {
        return null;
    }
}

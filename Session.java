import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.BitSet;
import java.util.Timer;
import java.util.TimerTask;

public class Session implements Schedulable {
    // FINALS
    private static final int WORK_HOURS_IN_DAY = 8;
    private static final int START_HOUR = 9;
    private static final int DEFAULT_SESSION_DURATION = 2;

    // ATTRIBUTES
    private long duration;      // duration of session in seconds
    private long startTime;     // gets start time of session in standard format
    private long endTime;       // end time of session in standard format
    private Student student;    // student in session
    private Tutors tutor;
    private String lesson;      // lesson being taught
    private BitSet appointmentTime = new BitSet(WORK_HOURS_IN_DAY);

    /** CONSTRUCTOR
     *
     * @param duration
     * @param startTime
     * @param tutor
     * @param student
     * @param lesson
     */
    public Session(long duration, long startTime, Tutors tutor, Student student, String lesson) {
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = startTime + this.duration * 1000;
        this.tutor = tutor;
        this.student = student;
        this.lesson = lesson;
    }

    /**
     * Constructor, with default duration = 2 'hours'
     * @param startTime
     * @param tutor
     * @param student
     * @param lesson
     */
    public Session(long startTime, Tutors tutor, Student student, String lesson) {
        this.duration = DEFAULT_SESSION_DURATION;
        this.startTime = System.currentTimeMillis();
        this.endTime = startTime + this.duration * 1000;
        this.student = student;
        this.lesson = lesson;
    }

    public void printSessionTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        boolean hasAppointment = false;

        for (int i = 0; i < WORK_HOURS_IN_DAY; i++) {
            if (appointmentTime.get(i)) {
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
     *
     * @param startTime
     * @param duration
     * @return
     */
    @Override
    public boolean isAvailable(int startTime, int duration) {
        BitSet proposedSession = new BitSet(WORK_HOURS_IN_DAY);
        startTime -= WORK_HOURS_IN_DAY;
        // create bitset for proposedSession with startTime and duration
        try {
            proposedSession.set(startTime, startTime + duration);
        } catch (Exception e) {
            System.out.println("Invalid start time or duration.");
        }

        int i = proposedSession.nextSetBit(0);
        while (i != -1) {
            System.out.println("Bit at index " + i + " is set");
            i = proposedSession.nextSetBit(i + 1);
        }

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
//        //TODO: update student lesson after session finished
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
                "Tutor: " + this.tutor.getName() +
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
}

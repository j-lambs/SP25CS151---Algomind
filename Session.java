import java.util.Timer;
import java.util.TimerTask;

public class Session {
    static final int DEFAULT_SESSION_DURATION = 3;

    private long duration;      // duration of session in seconds
    private long startTime;     // gets start time of session in standard format
    private long endTime;       // end time of session in standard format
    private Student student;    // student in session
    private Lesson lesson;      // lesson being taught

    public Session(long duration, long startTime, Student student, Lesson lesson) {
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = startTime + this.duration * 1000;
        this.student = student;
        this.lesson = lesson;
    }

    public Session(Student student, Lesson lesson) {
        this.duration = DEFAULT_SESSION_DURATION;
        this.startTime = System.currentTimeMillis();
        this.endTime = startTime + this.duration * 1000;
        this.student = student;
        this.lesson = lesson;
    }

    /**
    Starts timer to start session, will end after duration of session
     */
    public void startSession() {
        printMilitaryTime(startTime);

        Timer timer = new Timer();
        // Schedule a task to run after 10 seconds (10000 milliseconds)
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                endSession(timer);
                timer.cancel(); // Stop the timer after execution
            }
        }, this.duration * 1000L);

        System.out.println("Timer started. Function will execute in " + DEFAULT_SESSION_DURATION + " seconds...");
    }

    /**
     * Ends session
     */
    public void endSession(Timer timer) {
        System.out.println(duration + " seconds passed! Session finished.");
        printMilitaryTime(endTime);
        timer.cancel(); // Stop the timer
        timer.purge(); //Remove cancelled tasks

        //TODO: update student lesson after session finished

    }

    /**
     * Converts and prints milliseconds from midnight, myTime, and prints it in military time.
     * @param myTime
     */
    public static void printMilitaryTime(long myTime) {
        System.out.println(String.format("%1$TH:%1$TM:%1$TS", myTime));
    }

    /**
     * Prints Attributes of Session
     */
    public void viewSessionDetails() {
        System.out.println(
                "Duration: " + this.duration +
                "Start Time: " + this.startTime +
                "End Time: " + this.endTime +
                "Student: " + this.student.getStudentName() +
                "Lesson: " + this.lesson.getLessonName()
                );
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}

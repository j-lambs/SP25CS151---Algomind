import java.util.Timer;
import java.util.TimerTask;

public class Session {
    static final int DEFAULT_SESSION_DURATION = 10;

    long duration;      // duration of session in seconds
    long startTime;     // seconds from midnight
    long endTime;       // seconds from midnight
    Student student;    // student in session
    Lesson lesson;      // lesson being taught
    Timer timer = new Timer();

    public Session(long duration, long startTime, Student student, Lesson lesson) {
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = startTime + this.duration;
        this.student = student;
        this.lesson = lesson;
    }

    public Session(int startTime, Student student, Lesson lesson) {
        this.duration = DEFAULT_SESSION_DURATION;
        this.startTime = startTime;
        this.endTime = startTime + this.duration;
        this.student = student;
        this.lesson = lesson;
    }

    /**
    Starts timer to start session, will end after duration of session
     */
    public void startSession() {
        // Schedule a task to run after 10 seconds (10000 milliseconds)
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                endSession();
                timer.cancel(); // Stop the timer after execution
            }
        }, this.duration * 1000L);

        System.out.println("Timer started. Function will execute in " + DEFAULT_SESSION_DURATION + " seconds...");
    }

    /**
     * Ends session
     */
    public void endSession() {
        System.out.println(duration + " seconds passed! Session finished.");
        //TODO: update student lesson after session finished
    }

    /**
     * Converts seconds from midnight, myTime, and prints it in military time.
     * @param myTime
     */
    public static String convertToMilitaryTime(long myTime) {
        long hours = (myTime / 3600) % 24;  // Get hours
        long minutes = (myTime % 3600) / 60; // Get remaining minutes
        long seconds = myTime % 60;         // Get remaining seconds

         return (String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    /**
     * Prints Attributes of Session
     */
    public void viewSessionDetails() {
        System.out.println(
                "Duration: " + this.duration
                "Start Time: " + this.startTime +
                "End Time: " + this.endTime +
                "Student: " + this.student.getName() +
                "Lesson: " this.lesson.getName()
                );
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}

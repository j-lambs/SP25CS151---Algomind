public class Session {
    int duration; // duration of session in minutes
    int startTime; // minutes since midnight
    int endTime;
    Student student;
    Lesson lesson;

    public Session(int duration, int startTime, Student student, Lesson lesson) {
        this.duration = duration;
        this.startTime = startTime;
        this.endTime = startTime + duration;
        this.student = student;
        this.lesson = lesson;
    }

    public Session(int startTime, Student student, Lesson lesson) {
        this.duration = 60;
        this.startTime = startTime;
        this.endTime = startTime + duration;
        this.student = student;
        this.lesson = lesson;
    }

    public startSession() {

    }
    public endSession() {

    }

    public viewSessionDetails() {

    }

    public int getDuration() {
        return duration;
    }

    public int setDuration(int duration) {
        this.duration = duration;
    }

    public Lesson getLesson() {
        return this.lesson;
    }
}

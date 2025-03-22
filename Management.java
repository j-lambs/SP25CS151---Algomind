import java.util.ArrayList;
import java.util.List;

// Class for managing tutors, students, and tutoring sessions

// Method to add a student
public class Management {
    private List<Tutors> tutors;
    private List<Student> students;
    private List<Session> sessions;
    // Constructor to initialize the lists
    public Management() {
        this.tutors = new ArrayList<>();
        this.students = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }

    // Method for adding tutors
    public void addTutor(Tutors tutor) {
        this.tutors.add(tutor);
    }

    //method for removing tutors
    public void removeTutor(Tutors tutor) {
        this.tutors.remove(tutor);
    }

    //method for adding student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to remove students
    public void removeStudent(Student student) {
        students.remove(student);
    }

    // Method to add session
    public void scheduleSession(long duration, long startTime, Tutors tutor, Student student, String lesson) {
        // Check if tutor is available at the proposed start time (if desired)
        boolean isAvailable = tutor.isAvailable((int)startTime,(int) duration);

        if (isAvailable) {
            Session session = new Session(duration, startTime, tutor, student, lesson);
            sessions.add(session);
            System.out.println("Session scheduled for " + student.studentName
                    + " with " + tutor.getFullName()
                    + " on " + startTime + " for " + duration + " seconds.");
        } else {
            System.out.println("Tutor " + tutor.getFullName() + " is not available at the requested time.");
        }
    }


    // Method to view all tutors
    public void viewTutors() {
        System.out.println("Tutors in the system:");
        for (Tutors tutor : tutors) {
            System.out.println(tutor);
        }
    }

    // Method to view all students
    public void viewStudents() {
        System.out.println("Students in the system:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Method to view all sessions
    public void viewSessions() {
        System.out.println("Scheduled tutoring sessions:");
        for (Session session : sessions) {
            System.out.println(session);
        }
    }
}

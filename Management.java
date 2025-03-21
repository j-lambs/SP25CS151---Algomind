import java.util.ArrayList;
import java.util.List;

// Class for managing tutors, students, and tutoring sessions
public class Management {
    // List to hold tutors, students, and sessions
    private List<Tutors> tutors;
    private List<Student> students;
    private List<Session> sessions;

    // Constructor to initialize the lists
    public Management() {
        this.tutors = new ArrayList<>();
        this.students = new ArrayList<>();
        this.sessions = new ArrayList<>();
    }

    // Method to add a tutor
    public void addTutor(Tutors tutor) {
        tutors.add(tutor);
    }
    // Method to remove tutor
    public void removeTutor(Tutors tutor) {
    tutors.remove(tutor);}
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
    }
    // Method to remove students
    public void removeStudent(Student student){

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

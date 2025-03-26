import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private final ArrayList<Tutors> managedTutors;  // List of tutors the manager manages
    private final ArrayList<Session> sessions;
    private final ArrayList<Student> students;
    private double grossPay;// List of sessions the manager oversees

    // Constructor
    public Manager(String firstName, String lastName, String email, String phone, int id, String status) {
        super(firstName, lastName, email, phone, id,status); // Call Employee constructor
        managedTutors = new ArrayList<>(); // Initialize the list of tutors
        sessions = new ArrayList<>();
        students = new ArrayList<>();// Initialize the list of sessions
    }

    public ArrayList<Tutors> getManagedTutors() {
        return managedTutors;
    }
    public ArrayList<Session> getSessions() {
        return sessions;
    }
    public ArrayList<Student> getStudents() { return students; }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }


    // Method to add a tutor to the manager's list
    public void hireTutor(Tutors tutor) {
        managedTutors.add(tutor);
        System.out.println("Tutor " + tutor.getFullName() + " now reports to "
                + this.getFullName() + ".");
    }

    // Method to remove a tutor from the manager's list
    public void fireTutor(Tutors tutor) {
        try {
            if (tutor == null) {
                throw new IllegalArgumentException("Tutor cannot be null.");
            }
            if (!managedTutors.contains(tutor)) {
                throw new IllegalArgumentException("Tutor not found.");
            }
            managedTutors.remove(tutor);
            System.out.println("Tutor " + tutor.getFullName() + " no longer reports to "
                + this.getFullName() + ".");
        } catch (IllegalArgumentException e) {
            System.out.println("Error removing tutor: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while removing tutor: " + e.getMessage());
        }
    }

    // Method to display all tutors managed by the manager
    public void showAllTutors() {
        try {
            if (managedTutors.isEmpty()) {
                throw new Exception("No tutors available to display.");
            }
            for (Tutors tutor : managedTutors) {
                tutor.display_information();
                System.out.println("-------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error displaying tutors: " + e.getMessage());
        }
    }

    // Method to schedule a session for a tutor
    public Session scheduleSession(Tutors tutor, Student student, Course course, int startTime, int duration) {
        // Check if the tutor is available for the session
        Session session = new Session(duration, startTime, tutor, student, course);
        if (session.isAvailable(startTime, duration, tutor, student)) {
            sessions.add(session);
            System.out.println("Session scheduled for tutor " + tutor.getFullName()
                    + " with student " + student.getStudentName());
            return session;
        } else {
            System.out.println("Tutor " + tutor.getFullName() + " is not available at the requested time.");
        }
        return null;
    }

    // Method to display all sessions for the manager
    public void showAllSessions() {
        try {
            if (sessions.isEmpty()) {
                throw new Exception("No sessions available to display.");
            }
            for (Session session : sessions) {
                session.viewSessionDetails();
                System.out.println("-------------------------");
            }
        } catch (Exception e) {
            System.out.println("Error displaying sessions: " + e.getMessage());
        }
    }

    // Override positionPayRate method
    @Override
    void positionPayRate() {
        try {
            System.out.println("Manager's pay rate: $30/hr");
        } catch (Exception e) {
            System.out.println("Error retrieving pay rate: " + e.getMessage());
        }
    }

    // Override updateGrossPay method
    @Override
    protected void updateGrossPay() {
        this.grossPay = this.grossPay + (30 * 40);
    }

    protected void payEmployee(Manager manager) {
        System.out.println(this.getFullName() + " has been paid for the week.");
        updateGrossPay();
    }

    public Tutors getTutor(String tutorName) {
        for (Tutors tutor : managedTutors) {
            if (tutor.getFirstName().equalsIgnoreCase(tutorName)) {
                return tutor;
            }
        }
        return null;
    }

    public ArrayList<Student> returnStudents(){
        return students;
    }
    public Student returnStudentByName(String studentName) {
        for (Student student : students) {
            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                return student;
            }
        }
        return null;
    }
}


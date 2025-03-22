import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Employee {
    private List<Tutors> managedTutors;  // List of tutors the manager manages
    private List<Session> sessions;     // List of sessions the manager oversees

    // Constructor
    public Manager(String firstName, String lastName, String email, String phone, int id, Date hireDate, String status) {
        super(firstName, lastName, email, phone, id, hireDate, status); // Call Employee constructor
        managedTutors = new ArrayList<>(); // Initialize the list of tutors
        sessions = new ArrayList<>();      // Initialize the list of sessions
    }

    // Method to add a tutor to the manager's list
    public void addTutor(Tutors tutor) {
        try {
            if (tutor == null) {
                throw new IllegalArgumentException("Tutor cannot be null.");
            }
            managedTutors.add(tutor);
            System.out.println("Tutor " + tutor.getFullName() + " added.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding tutor: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while adding tutor: " + e.getMessage());
        }
    }

    // Method to remove a tutor from the manager's list
    public void removeTutor(Tutors tutor) {
        try {
            if (tutor == null) {
                throw new IllegalArgumentException("Tutor cannot be null.");
            }
            if (!managedTutors.contains(tutor)) {
                throw new IllegalArgumentException("Tutor not found.");
            }
            managedTutors.remove(tutor);
            System.out.println("Tutor " + tutor.getFullName() + " removed.");
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
    public void scheduleSession(Tutors tutor, Student student, String lesson, long startTime) {
        try {
            if (tutor == null || student == null || lesson == null || startTime <= 0) {
                throw new IllegalArgumentException("Invalid session parameters.");
            }

            // Check if the tutor is available for the session
            Session session = new Session(startTime, tutor, student, lesson);
            if (session.isAvailable((int) startTime, (int) session.getDuration())) {
                // If available, schedule the session
                sessions.add(session);
                System.out.println("Session scheduled for tutor " + tutor.getFullName() + " with student " + student.getStudentName());
            } else {
                System.out.println("Tutor " + tutor.getFullName() + " is not available at the requested time.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error scheduling session: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while scheduling session: " + e.getMessage());
        }
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
    double updateGrossPay() {
        try {
            // Assuming manager works 40 hours/week, 4 weeks/month
            double pay = 30.0 * 40 * 4;
            return pay;
        } catch (Exception e) {
            System.out.println("Error calculating gross pay: " + e.getMessage());
            return 0;
        }
    }
}


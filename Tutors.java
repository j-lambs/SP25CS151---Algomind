import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tutors {
    private String tutorName;
    private String tutorEmail;
    private int tutorPhone;
    private boolean availability;
    private List<String> coursesTeaching;
    private List<String> scheduledSessions;
    private List<Tutors> tutorList;

    public Tutors(String tutorName, String tutorEmail, int tutorPhone, boolean availability, List<String> coursesTeaching, List<Tutors> tutorList) {
        this.tutorName = tutorName;
        this.tutorEmail = tutorEmail;
        this.tutorPhone = tutorPhone;
        this.availability = availability;
        this.coursesTeaching = new ArrayList(coursesTeaching);
        this.scheduledSessions = new ArrayList();
        this.tutorList = tutorList;
    }

    public String getName() {
        return this.tutorName;
    }

    public boolean isAvailable() {
        return this.availability;
    }

    public String getEmail() {
        return this.tutorEmail;
    }

    public int getPhone() {
        return this.tutorPhone;
    }

    public List<String> getCourses() {
        return new ArrayList(this.coursesTeaching);
    }

    public List<String> getSessions() {
        return new ArrayList(this.scheduledSessions);
    }

    public List<Tutors> getTutors() {
        return new ArrayList(this.tutorList);
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setCoursesTeaching(List<String> coursesTeaching) {
        this.coursesTeaching = new ArrayList(coursesTeaching);
    }

    public void setScheduledSessions(List<String> scheduledSessions) {
        this.scheduledSessions = new ArrayList(scheduledSessions);
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public void setTutorEmail(String tutorEmail) {
        this.tutorEmail = tutorEmail;
    }

    public void setTutorPhone(int tutorPhone) {
        this.tutorPhone = tutorPhone;
    }

    public void setTutorList(List<Tutors> tutorList) {
        this.tutorList = new ArrayList(tutorList);
    }

    public void addTutor(Tutors tutor) {
        this.tutorList.add(tutor);
        System.out.println("Added Tutor: " + tutor.getName());
    }

    public void showInformation() {
        System.out.println("Name: " + this.tutorName);
        System.out.println("Email: " + this.tutorEmail);
        System.out.println("Phone: " + this.tutorPhone);
        System.out.println("Availability: " + this.availability);
        System.out.println("Courses: " + String.valueOf(this.coursesTeaching));
        System.out.println("Scheduled Sessions: " + String.valueOf(this.scheduledSessions));
    }

    public void scheduleSessions(String session) {
        if (this.availability) {
            this.scheduledSessions.add(session);
            System.out.println("Session scheduled: " + session);
        } else {
            System.out.println("Tutor is not available for scheduling.");
        }

    }

    public void updateSessions(String oldSession, String newSession) {
        int index = this.scheduledSessions.indexOf(oldSession);
        if (index >= 0) {
            this.scheduledSessions.set(index, newSession);
            System.out.println("Session updated: " + newSession);
        } else {
            System.out.println("Session not found: " + oldSession);
        }

    }

    public void showSessions() {
        if (this.scheduledSessions.isEmpty()) {
            System.out.println("No scheduled sessions available.");
        } else {
            System.out.println("Scheduled Sessions:");

            for(int i = 0; i < this.scheduledSessions.size(); ++i) {
                System.out.println(i + 1 + ". " + (String)this.scheduledSessions.get(i));
            }
        }

    }

    public void showAllTutors() {
        if (this.tutorList.isEmpty()) {
            System.out.println("No tutors available.");
        } else {
            System.out.println("Tutors List:");

            for(int i = 0; i < this.tutorList.size(); ++i) {
                ((Tutors)this.tutorList.get(i)).showInformation();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
            }
        }

    }

    public void removeTutor(String tutorName) {
        this.tutorList.removeIf((tutor) -> tutor.getName().equals(tutorName));
        System.out.println("Tutor removed: " + tutorName);
    }

    public static void main(String[] args) {
        List<Tutors> tutorList = new ArrayList();
        List<String> courses1 = Arrays.asList("Pre-Calculus", "Calculus", "Geometry");
        Tutors tutor1 = new Tutors("Preet", "preet2p@gmail.com", 66930593, true, courses1, tutorList);
        tutor1.addTutor(tutor1);
        List<String> courses2 = Arrays.asList("Algebra", "Linear Algebra", "Calculus 2");
        Tutors tutor2 = new Tutors("Jack", "jack2k@gmail.com", 6694056, false, courses2, tutorList);
        tutor1.addTutor(tutor2);
        tutor1.showAllTutors();
        tutor1.scheduleSessions("Algebra - Monday 10 AM");
        tutor1.showSessions();
        tutor1.updateSessions("Algebra - Monday 10 AM", "Algebra - Monday 11 AM");
        tutor1.showSessions();
        tutor1.setTutorEmail("Mckay@gmail.com");
        tutor1.setTutorPhone(40866789);
        tutor1.setCoursesTeaching(Arrays.asList("Algebra", "Trigonometry"));
        tutor1.showInformation();
        List<Tutors> retrievedTutors = tutor1.getTutors();
        System.out.println("Retrieved Tutors: " + retrievedTutors.size());
        tutor1.removeTutor("Jack");
        tutor1.showAllTutors();
    }
}


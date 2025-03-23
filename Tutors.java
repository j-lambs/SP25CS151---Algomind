import java.util.*;

public class Tutors extends Employee {
    private String tutorEmail;
    private double payRate;
    private BitSet availability;
    private final ArrayList<Course> coursesTeaching;
    private final List<Session> scheduledSessions;
    private double grossPay;

    public Tutors(String firstName, String lastName, int id, double payRate, String status, String phoneNumber,
                  String tutorEmail, BitSet availability, List<String> coursesTeaching) {
        //Calling parent class constructor
        super(firstName,
                lastName,
                tutorEmail,
                phoneNumber,
                id,
                status);
        this.payRate = payRate;
        this.availability = availability;
        this.coursesTeaching = new ArrayList<>();
        this.scheduledSessions = new ArrayList<>();
    }
    //getters

    public double getPayRate() {
        return payRate;
    }
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    public BitSet getAvailability() {
        return availability;
    }
    public void setAvailability(BitSet availability) {
        this.availability = availability;
    }
    public List<Course> getCourses() {
        return coursesTeaching;
    }
    public List<Session> getSessions() {
        return scheduledSessions;
    }

    //Setters
    public void addSession(Session session) {
        scheduledSessions.add(session);
    }
    public void removeSession(Session session) {
        scheduledSessions.remove(session);
    }
    public void addTeachableCourse(Course course) {
        coursesTeaching.add(course);
    }

    // show tutor information
    public void showInformation() {
        super.display_information();
        System.out.println("Available: " + (availability));
        System.out.println("Courses: " + coursesTeaching);
        if (scheduledSessions.isEmpty()) {
            System.out.println("No scheduled sessions");
        }
        else {
            System.out.println("Sessions: " + scheduledSessions);
        }
    }

    public void updateSession(Session oldSession, Session newSession) {
        addSession(newSession);
        int index = scheduledSessions.indexOf(oldSession);
        if (index != -1) {
            removeSession(oldSession);
            addSession(newSession);
            System.out.println("Updated: " + newSession);
        } else {
            System.out.println("Session was not found.");
        }
    }

    @Override
    public void positionPayRate() {
        System.out.println("Pay rate: $25hr");
    }

    @Override
    public void updateGrossPay() {
        this.grossPay = this.grossPay + (25.0 * 40);
    }

    public void payEmployee(Tutors tutor) {
        System.out.println(tutor.getFullName() + " has been paid for the week.");
        updateGrossPay();
    }

}


    /* public static void main(String[] args) {
         List<Tutors> tutorList = new ArrayList<>();
         List<String> courses = Arrays.asList("Math", "Science");
         Tutors tutor = new Tutors("Preet", "Singh", 101, new Date(), "Active", 66930593L, "preet@gmail.com", true, courses, tutorList);

         tutor.addTutor(tutor);
         tutor.showAllTutors();
         tutor.scheduleSession("Math - Monday 10 AM");
         tutor.showInformation();
         tutor.updateSession("Math - Monday 10 AM", "Math - Monday 11 AM");
        tutor.removeTutor(tutor);
        // tutor.removeTutor("Preet Singh");
         tutor.showAllTutors();
     }

     @Override
     double update_gross_pay() { // no need because we removed from employee
         return 20.0 * 20 * 4;
     }

     @Override // no need
     void position_pay_rate() {
         System.out.println("Pay rate: $20/hr");
     }




*/

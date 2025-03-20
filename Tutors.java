import java.util.*;

public class Tutors extends Employee {
    private String tutorEmail;
    private boolean availability;
    private List<String> coursesTeaching;
    private List<String> scheduledSessions;
    private List<Tutors> tutorList;

    public Tutors( String firstName, String lastName, int id, Date hireDate,String status,long phoneNumber,
                  String tutorEmail, boolean availability, List<String> coursesTeaching, List<Tutors> tutorList) {
        super(firstName, lastName, id, hireDate, status, phoneNumber);// call the construcotr from the employee calss means parent class
        this.tutorEmail = tutorEmail;
        this.availability = availability;
        this.coursesTeaching = new ArrayList<>(coursesTeaching);
        this.scheduledSessions = new ArrayList<>();
        this.tutorList = tutorList;
    }

    public String getEmail() {
        return tutorEmail;
    }
    public boolean isAvailability() {
        return availability;
    }
    public List<String> getCourses() {
        return coursesTeaching;
    }
    public List<String> getSessions() {
        return scheduledSessions;
    }
    public List<Tutors> getTutors() {
        return tutorList;
    }

    public void setEmail(String email) {
        tutorEmail = email;
    }
    public void setAvailability(boolean available) {
        availability = available;
    }
    public void setCoursesTeaching(List<String> courses) {
        coursesTeaching = courses;
    }

    public void addTutor(Tutors name) {
        tutorList.add(name);
        System.out.println("Tutor added: " + name.getFirstName() + " " + name.getLastName());
    }

    public void showInformation() {
        super.displayInformation();
        System.out.println("Email: " + tutorEmail);
        System.out.println("Available: " + (availability ? "Yes" : "No"));
        System.out.println("Courses: " + coursesTeaching);
        if (scheduledSessions.isEmpty()) {
            System.out.println("Sessions: Null means nothing");
        } else {
            System.out.println("Sessions: " + scheduledSessions);
        }
    }

    public void scheduleSession(String session) {
        if (availability) {
            scheduledSessions.add(session);
            System.out.println("Scheduled: " + session);
        } else {
            System.out.println("Tutor not available.");
        }
    }

    public void updateSession(String oldSession, String newSession) {
        int index = scheduledSessions.indexOf(oldSession);
        if (index != -1) {
            scheduledSessions.set(index, newSession);
            System.out.println("Updated: " + newSession);
        } else {
            System.out.println("Session not found.");
        }
    }

    public void showAllTutors() {
        if (tutorList.isEmpty()) {
            System.out.println("No tutors available.");
            return;
        }
        for (Tutors tutor : tutorList) {
            tutor.showInformation();
            System.out.println("-----------------");
        }
    }

    //public void removeTutor(String name) {
       // if (tutorList.contains(name)) {
           // tutorList.remove(name);
          //  System.out.println("Tutor removed: " + name.getFirstName() + " " + name.getLastName());
      //  } else {
           // System.out.println("Tutor not found: " + name.getFirstName() + " " + name.getLastName());
        //}

    public void removeTutor(Tutors tutor) {
        if (tutorList.contains(tutor)) {
            tutorList.remove(tutor);
            System.out.println("Tutor removed: " + tutor.getFirstName() + " " + tutor.getLastName());
        } else {
            System.out.println("Tutor not found.");
        }
    }


    @Override
    public double grossPay() {
        return 20.0 * 20 * 4; // $20 per hour, 20 hours per week, 4 weeks per month
    }

    @Override
    public void positionPayRate() {
        System.out.println("Pay rate: $20/hr");
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
}*/
 // main

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Tutors> tutorList = new ArrayList<>();
        System.out.println("Enter tutor's first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter tutor's last name: ");
        String lastName = sc.nextLine();
        System.out.println("Enter tutor's id: ");
        int id = sc.nextInt();
        System.out.println("Enter tutor's email: ");
        String email = sc.nextLine();
        System.out.println("Enter tutor's availability: ");
        boolean availability = sc.nextBoolean();
        sc.nextLine();
        System.out.println("Enter tutor's courses: ");
        List <String> coursesTeaching = new ArrayList<>();
        sc.nextLine();



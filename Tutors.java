import java.util.*;

public class Tutors extends Employee implements Schedulable{
    private String tutorEmail;
    private BitSet availability;
    private List<String> coursesTeaching;
    private List<String> scheduledSessions;
    private double rate;
//    private List<Tutors> tutorList;
//    private List<Student> students = new ArrayList<>();


    public Tutors(String firstName, String lastName, int id, double payRate,String status, String phoneNumber,
                  String tutorEmail, BitSet availability, List<String> coursesTeaching, List<Tutors> tutorList,List<Student> students) {
        super(firstName,
                lastName,
               tutorEmail,
               phoneNumber,
                id,
                payRate,
                status);
                // call the construcotr from the employee calss means parent class
        this.tutorEmail = tutorEmail;
        this.availability = availability;
        this.coursesTeaching = new ArrayList<>(coursesTeaching);
        this.scheduledSessions = new ArrayList<>();
//        this.tutorList = tutorList;
//        this.students = students;
    }


//    public String getTutorFirstName() {
//
//        return getFirstName;
//    }
//    public String getTutorLastName() {
//
//    }

    public BitSet getAvailability() {
        return availability;
    }


    public String getEmail() {
        return tutorEmail;
    }

//    public boolean isAvailability() {
//        return availability;
//    }

    public List<String> getCourses() {
        return coursesTeaching;
    }

    public List<String> getSessions() {
        return scheduledSessions;
    }

//    public List<Tutors> getTutors() {
//        return tutorList;
//    }
//    public List<Student> getStudents() {
//        return students;
//    }

    public void setEmail(String email) {
        tutorEmail = email;
    }

//    public void setAvailability(boolean available) {
//        availability = available;
//    }

    public void setCoursesTeaching(List<String> courses) {
        for (String s : coursesTeaching = courses) {

        }

    }

   public void addTutor(Tutors name) {
      tutorList.add(name);
        System.out.println("Tutor added: " + name.getFullName());
    }



    // show tutor information
    public void showInformation() {
        super.display_information();
        System.out.println("Email: " + tutorEmail);
        System.out.println("Available: " + (availability ))
        System.out.println("Courses: " + coursesTeaching);
        if (scheduledSessions.isEmpty()) {
            System.out.println("Sessions: Null means nothing");
        } else {
            System.out.println("Sessions: " + scheduledSessions);
        }
    }
    // adding students
    public void addStudent(Student student) {
        students.add(student);

        System.out.println("Student added: " + student.StudentName());

    }

// showing information student information
    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students assigned to this tutor.");
        } else {
            System.out.println("Students  going to assigned to  the Tutor: " + getFirstName());
            for (Student student : students) {
                student.getStudentInfo();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
            }
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
            System.out.println("Session not able to found .");
        }
    }

    public void showAllTutors() {
        if (tutorList.isEmpty()) {
            System.out.println("No tutors available.");
            return;
        }
        for (Tutors tutor : tutorList) {
            tutor.showInformation();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
        }
    }


    @Override
    public void positionPayRate() {
        System.out.println("Pay rate: $25hr");
    }

    @Override
    double updateGrossPay() {
        return 25.0 * 20 * 4;
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




}














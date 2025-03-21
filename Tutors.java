import java.util.*;

public class Tutors extends Employee {
    private String tutorEmail;
    private boolean availability;
    private List<String> coursesTeaching;
    private List<String> scheduledSessions;
    private List<Tutors> tutorList;
    private List<Student> students = new ArrayList<>();


    public Tutors(String firstName, String lastName, int id, Date hireDate, String status, long phoneNumber,
                  String tutorEmail, boolean availability, List<String> coursesTeaching, List<Tutors> tutorList,List<Student> students) {
        super(firstName,
                lastName,
                id,
                hireDate,
                status,
                phoneNumber);// call the construcotr from the employee calss means parent class
        this.tutorEmail = tutorEmail;
        this.availability = availability;
        this.coursesTeaching = new ArrayList<>(coursesTeaching);
        this.scheduledSessions = new ArrayList<>();
        this.tutorList = tutorList;
        this.students = students;
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
    public List<Student> getStudents() {
        return students;
    }

    public void setEmail(String email) {
        tutorEmail = email;
    }

    public void setAvailability(boolean available) {
        availability = available;
    }

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
        System.out.println("Available: " + (availability ? "Yes" : "No"));
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

        System.out.println("Student added: " + student.getStudentName());

    }

// showing information student information
    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students assigned to this tutor.");
        } else {
            System.out.println("Students assigned to Tutor: " + getFirstName());
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

    /*public void removeTutor(Tutors tutor) {
        if (tutorList.contains(tutor)) {
            tutorList.remove(tutor);
            System.out.println("Tutor removed: " + tutor.get_firstName() + " " + tutor.get_lastName());
        } else {
            System.out.println("Tutor not found.");
        }
    }*/




    @Override
    public void positionPayRate() {
        System.out.println("Pay rate: $20/hr");
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
     double update_gross_pay() {
         return 20.0 * 20 * 4;
     }

     @Override
     void position_pay_rate() {
         System.out.println("Pay rate: $20/hr");
     }

 }*/
// new main using scanner
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Tutors> tutorList = new ArrayList<>();
        // using for loop to apply only in 10 tutors
        for (int i = 0; i < 10; i++) {
            System.out.println("/n1.add Tutors");
            System.out.println("/n2.show all Tutors");
            System.out.println("/n3. schdule a Session");
            System.out.println("/n4 update a Session");
            System.out.println("/n5 remove a Tutor");
            System.out.println("/n6 view students of a tutor");

            System.out.println("/n7 exit");

            System.out.println("choose an option:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter tutor's first name:");
                    String firstName = sc.next();
                    //lastname
                    System.out.println("Enter tutor's last name:");
                    String lastName = sc.next();
                    System.out.println("Enter tutor's id:");
                    int id = sc.nextInt();
                    System.out.println("Enter tutor's status:");
                    String status = sc.next();
                    System.out.println("Enter tutor's phone number:");
                    long phoneNumber = sc.nextLong();
                    System.out.println("Enter tutor's tutor email:");
                    String email = sc.next();
                    System.out.println("Enter tutor's availability:");
                    boolean availability = sc.nextBoolean();
                    break;
                case 2:
                    if (!tutorList.isEmpty()) {
                        for (Tutors tutor : tutorList) {
                            tutor.showInformation();
                            System.out.println("---------------");
                        }
                    } else {
                        System.out.println(" no tutors information available");
                    }
                    break;
                case 3:
                    System.out.print("Enter tutor ID: ");
                    int tutorIDForSession = sc.nextInt();
                    sc.nextLine();

                    for (Tutors tutor : tutorList) {
                        if (tutor.getId() == tutorIDForSession) {
                            System.out.print("Enter session: ");
                            tutor.scheduleSession(sc.nextLine());
                            break;
                        }
                    }
                case 4:
                    System.out.print("Enter tutor ID: ");
                    int tutorIDForUpdate = sc.nextInt();
                    sc.nextLine(); // Fix input issue

                    for (Tutors tutor : tutorList) {
                        if (tutor.getId() == tutorIDForUpdate) {
                            System.out.print("Enter old session: ");
                            String oldSession = sc.nextLine();
                            System.out.print("Enter new session: ");
                            tutor.updateSession(oldSession, sc.nextLine());
                            break;
                        }
                    }
                case 5:
                    System.out.print("Enter tutor ID to remove: ");
                    int tutorIDToRemove = sc.nextInt();
                    sc.nextLine();
                    for (Tutors tutor : tutorList) {
                        if (tutor.getId() == tutorIDToRemove) {
                            tutorList.remove(tutor);
                            System.out.println("Tutor removed: " + tutor.getFirstName() + " " + tutor.getLastName());
                            break;
                        }
                    }
                case 6:
                    System.out.print("Enter Tutor ID to view students: ");
                    int tutorIdToView = sc.nextInt();
                    sc.nextLine();
                            boolean found = false;
                            for (Tutors tutor : tutorList) {
                                if (tutor.getId() == tutorIdToView) {
                                    tutor.showInformation();
                                    found = true;
                                    break;
                                }
                            }

                    
                    if (!found) {
                        System.out.println("Tutor not found.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choosen try again.");
            }
        }
        // System.out.println("You have reached the maximum number of actions. Exiting program...");
        sc.close();
    }



}













// main

/*public static void main(String[] args) {
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
    */
/*public void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Tutors> tutorList = new ArrayList<>();

    // Get tutor details from user
    System.out.print("Enter tutor's first name: ");
    String firstName = scanner.nextLine();

    System.out.print("Enter tutor's last name: ");
    String lastName = scanner.nextLine();

    System.out.print("Enter tutor ID: ");
    int tutorID = scanner.nextInt();
    scanner.nextLine();  // Fix input issue

    System.out.print("Enter tutor's email: ");
    String tutorEmail = scanner.nextLine();

    System.out.print("Is the tutor available? (true/false): ");
    boolean availability = scanner.nextBoolean();
    scanner.nextLine();  // Fix input issue

    // Create tutor object
    Tutors tutor = new Tutors(firstName, lastName, tutorID, tutorEmail, availability);
    tutor.addTutor(tutor);

    for (int i = 0; i < 10; i++) {
        System.out.println("\n1. Show All Tutors");
        System.out.println("2. Schedule a Session");
        System.out.println("3. Update a Session");
        System.out.println("4. Remove a Tutor");
        System.out.println("5. Show Tutor Info");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Fix input issue

        switch (choice) {
            case 1:
                tutor.showAllTutors();
                break;
            case 2:
                System.out.print("Enter session details: ");
                String session = scanner.nextLine();
                tutor.scheduleSession(session);
                break;
            case 3:
                System.out.print("Enter the old session: ");
                String oldSession = scanner.nextLine();
                System.out.print("Enter the new session: ");
                String newSession = scanner.nextLine();
                tutor.updateSession(oldSession, newSession);
                break;
            case 4:
                System.out.print("Enter tutor's full name to remove: ");
                String tutorName = scanner.nextLine();
                tutor.removeTutor(tutorName);
                break;
            case 5:
                tutor.showInformation();
                break;
            case 6:
                System.out.println("Exiting program...");
                return;
            default:
                System.out.println("Invalid choice! Try again.");
        }
    }
    System.out.println("You have reached the maximum number of actions. Exiting program...");
    scanner.close();
}*/

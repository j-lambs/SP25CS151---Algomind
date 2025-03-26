import java.lang.reflect.Array;
import java.util.*;

public class TutorCenterUI {
    // Constants
    private static final int WORK_HOURS_IN_DAY = 8;
    private static final int START_HOUR = 9;
    private static final int DEFAULT_SESSION_DURATION = 1;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create some initial lists
        ArrayList<Tutors> listOfTutors = new ArrayList<>();
        ArrayList<Manager> listOfManagers = new ArrayList<>();
        ArrayList<Student> listOfStudents = new ArrayList<>();
        ArrayList<Session> listOfSessions = new ArrayList<>();

        // Example: Add 2 managers for the sake of demonstration
        Manager manager1 = new Manager("Jane", "Doe", "jane.doe@algomind.com",
                "650888999", 1, "active");
        listOfManagers.add(manager1);
        Manager manager2 = new Manager("John", "Doe", "john.doe@algomind.com",
                "6504567893", 2, "active");
        listOfManagers.add(manager2);
//        // Add 2 tutors for demo
        BitSet aliceSchedule = createNewAvailabilityBitSet(9, 4);

        ArrayList<Course> aliceCourses = new ArrayList<>();
        ArrayList<Course> bobCourses = new ArrayList<>();
        BitSet bobSchedule = createNewAvailabilityBitSet(13, 4);
        Tutors alice = new Tutors("Alice", "Smith", 100, 20, "active",
                "4089091111", "alice.smith@algomind.com", aliceSchedule, aliceCourses);
        Tutors bob = new Tutors("Bob", "Builder", 101, 18, "active",
                "5105557777", "bob.builder@algomind.com", bobSchedule, bobCourses);
        listOfTutors.add(alice);
        listOfTutors.add(bob);
        manager1.hireTutor(alice);
        manager2.hireTutor(bob);

        ArrayList<Course> student1CurrentCourses = new ArrayList<>();
        ArrayList<Course> student2CurrentCourses = new ArrayList<>();

        Course linearAlgebra = new Course("Linear Algebra", "Study of vectors, matrices, and systems of linear equations.",
                202, 2, "Dr. Mark Lee");
        Course discreteMath = new Course("Discrete Mathematics", "Introduction to logic, set theory, combinatorics, and graph theory.",
                301, 3, "Dr. Emily White");
        Course calc1 = new Course("Calculus I", "Introduction to calculus, limits, and derivatives.",
                101, 1, "Dr. John Doe");

        student1CurrentCourses.add(linearAlgebra);
        student1CurrentCourses.add(discreteMath);
        alice.addTeachableCourse(linearAlgebra);
        bob.addTeachableCourse(discreteMath);

        student2CurrentCourses.add(calc1);
        student2CurrentCourses.add(discreteMath);

        Student student1 = new Student("mccay", student1CurrentCourses, "8881019999",
                "mccay.beckrhode@gmail.com", 2);
        Student student2 = new Student("preet", student1CurrentCourses, "7078884444",
                "mccay.beckrhode@gmail.com", 1);
        listOfStudents.add(student1);
        listOfStudents.add(student2);

        // Main loop
        while (true) {
            System.out.println("Welcome to our Tutor Center, Select an option:");
            System.out.println("1. Manager Menu");
            System.out.println("2. Tutor Menu");
            System.out.println("3. Student Menu");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showManagerMenu(listOfManagers, listOfStudents, listOfTutors, listOfSessions);
                    break;
                case 2:
                    showTutorMenu(listOfTutors, listOfManagers, listOfStudents, listOfSessions);
                    break;
                case 3:
                    showStudentMenu(listOfStudents);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Manager Menu
    private static void showManagerMenu(ArrayList<Manager> listOfManagers,
                                        ArrayList<Student> students,
                                        ArrayList<Tutors> listOfTutors,
                                        ArrayList<Session> listOfSessions) {
        Manager currentManager = signInManager(listOfManagers);
        System.out.println("Welcome Manager " + currentManager.getFirstName() + "!");
        while (true) {
            System.out.println("\nManager Menu");
            System.out.println("1. Hire Tutor");
            System.out.println("2. Fire Tutor");
            System.out.println("3. View Tutors");
            System.out.println("4. Add New Student");
            System.out.println("5. Add New Manager");
            System.out.println("6. Create New Session ");
            System.out.println("7. Update Session ");
            System.out.println("8. Go Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hireTutor(currentManager, listOfTutors);
                    break;
                case 2:
                    fireTutor(currentManager);
                    break;
                case 3:
                    viewTutors(currentManager);
                    break;
                case 4:
                    addNewStudent(students);
                    break;
                case 5:
                    addNewManager(listOfManagers);
                case 6:
                    scheduleSession(currentManager, listOfSessions,students);
                    break;
                case 7:
                    updateSession(currentManager, currentManager.getSessions());
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addNewManager(ArrayList<Manager> listOfManagers) {
        System.out.print("Enter manager first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter manager last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter manager gross pay: ");
        double grossPay = scanner.nextDouble();
        scanner.nextLine();

        int newID = generateNewID();
        System.out.print("Enter manager phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter start hour.");
        int startHour = scanner.nextInt();
        System.out.println("Enter amount of hours they can work.");
        int durationHours = scanner.nextInt();
        BitSet workBS = createNewAvailabilityBitSet(startHour, durationHours);

//        Manager newManager = new Manager(firstName, lastName, newID, grossPay, "active", phoneNumber,
//                firstName + "." + lastName + "@algomind.com", workBS, new ArrayList<>());
        Manager newManager = new Manager(firstName, lastName, firstName + "." + lastName + "@algomind.com",
                phoneNumber, newID, "active");
        listOfManagers.add(newManager);

        System.out.println("Manager hired successfully!");
    }


    // Sign in for Manager
    private static Manager signInManager(List<Manager> listOfManagers) {
        System.out.println("Welcome to the Manager Menu!");
        System.out.print("""
                Manager:ID
                ----------
                """);
        for (Manager manager : listOfManagers) {
            System.out.println(manager.getFirstName() + " " + manager.getLastName()
                    + ":" + manager.getId());
        }
        System.out.println("---------");
        System.out.print("Enter the Manager iD: ");
        int managerID = scanner.nextInt();
        scanner.nextLine();

        for (Manager manager : listOfManagers) {
            if (manager.getId() == managerID) {
                return manager;
            }
        }
        System.out.println("Manager not found. Try again.");
        System.out.println();
        return signInManager(listOfManagers); // retry
    }


    // Hire a Tutor
    private static void hireTutor(Manager manager, ArrayList<Tutors> listOfTutors) {
        System.out.println("Hire a Tutor!");
        System.out.print("Enter tutor's first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter tutor's last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter tutor's hourly rate: ");
        double payRate = scanner.nextDouble();
        scanner.nextLine();

        int newTutorID = generateNewID();
        System.out.print("Enter tutor's phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter start hour.");
        int startHour = scanner.nextInt();
        BitSet workBS = null;
        while (workBS == null) {
            System.out.println("Enter hours per day they can work.");
            int durationHours = scanner.nextInt();
            workBS = createNewAvailabilityBitSet(startHour, durationHours);
        }
        ;
        Tutors newTutor = new Tutors(firstName, lastName, newTutorID, payRate, "active", phoneNumber,
                firstName + "." + lastName + "@algomind.com", workBS, new ArrayList<>());
        manager.hireTutor(newTutor);
        System.out.println("Tutor hired successfully! A new Tutor ID(" + newTutor.getId()
                + ") has been generated.");
        listOfTutors.add(newTutor);
    }

    /**
     * Creates a BitSet for the session's availability based on start time and duration
     */
    private static BitSet createNewAvailabilityBitSet(int startTime, int duration) {
        BitSet newAvailabilityBitSet = new BitSet(WORK_HOURS_IN_DAY);
        if (duration > WORK_HOURS_IN_DAY) {
            System.out.println("Invalid start hour. Try again.");
            return null;
        }
        newAvailabilityBitSet.set(startTime, startTime + duration);// Corrected time setting
        return newAvailabilityBitSet;
    }

    // Generate random ID
    private static int generateNewID() {
        Random random = new Random();
        return random.nextInt(900) + 100; // Generates a number between 100 and 999
    }

    // View all tutors
    private static void viewTutors(Manager currentManager) {
        System.out.println();
        if (currentManager.getManagedTutors().isEmpty()) {
            System.out.println("No tutors available.");
        } else {
            for (Tutors tutor : currentManager.getManagedTutors()) {
                tutor.showInformation();
            }
        }
    }

    // Add a new student
    private static void addNewStudent(ArrayList<Student> students) {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter grade level: ");
        int gradeLevel = scanner.nextInt();
        while (gradeLevel < 0 || gradeLevel > 5) {
            System.out.print("Grade level must be between 1 and 4: ");
            gradeLevel = scanner.nextInt();
        }
        scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        // Assume courses taken by the student are added here
        ArrayList<Course> studentCourses = new ArrayList<>();
        System.out.println("Enter current courses taken by the student(separate by comma)");
        String coursesInput = scanner.nextLine();

        for (String courseName : coursesInput.split(",")) {
            Course course = Course.MathCourses.getMathCourse(courseName);
            if (course != null) {
                studentCourses.add(course);
            }

            Student newStudent = new Student(name, studentCourses, phoneNumber, email, gradeLevel);
            students.add(newStudent);

            System.out.println("New student added successfully!");
        }
    }

    /**
     * Returns tutor of given targetID
     *
     * @param managedTutors
     * @param targetID
     * @return
     */
    private static Tutors findTutorById(List<Tutors> managedTutors, int targetID) {
        for (Tutors tutor : managedTutors) {
            if (tutor.getId() == targetID) {
                return tutor;
            }
        }
        // Tutor ID not found
        return null;
    }

    // Fire a Tutor
    private static void fireTutor(Manager manager) {
        System.out.print("Enter tutor ID to fire: ");
        int tutorID = scanner.nextInt();
        scanner.nextLine();

        Tutors tutorToFire = findTutorById(manager.getManagedTutors(), tutorID);
        if (tutorToFire != null) {
            manager.fireTutor(tutorToFire);
            System.out.println("Tutor fired successfully.");
        } else {
            System.out.println("Tutor not found.");
        }
    }

    private static Tutors findTutorByName(String name, Manager manager) {
        //Object manager = null;
        for (Tutors tutor : manager.getManagedTutors()) {
            if (tutor.getFullName().equalsIgnoreCase(name)) {
                return tutor;
            }
        }
        return null;
    }

    // Tutor Menu
    private static void showTutorMenu(List<Tutors> listOfTutors, List<Manager> listOfManagers,
                                      List<Student> students,
                                      ArrayList<Session> sessions) {
        Tutors currentTutor = signInTutor(listOfTutors);
        System.out.println("Welcome Tutor " + currentTutor.getFirstName() + "!");
        while (true) {
            System.out.println("\nTutor Menu");
            System.out.println("1. View Tutor Information");
            System.out.println("2. View Session");
            System.out.println("3. Show all Tutors");
            System.out.println();
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    currentTutor.showInformation();
                    break;
                case 2:
                    tutorOwnViewSessions(currentTutor,sessions);
                    break;
                case 3:
                    viewAllTutors(listOfTutors);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Sign in for Tutor
    private static Tutors signInTutor(List<Tutors> listOfTutors) {
        System.out.print("Enter Tutor ID: ");
        int tutorID = scanner.nextInt();
        scanner.nextLine();

        for (Tutors tutor : listOfTutors) {
            if (tutor.getId() == tutorID) {
                return tutor;
            }
        }
        System.out.println("Tutor not found. Try again.");
        return signInTutor(listOfTutors); // retry
    }

    private static void viewAllTutors(List<Tutors> listOfTutors) {
        for (Tutors tutor : listOfTutors) {
            tutor.display_information();
        }
    }

    private static void viewAllStudents(List<Student> students) {
        for (Student student : students) {
            student.getStudentInfo();
        }
    }

    // Student Menu
    private static void showStudentMenu(List<Student> students) {
        Student currentStudent = signInStudent(students);
        System.out.println("Welcome Student " + currentStudent.getStudentName() + "!");
        while (true) {
            System.out.println("\nStudent Menu");
            System.out.println("1. View Courses");
            System.out.println("2. View Student Information");
            System.out.println("3. Go Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    currentStudent.viewCourses();
                    break;
                case 2:
                    currentStudent.getStudentInfo();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Sign in for Student
    private static Student signInStudent(List<Student> students) {
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                return student;
            }
        }
        System.out.println("Student not found. Try again.");
        return signInStudent(students); // retry
    }

    private static void viewStudentInfo(Student student) {
        student.getStudentInfo();
    }

    private static void updateLesson() {
        // Implementation of lesson update can be added here
    }

    private static void scheduleSession(Manager manager, ArrayList<Session> sessions,
                                        ArrayList<Student> students) {
        while (true) {
            System.out.print("Please enter the student's name: ");
            String studentName = scanner.nextLine();
            System.out.print("Please enter the tutor's name: ");
            String tutorName = scanner.nextLine();
            System.out.println("What course is this session for: ");
            String courseName = scanner.nextLine();
            System.out.print("What is the start time: ");
            int startTime = scanner.nextInt();
            System.out.print("What is the duration: ");
            int duration = scanner.nextInt();


            sessions.add(manager.scheduleSession(
                    manager.getTutor(tutorName),
                    returnStudentByName(studentName, students),
                    Course.MathCourses.getMathCourse(courseName),
                    startTime, duration));
        }
    }

    private static void updateSession(Manager manager, ArrayList<Session> session) {

        // Implement logic for session updates here
    }

    private static void clearSessions(ArrayList<Session> sessions) {
        sessions.clear();
    }

    private static void viewSessions(ArrayList<Session> sessions) {
        System.out.println("Current Sessions:");
        for(Session s: sessions) {
            System.out.println(s);
        }
    }
    private static void tutorOwnViewSessions(Tutors tutor, ArrayList<Session> sessions) {
        for (Session s : sessions) {
            if (s.getTutor().getFirstName().equalsIgnoreCase(tutor.getFirstName())) {
                s.viewSessionDetails();
            }
        }
    }
    private static Student returnStudentByName(String studentName,ArrayList<Student> students) {
        for (Student student : students) {
            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                return student;
            }
        }
        return null;
    }
}
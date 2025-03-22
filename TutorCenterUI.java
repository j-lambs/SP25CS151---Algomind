import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TutorCenterUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Tutors> listOfTutors = new ArrayList<>();
        ArrayList<Manager> listOfManagers = new ArrayList<>();
        ArrayList<Student> listOfStudents = new ArrayList<>();
//        Manager m0 = new Manager("jane", "doe", "jane.doe@algomind.com",
//                "650888999", 100, "active");
//        listOfManagers.add(m0);

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
                    showManagerMenu(listOfTutors, listOfManagers, listOfStudents);
                    break;
                case 2:
                    showTutorMenu(listOfTutors, listOfManagers, listOfStudents);
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

    private static void showManagerMenu(ArrayList<Tutors> listOfTutors, ArrayList<Manager> listOfManagers, ArrayList<Student> students) {
        // Make manager sign in by ID
        Manager currentManager = signIn(listOfManagers);
        while (true) {
            System.out.println("\nManager Menu");
            System.out.println("1. Hire Tutor");
            System.out.println("2. Fire Tutor");
            System.out.println("3. View Tutors");
            System.out.println("4. Add New Student");
            System.out.println("5. Go Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hireTutor(listOfTutors, currentManager);
                    break;
                case 2:
                    fireTutor();
                    break;
                case 3:
                    viewTutors(listOfTutors);
                    break;
                case 4:
                    addNewStudent(students);
                case 5:
                   return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * signIn for Managers
     * @param listOfManagers
     * @return
     */
    private static Manager signIn(ArrayList<Manager> listOfManagers) {
        Scanner employeeMenuScanner = new Scanner(System.in);
        Manager currentManager;
        boolean validEmp = false;

        while (!validEmp) {
            System.out.println("Which manager are you? Enter your ID.");
            int currentManagerID = employeeMenuScanner.nextInt();
            // check if ID exists in listOfManagers
            int i = 0;
            for (Manager m : listOfManagers) {
                if (m.getId() == currentManagerID) {
                    currentManager = m;
                    validEmp = true;
                    break;
                }
                ++i;
            }
            // has look through listOfManagers and ID does not exist
            if (i >= listOfManagers.size()) {
                System.out.println("Employee ID does not exist. Please try again.");
            }
        }
        employeeMenuScanner.close();
        return currentManager;
    }

    /**
     * Creates and adds a new student to listOfStudents
     * @param students
     */
    private static void addNewStudent(ArrayList<Student> students) {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.println("Enter grade level");
        String gradeLevel = scanner.nextLine();

        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();

        boolean moreCourses = true;
        List<Courses> coursesTaken = new ArrayList<>();
        while (moreCourses) {
            System.out.println("Enter the next course you've taken. Press 0 (zero) when done.");
            String nextCourse = scanner.nextLine();
            if (nextCourse.equals("0")) {
                moreCourses = false;
            } else {
                coursesTaken.add(nextCourse);
            }
        }

        Student newStudent = new Student(name, coursesTaken, phoneNumber, email, gradeLevel);
        students.add(newStudent);
    }

    /**
     * Sign in for tutors
     * @param listOfTutors
     * @return
     */
    private static Tutors signIn(ArrayList<Tutors> listOfTutors) {
        Scanner employeeMenuScanner = new Scanner(System.in);
        Tutors currentTutor;
        boolean validEmp = false;

        while (!validEmp) {
            System.out.println("Which tutor are you? Enter your ID. Or press 1 to display all Tutor info.");
            int currentTutorID = employeeMenuScanner.nextInt();
            if (currentTutorID == 1) {
                viewAllTutors(listOfTutors);
            } else {
                // check if ID exists in listOfManagers
                int i = 0;
                for (Tutors t : listOfTutors) {
                    if (t.getId() == currentTutorID) {
                        currentTutor = t;
                        validEmp = true;
                        break;
                    }
                    ++i;
                }
                // has look through listOfTutors and ID does not exist
                if (i >= listOfTutors.size()) {
                    System.out.println("Employee ID does not exist. Please try again.");
                }
            }
            employeeMenuScanner.close();
            return currentTutor;
        }
    }

    private static Student signIn(ArrayList<Student> students, String studentName) {
        if (students.size() == 0) {
            throw new IllegalArgumentException("No active students.");
        }

        Scanner signInScanner = new Scanner(System.in);
        Student currentStudent = null;
        // look for studentName in listOfStudents
        boolean validStudent = false;
        while (!validStudent) {
            for (Student s : students) {
                if (studentName.equalsIgnoreCase(s.getStudentName())) {
                    validStudent = true;
                    signInScanner.close();
                    return s;
                }
            }
            // studentName not found
            System.out.println("Student not found. Please enter valid student name.");
            studentName = signInScanner.nextLine();
        }
        return currentStudent;
    }

    /**
     * Displays all tutors hired.
     * @param tutorsArrayList
     */
    private static void viewTutors(ArrayList<Tutors> tutorsArrayList) {
        for (Tutors t : tutorsArrayList) {
            t.showInformation();
        }
    }

    private static void hireTutor(Manager manager) {
        // Get tutor info
        System.out.print("Enter tutor first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter tutor last name: ");
        String lastName = scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        String email = firstName + "." + lastName + "@algomind.com";

        System.out.print("Enter hourly rate: ");
        double payRate = scanner.nextDouble();
        int newTutorID = generateNewID();
        System.out.print("Enter tutor phone number: ");
        ArrayList<String> coursesTeaching = getCoursesTutorCanTeach();

        scanner.nextLine();  // Consume newline character
        Tutors tutor = new Tutors(firstName, lastName, newTutorID, payRate,"active", phoneNumber, email, true,
                coursesTeaching);
        manager.hireTutor(tutor);
        System.out.println("New hire information:");
        tutor.display_information();
        System.out.println("Tutor hired successfully!");
    }

    /**
     * Creates random ID between 100 and 900
     * @return newID
     */
    private static int generateNewID() {
        Random random = new Random();
        return random.nextInt(900) + 100; // Generates a number between 100 and 999
    }

    private static ArrayList<String> getCoursesTutorCanTeach() {
        Scanner tempScanner = new Scanner(System.in);
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Arithmetic"); courses.add("Algebra"); courses.add("Trigonometry");
        boolean moreCourses = true;
        while (moreCourses) {
            String nextCourse = tempScanner.nextLine();
            if (nextCourse.equals("s")) {
                moreCourses = false;
            } else {
                courses.add(nextCourse);
                System.out.println("Press 's' when done.");
            }
        }
        tempScanner.close();
        return courses;
    }

    private static void fireTutor(Manager manager ) {
        System.out.print("Enter tutor name to fire: ");
        String name = scanner.nextLine();
        // Assuming the manager has the method to find tutor by name
        Tutors tutorToFire = findTutorByName(name);
        if (tutorToFire != null) {
            manager.fireTutor(tutorToFire);
            System.out.println("Tutor fired successfully!");
        } else {
            System.out.println("Tutor not found.");
        }
    }

    private static Tutors findTutorByName(String name) {
        for (Tutors tutor : manager.getTutors()) {
            if (tutor.getName().equals(name)) {
                return tutor;
            }
        }
        return null;
    }

    private static void showTutorMenu(ArrayList<Tutors> listOfTutors, ArrayList<Manager> listOfManagers, ArrayList<Student> students) {
        // Make tutor sign in by ID
        Tutors currentTutor = (Tutors) signIn(listOfTutors);
        while (true) {
            System.out.println("\nTutor Menu");
            System.out.println("1. View Student Information");
            System.out.println("2. View Session");
            System.out.println("3. Update Lesson");
            System.out.println("4. Show all Tutors");
            System.out.println("5. Schedule Session");
            System.out.println("6. Update Session");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String studentName = scanner.nextLine();
                    Student studentOfInterest = signIn(students, studentName);
                    studentOfInterest.getStudentInfo();
                    break;
                case 2:
                    viewSessions();
                    break;
                case 3:
                    updateLesson();
                    break;
                case 4:
                    viewAllTutors(listOfTutors);
                    break;
                case 5:
                    scheduleSession();
                    break;
                case 6:
                    updateSession();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * Displays info of single student
     * @param student
     */
    private static void viewStudentInfo(Student student) {
        student.getStudentInfo();
    }

    private static void viewSessions() {
    }

    private static void updateLesson() {
    }
    private static void viewAllTutors(ArrayList<Tutors> listOfTutors) {
        for (Tutors t: listOfTutors) {
            t.display_information();
        }
    }
    private static void scheduleSession() {
    }

    private static void updateSession() {
    }



    private static void showStudentMenu(ArrayList<Student> students) {
        Student currentStudent = null;
        try {
            Scanner studentMenuScanner = new Scanner(System.in);
            System.out.println("Enter Student Name");
            String studentName = studentMenuScanner.nextLine();
            currentStudent = signIn(students, studentName);
        } catch (Exception e) {
            System.out.println("Student Sign in Error");
        }
        while (true) {
            System.out.println("\nStudent Menu");
            System.out.println("1. View Courses");
            System.out.println("2. View Student Information");
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
                default:
                    System.out.println("Invalid choice, Try again!");
            }
        }
    }

    private static void viewCourse() {
    }

    private static void viewSessions() {
        System.out.print("Enter your student name: ");
        String studentName = scanner.nextLine();
    }


}



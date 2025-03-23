import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TutorCenterUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Create some initial lists
        List<Tutors> listOfTutors = new ArrayList<>();
        List<Manager> listOfManagers = new ArrayList<>();
        List<Student> listOfStudents = new ArrayList<>();

        // Example: Add one manager for the sake of demonstration
        Manager manager1 = new Manager("Jane", "Doe", "jane.doe@algomind.com",
                "650888999", 1, "active");
        listOfManagers.add(manager1);
        Manager manager2 = new Manager("John", "Doe", "john.doe@algomind.com",
                "6504567893", 2, "active");
        listOfManagers.add(manager2);

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
                    showManagerMenu(listOfManagers);
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

    // Manager Menu
    private static void showManagerMenu(List<Manager> listOfManagers) {
        Manager currentManager = signInManager(listOfManagers);
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
                    hireTutor(currentManager);
                    break;
                case 2:
                    fireTutor(currentManager);
                    break;
                case 3:
                    viewTutors(currentManager);
                    break;
                case 4:
                    addNewStudent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }


    // Sign in for Manager
    private static Manager signInManager(List<Manager> listOfManagers) {
        System.out.print("Enter Manager ID: ");
        int managerID = scanner.nextInt();
        scanner.nextLine();

        for (Manager manager : listOfManagers) {
            if (manager.getId() == managerID) {
                return manager;
            }
        }
        System.out.println("Manager not found. Try again.");
        return signInManager(listOfManagers); // retry
    }


    // Hire a Tutor
    private static void hireTutor(Manager manager) {
        System.out.print("Enter tutor first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter tutor last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter tutor hourly rate: ");
        double payRate = scanner.nextDouble();
        scanner.nextLine();

        int newTutorID = generateNewID();
        System.out.print("Enter tutor phone number: ");
        String phoneNumber = scanner.nextLine();

        Tutors newTutor = new Tutors(firstName, lastName, newTutorID, payRate, "active", phoneNumber, firstName + "." + lastName + "@algomind.com", true, new ArrayList<>());
        manager.hireTutor(newTutor);
        System.out.println("Tutor hired successfully!");
    }

    // Generate random ID
    private static int generateNewID() {
        Random random = new Random();
        return random.nextInt(900) + 100; // Generates a number between 100 and 999
    }

    // View all tutors
    private static void viewTutors(Manager currentManager) {
        if (currentManager.getManagedTutors().isEmpty()) {
            System.out.println("No tutors available.");
        } else {
            for (Tutors tutor : currentManager.getManagedTutors()) {
                tutor.showInformation();
            }
        }
    }

    // Add a new student
    private static void addNewStudent() {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter grade level: ");
        int gradeLevel = scanner.nextInt();
        while (gradeLevel < 0 || gradeLevel > 5) {
            System.out.print("Grade level must be between 1 and 4: ");
            gradeLevel = scanner.nextInt();
        }

        System.out.print("Enter phone number: ");
        int phoneNumber = scanner.nextInt();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        // Assume courses taken by the student are added here
        List<Course> studentCourses = new ArrayList<>();
        System.out.println("Enter current courses taken by the student(separate by comma)");
        String coursesInput = scanner.nextLine();

        for (String courseName : coursesInput.split(",")) {
            Course course = Course.MathCourses.getMathCourse(courseName);
            if (course != null) {
                studentCourses.add(course);
            }

            Student newStudent = new Student(name, studentCourses, phoneNumber, email, gradeLevel);

            System.out.println("New student added successfully!");
        }
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
    private static void showTutorMenu(List<Tutors> listOfTutors, List<Manager> listOfManagers, List<Student> students) {
        Tutors currentTutor = signInTutor(listOfTutors);
        while (true) {
            System.out.println("\nTutor Menu");
            System.out.println("1. View Student Information");
            System.out.println("2. View Session");
            System.out.println("3. Show all Tutors");
            System.out.println("4. Schedule Session");
            System.out.println("5. Update Session");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewStudentInfo(Scanner);
                    break;
                case 2:
                    viewSessions();
                    break;
                case 3:
                    viewAllTutors(listOfTutors);
                    break;
                case 4:
                    scheduleSession();
                    break;
                case 5:
                    updateSession();
                    break;
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

    // Student Menu
    private static void showStudentMenu(List<Student> students) {
        Student currentStudent = signInStudent(students);
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

    private static void scheduleSession() {
        // Implementation for session scheduling can go here
    }

    private static void updateSession() {
        // Implement logic for session updates here
    }

    private static void viewSessions() {
        // Session view logic
    }
}
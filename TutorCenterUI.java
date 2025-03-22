import java.util.ArrayList;
import java.util.Scanner;

public class TutorCenterUI {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Tutors> listOfTutors = new ArrayList<>();
        ArrayList<Manager> listOfManagers = new ArrayList<>();

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
                    showManagerMenu();
                    break;
                case 2:
                    showTutorMenu();
                    break;
                case 3:
                    showStudentMenu();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showManagerMenu() {
        while (true) {
            System.out.println("\nManager Menu");
            System.out.println("1. Hire Tutor");
            System.out.println("2. Fire Tutor");
            System.out.println("3. View Tutors");
            System.out.println("4. Go Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hireTutor();
                    break;
                case 2:
                    fireTutor();
                    break;
                case 3:
                    viewTutors();
                    break;
                case 4:
                   return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void viewTutors() {
    }

    private static void hireTutor(ArrayList<Tutors> tutorsArrayList, Manager manager) {
        // Get tutor info
        System.out.print("Enter tutor first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter tutor last name: ");
        String lastName = scanner.nextLine();
        int newTutorID = tutorsArrayList.size();
        System.out.print("Enter hourly rate: ");
        double payRate = scanner.nextDouble();
        System.out.print("Enter tutor phone number: ");
        String phoneNumber = scanner.nextLine();
        String email = firstName + "." + lastName + "@algomind.com";

        ArrayList<String> coursesTeaching = getCoursesTutorCanTeach();

        scanner.nextLine();  // Consume newline character
        Tutors tutor = new Tutors(firstName, lastName, newTutorID, payRate,"active", phoneNumber, email, true,
                coursesTeaching);
        manager.hireTutor(tutor);
        System.out.println("Tutor hired successfully!");
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

    private static void fireTutor() {
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

    private static void showTutorMenu() {
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
                    viewStudentInfo();
                    break;
                case 2:
                    viewSessions();
                    break;
                case 3:
                    updateLesson();
                    break;
                case 4:
                    viewAllTutors();
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

    private static void viewStudentInfo() {
        System.out.print("Enter your Student name: ");
        String studentName = scanner.nextLine();

        if (studentName != null) {

        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewSessions() {
    }

    private static void updateLesson() {
    }
    private static void viewAllTutors() {
    }
    private static void scheduleSession() {
    }

    private static void updateSession() {
    }



    private static void showStudentMenu() {
        while (true) {
            System.out.println("\nStudent Menu");
            System.out.println("1. View Courses");
            System.out.println("2. View Student Information");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewCourse();
                    break;
                case 2:
                    viewStudentInfo();
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



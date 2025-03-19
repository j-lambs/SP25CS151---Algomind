import java.util.ArrayList;

public class Student {
    public String studentName;
    public ArrayList<String> coursesTaken;
    public long phoneNo;
    public String email;
    public String gradeLevel;
    public Course currentCourse;

    public Student(String studentName, ArrayList<String> coursesTaken, long phoneNo, String email, String gradeLevel) {
        this.studentName = studentName;
        this.coursesTaken = coursesTaken;
        this.phoneNo = phoneNo;
        this.email = email;
        this.gradeLevel = gradeLevel;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void getStudentInfo() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Courses Taken: " + coursesTaken);
    }

    public void viewCourses() {
        System.out.println(studentName + "'s courses: " + coursesTaken);
    }

    public void addCourse(String course) {
        coursesTaken.add(course);
    }

    public void updateGradeLevel(String newGradeLevel) {
        this.gradeLevel = newGradeLevel;
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }

    /**
     * Prints all courses student knows
     */
    public void showCoursesTaken() {
        for (String course : coursesTaken) {
            System.out.print(course + " ");
        }
        System.out.println();
    }
}
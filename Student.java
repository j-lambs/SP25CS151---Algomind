import java.util.ArrayList;

public class Student {
    public String studentName;
    public ArrayList<String> coursesTaken;
    public int phoneNo;
    public String email;
    public String gradeLevel;

    public Student(String studentName, ArrayList<String> coursesTaken, int phoneNo, String email, String gradeLevel) {
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
}

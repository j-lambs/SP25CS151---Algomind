import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseSummary;
    private int courseCode;
    private int gradeLevel;
    private String instructor;
    private List<Student> students;

    // Constructor
    public Course(String courseName, String courseSummary,
                  int courseCode, int gradeLevel, String instructor) {
        this.courseName = courseName;
        this.courseSummary = courseSummary;
        this.courseCode = courseCode;
        this.gradeLevel = gradeLevel;
        this.instructor = instructor;
        this.students = new ArrayList<>();
    }

    // Getter Methods
    public String getCourseName() {
        return courseName;
    }

    public String getCourseInfo() {
        return courseSummary;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public String getInstructor() {
        return instructor;
    }
    public List<Student> getStudents() {
        return students;
    }

    // Setter Methods
    protected void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    protected void setCourseInfo(String courseSummary) {
        this.courseSummary = courseSummary;
    }

    protected void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    protected void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    protected void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    protected void setStudents(List<Student> students) {
        this.students = students;
    }

    //Displaing Course Info
    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + " (Code: " + courseCode + ")");
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Info: " + courseSummary);
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void disiplineStudent(Student student) {
        System.out.println("Student disiplined: " + student);
    }


}


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseSummary;
    private int courseCode;
    private int gradeLevel;
    private String instructor;
    private ArrayList<Student> students;

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

    public String getCourseSumary() {
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

    public ArrayList<Student> getStudents() {
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

    protected void setStudents(ArrayList<Student> students) {
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

    public static class MathCourses {

        // Method to return the list of available math courses
        public static List<Course> getMathCourses() {
            List<Course> mathCourses = new ArrayList<>();

            // Add the math courses to the list
            mathCourses.add(new Course("Calculus I", "Introduction to calculus, limits, and derivatives.",
                    101, 1, "Dr. John Doe"));
            mathCourses.add(new Course("Calculus II", "Continuation of Calculus I, integration techniques, and applications.",
                    102, 1, "Dr. John Doe"));
            mathCourses.add(new Course("Calculus III", "Advanced calculus with multivariable functions.",
                    201, 2, "Dr. Jane Smith"));
            mathCourses.add(new Course("Linear Algebra", "Study of vectors, matrices, and systems of linear equations.",
                    202, 2, "Dr. Mark Lee"));
            mathCourses.add(new Course("Discrete Mathematics", "Introduction to logic, set theory, combinatorics, and graph theory.",
                    301, 3, "Dr. Emily White"));
            mathCourses.add(new Course("Abstract Algebra", "Study of algebraic structures such as groups, rings, and fields.",
                    302, 3, "Dr. Alan Brown"));
            mathCourses.add(new Course("Probability and Statistics", "An introduction to probability theory and statistical methods.",
                    401, 4, "Dr. Sophie Green"));
            mathCourses.add(new Course("Differential Equations", "Study of ordinary differential equations and their applications.",
                    402, 3, "Dr. Richard Black"));

            return mathCourses;
        }
        public static Course getMathCourse(String courseName) {
            for (int i = 0; i < getMathCourses().size(); i++) {
                if (getMathCourses().get(i).getCourseName().equals(courseName)) {
                    return getMathCourses().get(i);
                }
            }
            return null;
        }
    }nnl  =pp==\/

    public void displayMathCourses() {
        System.out.println("Math courses: " + MathCourses.getMathCourses());
    }

}


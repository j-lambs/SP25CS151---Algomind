public class Course {
    private String courseName;
    private String courseInfo;
    private int courseCode;
    private String gradeLevel;

    // Constructor
    public Course(String courseName, String courseInfo, int courseCode, String gradeLevel) {
        this.courseName = courseName;
        this.courseInfo = courseInfo;
        this.courseCode = courseCode;
        this.gradeLevel = gradeLevel;
    }

    // Getter Methods
    public String getCourseName() {
        return courseName;
    }

    public String getCourseInfo() {
        return courseInfo;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    // Setter Methods
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    // Display Course Info
    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + " (Code: " + courseCode + ")");
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Info: " + courseInfo);
    }

    // Main Method for Testing
    public static void main(String[] args) {
        // Creating a course object
        Course course1 = new Course("Algebra I", "Basic algebra principles", 101, "9th Grade");

        // Displaying course information
        course1.displayCourseInfo();

        // Updating some details
        course1.setCourseInfo("Introduction to algebra concepts and problem-solving");

        // Display updated information
        System.out.println("\nUpdated Course Information:");
        course1.displayCourseInfo();
    }
}

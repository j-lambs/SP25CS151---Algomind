import java.util.ArrayList;

public class Courses {
    private String courseName;
    private String courseInfo;
    private int courseCode;
    private String gradeLevel;
    private ArrayList<String> lessons;

    // Constructor
    public Courses(String courseName, String courseInfo, int courseCode, String gradeLevel) {
        this.courseName = courseName;
        this.courseInfo = courseInfo;
        this.courseCode = courseCode;
        this.gradeLevel = gradeLevel;
        this.lessons = new ArrayList<>();
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

    public ArrayList<String> getLessons() {

        return lessons;
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

    // Methods to manage lessons
    public void addLesson(String lesson) {

        lessons.add(lesson);
        System.out.println("Lesson  should added: " + lesson);
    }
    //methods to remove lessons
    public void removeLesson(String lesson) {
        if (lessons.contains(lesson)) {
            lessons.remove(lesson);
            System.out.println("Lesson removed: " + lesson);
        } else {
            System.out.println("Lesson not found: " + lesson);
        }
    }
    //Update lessons
    public void updateLesson(String lesson) {
        if (lessons.contains(lesson)) {
            lessons.set(lessons.indexOf(lesson), lesson);
            System.out.println("Lesson update: " + lesson);
        }
        else {
            System.out.println("Lesson not found: " + lesson);
        }
    }

    //Displaing Course Info
    public void displayCourseInfo() {
        System.out.println("Course: " + courseName + " (Code: " + courseCode + ")");
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Info: " + courseInfo);
        System.out.println("Lessons:");
        for (String lesson : lessons) {
            System.out.println("- " + lesson);
        }
    }

}

import java.util.List;

public class Student {  
    public String studentName;
    public List<Courses> coursesTaken;
    public int phoneNo;
    public String email;
    public String gradeLevel;

    public Student(String studentName, List<Courses> coursesTaken, int phoneNo, String email, String gradeLevel) {
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

    public void addCourse(Courses course) {
        if (!coursesTaken.contains(course)) {
            if (course.getGradeLevel().equals(gradeLevel)) {
                coursesTaken.add(course);
                System.out.println(course.getCourseName() + " added.");
            } else {
                System.out.println("Cannot enroll in " + course.getCourseName() +
                        " as it is for " + course.getGradeLevel());
            }
        } else {
            System.out.println(course.getCourseName() + " already exists.");
        }
    }

    public void removeCourse(Courses course) {
        if (coursesTaken.contains(course)) {
            coursesTaken.remove(course);
            System.out.println(course + " removed.");
        } else {
            System.out.println(course + " not found.");
        }
    }

    public boolean isEnrolled(Courses course) {
        if (coursesTaken.contains(course)) {
            System.out.println(studentName + " is enrolled in " + course);
            return true;
        } else {
            System.out.println(studentName + " is NOT enrolled in " + course);
            return false;
        }
    }

    public void enrollStudent(Student student) {

    }
}
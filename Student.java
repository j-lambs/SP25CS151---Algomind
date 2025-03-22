import java.util.ArrayList;

class Student {
    public String studentName;
    public ArrayList<String> coursesTaken;
    public long phoneNo;
    public String email;
    public String gradeLevel;

    public Student(String studentName, ArrayList<String> coursesTaken, long phoneNo, String email, String gradeLevel) {
        this.studentName = studentName;
        this.coursesTaken = coursesTaken;
        this.phoneNo = phoneNo;
        this.email = email;
        this.gradeLevel = gradeLevel;
    }

    public void getStudentInfo() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Grade Level: " + gradeLevel);
        System.out.println("Courses Taken: " + coursesTaken);
    }

    public void viewCourses() {
        System.out.println(studentName + "'s courses: " + coursesTaken);
    }

    public void addCourse(Course course) {
        if (!coursesTaken.contains(course.getCourseName())) {
            if (course.getGradeLevel().equals(gradeLevel)) {
                coursesTaken.add(course.getCourseName());
                System.out.println(course.getCourseName() + " added.");
            } else {
                System.out.println("Cannot enroll in " + course.getCourseName() +
                        " as it is for " + course.getGradeLevel());
            }
        } else {
            System.out.println(course.getCourseName() + " already exists.");
        }
    }

    public void removeCourse(String course) {
        if (coursesTaken.contains(course)) {
            coursesTaken.remove(course);
            System.out.println(course + " removed.");
        } else {
            System.out.println(course + " not found.");
        }
    }

    public boolean isEnrolled(String course) {
        if (coursesTaken.contains(course)) {
            System.out.println(studentName + " is enrolled in " + course);
            return true;
        } else {
            System.out.println(studentName + " is NOT enrolled in " + course);
            return false;
        }
    }

    public void updateGradeLevel(String newGradeLevel) {
        if (!newGradeLevel.equals(gradeLevel)) {
            gradeLevel = newGradeLevel;
            System.out.println("Grade level updated to " + newGradeLevel);
        } else {
            System.out.println("New grade level is same as current.");
        }
    }

    public String currentCourse(Session session) {
        if (session != null && session.getStudent().equals(this)) {
            return session.getLessonName();
        } else {
            return "No active session found.";
        }
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }
}
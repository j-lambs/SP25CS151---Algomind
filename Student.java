import java.util.List;

class Student {
    public String studentName;
    public List<Course> coursesTaken;
    public int phoneNo;
    public String email;
    public int gradeLevel;
  
    public Student(String studentName, List<Course> coursesTaken, int phoneNo, String email, int gradeLevel) {
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


    public void addCourse(Course course) {
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

    public void removeCourse(Course course) {
        if (coursesTaken.contains(course)) {
            coursesTaken.remove(course);
            System.out.println(course + " removed.");
        } else {
            System.out.println(course + " not found.");
        }
    }

    public boolean isEnrolled(Course course) {
        if (coursesTaken.contains(course)) {
            System.out.println(studentName + " is enrolled in " + course);
            return true;
        } else {
            System.out.println(studentName + " is NOT enrolled in " + course);
            return false;
        }
    }


    public void enrollInCourse(Course course) {
        if (coursesTaken.contains(course)) {

        }
    }

    public void updateGradeLevel(int newGradeLevel) {
        if (newGradeLevel != gradeLevel) {
            gradeLevel = newGradeLevel;
            System.out.println("Grade level updated to " + newGradeLevel);
        } else {
            System.out.println("New grade level is same as current.");
        }
    }

    public Course currentCourse(Session session) {
        if (session != null && session.getStudent().equals(this)) {
            return session.getLessonName();
        } else {
            return "No active session found.";
        }
    }

}
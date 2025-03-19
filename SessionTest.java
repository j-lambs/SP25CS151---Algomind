import java.util.*;

public class SessionTest {
    public static void main(String[] args) {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Algebra 1"); courses.add("Trig");

        Student myStudent = new Student("Jack", courses, 800, "jack.rellamas@gmail.com", "10");
        String lesson = "Quadratic Formula";
        Session session = new Session(myStudent, lesson);
        session.startSession();
        System.out.println(session.getLessonName());
    }
}

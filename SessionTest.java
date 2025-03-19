public class SessionTest {
    public static void main(String[] args) {
        Student myStudent = new Student();
        Lesson myLesson = new Lesson();
        Session session = new Session(45330, myStudent, myLesson);

        session.convertToMilitaryTime(45330);
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Create a Course with Min 2 and Max 5 Students
        classes javaCourse = new classes("Java Programming", "Learn Java Basics", 5,2 );

        // Test addEnrolledStudent() method
        javaCourse.addEnrolledStudent("Karamjeet");
        javaCourse.addEnrolledStudent("Preet");
        javaCourse.addEnrolledStudent("Jack");
        javaCourse.addEnrolledStudent("Preet");
        javaCourse.addEnrolledStudent("Bhavya");
        javaCourse.addEnrolledStudent("Sean"); // This should fail (Class is full)
        // testremove enrolled student()
        javaCourse.removeEnrolledStudent(" karamjeet");
        javaCourse.removeEnrolledStudent("Preet");
        javaCourse.removeEnrolledStudent("Jack");
        javaCourse.removeEnrolledStudent("Preet");
        javaCourse.removeEnrolledStudent("Bhavya");
        javaCourse.removeEnrolledStudent("Sean");

    }
}
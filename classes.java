import java.util.ArrayList;

public class classes {
    // first step I wil add attribites
    // then constructor
    // then we will do add classes and remove classes and  view classes gonna use method.

 private String className;
 private String description;
 private int maxSize;
 private int minSize;
 private ArrayList<String>enrolledStudents;
 private ArrayList<String>lessons;
 // now constructor
    public classes(String className, String description, int maxSize, int minSize) {
        this.className = className;// we seprated attribute names with constrcutor names using this .
        this.description = description;
        this.maxSize = maxSize;
        this.minSize = minSize;
        this.enrolledStudents = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }
    // third step now i am going to use first method enrolled students
    public String getClassName(){
        return className;
    }
    public String getDescription(){
        return description;
    }
    public int getMaxSize(){
        return maxSize;
    }
    public int getMinSize(){
        return minSize;
    }
    public ArrayList<String> getEnrolledStudents(){
        return enrolledStudents;

    }
    public ArrayList<String> getLessons(){
        return lessons;
    }
    public void addEnrolledStudent(String student) {
        // enrolledStudents.add(student);
        //System.out.println("Enrolled student: " + student);
        if (enrolledStudents.size() >= maxSize) {
            System.out.println(" can Not able to add more students Sorry due to Univeristy policy :" + student);
            return;
        } else {
            enrolledStudents.add(student);
            System.out.println("Enrolled student welcome in : " + student);
        }
    }
        public void removeEnrolledStudent( String student){
            if( enrolledStudents.size() < minSize){
                System.out.println("  can not remove student "+ student);
                return;
            }
            else{
                enrolledStudents.remove(student);
                System.out.println("removed student because minmum student is requiremnt is full "+ student);
            }
        }






    }

    /*public class Main {
        public static void main(String[] args) {
            // Create a Course with Min 2 and Max 5 Students
            classes javaCourse = new classes("Java Programming", "Learn Java Basics", 2, 5);

            // Test addEnrolledStudent() method
            javaCourse.addEnrolledStudent("Karamjeet");
            javaCourse.addEnrolledStudent();addEnrolledStudent("Mckay");
            javaCourse.addEnrolledStudent();addEnrolledStudent("Jack");
            javaCourse.addEnrolledStudent("Preet");
            javaCourse.addEnrolledStudent("Bhavya");
            javaCourse.addEnrolledStudent();addEnrolledStudent("Sean"); // This should fail (Class is full)
        }
    }*/







import java.util.ArrayList;

abstract class Employee {
    public String fullName;
    public int age;
    public int employee_id;
    public double salary;
    public ArrayList availability; //bitstring of hour available
    public String position;

    public Employee(String fullName, int age, int id, double salary, ArrayList availability, String position) {
        this.fullName = fullName;
        this.age = age;
        this.id = id;
        this.salary = salary;
        this.availability = availability;
        this.position = position;
    }


}

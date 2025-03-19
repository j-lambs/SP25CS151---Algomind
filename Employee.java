import java.util.ArrayList;
import java.util.Date;

abstract class Employee {
    private String fullName;
    private int age;
    private int id;
    private double pay;
    private ArrayList availability; //bitstring of hour available
    private String positionTitle;
    private String Manager;
    private Date Hire_date;

    //All employee info is known
    protected Employee(String fullName,
                    int age,
                    int id,
                    double pay,
                    ArrayList availability,
                    String positionTitle,
                    Date Hire_date) {
            this.fullName = fullName;
            this.age = age;
            this.id = id;
            this.pay = pay;
            this.availability = availability;
            this.positionTitle = positionTitle;
            this.Hire_date = Hire_date;
    }
    //Basic employee info is known
    protected Employee(String fullName, int age, int id, Date Hire_date) {
            this.fullName = fullName;
            this.age = age;
            this.id = id;
            this.Hire_date = Hire_date;
    }

    //use in hourly and salary to display differently depending on employee type
    abstract void display_information();

    protected void update_age(){
        this.age = this.age + 1;
    }

    protected void update_pay(double pay){ //percent increase
        this.pay = this.pay + this.pay*pay;
    }

    protected void update_availability(ArrayList availability){
        this.availability = availability;
    }
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
    }

    public ArrayList get_availability(){
        return this.availability;
    }

    //promotes or demotes
    protected void new_title(String positionTitle){
        this.positionTitle = positionTitle;
    };

    protected void assign_manager(String manager){
        this.Manager = manager;
    }

    abstract void offboard();

}

class hourly_employee extends Employee {

    public hourly_employee(String fullName,int age, int id, Date Hire_date) {
        super(fullName, age, id, Hire_date);
    }

    public hourly_employee(String fullName,int age, int id, double pay, ArrayList availability, String positionTitle, Date Hire_date) {
        super(fullName, age, id, pay, availability, positionTitle, Hire_date);
    }

    public void display_information() {
        System.out.println(
                "Name: " +
                "Birthday: " +
                "Employee ID: " +
                "Position Title: " +
                "Hourly Rate: " +
                "Manager: " +
                "Hire Date: "
        );
    }

    public void offboard(){

    }
}
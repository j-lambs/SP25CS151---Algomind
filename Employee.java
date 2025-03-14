import java.util.ArrayList;
import java.util.Date;

abstract class Employee {
    private String fullName;
    private int age;
    private int id;
    private double pay = 0.00;
    private ArrayList availability = null; //bitstring of hour available
    private String positionTitle = "Unassigned";
    private String manager = "Unassigned";
    private Date hire_date;

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
            this.hire_date = Hire_date;
    }
    //Basic employee info is known
    protected Employee(String fullName, int age, int id, Date hire_date) {
            this.fullName = fullName;
            this.age = age;
            this.id = id;
            this.hire_date = hire_date;
    }

    //getters
    protected String getFullName() {
        return fullName;
    }
    protected int getAge() {
        return age;
    }
    protected int getId() {
        return id;
    }
    protected double getPay() {
        return pay;
    }
    protected ArrayList getAvailability() {
        return availability;
    }
    protected String getPositionTitle() {
        return positionTitle;
    }
    protected Date getHire_date() {
        return hire_date;
    }
    protected String getManager() {
        return manager;
    }

    // Setters
    protected void setFullName(String fullName) {
        this.fullName = fullName;
    }
    protected void setAge(int age) {
        this.age = age;
    }
    protected void setId(int id) {
        this.id = id;
    }
    protected void setPay(double pay) {
        this.pay = pay;
    }
    protected void setAvailability(ArrayList availability) {
        this.availability = availability;
    }
    protected void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }
    protected void setHire_date(Date Hire_date) {
        this.hire_date = Hire_date;
    }

    //access methods
    abstract void display_information();

    abstract void pay_employee();

    protected void update_age(int age){
        this.age = age;
    }

    protected void update_pay(double pay){ //percent increase
        this.pay = this.pay + this.pay*pay;
    }

    protected void update_availability(ArrayList availability){
        this.availability = availability;
    }

    //promotes or demotes
    protected void new_title(String positionTitle){
        this.positionTitle = positionTitle;
    };

    protected void assign_manager(String manager){
        this.manager = manager;
    }


}

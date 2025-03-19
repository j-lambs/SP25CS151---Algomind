import java.util.ArrayList;
import java.util.Date;

abstract class Employee {
    private String firstName;
    private String lastName;
    private int id;
    private String positionTitle = "Unassigned";
    private Date hire_date;
    private String status; // active, inactive
    private long phone_number;

    //All employee info is known
    protected Employee() {}

    protected Employee(String firstName,
                       String lastName,
                       int age,
                       int id,
                       Date hire_date,
                       String status,
                       long phone_number) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
            this.positionTitle = positionTitle;
            this.hire_date = hire_date;
            this.status = status;
            this.phone_number = phone_number;
    }

    // Setters
    protected void set_firstName(String firstName) {
        this.firstName = firstName;
    }
    protected void set_lastName(String lastName) {
        this.lastName = lastName;
    }
    protected void set_id(int id) {
        this.id = id;
    }
    protected void set_positionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }
    protected void set_hire_date(Date hire_date) {
        this.hire_date = hire_date;
    }
    protected void set_status(String status) {
        this.status = status;
    }
    protected void set_phone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    //getters
    protected String get_firstName() {
        return firstName;
    }
    protected String get_lastName() {
        return lastName;
    }
    protected int getId() {
        return id;
    }
    protected String getPositionTitle() {
        return positionTitle;
    }
    protected Date getHire_date() {
        return hire_date;
    }
    protected String get_status() {
        return status;
    }
    protected long getPhone_number() {
        return phone_number;
    }

    //access methods
    public void display_information(){
        System.out.println("Employee: " + get_lastName() + ", " + get_firstName());
        System.out.println("Employee ID: " + getId());
        System.out.println("Hire Date: " + getHire_date());
        System.out.println("Position Title: " + getPositionTitle());
        System.out.println("Status: " + get_status());
        System.out.println("Phone Number: " + getPhone_number());
    };

    abstract double gross_pay();
    abstract void position_pay_rate();


}

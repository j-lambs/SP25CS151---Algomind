import java.util.ArrayList;
import java.util.Date;

abstract class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int id;
    private String positionTitle = "Unassigned";
    private Date hire_date;
    private String status; // active, inactive

    //All employee info is known
    protected Employee() {}

    protected Employee(String firstName,
                       String lastName,
                       String email,
                       String phone,
                       int age,
                       int id,
                       Date hire_date,
                       String status) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.id = id;
            this.positionTitle = positionTitle;
            this.hire_date = hire_date;
            this.status = status;
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
    protected void set_phone_number(String phone) {
        this.phone = phone;
    }
    protected void set_email(String email) {
        this.email = email;
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
    protected String get_Phone_number() {
        return phone;
    }
    protected String get_email() {
        return email;
    }

    //access methods
    public void display_information(){
        System.out.println("Employee: " + get_lastName() + ", " + get_firstName());
        System.out.println("Email: " + get_email());
        System.out.println("Phone: " + get_Phone_number());
        System.out.println("Employee ID: " + getId());
        System.out.println("Hire Date: " + getHire_date());
        System.out.println("Position Title: " + getPositionTitle());
        System.out.println("Status: " + get_status());
    };

    abstract double update_gross_pay(); //for tutor and manager
    abstract void position_pay_rate();


}

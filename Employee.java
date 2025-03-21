import java.util.Date;

abstract class Employee {
    private String firstName = null
    private String lastName = null;
    private String email = null;
    private String phone = null;
    private int id = 0;
    private String positionTitle = "Unassigned";
    private Date hireDate;
    private String status = "Unassigned";// active, inactive

    //All employee info is known
    protected Employee() {}

    protected Employee(String firstName,
                       String lastName,
                       String email,
                       String phone,
                       int id,
                       Date hireDate,
                       String status) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.id = id;
            this.positionTitle = positionTitle;
            this.hireDate = hireDate;
            this.status = status;
    }

    // Setters
    protected void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    protected void setLastName(String lastName) {
        this.lastName = lastName;
    }
    protected void setID(int id) {
        this.id = id;
    }
    protected void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }
    protected void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
    protected void setStatus(String status) {
        this.status = status;
    }
    protected void setPhoneNumber(String phone) {
        this.phone = phone;
    }
    protected void setEmail(String email) {
        this.email = email;
    }

    //getters
    protected String getFirstName() {
        return firstName;
    }
    protected String getLastName() {
        return lastName;
    }
    protected int getId() {
        return id;
    }
    protected String getPositionTitle() {
        return positionTitle;
    }
    protected Date getHireDate() {
        return hireDate;
    }
    protected String getStatus() {
        return status;
    }
    protected String getPhoneNumber() {
        return phone;
    }
    protected String getEmail() {
        return email;
    }

    //access methods
    public void display_information(){
        System.out.println("Employee: " + getLastName() + ", " + getFirstName());
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + getPhoneNumber());
        System.out.println("Employee ID: " + getId());
        System.out.println("Hire Date: " + getHireDate());
        System.out.println("Position Title: " + getPositionTitle());
        System.out.println("Status: " + getStatus());
    };

    abstract double updateGrossPay(); //for tutor and manager
    abstract void positionPayRate();


}

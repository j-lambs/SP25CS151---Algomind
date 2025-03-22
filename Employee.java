
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;

abstract class Employee {
    private final int WORK_HOURS_IN_DAY = 8;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int id;
    private String positionTitle = "Unassigned";
    private Date hire_date;
    private String status; // active, inactive
//    private BitSet availability = new BitSet(WORK_HOURS_IN_DAY); // availability of Employee for every 30 minutes

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


    // Set availability for a specific 30-minute slot
    public void setAvailability(int slot, boolean isAvailable) {
        if (slot >= 0 && slot < WORK_HOURS_IN_DAY) {
            availability.set(slot, isAvailable);
        } else {
            throw new IllegalArgumentException("Invalid time slot.");
        }
    }

    // Check if the employee is available at a specific slot
    public boolean isAvailable(int slot) {
        if (slot >= 0 && slot < WORK_HOURS_IN_DAY) {
            return availability.get(slot);
        }
        throw new IllegalArgumentException("Invalid time slot.");
    }

    // Getter: Convert the BitSet to a bitstring representation
    public String getAvailabilityBitString() {
        StringBuilder bitString = new StringBuilder(WORK_HOURS_IN_DAY);
        for (int i = 0; i < WORK_HOURS_IN_DAY; i++) {
            bitString.append(availability.get(i) ? "1" : "0");
        }
        return bitString.toString();
    }

    // Setter: Set availability from a bitstring (must be exactly 48 characters)
    public void setAvailabilityBitString(String bitString) {
        if (bitString.length() != WORK_HOURS_IN_DAY || !bitString.matches("[01]+")) {
            throw new IllegalArgumentException("Bitstring must be 48 characters long, containing only '0' or '1'.");
        }
        availability.clear();
        for (int i = 0; i < WORK_HOURS_IN_DAY; i++) {
            if (bitString.charAt(i) == '1') {
                availability.set(i);
            }
        }
    }

    // Print availability for better readability
    public void printAvailability() {
        for (int i = 0; i < WORK_HOURS_IN_DAY; i++) {
            String time = String.format("%02d:%02d", i / 2, (i % 2) * 30);
            System.out.println(time + " - " + (availability.get(i) ? "Available" : "Unavailable"));
        }
    }

    abstract double update_gross_pay(); //for tutor and manager
    abstract void position_pay_rate();

    abstract double updateGrossPay(); //for tutor and manager
    abstract void positionPayRate();



}

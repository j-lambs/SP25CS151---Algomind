import java.util.Calendar;
import java.util.Date;
import java.time.LocalTime;

//Add contract hours for tutors
public class Manager extends Employee {
    private String firstName = null
    private String lastName = null;
    private String email = null;
    private String phone = null;
    private int id = 0;
    private String positionTitle = "Unassigned";
    private Date hireDate;
    private String status = "Unassigned";
    private int salary = 0;
    private int grossPay = 0 ;

    public Manager() {}
    public Manager(String firstName,
                   String lastName,
                   String email,
                   String phone,
                   int id,
                   Date hireDate,
                   String status) {
        super(firstName,lastName,email,phone,id, hireDate,status);
        this.salary = 0;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getSalary() {
        return salary;
    }

    public void setGrossPay(int grosspay) {
        this.grossPay = grosspay;
    }
    public int getGrosspay() {
        return grossPay;
    }

    @Override
    public void display_information() {
        super.display_information();
        System.out.println("Salary: " + getSalary());
        System.out.println("Gross Pay" + getGrosspay());
    }

    @Override
    double updateGrossPay() {
        Calendar rightNow = Calendar.getInstance();

    }

    @Override
    void positionPayRate() {

    }

    public void train(Employee tutor){
        tutor.
    }

    public void hire(Tutors tutor){

    }

    public void fire(){

    }

    public double pay(){

    }
    public void setAppointment(){

    }


}

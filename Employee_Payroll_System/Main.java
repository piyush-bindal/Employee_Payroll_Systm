import java.util.*;
//using abstraction
abstract class Employee {
    private String name;
    private int id;
    //using encapsulation for security reasons
   public Employee( String name, int id) {
        this.name = name;
        this.id = id;
   }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    //abstract method which will be used by subclasses that will inherit it
    abstract  double calculateSalary();

    @Override
    public String toString() {
        return "[name :" + name + " id: " + id +" salary: " + calculateSalary() + " ]";
    }

}
//using inheritence
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id); //calling the constructor of superclass
        this.monthlySalary = monthlySalary;
    }

    //overriding the abstract method
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
//using inheritence
class  PartTimeEmplyoee extends Employee {
    private int hoursWork;
    private double hourlyRate;

    public PartTimeEmplyoee(String name, int id, int hoursWork, double hourlyRate) {
        super(name, id);
        this.hourlyRate =hourlyRate;
        this.hoursWork = hoursWork;
    }

    //overriding method of abstract class
    @Override
    double calculateSalary() {
        return hoursWork * hourlyRate;
    }
}

class PayRollSystem {
    private ArrayList<Employee> employeeList;

    PayRollSystem() {
        employeeList = new ArrayList<>();

    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {

        Employee employeeToRemove = null;

        for(Employee emp : employeeList) {
            if(emp.getId() == id) {
                employeeToRemove = emp;
                break;
            }
        }

        if(employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
            System.out.println("Employee deleted successfully");
        }  else {
            System.out.println("Employee doesn't exist, unable to remove");
        }
    }

    public void displayEmployees() {
        for(Employee emp : employeeList) {
            System.out.println("id: " + emp.getId() +" name :" + emp.getName() + "Salary : "+ emp.calculateSalary());
        }
    }
}
public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        PayRollSystem payrollsystem = new PayRollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas" ,1, 1000000);
        PartTimeEmplyoee emp2 = new PartTimeEmplyoee("abc" , 2, 4, 5000);

        payrollsystem.addEmployee(emp1);
        payrollsystem.addEmployee(emp2);

        System.out.println("Inital employee details : ->");
        payrollsystem.displayEmployees();
        System.out.println();
        System.out.println("printing specific employee details");
        System.out.println(emp1.toString());
    }

}
package Oop.Inheritance;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(500);
        HrManager hrManager = new HrManager(1000);

        employee.work();
        System.out.println("Employee Salary: "+employee.getSalary());

        hrManager.work();
        System.out.println("Manager Salary: "+hrManager.getSalary());

        hrManager.addEmployee();
    }
}

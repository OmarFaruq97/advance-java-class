//Create a Java program with an Employee class that has a calculateSalary() method.
// Create two subclasses, Manager and Programmer, and override the calculateSalary() method
// in each to calculate salaries based on their roles.
// This shows how polymorphism works with method overriding.
package Oop.PolyMorphism.Three;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("Messi",200.05,50.35);
        Programmer programmer = new Programmer("Ronaldo",25.20,10.5);

        Employee[] employees={ manager, programmer};
        for (Employee employee : employees){
            System.out.println("Employee: "+employee.getName() + ", Role: " + employee.getRole());
            System.out.println("Salary: $" + employee.SalaryCalculate());
            System.out.println();
        }
    }
}

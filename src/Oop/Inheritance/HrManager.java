// Create a subclass called HRManager that overrides the work() method and
// adds a new method called addEmployee().
package Oop.Inheritance;

public class HrManager extends Employee{
    public HrManager(int salary) {
        super(salary);
    }

    @Override
    public void work() {
        System.out.println("\nManager is Employee");
    }
    public void addEmployee(){
        System.out.println("\nAdding new Employee");
    }
}

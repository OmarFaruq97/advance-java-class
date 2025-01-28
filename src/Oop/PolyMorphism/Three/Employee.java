package Oop.PolyMorphism.Three;

public class Employee {

    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
    public double SalaryCalculate(){
        return 0.0;
    }
}
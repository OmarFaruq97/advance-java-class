package Oop.PolyMorphism.Three;

public class Manager extends Employee {

    private double salary;
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, "Manager");
        this.salary = salary;
        this.bonus = bonus;
    }

    public double SalaryCalculate() {
        return salary + bonus;
    }
}

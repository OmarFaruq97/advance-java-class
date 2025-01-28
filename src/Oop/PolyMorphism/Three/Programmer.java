package Oop.PolyMorphism.Three;

public class Programmer extends Employee{

    private double hourWork;
    private double hourRate;

    public Programmer(String name, double salary, double bonus) {
        super(name, "Programmer");
        this.hourWork = salary;
        this.hourRate = bonus;
    }
    @Override
    public double SalaryCalculate(){
        return hourWork * hourRate;
    }
}

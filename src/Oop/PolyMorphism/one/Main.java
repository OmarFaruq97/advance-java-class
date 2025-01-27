package Oop.PolyMorphism.one;

public class Main {
    public static void main(String[] args) {
        Person obj = new Person();
        obj.display();

        obj = new Student();
        obj.display();

        obj = new Teacher();
        obj.display();

        obj = new Worker();
        obj.display();
    }
}
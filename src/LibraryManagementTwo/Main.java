package LibraryManagementTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<LibrarySystem> librarySystems=new ArrayList<>();

        LibrarySystem bookOne = new LibrarySystem
                ("java","Messi",2015,210,20.50,true);
        LibrarySystem bookTwo = new LibrarySystem
                ("HTML","Ronaldo",2014,250,50.40,true);
        LibrarySystem bookThree = new LibrarySystem
                ("CSS","Neymar",2016,215,15.50,true);

        librarySystems.add(bookOne);
        librarySystems.add(bookTwo);
        librarySystems.add(bookThree);

//        for (LibrarySystem lOOp : librarySystems){
//            lOOp.displayInformation();
//        }

        while (true){
            System.out.println("\n WellCome to Library Menu====");
            System.out.println("1)**List of all Books**");
            System.out.println("2)Borrow any Book");
            System.out.println("3)Return Book");
            System.out.println("4)Exit");

            System.out.println("Choose a option: ");
            int main = scanner.nextInt();
            scanner.nextLine();
            switch (main){
                case 1:
                    listBook(librarySystems);
                    break;
                case 2:
//                    BorrowBookMethod(scanner);

            }
        }
    }
    public static void listBook(List<LibrarySystem> librarySystems){
        for (LibrarySystem lOOp : librarySystems){
            lOOp.displayInformation();
        }

    }





}

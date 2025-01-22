package LibraryManagment;

public class Book {

    String title;
    String author;
    int year;
    int pageNumber;
    double price;
    boolean isBorrowed;

    public Book(String title, String author, int year, int pageNumber, double price, boolean isBorrewed ) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pageNumber = pageNumber;
        this.price = price;
        this.isBorrowed = false;
    }
    public void isBorrow (){
        isBorrowed = true;
    }
    public void returnBook(){
        isBorrowed = false;
    }
    public boolean isAvailable(){
        return !isBorrowed;
    }
    public void displayBookDetails(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Publish Year: "+year);
        System.out.println("Number of Pages: "+ pageNumber);
        System.out.println("Price: "+price);
    }

}

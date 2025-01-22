package LibraryManagementTwo;

public class LibrarySystem {
    private String title;
    private String author;
    private int year;
    private int pageNumber;
    private double price;
    private boolean available;

    public LibrarySystem(String title, String author, int year,
         int pageNumber, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pageNumber = pageNumber;
        this.price = price;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void displayInformation(){
        System.out.println("Book Title: "+title);
        System.out.println("Book Author: "+author);
        System.out.println("Published Year: "+year);
        System.out.println("Number of Pages: "+pageNumber);
        System.out.println("Book Price: "+price);
        System.out.println();
    }
}

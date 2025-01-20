package Task;

public class Main {
    public static void main(String[] args) {
        BookData insertStudentData = new BookData();

        // Define Dummy Data
        String[][] BookData = {
                {"Mezor Dalim Bolchi", "Mezor Dalim", "AttoZiboni", "500.30", "1975-08-15"},
//
        };

        // Call the method to insert dummy data
//        insertStudentData.insertDummyData(students);

        BookData postgreSql = new BookData();
        postgreSql.insertDummyData(BookData);

    }
}

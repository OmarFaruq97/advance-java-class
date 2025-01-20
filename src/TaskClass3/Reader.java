package TaskClass3;

import java.io.*;

public class Reader {

    String filepath = "C:\\Users\\Java Student2\\Desktop\\1285325\\Information.csv";
    String delimeter = ",";

    public void readCsv(){
        String line;

        try (BufferedReader readerFileAsLine = new BufferedReader(new FileReader("filepath"))){

            while ((line = readerFileAsLine.readLine()) !=null){

                String[] colulmn = line.split(delimeter);

                for (String myline : colulmn){
                    System.out.println();
                }
                System.out.println();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

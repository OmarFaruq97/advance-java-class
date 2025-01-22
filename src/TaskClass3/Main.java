package TaskClass3;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String inputPath = "C:\\GIT\\advance-java-class\\src\\TaskClass3\\Information.csv";
        ReadFile readFile = new ReadFile(inputPath);
        readFile.readFile();
        List<String[]> inputfile = readFile.getStringList();

        InsertData insertData = new InsertData();
        insertData.insertAllProduct(inputfile);

        RetriveData retriveData = new RetriveData();
        retriveData.selectAllProduct();
        List<String[]> readData = retriveData.getArrayString();

        for (String[] data : readData) {


            data[2] = "Juice";
            data[3] = "CocaCola";
        }

        String filePath2 = "C:\\GIT\\advance-java-class\\src\\TaskClass3\\write.csv";
        WriteFile writeFile = new WriteFile(filePath2, readData);
        writeFile.writeFile();
    }

}

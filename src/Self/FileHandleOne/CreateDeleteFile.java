package Self.FileHandleOne;

import java.io.File;

public class CreateDeleteFile {
    public static void main(String[] args) {

        File folder = new File("D:\\CheckFileJava");
        if (folder.mkdir()){
            System.out.println("Folder has been created");
        }else {
            System.out.println("Failed to create folder");
            System.out.println("Folder Name: "+folder.getName());
        }
        String path = folder.getAbsolutePath();

        File studentOne = new File(path+"\\Student.txt");
        File teacherTwo = new File(path+"\\Teacher.txt");

        try {
            studentOne.createNewFile();
            teacherTwo.createNewFile();
            System.out.println("Files has been Created");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Location: "+path);

        if (folder.delete()){
            System.out.println("Folder has been delete");
        }else System.out.println("Failed to delete folder");

        if (studentOne.exists()){
            System.out.println(studentOne.getName()+" file is existing");
        }
        else System.out.println(studentOne.getName()+" file not founded");

        if (teacherTwo.exists()){
            System.out.println(teacherTwo.getName()+" file is existing");
        }
        else System.out.println(teacherTwo.getName()+" file not founded");
    }
}
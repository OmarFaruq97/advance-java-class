package Self;
import java.io.File;

public class CreateDeleteDirectory {
    public static void main(String[] args) {

        File dir = new File("D:\\My Project\\CheckFolder");

        if (dir.mkdir()){       //how to create a folder
            System.out.println(dir.getName()+" has been Created");
        }else {
            System.out.println("Failed to create folder");
        }
        String dirLocation = dir.getAbsolutePath();
        System.out.println(dirLocation);
        System.out.println(dir.getName());


//        How to delete a folder
//        if (dir.delete()){
//            System.out.println(dir.getName()+" has been deleted");
//        }else {
//            System.out.println("Failed to delete folder");
//        }

    }
}

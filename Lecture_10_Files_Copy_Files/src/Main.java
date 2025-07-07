import java.io.File;
import java.io.InputStream;

public class Main{
    public static void main(String [] args){
      boolean status;
        status=CopyFiles.copyFile("C:\\Users\\Sarthak Darade\\Desktop\\Folders\\Links of site having good animations.xlsx",
               "C:\\Users\\Sarthak Darade\\Desktop");
        System.out.println("Copying..");
        if(status){
            System.out.println("Copied");
        }
        else{
            System.out.println("Copy failed");
        }

        status=CopyFiles.copyDir("C:\\Users\\Sarthak Darade\\Desktop\\f\\Java_Programs\\Lecture_10_Files_Copy_Files\\src",
                "C:\\Users\\Sarthak Darade\\Desktop");
        System.out.println("Copying..");
        if(status){
            System.out.println("Copied");
        }
        else{
            System.out.println("Copy failed");
        }
    }

}
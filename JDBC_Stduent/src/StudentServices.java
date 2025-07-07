import java.util.ArrayList;

public class StudentServices {

    public static void addStudent(StudentDAO stuDAO,Student s){

        stuDAO.addStudent(s);
    }
    public static Student getStudentById(StudentDAO stuDAO,int id){

     Student s=stuDAO.getStudentById(id);
         return s;
    }
    public static ArrayList<Student> getAllStudent(StudentDAO stuDAO){

       return  stuDAO.getAllStudent();
    }
    public static void updateStudent(StudentDAO stuDAO,int id,int marks){

        stuDAO.updateStudentMarks(id,marks);
    }
    public static void deleteStudent(StudentDAO stuDAO,int id){

        stuDAO.deleteStudent(id);
    }
}

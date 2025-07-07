import java.util.ArrayList;
import java.util.List;

public interface StudentDAO {

    public void addStudent(Student student);
    public Student getStudentById(int id);
    public ArrayList<Student> getAllStudent();
    public void updateStudentMarks(int id,int marks);
    public void deleteStudent(int id);
}

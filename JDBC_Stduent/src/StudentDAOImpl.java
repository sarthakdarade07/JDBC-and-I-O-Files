import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    public void addStudent(Student student){
        String query="insert into student(id,name,email,marks) values(?,?,?,?)";
        Connection con=DBConnection.getConnection();
        try {
            PreparedStatement prep=con.prepareStatement(query);
            prep.setInt(1,student.getId());
            prep.setString(2,student.getName());
            prep.setString(3, student.getEmail());
            prep.setInt(4,student.getMarks());
             prep.execute();
             int count=prep.getUpdateCount();
             if(count>0){
                 System.out.println("record added to database");
             }

        } catch (SQLException e) {
            System.out.println("err");
        }
    }

    @Override
    public Student getStudentById(int id) {
        String query="select id,name,email,marks from student where id="+id;
        Connection con=DBConnection.getConnection();
        try {
            PreparedStatement prep=con.prepareStatement(query);
            ResultSet res=prep.executeQuery();
            boolean status = res.next();
            if(status) {
                Student s = new Student(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4));
                return s;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("err");
        }
        return null;
    }

    @Override
    public ArrayList<Student> getAllStudent() {
        String query="select * from student";
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement prep=con.prepareStatement(query);
            ArrayList<Student> studentsList=new ArrayList<>();

            ResultSet rs=prep.executeQuery();

            while (rs.next()){
//                System.out.println("id: "+rs.getInt(1));
//                System.out.println("name: "+rs.getString(2));
//                System.out.println("email: "+rs.getString(3));
//                System.out.println("id: "+rs.getInt(4));
//                System.out.println("-------------------------------------------");

                Student stu=new Student(rs.getInt("id"),rs.getString("name"),
                                        rs.getString("email"),rs.getInt("marks"));
                studentsList.add(stu);
            }
            con.close();
            return studentsList;
        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public void deleteStudent(int id) {
        String query="delete from student where id="+id;
        Connection con=DBConnection.getConnection();
        try {
            PreparedStatement prep=con.prepareStatement(query);
            prep.execute();

           if(prep.getUpdateCount()>0){
               System.out.println("Record deleted from student with id "+id);
           }

            con.close();
        } catch (SQLException e) {

            System.out.println("err in delete");
        }



    }

    @Override
    public void updateStudentMarks(int id, int marks) {
        String query="update student set marks=? where id=?";
        Connection con=DBConnection.getConnection();
        try {
            PreparedStatement prep= con.prepareStatement(query);
            prep.setInt(1,marks);
            prep.setInt(2,id);
            prep.execute();
            if(prep.getUpdateCount()>0){
                System.out.println("Record Updated");
            }
            else{
                System.out.println("Record is not Updated..");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

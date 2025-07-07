public class Student {
   private int id,marks;
    private String name,email;

    public Student(int id,String name,String email,int marks){
        this.id=id;
        this.name=name;
        this.email=email;
        this.marks=marks;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", marks=" + marks +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';

    }
    public  void display(){
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.printf("%-5d | %-10s | %-15s | %-5d",id,name,email,marks);

    }


}

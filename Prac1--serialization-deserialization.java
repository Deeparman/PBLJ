import java.io.*;

class Student implements Serializable {
    int studentID;
    String name;
    String grade;

    public Student(int studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public void display(){
        System.out.println("Student ID: " + studentID + "Name: " + name + "Grade: " + grade);
    }
}

public class Ques2 {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", "A");
        String filename = "student.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(s1);
            System.out.println("Serialization Done Successfully...........");
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student s2 = (Student) ois.readObject();
            System.out.println("Deserialization done Successfully..............");
            System.out.println(s2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

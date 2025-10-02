import java.sql.*;

public class SQLConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/EmployeeInfo";
        String user = "root";
        String password = "abc@123";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT EmpID, Name, Salary FROM Employee");

            System.out.println("EmpID\tName\tSalary");
            while (rs.next()) {
                System.out.println(rs.getInt("EmpID") + "\t" + 
                                   rs.getString("Name") + "\t" + 
                                   rs.getDouble("Salary"));
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

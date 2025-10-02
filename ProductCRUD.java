import java.sql.*;
import java.util.Scanner;

public class ProductCRUD {
    static final String URL = "jdbc:mysql://localhost:3306/ProductInfo";
    static final String USER = "root";
    static final String PASS = "abcd1234";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false);  
            boolean exit = false;

            while (!exit) {
                System.out.println("\n1. Create Product\n2. Read Products\n3. Update Product\n4. Delete Product\n5. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        PreparedStatement psInsert = con.prepareStatement(
                                "INSERT INTO Product (ProductName, Price, Quantity) VALUES (?, ?, ?)");
                        psInsert.setString(1, name);
                        psInsert.setDouble(2, price);
                        psInsert.setInt(3, qty);
                        psInsert.executeUpdate();
                        con.commit();
                        System.out.println("Product added successfully!");
                        break;

                    case 2: 
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
                        System.out.println("ID\tName\tPrice\tQuantity");
                        while (rs.next()) {
                            System.out.println(rs.getInt("ProductID") + "\t" +
                                               rs.getString("ProductName") + "\t" +
                                               rs.getDouble("Price") + "\t" +
                                               rs.getInt("Quantity"));
                        }
                        rs.close();
                        stmt.close();
                        break;

                    case 3:
                        System.out.print("Enter ProductID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new Price: ");
                        double newPrice = sc.nextDouble();
                        System.out.print("Enter new Quantity: ");
                        int newQty = sc.nextInt();

                        PreparedStatement psUpdate = con.prepareStatement(
                                "UPDATE Product SET ProductName=?, Price=?, Quantity=? WHERE ProductID=?");
                        psUpdate.setString(1, newName);
                        psUpdate.setDouble(2, newPrice);
                        psUpdate.setInt(3, newQty);
                        psUpdate.setInt(4, updateId);
                        psUpdate.executeUpdate();
                        con.commit();
                        System.out.println("Product updated successfully!");
                        break;

                    case 4:
                        System.out.print("Enter ProductID to delete: ");
                        int deleteId = sc.nextInt();
                        PreparedStatement psDelete = con.prepareStatement(
                                "DELETE FROM Product WHERE ProductID=?");
                        psDelete.setInt(1, deleteId);
                        psDelete.executeUpdate();
                        con.commit();
                        System.out.println("Product deleted successfully!");
                        break;

                    case 5:
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

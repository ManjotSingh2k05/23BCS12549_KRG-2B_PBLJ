import java.sql.*; 
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password"
            );
            con.setAutoCommit(false);
            int choice;

            while (true) {
                System.out.println("\n--- Product Management Menu ---");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                if (choice == 1) {
                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO Product VALUES (?, ?, ?, ?)"
                    );
                    System.out.print("Enter Product ID: ");
                    ps.setInt(1, sc.nextInt());
                    System.out.print("Enter Product Name: ");
                    ps.setString(2, sc.next());
                    System.out.print("Enter Price: ");
                    ps.setDouble(3, sc.nextDouble());
                    System.out.print("Enter Quantity: ");
                    ps.setInt(4, sc.nextInt());
                    ps.executeUpdate();
                    con.commit();
                    System.out.println("Product Added Successfully!");
                } 
                else if (choice == 2) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM Product");
                    while (rs.next()) {
                        System.out.println(
                            rs.getInt(1) + " | " + 
                            rs.getString(2) + " | " + 
                            rs.getDouble(3) + " | " + 
                            rs.getInt(4)
                        );
                    }
                } 
                else if (choice == 3) {
                    PreparedStatement ps = con.prepareStatement(
                        "UPDATE Product SET Price=?, Quantity=? WHERE ProductID=?"
                    );
                    System.out.print("Enter Product ID: ");
                    ps.setInt(3, sc.nextInt());
                    System.out.print("Enter New Price: ");
                    ps.setDouble(1, sc.nextDouble());
                    System.out.print("Enter New Quantity: ");
                    ps.setInt(2, sc.nextInt());
                    ps.executeUpdate();
                    con.commit();
                    System.out.println("Product Updated Successfully!");
                } 
                else if (choice == 4) {
                    PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM Product WHERE ProductID=?"
                    );
                    System.out.print("Enter Product ID: ");
                    ps.setInt(1, sc.nextInt());
                    ps.executeUpdate();
                    con.commit();
                    System.out.println("Product Deleted Successfully!");
                } 
                else if (choice == 5) {
                    System.out.println("Exiting...");
                    break;
                } 
                else {
                    System.out.println("Invalid Choice");
                }
            }
            con.close();
        } 
        catch (Exception e) { 
            System.out.println("Error! Rolling Back...");
        }
    }
}

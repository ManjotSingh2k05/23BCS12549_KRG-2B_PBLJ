import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.sql.*;

public class EmployeeServlet extends HttpServlet { 
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
        res.setContentType("text/html"); 
        PrintWriter out = res.getWriter(); 
        String empid = req.getParameter("empid"); 

        try { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password"
            ); 

            Statement st = con.createStatement(); 
            ResultSet rs; 

            if (empid != null && !empid.isEmpty()) { 
                rs = st.executeQuery("SELECT * FROM Employee WHERE EmpID=" + empid); 
            } else { 
                rs = st.executeQuery("SELECT * FROM Employee"); 
            }

            out.println("<h2>Employee List:</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Dept</th></tr>");
            
            while (rs.next()) { 
                out.println("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td></tr>");
            }
            
            out.println("</table>");
            con.close(); 
        } 
        catch (Exception e) { 
            out.println("Error: " + e.getMessage()); 
        } 
    } 
}

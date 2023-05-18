import java.sql.*;

public class JDBCex {
   static final String DB_URL = "jdbc:mysql://localhost/3306";
   static final String USER = "root";
   static final String PASS = "vpms";
   static final String QUERY = "select * from emp";

   public static void main(String[] args) {
      // Open a connection 
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
        	System.out.print("Emp name: " + rs.getString("empname"));
            System.out.print("ID: " + rs.getInt("empid"));
            System.out.println("Address: " + rs.getString("empadd"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}
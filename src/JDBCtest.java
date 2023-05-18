import java.sql.*;
public class JDBCtest {
	public static void main(String args[]){   
	try{  
	    Class.forName("com.mysql.cj.jdbc.Driver");  
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest","root","vpms");
	    Statement stmt=con.createStatement();  
	
	    int resultins=stmt.executeUpdate("insert into emp(empname,empid, empadd) values('Ranjan', 001, 'Bihar')");
	    if (resultins>0){
            System.out.println("Successfully Inserted");
        }
        else{
            System.out.println("Insertion Failed");
        }

	    int resultupd=stmt.executeUpdate("update emp set empname='RAM' where empid=3");
	    if (resultupd>0){
            System.out.println("successfully Updated");
        }
        else{
            System.out.println("Update failed");
        }

 	    ResultSet rs=stmt.executeQuery("select * from emp");  
 	    while(rs.next())  
 	    System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
        con.close();  
	}
	catch(Exception e){ 
        System.out.println(e);
    } 
	}
}
package com.sai.jdbc;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class jbcExample {
	public static void main(String[] args) throws IOException {
		//String testurl1 = System.getProperty("MY_VARIABLE");

		//String url=System.getenv();
		 Properties prop = new Properties();
//InputStream fis = prop.getClass().getClassLoader().getResourceAsStream("application.properties");
FileInputStream fis = new FileInputStream("C:/Users/sai/workspace/workspace072017//jdbc/src/main/resources/application.properties");
		 prop.load(fis);
		 String driverClassName = prop.getProperty("jdbc.driverClassName");
		 String url = prop.getProperty("jdbc.url");
		 String username = prop.getProperty("jdbc.username");
		 String password = prop.getProperty("jdbc.password");
		 System.out.println(driverClassName);
		 
	try {
		Class.forName(driverClassName);
		Connection conn = DriverManager.getConnection(url ,username, password);
	    Statement stm =conn.createStatement();
	    ResultSet rs = stm.executeQuery("Select * from EMP");
	   
	  int a[];
	  int j=0;
	   while(rs.next()){  
		 int i =rs.getInt(1);
		String b=rs.getString(2);
		int k=rs.getInt(3);
		String r=rs.getString(4);
		 j++;
		
			System.out.println("Eid "+ i +"  Name " + b + "  Salary  "+k +"  Dept  " + r);
			 }
	    conn.close();
	    
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}

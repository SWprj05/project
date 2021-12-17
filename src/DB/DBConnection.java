package DB;

import java.io.*;
import java.lang.*;
import java.sql.*;
import java.util.logging.*;

/**
 * �����ͺ��̽��� �����մϴ�.
 * @author Team5
 *
 */
public class DBConnection {
	
	final String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	final String db_id = "software";
	final String db_password = "selab"; // DB���� ����
	Connection conn = null;
	Statement stmt = null; 
	
	public Statement db_connect() {
		try {
			// ���� ����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbc_url, db_id, db_password); 
			System.out.println("DB���� ����");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);   
			// ����κ��� statement ����
		} 
		catch (SQLException ex) 
		{
			System.out.println("DB���� ����");
		} 
		catch (ClassNotFoundException ex) 
		{
			System.out.println("JDBC ����̹� �ε� ���� "); 
		}
		return stmt;
	}  
	
	/**
	* �����ͺ��̽����� ���� ����
	*/
	public void db_close() { 
		try 
		{
			conn.close();
		} 
		catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
		}
	}

}

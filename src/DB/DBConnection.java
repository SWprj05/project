package DB;

import java.io.*;
import java.lang.*;
import java.sql.*;


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
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection(jdbc_url, db_id, db_password); 
			System.out.println( "DB����Ϸ�. " );	
			stmt = conn.createStatement(); 
			
			
		} catch( ClassNotFoundException e ) {
			System.out.println( "�ش����̹���ã���������ϴ�.\n" + e);
		} catch( SQLException e) {
			System.out.println( "�ش����̹���ã���������ϴ�.\n" + e);
		}
		
		return stmt;
	}


}

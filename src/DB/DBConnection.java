package DB;

import java.io.*;
import java.lang.*;
import java.sql.*;
import java.util.logging.*;

/**
 * 데이터베이스에 연결합니다.
 * @author Team5
 *
 */
public class DBConnection {
	
	final String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	final String db_id = "software";
	final String db_password = "selab"; // DB연결 관련
	Connection conn = null;
	Statement stmt = null; 
	
	public Statement db_connect() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection(jdbc_url, db_id, db_password); 
			System.out.println( "DB연결완료. " );	
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE); 
			
		} catch( ClassNotFoundException e ) {
			System.out.println( "해당드라이버를찾을수없습니다.\n" + e);
		} catch( SQLException e) {
			System.out.println( "해당드라이버를찾을수없습니다.\n" + e);
		}
		
		return stmt;
	}
	
	/**
	* 데이터베이스와의 연결 해제
	*/

	public  void db_close() { 
		try 
		{
			conn.close();
		} 
		catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex); 
		}
	}

}

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
			// 연결 생성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbc_url, db_id, db_password); 
			System.out.println("DB연결 성공");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);   
			// 연결로부터 statement 생성
		} 
		catch (SQLException ex) 
		{
			System.out.println("DB연결 오류");
		} 
		catch (ClassNotFoundException ex) 
		{
			System.out.println("JDBC 드라이버 로드 오류 "); 
		}
		return stmt;
	}  
	
	/**
	* 데이터베이스와의 연결 해제
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

package DB;

import java.io.*;
import java.lang.*;
import java.sql.*;

/**
 * Oracle DB시스템과 연결.
 * @author Team5
 *
 */
public class DBconnection {
	
	public void connect() {
		/**
		 * DB와 연결할 변수들.
		 */
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		/**
		 * DB게정(아이디, 비밀번호).
		 */
		String db_id = "software";
		String db_pw = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", db_id, db_pw); 
			System.out.println( "성공적으로로딩되었음" );	
			stmt = conn.createStatement (); 
			rset = stmt.executeQuery ("select * from foodtrucktb"); 
			
		} catch( ClassNotFoundException e ) {
			System.out.println( "해당드라이버를찾을수없습니다.\n" + e);
		} catch( SQLException e) {
			System.out.println( "해당드라이버를찾을수없습니다.\n" + e);
		}
	}
	
}

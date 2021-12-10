package DB;

import java.io.*;
import java.lang.*;
import java.sql.*;

/**
 * Oracle DB�ý��۰� ����.
 * @author Team5
 *
 */
public class DBconnection {
	
	public void connect() {
		/**
		 * DB�� ������ ������.
		 */
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		/**
		 * DB����(���̵�, ��й�ȣ).
		 */
		String db_id = "software";
		String db_pw = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", db_id, db_pw); 
			System.out.println( "���������ηε��Ǿ���" );	
			stmt = conn.createStatement (); 
			rset = stmt.executeQuery ("select * from foodtrucktb"); 
			
		} catch( ClassNotFoundException e ) {
			System.out.println( "�ش����̹���ã���������ϴ�.\n" + e);
		} catch( SQLException e) {
			System.out.println( "�ش����̹���ã���������ϴ�.\n" + e);
		}
	}
	
}

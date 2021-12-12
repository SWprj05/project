package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 사용자 정보가 담겨있는 DB에서 id와 pw를 검색하는 클래스 입니다.
 * @author Team5
 *
 */

public class UserDB {
	DBConnection db;
	
	public UserDB() {
		db = new DBConnection();
		db.db_connect();
	}
	
	/**
	 * sql문을 통해 DB에서 id값을 찾는다. 
	 * @param input_id 검색할 아이디	
	 * @return 아이디
	 */
	public String get_ID(String input_id) {
		String id = "";
		Statement stmt;
		stmt = db.db_connect();
		
		try {
			ResultSet rs = stmt.executeQuery("select * from usertb where id = '" + input_id + "'");
			while(rs.next()) {
				id = rs.getString("id");
			}
			
			System.out.println("데이터 베이스에서 찾는 id : " + id);
		}
		catch( SQLException e) {
			System.out.println( "해당 ID가 없습니다." + e);
		}
		return id;
	}
	
	/**
	 * sql문을 통해 DB에서 pw값을 찾는다. 
	 * id값을 sql문으로 검색하고 그에 맞는 pw값을 검색합니다.
	 * 일치하는 경우 pw를 리턴하고 일치하지 않는 경우에 쓰레기값 "0"을 리턴합니다.
	 * 
	 * @param input_id 검색할 아이디
	 * @param input_pw 검색할 패스워드
	 * @return 패스워드
	 */
	public String get_PW(String input_id, String input_pw) {
		String id = "";
		String pw = "";
		boolean pw_check = false;
		Statement stmt;
		stmt = db.db_connect();
		
		try {
			ResultSet rs = stmt.executeQuery("select * from usertb where id = '" + input_id + "'");
			while(rs.next()) {
				
				pw = rs.getString("pw");
				if(pw.equals(input_pw)) {
					pw_check = true;
				}else {
					pw_check = false;
				}
				
			}
			
			System.out.println("데이터 베이스에서 찾는 pw : " + pw);
		}
		catch( SQLException e) {
			System.out.println( "해당 PW가 없습니다." + e);
		}
		if(pw_check) {
			return pw;
		}
		else {
			return "0";
		}
		
	}


}

package DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ����� ������ ����ִ� DB���� id�� pw�� �˻��ϴ� Ŭ���� �Դϴ�.
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
	 * sql���� ���� DB���� id���� ã�´�. 
	 * @param input_id �˻��� ���̵�	
	 * @return ���̵�
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
			
			System.out.println("������ ���̽����� ã�� id : " + id);
		}
		catch( SQLException e) {
			System.out.println( "�ش� ID�� �����ϴ�." + e);
		}
		return id;
	}
	
	/**
	 * sql���� ���� DB���� pw���� ã�´�. 
	 * id���� sql������ �˻��ϰ� �׿� �´� pw���� �˻��մϴ�.
	 * ��ġ�ϴ� ��� pw�� �����ϰ� ��ġ���� �ʴ� ��쿡 �����Ⱚ "0"�� �����մϴ�.
	 * 
	 * @param input_id �˻��� ���̵�
	 * @param input_pw �˻��� �н�����
	 * @return �н�����
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
			
			System.out.println("������ ���̽����� ã�� pw : " + pw);
		}
		catch( SQLException e) {
			System.out.println( "�ش� PW�� �����ϴ�." + e);
		}
		if(pw_check) {
			return pw;
		}
		else {
			return "0";
		}
		
	}


}

package Login;

import DB.*;

/**
 * UserDB�� �����ؼ� �α��� ������ ��� Ŭ���� �Դϴ�.
 * @author Team5
 *
 */
public class LoginProcess {
	
	UserDB obj = new UserDB();
	
	/**
	 * LoginDisplay���� �ؽ�Ʈ �ʵ忡 �Էµ� id, pw���� �ùٸ��� �˻�.
	 * @param id	�ؽ�Ʈ �ʵ忡 �Է¹��� ���̵�
	 * @param pw	�н����� �ʵ忡 �Է¹��� �н�����
	 * @return true / false
	 */
	public boolean login_check(String id, String pw) {
		
		String id_fromDB = obj.get_ID(id);
		String pw_fromDB = obj.get_PW(id, pw);
		
		if(id.equals(id_fromDB) && pw.equals(pw_fromDB)) {
			return true;
		}
		else {
			return false;
		}
	}
}

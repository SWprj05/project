package Login;

import DB.*;

/**
 * UserDB에 연결해서 로그인 정보를 얻는 클래스 입니다.
 * @author Team5
 *
 */
public class LoginProcess {
	
	UserDB obj = new UserDB();
	
	/**
	 * LoginDisplay에서 텍스트 필드에 입력된 id, pw값이 올바른지 검사.
	 * @param id	텍스트 필드에 입력받은 아이디
	 * @param pw	패스워드 필드에 입력받은 패스워드
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

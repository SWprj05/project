package Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import DB.*;
import Main.*;

/**
 * 로그인을 성공했을 경우 사용자의 이름과 함께 성공한 화면을 띄워주는 클래스입니다.
 * @author Team5
 *
 */
public class LoginSuccDisplay extends JFrame {
	
	UserDB ud;
	String name;
	
	public LoginSuccDisplay(){
		ud = new UserDB();;
		name = ud.get_Name(LoginDisplay.id);
		
		System.out.print(name);
		
		getContentPane().setFont(new Font("맑은 고딕", Font.BOLD, 17));
		setTitle("로그인 화면");
		setSize(360, 640);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel Txt_hello = new JLabel("반갑습니다 "+ name +" 님!");
		Txt_hello.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		Txt_hello.setBounds(82, 58, 211, 25);
		getContentPane().add(Txt_hello);
		
		JButton Btn_main = new JButton("홈화면");
		Btn_main.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		Btn_main.setBounds(187, 488, 97, 25);
		getContentPane().add(Btn_main);
		Btn_main.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new MainDisplay_User();
			}
			
		});
		
		JButton Btn_logout = new JButton("로그아웃");
		Btn_logout.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		Btn_logout.setBounds(59, 488, 97, 25);
		getContentPane().add(Btn_logout);
		
		
		
		if(MainDisplay_User.login_state == 1)
		{
			setVisible(true);
		}
	}
	
}

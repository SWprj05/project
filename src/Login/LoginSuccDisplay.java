package Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import DB.*;
import Main.*;

/**
 * �α����� �������� ��� ������� �̸��� �Բ� ������ ȭ���� ����ִ� Ŭ�����Դϴ�.
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
		
		getContentPane().setFont(new Font("���� ���", Font.BOLD, 17));
		setTitle("�α��� ȭ��");
		setSize(360, 640);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		JLabel Txt_hello = new JLabel("�ݰ����ϴ� "+ name +" ��!");
		Txt_hello.setFont(new Font("���� ���", Font.BOLD, 18));
		Txt_hello.setBounds(82, 58, 211, 25);
		getContentPane().add(Txt_hello);
		
		JButton Btn_main = new JButton("Ȩȭ��");
		Btn_main.setFont(new Font("���� ���", Font.BOLD, 14));
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
		
		JButton Btn_logout = new JButton("�α׾ƿ�");
		Btn_logout.setFont(new Font("���� ���", Font.BOLD, 14));
		Btn_logout.setBounds(59, 488, 97, 25);
		getContentPane().add(Btn_logout);
		
		
		
		if(MainDisplay_User.login_state == 1)
		{
			setVisible(true);
		}
	}
	
}

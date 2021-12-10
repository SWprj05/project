package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * �α��� ȭ�� �����ϴ� Ŭ����
 * @author Geongseo
 *
 */

public class LoginDisplay extends JFrame {
	
	private JTextField Txt_input_id;		// id �Է� �޴� �ؽ�Ʈ �ʵ�
	private JPasswordField Txt_input_pw;	// pw �Է� �޴� �н����� �ʵ�
	
	public LoginDisplay() {
		setSize(360, 640);
		setTitle("�α��� ȭ��");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/**
		 * '�α����� ���ּ���', �ؽ�Ʈ ��
		 */
		JLabel Txt_login_title = new JLabel("�α����� ���ּ���");
		Txt_login_title.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_login_title.setFont(new Font("���� ���", Font.BOLD, 18));
		Txt_login_title.setBounds(83, 27, 188, 99);
		getContentPane().add(Txt_login_title);
		
		/**
		 * 'ID : ', �ؽ�Ʈ ��
		 */
		JLabel Txt_id = new JLabel("ID : ");
		Txt_id.setFont(new Font("���� ���", Font.PLAIN, 12));
		Txt_id.setBounds(54, 210, 42, 48);
		getContentPane().add(Txt_id);
		
		/**
		 * 'PW : ', �ؽ�Ʈ ��
		 */
		JLabel Txt_pw = new JLabel("PW : ");
		Txt_pw.setFont(new Font("���� ���", Font.PLAIN, 12));
		Txt_pw.setBounds(54, 268, 42, 48);
		getContentPane().add(Txt_pw);
		
		Txt_input_id = new JTextField();
		Txt_input_id.setFont(new Font("���� ���", Font.PLAIN, 12));
		Txt_input_id.setBounds(108, 221, 174, 32);
		getContentPane().add(Txt_input_id);
		Txt_input_id.setColumns(20);
		
		Txt_input_pw = new JPasswordField();
		Txt_input_pw.setColumns(20);
		Txt_input_pw.setFont(new Font("���� ���", Font.PLAIN, 12));
		Txt_input_pw.setBounds(108, 279, 174, 32);
		getContentPane().add(Txt_input_pw);
		
		
		/**
		 * �α��� ��ư 
		 */
		JButton Btn_Login = new JButton("�α���");
		Btn_Login.setFont(new Font("���� ���", Font.PLAIN, 12));
		Btn_Login.setBounds(194, 343, 91, 23);
		getContentPane().add(Btn_Login);
		
		/**
		 * �α��� ��ư Ŭ���� ó��.
		 */
		Btn_Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		/**
		 * ����� ȸ������ ��ư
		 */
		JButton Btn_membership_seller = new JButton("����� ȸ������");
		Btn_membership_seller.setFont(new Font("���� ���", Font.PLAIN, 12));
		Btn_membership_seller.setBounds(181, 450, 132, 32);
		getContentPane().add(Btn_membership_seller);
		
		/**
		 * ����� ȸ������ ��ư
		 */
		JButton Btn_membership_user = new JButton("����� ȸ������");
		Btn_membership_user.setFont(new Font("���� ���", Font.PLAIN, 12));
		Btn_membership_user.setBounds(25, 450, 132, 32);
		getContentPane().add(Btn_membership_user);
		
		
	}
	
}

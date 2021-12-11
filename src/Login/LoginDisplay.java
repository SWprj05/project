package Login;

import javax.swing.*;

import Main.MainDisplay_User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 로그인 화면 구성합니다. 
 * @author Team5
 *
 */

public class LoginDisplay extends JFrame {
	
	/**
	 * id 입력 받는 텍스트 필드
	 */
	private JTextField Txt_input_id;		
	/**
	 * pw 입력 받는 패스워드 필드
	 */
	private JPasswordField Txt_input_pw;	
	
	public LoginDisplay() {
		setSize(360, 640);
		setTitle("로그인 화면");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/**
		 * '로그인을 해주세요', 텍스트 라벨
		 */
		JLabel Txt_login_title = new JLabel("로그인을 해주세요");
		Txt_login_title.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_login_title.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		Txt_login_title.setBounds(83, 27, 188, 99);
		getContentPane().add(Txt_login_title);
		
		/**
		 * 'ID : ', 텍스트 라벨
		 */
		JLabel Txt_id = new JLabel("ID : ");
		Txt_id.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Txt_id.setBounds(54, 210, 42, 48);
		getContentPane().add(Txt_id);
		
		/**
		 * 'PW : ', 텍스트 라벨
		 */
		JLabel Txt_pw = new JLabel("PW : ");
		Txt_pw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Txt_pw.setBounds(54, 268, 42, 48);
		getContentPane().add(Txt_pw);
		
		Txt_input_id = new JTextField();
		Txt_input_id.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Txt_input_id.setBounds(108, 221, 174, 32);
		getContentPane().add(Txt_input_id);
		Txt_input_id.setColumns(20);
		
		Txt_input_pw = new JPasswordField();
		Txt_input_pw.setColumns(20);
		Txt_input_pw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Txt_input_pw.setBounds(108, 279, 174, 32);
		getContentPane().add(Txt_input_pw);
		
		
		/**
		 * 로그인 버튼 
		 */
		JButton Btn_Login = new JButton("로그인");
		Btn_Login.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Btn_Login.setBounds(194, 343, 91, 23);
		getContentPane().add(Btn_Login);
		
		/**
		 * 로그인 버튼 클릭시 로그인 처리.
		 */
		Btn_Login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = Txt_input_id.getText();
				String pw = Txt_input_pw.getText();
				
				LoginProcess obj = new LoginProcess();
				boolean login_success = obj.login_check(id, pw);
				
				/**
				 * 로그인이 성공한 경우 다시 홈화면을 띄운다.
				 * 실패한 경우엔 경고창을 띄운다.
				 */
				if(login_success) {
					setVisible(false);
					System.out.println("로그인 성공!");
					new MainDisplay_User();
				}
				else {
					JOptionPane errorlog = new JOptionPane();
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 정확하게 입력해주세요", "로그인 오류", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		/**
		 * 사업자 회원가입 버튼
		 */
		JButton Btn_membership_seller = new JButton("사업자 회원가입");
		Btn_membership_seller.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Btn_membership_seller.setBounds(181, 450, 132, 32);
		getContentPane().add(Btn_membership_seller);
		
		/**
		 * 사용자 회원가입 버튼
		 */
		JButton Btn_membership_user = new JButton("사용자 회원가입");
		Btn_membership_user.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Btn_membership_user.setBounds(25, 450, 132, 32);
		getContentPane().add(Btn_membership_user);
		
		
	}
	
}

package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import Login.LoginDisplay;
import Search.*;

/**
 * '푸드트럭 여기야!' 사용자 버전 메인화면 입니다.
 * @author Team5
 *
 */
public class MainDisplay_User extends JFrame{
	
	private JTextField Txt_input_search;
	
	public static int login_state = 0;
	
	public MainDisplay_User() {
		setSize(360, 640);
		setTitle("홈화면");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/**
		 * '여기야!' 텍스트 라벨.
		 */
		JLabel Title_label = new JLabel("여기야!");
		Title_label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Title_label.setHorizontalAlignment(SwingConstants.CENTER);
		Title_label.setBounds(120, 15, 100, 40);
		getContentPane().add(Title_label);
		
		/**
		 * 메뉴바 이미지가 추가된 메뉴바 버튼.
		 */
		ImageIcon image_menubar = new ImageIcon("./Image/메뉴바.png");
		JButton Btn_menubar = new JButton(image_menubar);
		Btn_menubar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new LoginDisplay();
			};
		});
		Btn_menubar.setBounds(12, 10, 50, 50);
		getContentPane().add(Btn_menubar);
		
		
		/**
		 * 장바구니 이미지가 추가된 장바구니 버튼.
		 */
		ImageIcon image_cart = new ImageIcon("./Image/장바구니.png");
		JButton Btn_cart = new JButton(image_cart);
		Btn_cart.setBounds(284, 10, 50, 50);
		getContentPane().add(Btn_cart);
		
		/**
		 * 검색 이미지가 추가된 검색 버튼.
		 */
		ImageIcon image_search = new ImageIcon("./Image/검색_홈화면.png");
		JButton Btn_search = new JButton(image_search);
		Btn_search.setBounds(12, 135, 30, 30);
		getContentPane().add(Btn_search);
		/**
		 * 검색 버튼을 클릭할 경우 검색 화면으로 넘어갑니다. 
		 */
		Btn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(login_state == 1) {
					setVisible(false);
					new SearchDisplay();
				}
				else {
					JOptionPane errorlog = new JOptionPane();
					JOptionPane.showMessageDialog(null, "로그인을 먼저 해주세요.", "접근 오류", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		/**
		 * 검색어 입력받는 텍스트 필드.
		 */
		Txt_input_search = new JTextField("검색 버튼을 눌러 검색 화면으로 이동하세요.");
		Txt_input_search.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_input_search.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Txt_input_search.setEnabled(false);
		Txt_input_search.setBounds(42, 135, 290, 30);
		getContentPane().add(Txt_input_search);
		Txt_input_search.setColumns(20);
		
		/**
		 * 주변 푸드트럭을 찾는 버튼.
		 * 패널을 만들어서 패널 안에 버튼과 라벨을 배치함.
		 */
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "푸드트럭", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(12, 201, 320, 100);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		ImageIcon image_foodtruck = new ImageIcon("./Image/푸드트럭.png");
		JButton Btn_foodtruck = new JButton(image_foodtruck);
		Btn_foodtruck.setBounds(20, 25, 60, 60);
		panel1.add(Btn_foodtruck);
		JLabel Txt_foodtruck = new JLabel("내 주변 푸드트럭 찾아보기");
		Txt_foodtruck.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Txt_foodtruck.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_foodtruck.setBounds(100, 35, 200, 40);
		panel1.add(Txt_foodtruck);
		
		/**
		 * 결제내역을 확인하는 버튼.
		 * 패널을 만들어서 패널 안에 버튼과 라벨을 배치함.
		 */
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "결제내역", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel2.setBounds(12, 323, 320, 100);
		getContentPane().add(panel2);
		ImageIcon image_cartlist = new ImageIcon("./Image/결제내역.png");
		JButton Btn_cartlist = new JButton(image_cartlist);
		Btn_cartlist.setBounds(20, 25, 60, 60);
		panel2.add(Btn_cartlist);
		JLabel Txt_cartlist = new JLabel("결제 내역 및 대기표 확인");
		Txt_cartlist.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Txt_cartlist.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_cartlist.setBounds(100, 35, 200, 40);
		panel2.add(Txt_cartlist);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainDisplay_User();
	}
}

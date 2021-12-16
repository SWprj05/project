package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import Login.LoginDisplay;
import Search.*;

/**
 * 'Ǫ��Ʈ�� �����!' ����� ���� ����ȭ�� �Դϴ�.
 * @author Team5
 *
 */
public class MainDisplay_User extends JFrame{
	
	private JTextField Txt_input_search;
	
	public static int login_state = 0;
	
	public MainDisplay_User() {
		setSize(360, 640);
		setTitle("Ȩȭ��");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/**
		 * '�����!' �ؽ�Ʈ ��.
		 */
		JLabel Title_label = new JLabel("�����!");
		Title_label.setFont(new Font("���� ���", Font.BOLD, 20));
		Title_label.setHorizontalAlignment(SwingConstants.CENTER);
		Title_label.setBounds(120, 15, 100, 40);
		getContentPane().add(Title_label);
		
		/**
		 * �޴��� �̹����� �߰��� �޴��� ��ư.
		 */
		ImageIcon image_menubar = new ImageIcon("./Image/�޴���.png");
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
		 * ��ٱ��� �̹����� �߰��� ��ٱ��� ��ư.
		 */
		ImageIcon image_cart = new ImageIcon("./Image/��ٱ���.png");
		JButton Btn_cart = new JButton(image_cart);
		Btn_cart.setBounds(284, 10, 50, 50);
		getContentPane().add(Btn_cart);
		
		/**
		 * �˻� �̹����� �߰��� �˻� ��ư.
		 */
		ImageIcon image_search = new ImageIcon("./Image/�˻�_Ȩȭ��.png");
		JButton Btn_search = new JButton(image_search);
		Btn_search.setBounds(12, 135, 30, 30);
		getContentPane().add(Btn_search);
		/**
		 * �˻� ��ư�� Ŭ���� ��� �˻� ȭ������ �Ѿ�ϴ�. 
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
					JOptionPane.showMessageDialog(null, "�α����� ���� ���ּ���.", "���� ����", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
		/**
		 * �˻��� �Է¹޴� �ؽ�Ʈ �ʵ�.
		 */
		Txt_input_search = new JTextField("�˻� ��ư�� ���� �˻� ȭ������ �̵��ϼ���.");
		Txt_input_search.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_input_search.setFont(new Font("���� ���", Font.PLAIN, 12));
		Txt_input_search.setEnabled(false);
		Txt_input_search.setBounds(42, 135, 290, 30);
		getContentPane().add(Txt_input_search);
		Txt_input_search.setColumns(20);
		
		/**
		 * �ֺ� Ǫ��Ʈ���� ã�� ��ư.
		 * �г��� ���� �г� �ȿ� ��ư�� ���� ��ġ��.
		 */
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ǫ��Ʈ��", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel1.setBounds(12, 201, 320, 100);
		getContentPane().add(panel1);
		panel1.setLayout(null);
		ImageIcon image_foodtruck = new ImageIcon("./Image/Ǫ��Ʈ��.png");
		JButton Btn_foodtruck = new JButton(image_foodtruck);
		Btn_foodtruck.setBounds(20, 25, 60, 60);
		panel1.add(Btn_foodtruck);
		JLabel Txt_foodtruck = new JLabel("�� �ֺ� Ǫ��Ʈ�� ã�ƺ���");
		Txt_foodtruck.setFont(new Font("���� ���", Font.BOLD, 16));
		Txt_foodtruck.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_foodtruck.setBounds(100, 35, 200, 40);
		panel1.add(Txt_foodtruck);
		
		/**
		 * ���������� Ȯ���ϴ� ��ư.
		 * �г��� ���� �г� �ȿ� ��ư�� ���� ��ġ��.
		 */
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "��������", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel2.setBounds(12, 323, 320, 100);
		getContentPane().add(panel2);
		ImageIcon image_cartlist = new ImageIcon("./Image/��������.png");
		JButton Btn_cartlist = new JButton(image_cartlist);
		Btn_cartlist.setBounds(20, 25, 60, 60);
		panel2.add(Btn_cartlist);
		JLabel Txt_cartlist = new JLabel("���� ���� �� ���ǥ Ȯ��");
		Txt_cartlist.setFont(new Font("���� ���", Font.BOLD, 16));
		Txt_cartlist.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_cartlist.setBounds(100, 35, 200, 40);
		panel2.add(Txt_cartlist);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainDisplay_User();
	}
}

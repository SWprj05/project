package Search;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * �˻� ȭ���� ������ Ŭ����
 * @author Team5
 *
 */
public class SearchDisplay extends JFrame {
	
	private JTextField Txt_input_search;	// �˻��� �Է� �޴� �ؽ�Ʈ �ʵ�
	
	public SearchDisplay() {
		setSize(360, 640);
		setTitle("�˻� ȭ��");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		Txt_input_search = new JTextField();
		Txt_input_search.setFont(new Font("���� ���", Font.PLAIN, 12));
		Txt_input_search.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_input_search.setBounds(88, 23, 226, 38);
		getContentPane().add(Txt_input_search);
		Txt_input_search.setColumns(30);
		String txt = Txt_input_search.getText();
		
		/**
		 * �˻� �̹����� �߰��� ��ư
		 */
		ImageIcon image_search = new ImageIcon("./image/�˻�.png");
		JButton Btn_search = new JButton(image_search);
		Btn_search.setBounds(20, 21, 45, 45);
		getContentPane().add(Btn_search);
		
		
	}
	
	
	
}

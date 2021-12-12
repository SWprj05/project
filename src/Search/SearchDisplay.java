package Search;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import DB.*;
import javax.swing.border.LineBorder;

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
		
		/**
		 * �˻� �̹����� �߰��� ��ư
		 */
		ImageIcon image_search = new ImageIcon("./image/�˻�.png");
		JButton Btn_search = new JButton(image_search);
		Btn_search.setBounds(20, 21, 45, 45);
		getContentPane().add(Btn_search);
		
		
		/**
		 * �˻� ��ư Ŭ���� �˻� ó��
		 */
		Btn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String txt = Txt_input_search.getText();
				
				SearchProcess obj = new SearchProcess();
				String temp [];
				
				if(obj.IsEmpty(txt)) {
					temp = obj.search_res(txt);
					
					JPanel panel = new JPanel();
					panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
					panel.setBounds(-23, 102, 400, 100);
					getContentPane().add(panel);
					panel.setLayout(null);
					
					JButton Btn_foodtruck = new JButton(temp[0]);
					Btn_foodtruck.setBounds(45, 10, 301, 80);
					panel.add(Btn_foodtruck);
					
				}
				else {
					JOptionPane errorlog = new JOptionPane();
					JOptionPane.showMessageDialog(null, "�˻��� ����� �����ϴ�.", "�˻� ����", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
	}
}

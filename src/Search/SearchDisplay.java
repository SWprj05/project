package Search;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import DB.*;
import javax.swing.border.LineBorder;
import Menu.*;

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
		 * �˻� ��� ����ִ��� üũ�� �ϰ� ���� ����ִ� ��� ���� �˾�â�� ����.
		 * �˻� ����� ������ ����� �ش��ϴ� ���Թ�ư�� ����.
		 */
		Btn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String txt = Txt_input_search.getText();
				
				SearchProcess obj = new SearchProcess();
				String temp [];
				
				temp = obj.search_res(txt);
				JPanel panel [] = new JPanel[temp.length];
				JButton Btn_foodtruck [] = new JButton[temp.length];
				
				if(temp == null || temp.length == 0) {
					JOptionPane errorlog = new JOptionPane();
					JOptionPane.showMessageDialog(null, "�˻� ����� �����ϴ�.", "���� ����", JOptionPane.ERROR_MESSAGE);
				}
				else {
					for(int i = 0; i < temp.length; i++) {
						panel[i] = new JPanel();
						panel[i].setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
						panel[i].setBounds(-23, 102 + (i*120), 400, 400);
						getContentPane().add(panel[i]);
						
						String temp_txt = temp[i];
						
						Btn_foodtruck[i] = new JButton(temp_txt);
						Btn_foodtruck[i].setBounds(45, 10 + (i*120), 300, 80);
						panel[i].add(Btn_foodtruck[i]);
						panel[i].setLayout(null);
						
						Btn_foodtruck[i].addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								setVisible(false);
								new MenuDisplay(temp_txt);
							}
							
						});
					}
				}
				
				
			}
			
		});
		
	}
}

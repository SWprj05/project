package Search;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import DB.*;
import javax.swing.border.LineBorder;
import Menu.*;

/**
 * 검색 화면을 구성한 클래스
 * @author Team5
 *
 */
public class SearchDisplay extends JFrame {
	
	private JTextField Txt_input_search;	// 검색어 입력 받는 텍스트 필드
	
	public SearchDisplay() {
		setSize(360, 640);
		setTitle("검색 화면");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		Txt_input_search = new JTextField();
		Txt_input_search.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		Txt_input_search.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_input_search.setBounds(88, 23, 226, 38);
		getContentPane().add(Txt_input_search);
		Txt_input_search.setColumns(30);
		
		/**
		 * 검색 이미지가 추가된 버튼
		 */
		ImageIcon image_search = new ImageIcon("./image/검색.png");
		JButton Btn_search = new JButton(image_search);
		Btn_search.setBounds(20, 21, 45, 45);
		getContentPane().add(Btn_search);
		
		
		/**
		 * 검색 버튼 클릭시 검색 처리를 한다.
		 * 검색어가 비어있는지 체크를 하고 만약 비어있는 경우 오류 팝업창을 띄운다.
		 * 검색어가 있는 경우 검색어를 가지고 DB에 조회를한다. 
		 * 검색 결과가 있으면 결과에 해당하는 가게버튼을 띄우고 결과가 없으면 오류 팝업창을 띄운다.
		 */
		Btn_search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String txt = Txt_input_search.getText();
				
				if(txt.length() == 0) {
					JOptionPane errorlog = new JOptionPane();
					JOptionPane.showMessageDialog(null, "검색어가 없습니다..", "검색 오류", JOptionPane.ERROR_MESSAGE);
				}
				else {
					SearchProcess obj = new SearchProcess();
					String temp [];
					
					temp = obj.search_res(txt);

					JButton Btn_foodtruck [] = new JButton[temp.length];
					
					if(temp == null || temp.length == 0) {
						JOptionPane errorlog = new JOptionPane();
						JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "접근 오류", JOptionPane.ERROR_MESSAGE);
					}
					else {
						for(int i = 0; i < temp.length; i++) {
						
							String temp_txt = temp[i];
							
							Btn_foodtruck[i] = new JButton(temp_txt);
							Btn_foodtruck[i].setFont(new Font("맑은 고딕", Font.BOLD, 14));
							Btn_foodtruck[i].setBounds(20, 90 + (i*100), 300, 60);
							getContentPane().add(Btn_foodtruck[i]);
							
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
				
				
				
			}
			
		});
		
	}
}

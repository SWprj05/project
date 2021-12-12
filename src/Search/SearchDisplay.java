package Search;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import DB.*;
import javax.swing.border.LineBorder;

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
		 * 검색 버튼 클릭시 검색 처리
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
					JOptionPane.showMessageDialog(null, "검색한 결과가 없습니다.", "검색 오류", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});
		
	}
}

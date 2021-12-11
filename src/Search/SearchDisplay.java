package Search;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;

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
		String txt = Txt_input_search.getText();
		
		/**
		 * 검색 이미지가 추가된 버튼
		 */
		ImageIcon image_search = new ImageIcon("./image/검색.png");
		JButton Btn_search = new JButton(image_search);
		Btn_search.setBounds(20, 21, 45, 45);
		getContentPane().add(Btn_search);
		
		
	}
	
	
	
}

package Order;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Main.*;
import javax.swing.border.EtchedBorder;

/**
 * 결제하기 버튼을 누루고 결제가 완료되면 창을 띄워주는 클래스입니다.
 * @author HP
 *
 */
public class PayDoneDisplay extends JFrame{
	private final JPanel panel = new JPanel();

	public PayDoneDisplay(String order, int count, int total) {
		setSize(360, 640);
		setTitle("결제완료");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel Txt_orderFin = new JLabel("결제가 완료되었습니다.");
		Txt_orderFin.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_orderFin.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		Txt_orderFin.setBounds(72, 50, 210, 50);
		getContentPane().add(Txt_orderFin);
		
		JButton btn_main = new JButton("홈화면");
		btn_main.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		btn_main.setBounds(125, 464, 90, 40);
		getContentPane().add(btn_main);
		btn_main.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				new MainDisplay_User();
			}
			
		});
		
		JLabel Txt_wait = new JLabel("대기");
		Txt_wait.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_wait.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Txt_wait.setBounds(135, 133, 63, 50);
		getContentPane().add(Txt_wait);
		
		JLabel Txt_wait1 = new JLabel("01");
		Txt_wait1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		Txt_wait1.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_wait1.setBounds(135, 183, 63, 40);
		getContentPane().add(Txt_wait1);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(-20, 245, 405, 97);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel Txt_info = new JLabel("주문 정보");
		Txt_info.setHorizontalAlignment(SwingConstants.CENTER);
		Txt_info.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		Txt_info.setBounds(154, 0, 69, 35);
		panel.add(Txt_info);
		
		String str = order;
		if(count == 1)
			str = order;
		else if(count > 1)
			str = order + " 외 " + String.valueOf(count - 1);
		JLabel Txt_food = new JLabel(str);
		Txt_food.setHorizontalAlignment(SwingConstants.LEFT);
		Txt_food.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Txt_food.setBounds(36, 38, 202, 49);
		panel.add(Txt_food);
		
		JLabel Txt_price = new JLabel(total + "원");
		Txt_price.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		Txt_price.setHorizontalAlignment(SwingConstants.RIGHT);
		Txt_price.setBounds(257, 41, 103, 42);
		panel.add(Txt_price);
		
		
	}
}

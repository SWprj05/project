package Order;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import Menu.*;
/**
 * 장바구니 페이지에서나, 푸드트럭 가게의 메뉴판에서 주문하기 버튼을 눌렀을 때 전환되는 화면으로,
 * 결제하기 버튼을 누르면 외부결제 시스템과 연결되어 결제를 진행한다.
 * @author Team5
 *
 */

public class OrderDisplay extends JFrame {
	
	JLabel txt_title,txt_paymethod, txt_paymethod_card, txt_orderInfo,
	txt_order_money, tet_order_food, txt_money,txt_food, txt_ordersum,
	txt_ordersum_money;
	
	JButton btn_pay;
	
	String [] select_name = new String[20];
	String [] select_price = new String[20];
	
	int total;
	
	MenuDisplay md;
	private JPanel panel_3;
	
	public OrderDisplay(String [] name, String [] price, int count) {	
		//선택된 메뉴이름 배열 초기화
		for(int i = 0 ; i<count ; i++)
		{
			select_name[i] = name[i];
			System.out.println(i+"번째 : "+ select_name[i]);
		}
		
		//선택된 메뉴가격 배열 초기화
		for(int i = 0 ; i<count ; i++)
		{
			select_price[i] = price[i];
			total += Integer.parseInt(price[i]);
			System.out.println(i+"번째 : "+ select_price[i]);
		}
		
		
		setTitle("주문 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		getContentPane().setLayout(null);
	
		//결제하기 버튼
		btn_pay = new JButton("결제하기");
		btn_pay.addActionListener(new MyAction());
		btn_pay.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 14));
		btn_pay.setBounds(129, 537, 97, 30);
		getContentPane().add(btn_pay);
		
		//title 구분
		JPanel panel = new JPanel();  
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 344, 36);
		c.add(panel);
		txt_title = new JLabel("주문하기");
		panel.add(txt_title);
		txt_title.setHorizontalAlignment(SwingConstants.CENTER);
		txt_title.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 18));
		
		// 선으로 만들어 내용 구분
		JPanel panel_1 = new JPanel(); 
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(0, 156, 344, 1);
		c.add(panel_1);
		
		
		txt_paymethod = new JLabel("결제수단");
		txt_paymethod.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 17));
		txt_paymethod.setBounds(51, 77, 71, 15);
		c.add(txt_paymethod);
		
		
		JPanel panel_2 = new JPanel(); // 직사각형으로 만들어 내용 구분
		panel_2.setBackground(SystemColor.text);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(51, 102, 223, 23);
		c.add(panel_2);
		
		
		txt_paymethod_card = new JLabel(" 체크/신용카드");
		txt_paymethod_card.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
		
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);  //직사각형Panel과 카드Label 그룹화
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(txt_paymethod_card, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(115, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(txt_paymethod_card, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
		);
		panel_2.setLayout(gl_panel_2);
		
		
		txt_orderInfo = new JLabel("주문정보");
		txt_orderInfo.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 17));
		txt_orderInfo.setBounds(51, 192, 60, 15);
		c.add(txt_orderInfo);
		
		
		txt_order_money = new JLabel("주문 금액");
		txt_order_money.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
		txt_order_money.setBounds(70, 260, 52, 21);
		c.add(txt_order_money);
		
		tet_order_food = new JLabel("주문 메뉴");
		tet_order_food.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
		tet_order_food.setBounds(70, 229, 52, 21);
		c.add(tet_order_food);
		
		
		//메뉴이름 넘겨받아와야 함
		if(count > 1)
		{
			int i = count-1;
			txt_food = new JLabel(select_name[0]+" 외 "+String.valueOf(i));
			txt_food.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
			txt_food.setBounds(148, 229, 126, 25);
			c.add(txt_food);
		}
		else
		{
			txt_food = new JLabel(select_name[0]);
			txt_food.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
			txt_food.setBounds(148, 229, 126, 25);
			c.add(txt_food);
		}
		
		
		
		//메뉴 가격 넘겨받아와야 함
		txt_money = new JLabel(String.valueOf(total)+"원"); 
		txt_money.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));	
		txt_money.setBounds(148, 258, 126, 25);	
		c.add(txt_money);
		
		
		txt_ordersum = new JLabel("총 결제금액");
		txt_ordersum.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 17));
		txt_ordersum.setBounds(51, 378, 87, 15);
		c.add(txt_ordersum);

		//주문 금액 총 합계 
		txt_ordersum_money = new JLabel(String.valueOf(total)+"원"); 
		txt_ordersum_money.setFont(new Font("AppleSDGothicNeoB00", Font.PLAIN, 17));
		txt_ordersum_money.setBounds(203, 373, 105, 25);
		getContentPane().add(txt_ordersum_money);
		
		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.menu);
		panel_3.setBounds(0, 331, 344, 1);
		getContentPane().add(panel_3);
		

		setSize(360,640);
		setVisible(true);
	}
}


/**
 * 결제하기 버튼 클릭했을 때 이벤트 처리하는 메소드로, 외부 결제 시스템을 연결하여 결제를 진행한다.
 * @author Team5
 *
 */

class MyAction implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JButton b = (JButton)e.getSource();  // 이벤트 발생한 객체 리턴하여 얻기
		
		//외부 결제 시스템 연결 메소드 호출
	}
	
}



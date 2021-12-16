package Menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import DB.*;
import Order.*;

/**
 * 검색 결과 화면에서 푸드트럭 가게를 하나 클릭하면 해당 푸드트럭의 메뉴판 화면으로 전환이 되어, FoodtruckDB에 등록된
 * 메뉴들을 보여준다. 이후 주문할 메뉴들을 체크박스를 통해 체크하고, 체크된 메뉴들을 장바구니 버튼을 눌러 자신의 장바구니에
 * 메뉴를 담거나, 주문하기 버튼을 눌러 결제를 진행할수 있도록 주문하는 페이지로 전환된다.
 * @author Team5
 *
 */

public class MenuDisplay extends JFrame {
	
	JLabel txt_name ;
	JLabel totalLabel;
	JButton btn_cart, btn_order;
	
	JCheckBox [] cb = new JCheckBox[50]; //체크박스 
	JLabel [] txt_food= new JLabel[50]; //메뉴명
	JLabel [] txt_price = new JLabel[50]; //메뉴가격
	JPanel [] Line = new JPanel[50]; //구분선
	
	FoodtruckDB fd; //푸드트럭DB 객체
	
	String [] name = new String[50];
	String [] price = new String[50];	
	
	String [] select_name = new String[20];  //체크박스 선택된 메뉴를 저장하는 배열
	String [] select_price = new String[20]; // 체크박스 선택된 가격을 저장하는 배열
	
 	int menuCnt; //푸드트럭 가게의 메뉴 개수
	int total; 
	int count, count2;
	
	/**
	 * 생성자 함수
	 * 메뉴판 화면을 띄워줌
	 * 푸드트럭DB객체를 이용하여 해당 가게의 메뉴 개수만큼 
	 * 체크박스, 메뉴이름, 메뉴 가격을 보여줌 
	 */
	public MenuDisplay(String shop_name) {	
		fd = new FoodtruckDB();
		
		setTitle("메뉴판 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//페이지 title 받아와야 함 
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 344, 36);
		add(panel);
		txt_name = new JLabel(shop_name); // 검색 결과 화면에서 클릭한 푸드트럭 가게 이름 가져오기 
		panel.add(txt_name);
		txt_name.setHorizontalAlignment(SwingConstants.CENTER);
		txt_name.setFont(new Font("맑은 고딕", Font.BOLD, 18));
				
		//푸드트럭 가게에서 등록한 메뉴 이름 get
		name = fd.get_menu_name(shop_name);
		
		//푸드트럭 가게에서 등록한 메뉴 가격 get
		price = fd.get_menu_price(shop_name);
		
		//푸드트럭 가게에 등록된 메뉴 수 리턴 
		menuCnt = fd.get_shopCnt(shop_name);

		//가격 total값 초기화
		total = 0;
		
		count = 0;
		
		//위에서 푸드트럭DB의 메소드로 초기화한 값을 반복문으로 화면에 display
		MyItemListener listener = new MyItemListener();
		for(int i = 0; i < menuCnt ; i++) 
		{
			cb[i] = new JCheckBox("");
			cb[i].setBackground(Color.WHITE);
			cb[i].setBounds(40, 80+(i*120), 20, 20);
			add(cb[i]);
			cb[i].addItemListener(listener);
			
			txt_food[i] = new JLabel(name[i]);
			txt_food[i].setFont(new Font("맑은 고딕", Font.PLAIN, 18));
			txt_food[i].setBounds(166, 62+(i*120), 166, 25);
			add(txt_food[i]);
			
			txt_price[i] = new JLabel(price[i]+"원");
			txt_price[i].setFont(new Font("맑은 고딕", Font.PLAIN, 18));
			txt_price[i].setBounds(166, 97+(i*120), 166, 25);
			add(txt_price[i]);
			
			Line[i] = new JPanel();
			Line[i].setBackground(SystemColor.menu);
			Line[i].setBounds(0, 152+(i*120), 344, 3);
			add(Line[i]);
			
		}
		
		//totalLabel = new JLabel("total : " + total);
		//totalLabel.setSize(90,120);
		//totalLabel.setLocation(5,5);
		//c.add(totalLabel);
	
		//담기 버튼 
		JButton btn_cart = new JButton("장바구니");
		btn_cart.addActionListener(new CartAction());
		btn_cart.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btn_cart.setBounds(57, 537, 97, 30);
		getContentPane().add(btn_cart);
		
		
		//주문하기 버튼 
		JButton btn_order = new JButton("주문하기");
		btn_order.addActionListener(new OrderAction());
		btn_order.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		btn_order.setBounds(188, 537, 97, 30);
		getContentPane().add(btn_order);
		

		setSize(360,640);
		setVisible(true);
	}
	
	
	/**
	 * 장바구니 버튼 눌렀을 때 이벤트 처리하는 메소드로, 자신의 장바구니에 체크된 메뉴 이름, 가격 등이 저장된다.
	 * (장바구니DB에 삽입)
	 * @author youeng
	 *
	 */
	class CartAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton b = (JButton)e.getSource();  // 이벤트 발생한 객체 리턴하여 얻기
			//해당 사용자의 장바구니 DB에 저장 메소드  
		}
		
	}
	
	
	/**
	 * 주문하기 버튼을 눌렀을 때 이벤트 처리하는 메소드로, 주문화면으로 전환된다. 
	 * @author youeng
	 *
	 */
	class OrderAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton b = (JButton)e.getSource();  // 이벤트 발생한 객체 리턴하여 얻기
			
			
			if(fd.empty(select_name) && fd.empty(select_price)) //메뉴가 선택되지 않은 경우
			{
				JOptionPane error = new JOptionPane();
				JOptionPane.showMessageDialog(null, "선택된 메뉴가 없습니다. 메뉴를 선택해주세요.", "선택 오류", JOptionPane.ERROR_MESSAGE);
			}

			else {
				new OrderDisplay(select_name, select_price, count);
				setVisible(false);
			}
			
		}
		
	}
	
	/**
	 * 체크박스 체크된 것들만 select_name, select_price 배열에 저장 
	 * 체크박스 체크 취소될 경우, 각 배열에서 삭제 
	 * @author youeng
	 *
	 */
	class MyItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e)
		{
			
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				for(int i = 0 ; i<menuCnt ; i++)
				{
					if(e.getItem() == cb[i])
					{
						//total += Integer.parseInt(price[i]);
						select_name[count] = name[i];
						select_price[count] = price [i];
						System.out.println(count+"번째 : "+ select_name[count]);
						count++;
					}
					
				}
			}
			else
			{
				for(int i = 0 ; i<menuCnt ; i++)
				{
					if(e.getItem() == cb[i])
					{
						//total -= Integer.parseInt(price[i]);
						for(int j=0 ; j<count ; j++)
						{
							if(select_name[j].equals(name[i]) && select_price[j].equals(price[i]))
							{
								System.out.println(select_name[j]);
								for(int k = j ; k<count; k++ )
								{
									select_name[k]=select_name[k+1];
									select_price[k]=select_price[k+1];
									count--;
								}
							}
							
						}
					}
				}

			}
			//totalLabel.setText("total : " + total);
		}
	}
	
}


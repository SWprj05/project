package Menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import DB.*;
import Order.*;

/**
 * �˻� ��� ȭ�鿡�� Ǫ��Ʈ�� ���Ը� �ϳ� Ŭ���ϸ� �ش� Ǫ��Ʈ���� �޴��� ȭ������ ��ȯ�� �Ǿ�, FoodtruckDB�� ��ϵ�
 * �޴����� �����ش�. ���� �ֹ��� �޴����� üũ�ڽ��� ���� üũ�ϰ�, üũ�� �޴����� ��ٱ��� ��ư�� ���� �ڽ��� ��ٱ��Ͽ�
 * �޴��� ��ų�, �ֹ��ϱ� ��ư�� ���� ������ �����Ҽ� �ֵ��� �ֹ��ϴ� �������� ��ȯ�ȴ�.
 * @author Team5
 *
 */

public class MenuDisplay extends JFrame {
	
	JLabel txt_name ;
	JLabel totalLabel;
	JButton btn_cart, btn_order;
	
	JCheckBox [] cb = new JCheckBox[50]; //üũ�ڽ� 
	JLabel [] txt_food= new JLabel[50]; //�޴���
	JLabel [] txt_price = new JLabel[50]; //�޴�����
	JPanel [] Line = new JPanel[50]; //���м�
	
	FoodtruckDB fd; //Ǫ��Ʈ��DB ��ü
	
	String [] name = new String[50];
	String [] price = new String[50];	
	
	String [] select_name = new String[20];  //üũ�ڽ� ���õ� �޴��� �����ϴ� �迭
	String [] select_price = new String[20]; // üũ�ڽ� ���õ� ������ �����ϴ� �迭
	
 	int menuCnt; //Ǫ��Ʈ�� ������ �޴� ����
	int total; 
	int count, count2;
	
	/**
	 * ������ �Լ�
	 * �޴��� ȭ���� �����
	 * Ǫ��Ʈ��DB��ü�� �̿��Ͽ� �ش� ������ �޴� ������ŭ 
	 * üũ�ڽ�, �޴��̸�, �޴� ������ ������ 
	 */
	public MenuDisplay(String shop_name) {	
		fd = new FoodtruckDB();
		
		setTitle("�޴��� ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//������ title �޾ƿ;� �� 
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 344, 36);
		add(panel);
		txt_name = new JLabel(shop_name); // �˻� ��� ȭ�鿡�� Ŭ���� Ǫ��Ʈ�� ���� �̸� �������� 
		panel.add(txt_name);
		txt_name.setHorizontalAlignment(SwingConstants.CENTER);
		txt_name.setFont(new Font("���� ���", Font.BOLD, 18));
				
		//Ǫ��Ʈ�� ���Կ��� ����� �޴� �̸� get
		name = fd.get_menu_name(shop_name);
		
		//Ǫ��Ʈ�� ���Կ��� ����� �޴� ���� get
		price = fd.get_menu_price(shop_name);
		
		//Ǫ��Ʈ�� ���Կ� ��ϵ� �޴� �� ���� 
		menuCnt = fd.get_shopCnt(shop_name);

		//���� total�� �ʱ�ȭ
		total = 0;
		
		count = 0;
		
		//������ Ǫ��Ʈ��DB�� �޼ҵ�� �ʱ�ȭ�� ���� �ݺ������� ȭ�鿡 display
		MyItemListener listener = new MyItemListener();
		for(int i = 0; i < menuCnt ; i++) 
		{
			cb[i] = new JCheckBox("");
			cb[i].setBackground(Color.WHITE);
			cb[i].setBounds(40, 80+(i*120), 20, 20);
			add(cb[i]);
			cb[i].addItemListener(listener);
			
			txt_food[i] = new JLabel(name[i]);
			txt_food[i].setFont(new Font("���� ���", Font.PLAIN, 18));
			txt_food[i].setBounds(166, 62+(i*120), 166, 25);
			add(txt_food[i]);
			
			txt_price[i] = new JLabel(price[i]+"��");
			txt_price[i].setFont(new Font("���� ���", Font.PLAIN, 18));
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
	
		//��� ��ư 
		JButton btn_cart = new JButton("��ٱ���");
		btn_cart.addActionListener(new CartAction());
		btn_cart.setFont(new Font("���� ���", Font.PLAIN, 14));
		btn_cart.setBounds(57, 537, 97, 30);
		getContentPane().add(btn_cart);
		
		
		//�ֹ��ϱ� ��ư 
		JButton btn_order = new JButton("�ֹ��ϱ�");
		btn_order.addActionListener(new OrderAction());
		btn_order.setFont(new Font("���� ���", Font.PLAIN, 14));
		btn_order.setBounds(188, 537, 97, 30);
		getContentPane().add(btn_order);
		

		setSize(360,640);
		setVisible(true);
	}
	
	
	/**
	 * ��ٱ��� ��ư ������ �� �̺�Ʈ ó���ϴ� �޼ҵ��, �ڽ��� ��ٱ��Ͽ� üũ�� �޴� �̸�, ���� ���� ����ȴ�.
	 * (��ٱ���DB�� ����)
	 * @author youeng
	 *
	 */
	class CartAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton b = (JButton)e.getSource();  // �̺�Ʈ �߻��� ��ü �����Ͽ� ���
			//�ش� ������� ��ٱ��� DB�� ���� �޼ҵ�  
		}
		
	}
	
	
	/**
	 * �ֹ��ϱ� ��ư�� ������ �� �̺�Ʈ ó���ϴ� �޼ҵ��, �ֹ�ȭ������ ��ȯ�ȴ�. 
	 * @author youeng
	 *
	 */
	class OrderAction implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton b = (JButton)e.getSource();  // �̺�Ʈ �߻��� ��ü �����Ͽ� ���
			
			
			if(fd.empty(select_name) && fd.empty(select_price)) //�޴��� ���õ��� ���� ���
			{
				JOptionPane error = new JOptionPane();
				JOptionPane.showMessageDialog(null, "���õ� �޴��� �����ϴ�. �޴��� �������ּ���.", "���� ����", JOptionPane.ERROR_MESSAGE);
			}

			else {
				new OrderDisplay(select_name, select_price, count);
				setVisible(false);
			}
			
		}
		
	}
	
	/**
	 * üũ�ڽ� üũ�� �͵鸸 select_name, select_price �迭�� ���� 
	 * üũ�ڽ� üũ ��ҵ� ���, �� �迭���� ���� 
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
						System.out.println(count+"��° : "+ select_name[count]);
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


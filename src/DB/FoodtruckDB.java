package DB;

import java.sql.*;
import java.util.*;


/**
* Ǫ��Ʈ�� ���� �̸�, �޴��̸�, �޴� ���ݵ��� ��� ���� �����ͺ��̽� �����Ͽ�
* ���� ������ �޼ҵ���� ��� �ִ�.
* @author Team5
*/

public class FoodtruckDB {
	DBConnection db;
	String shop_name;
	
	/**
	 * �⺻ ������ 
	 */
	public FoodtruckDB(){
		db = new DBConnection();
		db.db_connect();
	}
	
	/**
	 * Ǫ��Ʈ�� �����̸��� �Ѱ� �ְ�, �����̸��� �迭�� �޾ƿ��� �޼ҵ��̴�.
	 * @param shop_name �˻��� ���� �̸�
	 * @return �˻��� �����̸� ��� �迭
	 */
	public String[] get_shop_name(String shop_name) {
		String name [] = new String[50];
		name[0] = "1";
		Statement stmt;
		stmt = db.db_connect();
		
		int i = 0;
		try {
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where shopname='"+shop_name+"'");
			while(rs.next()) {//������������ 
				name[i] = rs.getString("shopname");
				//System.out.println(i+"��° "+name[i]);
				i++;
			}
		}
		catch( SQLException e) {
			System.out.println( "�ش� ���� �޴��� �����ϴ�." + e);
		}
		
		return name;
	}
	
	/**
	 * Ǫ��Ʈ�� �����̸��� �Ѱ� �ְ�, �޴��̸��� �迭�� �޾ƿ��� �޼ҵ��̴�.
	 * @param shop_name �˻��� �����̸�
	 * @return �޴��̸��� ���� �迭
	 */
	public String[] get_menu_name(String shop_name) {
		String [] name = new String[50];
		Statement stmt;
		stmt = db.db_connect(); //�����ͺ��̽� �����ϱ�
				
		int i = 0;
		try {
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where shopname='"+shop_name+"'");
			while(rs.next()) {//������������ 
				name[i] = rs.getString("menuname");
				//System.out.println(i+"��° "+name[i]);
				i++;
			}
		}
		catch( SQLException e) {
			System.out.println( "�ش� ���� �޴��� �����ϴ�." + e);
		}
		return name;
	}
	
	
	/**
	 * Ǫ��Ʈ�� �����̸��� �Ѱ� �ְ�, �޴������� �迭�� �޾ƿ��� �޼ҵ��̴�.
	 * @param shop_name �˻��� �����̸�
	 * @return �޴������� ���� �迭
	 */
	public String[] get_menu_price(String shop_name) {
		String [] price = new String[50];
		Statement stmt;
		stmt = db.db_connect(); //�����ͺ��̽� �����ϱ�
		int price1;
		int i = 0;
		try {
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where shopname='"+shop_name+"'");
			while(rs.next()) {//������������ 
				price1 = rs.getInt("menuprice");
				price[i] = String.valueOf(price1);
				//System.out.println(i+"��° "+price[i]);
				i++;
			}
		}
		catch( SQLException e) {
			System.out.println( "�ش� ���� �޴��� �����ϴ�." + e);
		}
		return price;
	}
	
	
	/**
	 * Ǫ��Ʈ�� �����̸��� �Ѱ� �ְ�, ���Ե� �޴� ������(row) �޾ƿ��� �޼ҵ��̴�.
	 * @param shop_name �˻��� �����̸�
	 * @return row �޴� ����
	 */
	public int get_shopCnt(String shop_name) {
		// DB�� �����ؼ�, �ش� ������ �޴� ������ŭ üũ�ڽ� ����� 
		int row = 0;
		Statement stmt;
		stmt = db.db_connect(); //�����ͺ��̽� �����ϱ�
		try {
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where shopname='"+shop_name+"'");
			rs.last();
			row = rs.getRow();
			//System.out.println("row : "+ row);
		}
		catch( SQLException e) {
			System.out.println( "�ش� ���� �޴��� �����ϴ�." + e);
		}
		
		return row;
	}
	
	
	
	/**
	 * �迭�� �ߺ� ���Ҹ� ���� �� null�� �����ϴ� �޼ҵ�
	 * @param arr ������ array
	 * @return new_arr ������ array
	 */
	public String[] dup_del(String arr[]) {
		
		ArrayList<String> arrayList = new ArrayList<>();

        for(String i : arr){
            if(!arrayList.contains(i) && i != null)
                arrayList.add(i);
        }
        
        String [] new_arr = new String[arrayList.size()];
        
        for(int i = 0 ; i<arrayList.size() ; i++)
        {
        	new_arr[i] = arrayList.get(i);
        }

		
		return new_arr;	
	}
	
	/**
	 * �迭�� ���Ұ� null ���� Ȯ���ϴ� �޼ҵ�
	 */
	public boolean empty(String [] arr)
	{
		if(arr[0]==null)
			return true;
		return false;
	}
	
	
	
	/**
	 * �˻� ��� row ���� ��ȯ�ϴ� �޼ҵ� 
	 * @param txt (�˻���)
	 * @return row 
	 */
	public int get_search_cnt(String txt) {
		// DB�� �����ؼ�, �ش� ������ �޴� ������ŭ üũ�ڽ� ����� 
		int row=0;
		Statement stmt;
		stmt = db.db_connect(); //�����ͺ��̽� �����ϱ�
		try {
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where (menuname||shopname) like '%" + txt + "%'");
			rs.last();
			row = rs.getRow();
		}
		catch( SQLException e) {
			System.out.println( "�ش� ���� �޴��� �����ϴ�." + e);
		}
		
		return row;
	}
	
	
	/**
	 * DB�� ���� �� �˻� ����� �ش��ϴ� Ǫ��Ʈ�� ���� �̸��� �迭�� �޾� ��ȯ�ϴ� �޼ҵ�
	 * @param txt
	 * @return �˻� ����� ���� �迭 
	 */
	public String[] get_search_res(String txt) {
		String [] shop = new String[get_search_cnt(txt)]; //�˻� ��� �ุŭ �迭 ���� 
		
		Statement stmt;
		stmt = db.db_connect(); //�����ͺ��̽� �����ϱ�
		
		int i=0;
		try {
			
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where (menuname||shopname) like '%" + txt + "%'"); //������
			while(rs.next())
			{
				shop[i] = rs.getString("shopname"); //�˻� ����� �ش��ϴ� ���� �����̸��� �迭�� ����
				i++;
				
			}
		}
		catch( SQLException e) {
			System.out.println( "�ش� ���� �޴��� �����ϴ�." + e);
		}
		
		shop = dup_del(shop); //�迭 �ߺ� ���� ���� 
		return shop;	
	}
	
	
	
	
	//�˻� ����� �迭�� �����ϴ� �޼ҵ� "get_search_res" ���ø� �־�����ϴ�
	// Ȯ�� �� ���� �Լ��� �����ص� �˴ϴ� !
	
	public static void main(String args[]) {
		FoodtruckDB fd = new FoodtruckDB();
		String txt = "�ֵ���";
		String [] shop = new String[fd.get_search_cnt(txt)];
		shop = fd.get_search_res(txt);
		
		for(int i = 0 ; i<shop.length; i++) {
			System.out.println("�˻���� "+(i+1)+": "+shop[i]);
		}
			
	}
	
}


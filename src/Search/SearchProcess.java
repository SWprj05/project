package Search;

import DB.*;

/**
 * FoodtruckDB�� �����Ͽ� �˻� ����� ó���ϴ� Ŭ�����Դϴ�.
 * @author Team5
 *
 */

public class SearchProcess {
	FoodtruckDB obj = new FoodtruckDB();
	
	/**
	 * �˻� ����� ����ֳ� üũ�ϴ� �޼ҵ��Դϴ�.
	 * @param txt �˻��� �����̸�
	 * @return true||false
	 */
	public boolean IsEmpty(String txt) {
		String temp [] = obj.get_shop_name(txt);
	
		if(!temp[0].equals("1")) {
			return true;
		}
		else if(temp[0].equals("1")){
			return false;
		}
		else {
			return false;
		}
	}
	
	/**
	 * �˻���� �˻��� ���� �̸��� �������ִ� �޼ҵ��Դϴ�. 
	 * @param txt �˻��� �����̸�
	 * @return �˻���� �迭
	 */
	public String[] search_res(String txt) {
		String arr [] = obj.get_shop_name(txt);
		
		return arr;
	}
	
}

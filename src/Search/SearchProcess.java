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
	 * �˻���� �˻��� ���� �̸��� �������ִ� �޼ҵ��Դϴ�. 
	 * @param txt �˻��� �����̸�
	 * @return �˻���� �迭
	 */
	public String[] search_res(String txt) {
		String arr[] = obj.get_search_res(txt);
		
		return arr;
	}
	
}

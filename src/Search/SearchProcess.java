package Search;

import DB.*;

/**
 * FoodtruckDB에 연결하여 검색 결과를 처리하는 클래스입니다.
 * @author Team5
 *
 */

public class SearchProcess {
	FoodtruckDB obj = new FoodtruckDB();
	
	/**
	 * 검색어로 검색해 가게 이름을 리턴해주는 메소드입니다. 
	 * @param txt 검색할 가게이름
	 * @return 검색결과 배열
	 */
	public String[] search_res(String txt) {
		String arr[] = obj.get_search_res(txt);
		
		return arr;
	}
	
}

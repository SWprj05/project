package DB;

import java.sql.*;
import java.util.*;


/**
* 푸드트럭 가게 이름, 메뉴이름, 메뉴 가격등을 얻기 위해 데이터베이스 연결하여
* 값을 얻어오는 메소드들을 담고 있다.
* @author Team5
*/

public class FoodtruckDB {
	DBConnection db;
	String shop_name;
	
	/**
	 * 기본 생성자 
	 */
	public FoodtruckDB(){
		db = new DBConnection();
		db.db_connect();
	}
	
	/**
	 * 푸드트럭 가게이름을 넘겨 주고, 가게이름을 배열로 받아오는 메소드이다.
	 * @param shop_name 검색할 가게 이름
	 * @return 검색된 가게이름 결과 배열
	 */
	public String[] get_shop_name(String shop_name) {
		String name [] = new String[50];
		name[0] = "1";
		Statement stmt;
		stmt = db.db_connect();
		
		int i = 0;
		try {
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where shopname='"+shop_name+"'");
			while(rs.next()) {//쿼리문결과출력 
				name[i] = rs.getString("shopname");
				//System.out.println(i+"번째 "+name[i]);
				i++;
			}
		}
		catch( SQLException e) {
			System.out.println( "해당 가게 메뉴가 없습니다." + e);
		}
		
		return name;
	}
	
	/**
	 * 푸드트럭 가게이름을 넘겨 주고, 메뉴이름을 배열로 받아오는 메소드이다.
	 * @param shop_name 검색할 가게이름
	 * @return 메뉴이름을 담은 배열
	 */
	public String[] get_menu_name(String shop_name) {
		String [] name = new String[50];
		Statement stmt;
		stmt = db.db_connect(); //데이터베이스 연결하기
				
		int i = 0;
		try {
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where shopname='"+shop_name+"'");
			while(rs.next()) {//쿼리문결과출력 
				name[i] = rs.getString("menuname");
				//System.out.println(i+"번째 "+name[i]);
				i++;
			}
		}
		catch( SQLException e) {
			System.out.println( "해당 가게 메뉴가 없습니다." + e);
		}
		return name;
	}
	
	
	/**
	 * 푸드트럭 가게이름을 넘겨 주고, 메뉴가격을 배열로 받아오는 메소드이다.
	 * @param shop_name 검색할 가게이름
	 * @return 메뉴가격을 담은 배열
	 */
	public String[] get_menu_price(String shop_name) {
		String [] price = new String[50];
		Statement stmt;
		stmt = db.db_connect(); //데이터베이스 연결하기
		int price1;
		int i = 0;
		try {
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where shopname='"+shop_name+"'");
			while(rs.next()) {//쿼리문결과출력 
				price1 = rs.getInt("menuprice");
				price[i] = String.valueOf(price1);
				//System.out.println(i+"번째 "+price[i]);
				i++;
			}
		}
		catch( SQLException e) {
			System.out.println( "해당 가게 메뉴가 없습니다." + e);
		}
		return price;
	}
	
	
	/**
	 * 푸드트럭 가게이름을 넘겨 주고, 삽입된 메뉴 개수를(row) 받아오는 메소드이다.
	 * @param shop_name 검색할 가게이름
	 * @return row 메뉴 개수
	 */
	public int get_shopCnt(String shop_name) {
		// DB에 연결해서, 해당 가게의 메뉴 개수만큼 체크박스 만들기 
		int row = 0;
		Statement stmt;
		stmt = db.db_connect(); //데이터베이스 연결하기
		try {
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where shopname='"+shop_name+"'");
			rs.last();
			row = rs.getRow();
			//System.out.println("row : "+ row);
		}
		catch( SQLException e) {
			System.out.println( "해당 가게 메뉴가 없습니다." + e);
		}
		
		return row;
	}
	
	
	
	/**
	 * 배열의 중복 원소를 제거 및 null값 제거하는 메소드
	 * @param arr 정리할 array
	 * @return new_arr 정리된 array
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
	 * 배열의 원소가 null 인지 확인하는 메소드
	 */
	public boolean empty(String [] arr)
	{
		if(arr[0]==null)
			return true;
		return false;
	}
	
	
	
	/**
	 * 검색 결과 row 개수 반환하는 메소드 
	 * @param txt (검색어)
	 * @return row 
	 */
	public int get_search_cnt(String txt) {
		// DB에 연결해서, 해당 가게의 메뉴 개수만큼 체크박스 만들기 
		int row=0;
		Statement stmt;
		stmt = db.db_connect(); //데이터베이스 연결하기
		try {
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where (menuname||shopname) like '%" + txt + "%'");
			rs.last();
			row = rs.getRow();
		}
		catch( SQLException e) {
			System.out.println( "해당 가게 메뉴가 없습니다." + e);
		}
		
		return row;
	}
	
	
	/**
	 * DB에 연결 후 검색 결과에 해당하는 푸드트럭 가게 이름을 배열에 받아 반환하는 메소드
	 * @param txt
	 * @return 검색 결과를 담은 배열 
	 */
	public String[] get_search_res(String txt) {
		String [] shop = new String[get_search_cnt(txt)]; //검색 결과 행만큼 배열 생성 
		
		Statement stmt;
		stmt = db.db_connect(); //데이터베이스 연결하기
		
		int i=0;
		try {
			
			ResultSet rs = stmt.executeQuery("select * from foodtrucktb where (menuname||shopname) like '%" + txt + "%'"); //쿼리문
			while(rs.next())
			{
				shop[i] = rs.getString("shopname"); //검색 결과에 해당하는 값의 가게이름만 배열에 저장
				i++;
				
			}
		}
		catch( SQLException e) {
			System.out.println( "해당 가게 메뉴가 없습니다." + e);
		}
		
		shop = dup_del(shop); //배열 중복 원소 제거 
		return shop;	
	}
	
	
	
	
	//검색 결과를 배열에 저장하는 메소드 "get_search_res" 예시를 넣어놨습니다
	// 확인 후 메인 함수는 삭제해도 됩니다 !
	
	public static void main(String args[]) {
		FoodtruckDB fd = new FoodtruckDB();
		String txt = "핫도그";
		String [] shop = new String[fd.get_search_cnt(txt)];
		shop = fd.get_search_res(txt);
		
		for(int i = 0 ; i<shop.length; i++) {
			System.out.println("검색결과 "+(i+1)+": "+shop[i]);
		}
			
	}
	
}


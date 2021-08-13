package company.view;

import java.util.ArrayList;

public class EndView {
	
	//모든 정보  출력 
	public static void AllListView(ArrayList allcompany){ 
		if(allcompany != null) {
			int length = allcompany.size();
			
			if( length != 0 ){
				for(int index = 0; index < length; index++){			
					System.out.println("검색정보 " + (index+1) + " - " + allcompany.get(index));
				}
			}else {
				System.out.println("요청하신 정보는 없습니다");
			}
		}else {
			System.out.println("요청하신 정보는 없습니다.");
		}
	}
	
	
	//특정정보 출력 
	public static void oneView(Object info){
		System.out.println(info);		
	}

	
	//예외 상황 출력
	public static void showError(String message){
		System.out.println(message);		
	}

	public static void messageView(String message) {
		System.out.println(message);
	}
}
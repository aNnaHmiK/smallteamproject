package company.view;

import company.controller.Controller;
import company.model.dto.MemberDTO;

public class StartView {
	
	public static void main(String [] args){
		System.out.println("***** 모든 회사정보 검색 *****");	
		Controller.getAllCompanyData();

		// 자기 정보 입력
		System.out.println("***** 키보드로 정보 입력 *****");
		System.out.println("이 양식에 따라서 작성해 주세요");
		System.out.println("아이디/이름/생년월일/전공학과");
		MemberDTO newMember = Controller.insertMember();
		Controller.addMember(newMember);
	
		//내가 지원한 회사 정보 출력
		
		
	}
	
	
	
}
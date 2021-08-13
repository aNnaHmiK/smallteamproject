package company.view;

import java.util.Scanner;

import company.controller.CompanyController;

public class StartView {
	private static int number = 0;
	public Scanner scan = new Scanner(System.in);

	private static StartView instance = new StartView();
	private static CompanyController controller = CompanyController.getInstance();
	
	static {
		System.out.println("\n===================\n당신을 응원합니다."
				+ "\n1.회원가입 \n2.회원정보 수정\n3.나의 회원정보 검색\n4.지원하기\n5.지원정보 수정"
				+ "\n6.나의 지원정보 검색\n7.채용정보 전체검색\n8.직무정보 전체검색\n0.종료하기\n===================");	

		number = instance.scan.nextInt();
	}
	
	private StartView() {}

	public static StartView getInstance() {
		return instance;
	}

	
	public static void main(String [] args){
		
		// 1.회원가입 
		if (StartView.number == 1) {
			controller.memberSignUpInput();
		}
		
		// 2.회원정보 수정 
		if (StartView.number == 2) {
			controller.memberUpdate();
		}
		
		// 3.나의 회원정보 검색
		if (StartView.number == 3) {
			controller.myMemberInfo();
		}
		
		// 4.지원하기
		if (StartView.number == 4) {
			controller.applyInput();
		}
		
		// 5.지원정보 수정
		if (StartView.number == 5) {
			controller.applyUpdate();
		}
		
		// 6.나의 지원정보 검색
		if (StartView.number == 6) {
			controller.myApplyInfo();
		}
		
		// 7.채용정보 전체검색
		if (StartView.number == 7) {
			controller.getwantedList();
		}
		
		// 8.직무정보 전체검색
		if (StartView.number == 8) {
			controller.getdeptList();
		}
		
		// 0. 종료
		if (StartView.number == 0) {
			controller.goToEnd();
		}
		
	}
	
}
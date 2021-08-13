package company.view;

import java.util.Scanner;

import company.controller.CompanyController;

public class StartView {
	private static int number = 0;
	public Scanner scan = new Scanner(System.in);

	private static StartView instance = new StartView();
	private static CompanyController controller = CompanyController.getInstance();
	
	static {
		System.out.println("\n===================\n����� �����մϴ�."
				+ "\n1.ȸ������ \n2.ȸ������ ����\n3.���� ȸ������ �˻�\n4.�����ϱ�\n5.�������� ����"
				+ "\n6.���� �������� �˻�\n7.ä������ ��ü�˻�\n8.�������� ��ü�˻�\n0.�����ϱ�\n===================");	

		number = instance.scan.nextInt();
	}
	
	private StartView() {}

	public static StartView getInstance() {
		return instance;
	}

	
	public static void main(String [] args){
		
		// 1.ȸ������ 
		if (StartView.number == 1) {
			controller.memberSignUpInput();
		}
		
		// 2.ȸ������ ���� 
		if (StartView.number == 2) {
			controller.memberUpdate();
		}
		
		// 3.���� ȸ������ �˻�
		if (StartView.number == 3) {
			controller.myMemberInfo();
		}
		
		// 4.�����ϱ�
		if (StartView.number == 4) {
			controller.applyInput();
		}
		
		// 5.�������� ����
		if (StartView.number == 5) {
			controller.applyUpdate();
		}
		
		// 6.���� �������� �˻�
		if (StartView.number == 6) {
			controller.myApplyInfo();
		}
		
		// 7.ä������ ��ü�˻�
		if (StartView.number == 7) {
			controller.getwantedList();
		}
		
		// 8.�������� ��ü�˻�
		if (StartView.number == 8) {
			controller.getdeptList();
		}
		
		// 0. ����
		if (StartView.number == 0) {
			controller.goToEnd();
		}
		
	}
	
}
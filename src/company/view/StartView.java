package company.view;

import company.controller.Controller;
import company.model.dto.MemberInfoDTO;

public class StartView {
	
	public static void main(String [] args){
		System.out.println("***** ��� ȸ������ �˻� *****");	
		Controller.getAllCompanyData();

		// �ڱ� ���� �Է�
		System.out.println("***** Ű����� ���� �Է� *****");
		System.out.println("�� ��Ŀ� ���� �ۼ��� �ּ���");
		System.out.println("���̵�/�̸�/�������/�����а�");
		MemberInfoDTO newMember = Controller.insertMember();
		Controller.addMember(newMember);
	
		//���� ������ ȸ�� ���� ���
		
		
	}
	
	
	
}
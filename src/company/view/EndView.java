package company.view;

import java.util.ArrayList;

public class EndView {
	
	//��ü ȸ������ ��� 
	public static void companyListView(ArrayList allcompany){ 
		if(allcompany != null) {
			int length = allcompany.size();
			
			if( length != 0 ){
				for(int index = 0; index < length; index++){			
					System.out.println("�˻����� " + (index+1) + " - " + allcompany.get(index));
				}
			}else {
				System.out.println("��û�Ͻ� ȸ�� ������ 1�� �����ϴ�");
			}
		}else {
			System.out.println("��û�Ͻ� ȸ�� ������ �����ϴ�.");
		}
	}
	
//	//Ư�� ȸ������ ��� 
//	public static void projectView(CompanyInfoDTO info){
//		System.out.println(info);		
//	}

	
	
//	//update ����, ���� �� �޽�������ϱ�  
//	public static void updateView(boolean result, String id) {
//		if(result == true) {
//			System.out.println("��û�Ͻ�" + id + " ���� �Ϸ�");
//			
//		}else {
//			System.out.println("��û�Ͻ�" + id + " ���� ����, ȸ���̸� ��Ȯ���ϼ���");
//		}
//	}
	
	
	//���� ��Ȳ ���
	public static void showError(String message){
		System.out.println(message);		
	}

	public static void messageView(String message) {
		System.out.println(message);
	}
}
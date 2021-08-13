package company.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import company.model.dto.DeptInfoDTO;
import company.model.dto.MemberInfoDTO;
import company.model.dto.WantedInfoDTO;
import company.service.Companyservice;
import company.view.EndView;
import company.view.StartView;

public class CompanyController {
		
		private static CompanyController instance = new CompanyController();
		
		private static Companyservice service = Companyservice.getInstance();
		
		static Logger logger = Logger.getLogger("test");
		
		private CompanyController() {}

		public static CompanyController getInstance() {
			return instance;
		}
		
		
		// 1.ȸ������ 
		public void memberSignUpInput() {
			Boolean inputResult = false;
			
			try {
				inputResult = service.memberSignUpInputInput();
				
				if (inputResult == true) {
					EndView.messageView("ȸ������ ����");
				}else {
					EndView.messageView("ȸ������ ����. �Է������� Ȯ�����ּ���");
				}
			}catch (IOException e) {
				e.printStackTrace();
				EndView.messageView("ȸ������ ����. �ܼ� ����� ����");
			}catch (NoSuchElementException e) {
				e.printStackTrace();
				EndView.messageView("ȸ������ ����. NoSuchElement����");
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.messageView("ȸ������ ����. SQL�� ����");
			}	
		}

		// 2.ȸ������ ���� 
		public void memberUpdate() {
			boolean inputResult = false;
			
			try {
				inputResult = service.memberUpUpdate();
				
				if (inputResult == true) {
					EndView.messageView("ȸ������ ���� ����");
				}else {
					EndView.messageView("ȸ������ ���� ����. �Է������� Ȯ�����ּ���");
				}
			}catch (NoSuchElementException e) {
				e.printStackTrace();
				EndView.messageView("ȸ������ ���� ����. NoSuchElement����");
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.messageView("ȸ������ ���� ����. SQL�� ����");
			}	
		}

		// 3.���� ȸ������ �˻�
		public void myMemberInfo() {
			try {
				EndView.oneView(service.mymyMemberInfo());
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.showError("ȸ������ �˻� ����. SQL�� ����");
			}
		}
		
		
		// 4.�����ϱ�
		public void applyInput() {
			boolean inputResult = false;
			
			try {
				inputResult = service.applyInputInput();
				
				if (inputResult == true) {
					EndView.messageView("�������� �Է� ����");
				}else {
					EndView.messageView("�������� ����. �Է������� Ȯ�����ּ���");
				}
			}catch (IOException e) {
				e.printStackTrace();
				EndView.messageView("�������� ����. �ܼ� ����� ����");
			}catch (NoSuchElementException e) {
				e.printStackTrace();
				EndView.messageView("�������� ����. NoSuchElement����");
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.messageView("�������� ����. SQL�� ����");
			}	
		}
		
		// 5.�������� ����
		public void applyUpdate(){
			boolean inputResult = false;
			
			try {
				inputResult = service.applyUpUpdate();
				
				if (inputResult == true) {
					EndView.messageView("�������� ���� ����");
				}else {
					EndView.messageView("�������� ���� ����. �Է������� Ȯ�����ּ���");
				}
			}catch (NoSuchElementException e) {
				e.printStackTrace();
				EndView.messageView("�������� ���� ����. NoSuchElement����");
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.messageView("�������� ���� ����. SQL�� ����");
			}	
		}
		
		
		// 6.���� �������� �˻�
		public void myApplyInfo() {
			try {
				EndView.oneView(service.mymyApplyInfo());
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.showError("�������� �˻� ����. SQL�� ����");
			}
		}
	
		// 7.ä������ ��ü�˻�
		public void getwantedList() {
			try {
				ArrayList<WantedInfoDTO> AllWantedList = service.wantedList();
				if(AllWantedList.size() !=0) {
					EndView.AllListView(AllWantedList);
					logger.info("ä������ �˻��߽��ϴ�");
				}else {
					EndView.messageView("ä�� ������ �ƹ��͵� �������� �ʽ��ϴ�:(");
				}
			} catch (SQLException e) {
				EndView.messageView("ä������ �˻� ����. SQL�� ����");
				e.printStackTrace();
			}
			
		}
		
		// 8.�������� ��ü�˻�
		public void getdeptList() {
			try {
				ArrayList<DeptInfoDTO> AllDeptList = service.deptList();
				if(AllDeptList.size() !=0) {
					EndView.AllListView(AllDeptList);
				}else {
					EndView.messageView("���� ������ �ƹ��͵� �������� �ʽ��ϴ�:(");
				}
			} catch (SQLException e) {
				EndView.messageView("�������� �˻� ����. SQL�� ����");
				e.printStackTrace();
			}
			
		}

		// 0. ����
		public void goToEnd() {
			StartView.getInstance().scan.close();
			EndView.messageView("�̿����ּż� �����մϴ�:)");
		}		
	
}
	
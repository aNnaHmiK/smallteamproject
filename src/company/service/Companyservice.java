package company.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import company.model.dao.ApplyInfoDAO;
import company.model.dao.DeptInfoDAO;
import company.model.dao.MemberInfoDAO;
import company.model.dao.WantedInfoDAO;
import company.model.dto.ApplyInfoDTO;
import company.model.dto.DeptInfoDTO;
import company.model.dto.MemberInfoDTO;
import company.model.dto.WantedInfoDTO;
import company.view.EndView;
import company.view.StartView;

public class Companyservice {
	
	private static Companyservice instance = new Companyservice();
	
	private static StartView start = StartView.getInstance();
	private static ApplyInfoDAO ApplyInfoData = ApplyInfoDAO.getInstance();
	private static DeptInfoDAO DeptInfoData = DeptInfoDAO.getInstance();
	private static MemberInfoDAO MemberInfoData = MemberInfoDAO.getInstance();
	private static WantedInfoDAO WantedInfoData = WantedInfoDAO.getInstance();
	
	private Companyservice() {}
	
	public static Companyservice getInstance() {
		return instance;
	}
	
	
		// 1.ȸ������ 	
		public boolean memberSignUpInputInput() throws IOException, SQLException {
//			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			//��ŸƮ�信�� ȸ������ �޼ҵ带 ���� -> ��Ʈ�ѷ����� ���񽺿� input��� ��û -> ���񽺿��� input �ް� DAO�� insert ��û 
			//DAO���� insert�õ� �Ŀ� �����ϸ� 1, �����ϸ� 2�� ��ȯ�Ѵ� -> ���񽺴� ��ȯ���� ���� �ٽ� ��Ʈ�ѷ��� ���� 
			boolean insertResult = false;
			System.out.println("�� ��Ŀ� ���� �ۼ��� �ּ���");
			System.out.println("���̵�/�̸�/�������/�����а�/�̸���/�������");
//			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				StringTokenizer st = new StringTokenizer(start.scan.next(),"/");
				MemberInfoDTO newMember = new MemberInfoDTO();
				
				newMember.setMemberId(st.nextToken());
				newMember.setMemberName(st.nextToken());
				newMember.setBirthDate(st.nextToken());
				newMember.setMajor(st.nextToken());
				newMember.setEmail(st.nextToken());
				//input�� string���� �ޱ� ������, int�� ����ȯ 
				int DeptHope = Integer.parseInt(st.nextToken());
				newMember.setDeptHope(DeptHope);
				
				//�Է¹��� MemberInfoDTO�� MemberInfoDAO�� ������ insert�õ�
				//insert�õ� �Ŀ� ����� true�� false�� �޾ƿ´�
				insertResult = MemberInfoData.addMemberInfo(newMember);
				
			}finally {
				start.scan.close();
			}
			return insertResult;
		}
		
		// 2.ȸ������ ����
		public boolean memberUpUpdate() throws SQLException {
			boolean updateResult = false;
			System.out.println("���̵� �Է����ּ���");
			MemberInfoDTO myInfo = new MemberInfoDTO();
			
			try {
				StringTokenizer st = new StringTokenizer(start.scan.next(),"/");
				String myId = (st.nextToken());
				
				myInfo = MemberInfoData.getMemberInfo(myId);
				EndView.oneView(myInfo);
				
				System.out.println("������ ������ �Է����ּ���");
				System.out.println("-----------------");
				System.out.println("�̸�/�������/����/�̸���/�������");
				
				st = new StringTokenizer(start.scan.next(),"/");
				
				MemberInfoDTO newMemberInfo = new MemberInfoDTO();
				
				newMemberInfo.setMemberId(myId);
				newMemberInfo.setMemberName(st.nextToken());
				newMemberInfo.setBirthDate(st.nextToken());
				newMemberInfo.setMajor(st.nextToken());
				newMemberInfo.setEmail(st.nextToken());
				newMemberInfo.setDeptHope(Integer.parseInt(st.nextToken()));
				
				updateResult = MemberInfoData.updateMemberInfo(newMemberInfo);
				
			}finally {
				start.scan.close();
			}
			return updateResult;
		}
		
		// 3.���� ȸ������ �˻�
		public MemberInfoDTO mymyMemberInfo() throws SQLException {
			System.out.println("������ ���̵� �Է����ּ���");
			MemberInfoDTO myInfo = new MemberInfoDTO();
			
			try {
				StringTokenizer st = new StringTokenizer(start.scan.next());
				String myId = st.nextToken();
				
				myInfo = MemberInfoData.getMemberInfo(myId);
				
			}finally {
				start.scan.close();
			}
			return myInfo;
			
		}
		
		
		// 4.�����ϱ�
		public boolean applyInputInput() throws IOException, SQLException {
			boolean insertResult = false;
			System.out.println("�� ��Ŀ� ���� �ۼ��� �ּ���");
			System.out.println("������ȣ/ȸ�����̵�/�������� ��ȣ/������¥");
			
			try {
				StringTokenizer st = new StringTokenizer(start.scan.next(),"/");
				ApplyInfoDTO newApply = new ApplyInfoDTO();
				
				int applicantNum = Integer.parseInt(st.nextToken());
				newApply.setApplicantNum(applicantNum);

				newApply.setMemberId(st.nextToken());
				newApply.setWantedNum(st.nextToken());
				newApply.setApplyDate(st.nextToken());
				
				insertResult = ApplyInfoData.addApplyInfo(newApply);
				
			}finally {
				start.scan.close();
			}
			return insertResult;
		}
		
		// 5.�������� ����
		public boolean applyUpUpdate() throws SQLException {
			boolean updateResult = false;
			ApplyInfoDTO myInfo = new ApplyInfoDTO();
			
			try {
				System.out.println("���̵� �Է����ּ���");
				
				StringTokenizer st = new StringTokenizer(start.scan.next());
				String myId = st.nextToken();
				
				myInfo = ApplyInfoData.getApplyInfo(myId);
				EndView.oneView(myInfo);
				
				System.out.println("������ ä����� ��ȣ�� �Է����ּ���");
				
				st = new StringTokenizer(start.scan.next(),"/");
				
				String newWantedNum = st.nextToken();
				
				updateResult = ApplyInfoData.updateApplyInfo(myId, newWantedNum);
				
			}finally {
				start.scan.close();
			}
			return updateResult;
		}
		
		
		// 6.���� �������� �˻�
		public ApplyInfoDTO mymyApplyInfo() throws SQLException {
			System.out.println("���̵� �Է����ּ���");
			ApplyInfoDTO myInfo = new ApplyInfoDTO();
			
			try {
				StringTokenizer st = new StringTokenizer(start.scan.next());
				String myId = st.nextToken();
				
				myInfo = ApplyInfoData.getApplyInfo(myId);
				
			}finally {
				start.scan.close();
			}
			return myInfo;
			
		}
		
		// 7.ä������ ��ü�˻�
		public ArrayList<WantedInfoDTO> wantedList() throws SQLException {
			start.scan.close();
			return WantedInfoData.getAllWantedInfo();
		}
		
		// 8.�������� ��ü�˻�
		public ArrayList<DeptInfoDTO> deptList() throws SQLException {
			start.scan.close();
			return DeptInfoData.getAllDeptInfo();
		}
		
		
		

		

		

		

	
}

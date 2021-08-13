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
	
	
		// 1.회원가입 	
		public boolean memberSignUpInputInput() throws IOException, SQLException {
//			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			//스타트뷰에서 회원가입 메소드를 실행 -> 컨트롤러에서 서비스에 input기능 요청 -> 서비스에서 input 받고 DAO에 insert 요청 
			//DAO에서 insert시도 후에 성공하면 1, 실패하면 2를 반환한다 -> 서비스는 반환받은 값을 다시 컨트롤러에 전달 
			boolean insertResult = false;
			System.out.println("이 양식에 따라서 작성해 주세요");
			System.out.println("아이디/이름/생년월일/전공학과/이메일/희망직무");
//			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				StringTokenizer st = new StringTokenizer(start.scan.next(),"/");
				MemberInfoDTO newMember = new MemberInfoDTO();
				
				newMember.setMemberId(st.nextToken());
				newMember.setMemberName(st.nextToken());
				newMember.setBirthDate(st.nextToken());
				newMember.setMajor(st.nextToken());
				newMember.setEmail(st.nextToken());
				//input을 string으로 받기 때문에, int로 형변환 
				int DeptHope = Integer.parseInt(st.nextToken());
				newMember.setDeptHope(DeptHope);
				
				//입력받은 MemberInfoDTO를 MemberInfoDAO로 보내서 insert시도
				//insert시도 후에 결과를 true나 false로 받아온다
				insertResult = MemberInfoData.addMemberInfo(newMember);
				
			}finally {
				start.scan.close();
			}
			return insertResult;
		}
		
		// 2.회원정보 수정
		public boolean memberUpUpdate() throws SQLException {
			boolean updateResult = false;
			System.out.println("아이디를 입력해주세요");
			MemberInfoDTO myInfo = new MemberInfoDTO();
			
			try {
				StringTokenizer st = new StringTokenizer(start.scan.next(),"/");
				String myId = (st.nextToken());
				
				myInfo = MemberInfoData.getMemberInfo(myId);
				EndView.oneView(myInfo);
				
				System.out.println("수정할 정보를 입력해주세요");
				System.out.println("-----------------");
				System.out.println("이름/생년월일/전공/이메일/희망직무");
				
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
		
		// 3.나의 회원정보 검색
		public MemberInfoDTO mymyMemberInfo() throws SQLException {
			System.out.println("본인의 아이디를 입력해주세요");
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
		
		
		// 4.지원하기
		public boolean applyInputInput() throws IOException, SQLException {
			boolean insertResult = false;
			System.out.println("이 양식에 따라서 작성해 주세요");
			System.out.println("지원번호/회원아이디/구직정보 번호/지원날짜");
			
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
		
		// 5.지원정보 수정
		public boolean applyUpUpdate() throws SQLException {
			boolean updateResult = false;
			ApplyInfoDTO myInfo = new ApplyInfoDTO();
			
			try {
				System.out.println("아이디를 입력해주세요");
				
				StringTokenizer st = new StringTokenizer(start.scan.next());
				String myId = st.nextToken();
				
				myInfo = ApplyInfoData.getApplyInfo(myId);
				EndView.oneView(myInfo);
				
				System.out.println("지원할 채용공고 번호를 입력해주세요");
				
				st = new StringTokenizer(start.scan.next(),"/");
				
				String newWantedNum = st.nextToken();
				
				updateResult = ApplyInfoData.updateApplyInfo(myId, newWantedNum);
				
			}finally {
				start.scan.close();
			}
			return updateResult;
		}
		
		
		// 6.나의 지원정보 검색
		public ApplyInfoDTO mymyApplyInfo() throws SQLException {
			System.out.println("아이디를 입력해주세요");
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
		
		// 7.채용정보 전체검색
		public ArrayList<WantedInfoDTO> wantedList() throws SQLException {
			start.scan.close();
			return WantedInfoData.getAllWantedInfo();
		}
		
		// 8.직무정보 전체검색
		public ArrayList<DeptInfoDTO> deptList() throws SQLException {
			start.scan.close();
			return DeptInfoData.getAllDeptInfo();
		}
		
		
		

		

		

		

	
}

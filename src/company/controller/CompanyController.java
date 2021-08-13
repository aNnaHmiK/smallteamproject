package company.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import company.controller.exception.NotExistException;
import company.model.dto.DeptInfoDTO;
import company.model.dto.WantedInfoDTO;
import company.service.Companyservice;
import company.view.EndView;
import company.view.StartView;

import org.apache.log4j.Logger;


public class CompanyController {
		
		private static CompanyController instance = new CompanyController();
		
		private static Companyservice service = Companyservice.getInstance();
		
		static Logger logger = Logger.getLogger("controllerLog");
		
		private CompanyController() {}

		public static CompanyController getInstance() {
			return instance;
		}
		
		
		// 1.회원가입 
		public void memberSignUpInput() {
			Boolean inputResult = false;
			
			try {
				inputResult = service.memberSignUpInputInput();
				
				if (inputResult == true) {
					EndView.messageView("회원가입 성공");
					logger.info("새로운 회원 가입했습니다");
				}else {
					EndView.messageView("회원가입 실패. 입력정보를 확인해주세요");
				}
			}catch (IOException e) {
				e.printStackTrace();
				EndView.messageView("회원가입 실패. 콘솔 입출력 에러");
			}catch (NoSuchElementException e) {
				e.printStackTrace();
				EndView.messageView("회원가입 실패. NoSuchElement에러");
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.messageView("회원가입 실패. SQL문 에러");
			}	
		}

		// 2.회원정보 수정 
		public void memberUpdate() {
			boolean inputResult = false;
			
			try {
				inputResult = service.memberUpUpdate();
				
				if (inputResult == true) {
					EndView.messageView("회원정보 수정 성공");
				}else {
					EndView.messageView("회원정보 수정 실패. 입력정보를 확인해주세요");
				}
			}catch (NoSuchElementException e) {
				e.printStackTrace();
				EndView.messageView("회원정보 수정 실패. NoSuchElement에러");
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.messageView("회원정보 수정 실패. SQL문 에러");
			}catch (NotExistException e) {
				e.printStackTrace();
				EndView.showError("회원정보 수정 실패. NotExistException 에러");
			}	
		}

		// 3.나의 회원정보 검색
		public void myMemberInfo() {
			try {
				EndView.oneView(service.mymyMemberInfo());
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.showError("회원정보 검색 실패. SQL문 에러");
			}catch (NotExistException e) {
				e.printStackTrace();
				EndView.showError("회원정보 검색 실패. NotExistException 에러");
			}
		}
		
		// 4.지원하기
		public void applyInput() {
			boolean inputResult = false;
			
			try {
				inputResult = service.applyInputInput();
				
				if (inputResult == true) {
					EndView.messageView("지원정보 입력 성공");
					logger.info("새로운 이력서가 올라왔습니다");
				}else {
					EndView.messageView("지원정보 실패. 입력정보를 확인해주세요");
				}
			}catch (IOException e) {
				e.printStackTrace();
				EndView.messageView("지원정보 실패. 콘솔 입출력 에러");
			}catch (NoSuchElementException e) {
				e.printStackTrace();
				EndView.messageView("지원정보 실패. NoSuchElement에러");
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.messageView("지원정보 실패. SQL문 에러");
			}	
		}
		
		// 5.지원정보 수정
		public void applyUpdate(){
			boolean inputResult = false;
			
			try {
				inputResult = service.applyUpUpdate();
				
				if (inputResult == true) {
					EndView.messageView("지원정보 수정 성공");
				}else {
					EndView.messageView("지원정보 수정 실패. 입력정보를 확인해주세요");
				}
			}catch (NoSuchElementException e) {
				e.printStackTrace();
				EndView.messageView("지원정보 수정 실패. NoSuchElement에러");
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.messageView("지원정보 수정 실패. SQL문 에러");
			}catch (NotExistException e) {
				e.printStackTrace();
				EndView.showError("지원정보 검색 실패. NotExistException 에러");
			}	
		}
		
		// 6.나의 지원정보 검색
		public void myApplyInfo() {
			try {
					EndView.oneView(service.mymyApplyInfo());
			}catch (SQLException e) {
				e.printStackTrace();
				EndView.showError("지원정보 검색 실패. SQL문 에러");
			}catch (NotExistException e) {
				e.printStackTrace();
				EndView.showError("지원정보 검색 실패. NotExistException 에러");
			}
		}
	
		// 7.채용정보 전체검색
		public void getwantedList() {
			try {
				ArrayList<WantedInfoDTO> AllWantedList = service.wantedList();
				if(AllWantedList.size() !=0) {
					EndView.AllListView(AllWantedList);
					logger.info("채용정보 검색했습니다");
				}else {
					EndView.messageView("채용 정보가 아무것도 존재하지 않습니다:(");
				}
			} catch (SQLException e) {
				EndView.messageView("채용정보 검색 실패. SQL문 에러");
				e.printStackTrace();
			}
		}
		
		// 8.직무정보 전체검색
		public void getdeptList() {
			try {
				ArrayList<DeptInfoDTO> AllDeptList = service.deptList();
				if(AllDeptList.size() !=0) {
					EndView.AllListView(AllDeptList);
					logger.info("직무정보 검색했습니다");
				}else {
					EndView.messageView("직무 정보가 아무것도 존재하지 않습니다:(");
				}
			} catch (SQLException e) {
				EndView.messageView("직무정보 검색 실패. SQL문 에러");
				e.printStackTrace();
			}
		}

		// 0. 종료
		public void goToEnd() {
			StartView.getInstance().scan.close();
			EndView.messageView("이용해주셔서 감사합니다:)");
		}		
	
}
	
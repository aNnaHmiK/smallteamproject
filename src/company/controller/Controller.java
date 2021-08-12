package company.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import company.model.dao.CompanyInfoDAO;
import company.model.dao.MemberDAO;
import company.model.dto.CompanyInfoDTO;
import company.model.dto.MemberDTO;
import company.view.EndView;

public class Controller {
	
	//모든 회사 정보 검색
	public static ArrayList<CompanyInfoDTO> getAllCompanyData(){
		ArrayList<CompanyInfoDTO> allCompany = null;
		
		try {
			EndView.companyListView(CompanyInfoDAO.getAllCompanys());
		}catch(SQLException s) {
			s.printStackTrace();
			EndView.showError("모든 회사 검색시 에러 발생");
		}
		return allCompany;
	}
	
	/**
	 * 새로운 Member 저장
	 * 
	 * @param newMember
	 */
	public static boolean addMember(MemberDTO member) {
		boolean result = false;
	
		try{
			result = MemberDAO.addMember(member);
			//result = ProbonoService.addProbonoUser(probonoProject); 차이없음
			EndView.messageView("정보가 추가되었습니다.");
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("회원 정보 저장시 오류발생");
		}
		return result;
	}
	
	/** 
	 * 키보드로 정보를 입력해서 회원 정보 추가 
	 * 
	 */
	public static MemberDTO insertMember() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(in.readLine(),"/");;
			
			MemberDTO newMember = new MemberDTO();
			newMember.setMemberId(st.nextToken());
			newMember.setMemberName(st.nextToken());
			newMember.setBirthDate(st.nextToken());
			newMember.setMajor(st.nextToken());;
			
			return newMember;
		}catch (IOException e) {
			e.printStackTrace();
		}catch (NoSuchElementException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
	
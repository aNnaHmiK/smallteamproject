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
	
	//��� ȸ�� ���� �˻�
	public static ArrayList<CompanyInfoDTO> getAllCompanyData(){
		ArrayList<CompanyInfoDTO> allCompany = null;
		
		try {
			EndView.companyListView(CompanyInfoDAO.getAllCompanys());
		}catch(SQLException s) {
			s.printStackTrace();
			EndView.showError("��� ȸ�� �˻��� ���� �߻�");
		}
		return allCompany;
	}
	
	/**
	 * ���ο� Member ����
	 * 
	 * @param newMember
	 */
	public static boolean addMember(MemberDTO member) {
		boolean result = false;
	
		try{
			result = MemberDAO.addMember(member);
			//result = ProbonoService.addProbonoUser(probonoProject); ���̾���
			EndView.messageView("������ �߰��Ǿ����ϴ�.");
		}catch(SQLException s){
			s.printStackTrace();
			EndView.showError("ȸ�� ���� ����� �����߻�");
		}
		return result;
	}
	
	/** 
	 * Ű����� ������ �Է��ؼ� ȸ�� ���� �߰� 
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
	
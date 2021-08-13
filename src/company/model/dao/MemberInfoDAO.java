package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import company.model.dto.MemberInfoDTO;
import company.model.util.DBUtil;
import company.service.Companyservice;

public class MemberInfoDAO {

	private static Properties sql = DBUtil.getSql();
	
	private static MemberInfoDAO instance = new MemberInfoDAO();
	
	private MemberInfoDAO() {}

	public static MemberInfoDAO getInstance() {
		return instance;
	}
	
	//회원가입(insert)
	public boolean addMemberInfo (MemberInfoDTO newMember) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addMemberInfo"));

			pstmt.setString(1, newMember.getMemberId());
			pstmt.setString(2, newMember.getMemberName());
			pstmt.setString(3, newMember.getBirthDate());
			pstmt.setString(4, newMember.getMajor());
			pstmt.setString(5, newMember.getEmail());
			pstmt.setInt(6, newMember.getDeptHope());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//2.회원정보 수정 
	public static boolean updateMemberInfo(MemberInfoDTO newMemberInfo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("updateMemberInfo"));
			pstmt.setString(1, newMemberInfo.getMemberName());
			pstmt.setString(2, newMemberInfo.getBirthDate());
			pstmt.setString(3, newMemberInfo.getMajor());
			pstmt.setString(4, newMemberInfo.getEmail());
			pstmt.setInt(5, newMemberInfo.getDeptHope());
			pstmt.setString(6, newMemberInfo.getMemberId());

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//회원정보 삭제(탈퇴)
	public static boolean deleteMemberInfo(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteMemberInfo"));
			pstmt.setString(1, memberId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//회원 아이디로 회원정보 단일 검색
	public MemberInfoDTO getMemberInfo(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberInfoDTO member = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getMemberInfo"));
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new MemberInfoDTO(rset.getString(1), rset.getString(2), rset.getString(3), 
										   rset.getString(4), rset.getString(5), rset.getInt(6));
			}
//			if (rset.next()) {
//				member = new MemberInfoDTO(rset.getString(1), rset.getString(2), rset.getString(3), 
//						rset.getString(4), rset.getString(5), rset.getInt(6));
//			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}

//	//회원정보 전체 검색
//	public static ArrayList<MemberInfoDTO> getAllMemberInfo() throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		ArrayList<MemberInfoDTO> list = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql.getProperty("getAllMemberInfo"));
//			rset = pstmt.executeQuery();
//
//			list = new ArrayList<MemberInfoDTO>();
//			while (rset.next()) {
//				list.add(new MemberInfoDTO(rset.getString(1), rset.getString(2), rset.getString(3), 
//						   				   rset.getString(4), rset.getString(5), rset.getInt(6)));
//			}
//		} finally {
//			DBUtil.close(con, pstmt, rset);
//		}
//		return list;
//	}
}
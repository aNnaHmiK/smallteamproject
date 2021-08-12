package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import company.model.dto.ApplyInfoDTO;
import company.model.util.DBUtil;

public class ApplyInfoDAO {

	private static Properties sql = DBUtil.getSql();
	
	public static boolean addApplyInfo(ApplyInfoDTO applyInfo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addApplyInfo"));

			pstmt.setInt(1, applyInfo.getApplicantNum());
			pstmt.setString(2, applyInfo.getMemberId());
			pstmt.setString(3, applyInfo.getWantedNum());
			pstmt.setString(4, applyInfo.getApplyDate());
			

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//지원번호로 채용번호 수정하기
	public static boolean updateApplyInfo(String applicantNum, int wantedNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("updateApplyInfo"));
			pstmt.setString(1, applicantNum);
			pstmt.setInt(2, wantedNum);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//지원번호로 지원 취소하기(지원정보 삭제)
	public static boolean deleteApplyInfo(String applicantNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteApplyInfo"));
			pstmt.setString(1, applicantNum);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//지원번호로 지원정보 검색하기
	public static ApplyInfoDTO getApplyInfo(String applicantNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ApplyInfoDTO member = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getApplyInfo"));
			pstmt.setString(1, applicantNum);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new ApplyInfoDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}

	//전체 지원정보 검색하기
	public static ArrayList<ApplyInfoDTO> getAllApplyInfo() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ApplyInfoDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllApplyInfo"));
			rset = pstmt.executeQuery();

			list = new ArrayList<ApplyInfoDTO>();
			while (rset.next()) {
				list.add(new ApplyInfoDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
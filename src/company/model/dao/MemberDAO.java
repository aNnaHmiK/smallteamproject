package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import company.model.dto.MemberDTO;
import company.model.util.DBUtil;

public class MemberDAO {

	private static Properties sql = DBUtil.getSql();
	
	public static boolean addMember(MemberDTO member) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addMember"));

			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getBirthDate());
			pstmt.setString(4, member.getMajor());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

//	public static boolean updateMember(String companyName, int stockPrice) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//
//			pstmt = con.prepareStatement(sql.getProperty("updateMember"));
//			pstmt.setString(1, companyName);
//			pstmt.setInt(2, stockPrice);
//
//			int result = pstmt.executeUpdate();
//			if (result == 1) {
//				return true;
//			}
//		} finally {
//			DBUtil.close(con, pstmt);
//		}
//		return false;
//	}
//
//
//	public static boolean deleteMember(String companyName) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DBUtil.getConnection();
//			pstmt = con.prepareStatement(sql.getProperty("deleteMember"));
//			pstmt.setString(1, companyName);
//			int result = pstmt.executeUpdate();
//			if (result == 1) {
//				return true;
//			}
//		} finally {
//			DBUtil.close(con, pstmt);
//		}
//		return false;
//	}
//
//	
	public static MemberDTO getMember(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MemberDTO member = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getMember"));
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				member = new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return member;
	}

	
	public static ArrayList<MemberDTO> getAllMember() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MemberDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllMember"));
			rset = pstmt.executeQuery();

			list = new ArrayList<MemberDTO>();
			while (rset.next()) {
				list.add(new MemberDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
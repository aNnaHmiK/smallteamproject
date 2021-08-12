package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import company.model.dto.ManageInfoDTO;
import company.model.util.DBUtil;

public class ManageInfoDAO {

	private static Properties sql = DBUtil.getSql();
	
	public static boolean addManageInfo(ManageInfoDTO manageInfo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addManageInfo"));

			pstmt.setString(1, manageInfo.getCompanyName());
			pstmt.setInt(2, manageInfo.getMarketCap());
			pstmt.setInt(3, manageInfo.getStockPrice());
			pstmt.setString(4, manageInfo.getMainProduct());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 수정
	// 회사 이름으로 주식가격 수정하기
	public static boolean updateManageInfo(String companyName, int stockPrice) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("updateManageInfo"));
			pstmt.setString(1, companyName);
			pstmt.setInt(2, stockPrice);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// ??? 삭제
	public static boolean deleteManageInfo(String companyName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteManageInfo"));
			pstmt.setString(1, companyName);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// 회사 이름으로 모든 경영정보 반환
	public static ManageInfoDTO getManageInfo(String companyName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ManageInfoDTO manage = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getManageInfo"));
			pstmt.setString(1, companyName);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				manage = new ManageInfoDTO(rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getString(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return manage;
	}

	// 모든 경영정보 반환
	public static ArrayList<ManageInfoDTO> getAllManageInfo() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ManageInfoDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllManageInfo"));
			rset = pstmt.executeQuery();

			list = new ArrayList<ManageInfoDTO>();
			while (rset.next()) {
				list.add(new ManageInfoDTO(rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getString(4)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
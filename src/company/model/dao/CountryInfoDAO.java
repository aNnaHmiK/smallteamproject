package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import company.model.dto.CountryInfoDTO;
import company.model.util.DBUtil;



public class CountryInfoDAO {

	private static Properties sql = DBUtil.getSql();
	
	//���ο� �������� ���
	public static boolean addCountryInfo(CountryInfoDTO countryInfo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("CountryInfo"));

			pstmt.setString(1, countryInfo.getCountry_name());
			pstmt.setString(2, countryInfo.getContinent());
			pstmt.setInt(3, countryInfo.getGdp_rank());
			
			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	
	// �����̸����� gdp �����ϱ�
	public static boolean updateCountryInfo(String countryName, int gdpRank) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();

			pstmt = con.prepareStatement(sql.getProperty("updateCountryInfo"));
			pstmt.setString(1, countryName);
			pstmt.setInt(2, gdpRank);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// ����
	// sql - delete from activist where activist_id=?
	public static boolean deleteCountryInfo(String countryName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteCountryInfo"));
			pstmt.setString(1, countryName);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//���� �̸����� ��� ���� ��ȯ
	public static CountryInfoDTO getCountryInfo(String countryName) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CountryInfoDTO country = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getCountryInfo"));
			pstmt.setString(1, countryName);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				country = new CountryInfoDTO(rset.getString(1), rset.getString(2), rset.getInt(3));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return country;
	}

	// ��� ���� ��ȯ
	public static ArrayList<CountryInfoDTO> getAllCountryInfo() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CountryInfoDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("ApplyInfo"));
			rset = pstmt.executeQuery();

			list = new ArrayList<CountryInfoDTO>();
			while (rset.next()) {
				list.add(new CountryInfoDTO(rset.getString(1), rset.getString(2), rset.getInt(3)));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}
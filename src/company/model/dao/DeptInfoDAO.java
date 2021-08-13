package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import company.model.dto.DeptInfoDTO;
import company.model.util.DBUtil;

public class DeptInfoDAO {
	
	private static Properties sql = DBUtil.getSql();
	
	private static DeptInfoDAO instance = new DeptInfoDAO();

	private DeptInfoDAO() {}
	
	public static DeptInfoDAO getInstance() {
		return instance;
	}
	
	//새로운 정보 등록
	public static boolean addDeptInfo(DeptInfoDTO deptInfo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addDeptInfo"));
			
			pstmt.setInt(1, deptInfo.getDeptNum());
			pstmt.setString(2, deptInfo.getDeptName());
			pstmt.setInt(3, deptInfo.getIncentive());
			
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				return true;
			} 
		}finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 인센 수정
	public static boolean updateDeptInfo(int incentive) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql.getProperty("updateDeptInfo"));
			pstmt.setInt(1, incentive);
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		}finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
	// 인센 삭제
	public static boolean deleteDeptInfo(int incentive) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteDeptInfo"));
			pstmt.setInt(1, incentive);
			
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	// 전체 검색
	public ArrayList<DeptInfoDTO> getAllDeptInfo() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DeptInfoDTO> list = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllDeptInfo"));
			rset = pstmt.executeQuery();
			
			list = new ArrayList<DeptInfoDTO>();
			while(rset.next()) {
				list.add(new DeptInfoDTO(rset.getInt(1), rset.getString(2), rset.getInt(3)));
			}
		}finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
}
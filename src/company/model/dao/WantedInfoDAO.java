package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import company.model.dto.WantedInfoDTO;
import company.model.util.DBUtil;
import company.service.Companyservice;

public class WantedInfoDAO {

	private static Properties sql = DBUtil.getSql();
	
	private static WantedInfoDAO instance = new WantedInfoDAO();

	private WantedInfoDAO() {}
	
	public static WantedInfoDAO getInstance() {
		return instance;
	}
	
	//add
	public static boolean addWantedInfo(WantedInfoDTO wanted) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addWantedInfo"));
			
			pstmt.setInt(1, wanted.getWantedNum());
			pstmt.setString(2, wanted.getCompanyName());
			pstmt.setInt(3, wanted.getSalary());
			pstmt.setInt(4, wanted.getDeptNum());
			pstmt.setString(5, wanted.getLocation());
			pstmt.setString(6, wanted.getQualification());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//update
	public static boolean updateWantedInfo(int wantedNum, int salary) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateWantedInfo"));
			
			pstmt.setInt(1, salary);
			pstmt.setInt(2, wantedNum);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//delete
	public static boolean deleteWantedInfo(int wantedNum) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteWantedInfo"));
			
			pstmt.setInt(1, wantedNum);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//get
	public static WantedInfoDTO getWantedInfo(int wantedNum) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		WantedInfoDTO wanted = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getWantedInfo"));
			
			pstmt.setInt(1, wantedNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				wanted = new WantedInfoDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getString(5), rset.getString(6));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return wanted;
	}
	
	//getAll
	public ArrayList<WantedInfoDTO> getAllWantedInfo() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<WantedInfoDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllWantedInfo"));
			rset = pstmt.executeQuery();
			
			list = new ArrayList<WantedInfoDTO>();
			while(rset.next()){
				list.add(new WantedInfoDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getInt(4), rset.getString(5), rset.getString(6)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
}
package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import company.model.dto.FounderInfoDTO;
import company.model.util.DBUtil;

public class FounderInfoDAO {
	
	private static Properties sql = DBUtil.getSql();
	
	
	//add
	public static boolean addFounderInfo(FounderInfoDTO founder) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addFounder"));
			
			pstmt.setString(1, founder.getFounderName());
			pstmt.setString(2, founder.getBirthDate());
			pstmt.setString(3, founder.getBirthCountry());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	
	//update  ==> 설립자에 대해 수정할 내용이 딱히..?
	public static boolean updateFounderInfo(String companyName, String major) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateFounder"));
			
			pstmt.setString(1, major);
			pstmt.setString(2, companyName);
			
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
	public static boolean deleteFounderInfo(String companyName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteFounder"));
			
			pstmt.setString(1, companyName);
			
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
	public static FounderInfoDTO getFounderInfo(String companyName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		FounderInfoDTO company = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("getFounder");
			
			pstmt.setString(1, companyName);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				company = new FounderInfoDTO(rset.getString(1), rset.getString(2), rset.getString(3));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return company;
	}
	
	
	//getAll
	public static ArrayList<FounderInfoDTO> getAllFounderInfos() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FounderInfoDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("getAllFounders");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<FounderInfoDTO>();
			while(rset.next()){
				list.add(new FounderInfoDTO(rset.getString(1), rset.getString(2), rset.getString(3)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

}
package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import company.model.dto.CompanyInfoDTO;
import company.model.util.DBUtil;

public class CompanyInfoDAO {
	
	private static Properties sql = DBUtil.getSql();
	
	
	//add
	public static boolean addCompany(CompanyInfoDTO company) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addCompany"));
			
			pstmt.setString(1, company.getCompanyName());
			pstmt.setString(2, company.getFounderName());
			pstmt.setString(3, company.getFoundDate());
			pstmt.setString(4, company.getHeadCountry());
			pstmt.setInt(5, company.getSalary());
			
			
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
	public static boolean updateCompany(String companyName, int salary) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateCompany"));
			
			pstmt.setInt(1, salary);
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
	public static boolean deleteCompany(String companyName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteCompany"));
			
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
	public static CompanyInfoDTO getCompany(String companyName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		CompanyInfoDTO company = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getCompany"));
			
			pstmt.setString(1, companyName);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				company = new CompanyInfoDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return company;
	}
	
	
	//getAll
	public static ArrayList<CompanyInfoDTO> getAllCompanys() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CompanyInfoDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllCompanys"));
			rset = pstmt.executeQuery();
			
			list = new ArrayList<CompanyInfoDTO>();
			while(rset.next()){
				list.add(new CompanyInfoDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),rset.getInt(5)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
}
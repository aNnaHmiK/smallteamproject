package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import company.model.dto.ProductInfoDTO;
import company.model.util.DBUtil;


public class ProductInfoDAO {

	private static Properties sql = DBUtil.getSql();
	
	
	//add
	public static boolean addProductInfo(ProductInfoDTO product) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addProduct"));
			
			pstmt.setString(1, product.getProductName());
			pstmt.setString(2, product.getCompanyName());
			pstmt.setInt(3, product.getSales());
			
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
	public static boolean updateProductInfo(String companyName, int sales) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("updateProduct"));
			
			pstmt.setInt(1, sales);
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
	public static boolean deleteProductInfo(String companyName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deleteProduct"));
			
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
	public static ProductInfoDTO getProductInfo(String companyName) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ProductInfoDTO company = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("getProduct");
			
			pstmt.setString(1, companyName);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				company = new ProductInfoDTO(rset.getString(1), rset.getString(2), rset.getInt(3));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return company;
	}
	
	
	//getAll
	public static ArrayList<ProductInfoDTO> getAllProductInfos() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductInfoDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("getAllProducts");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ProductInfoDTO>();
			while(rset.next()){
				list.add(new ProductInfoDTO(rset.getString(1), rset.getString(2), rset.getInt(3)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
}
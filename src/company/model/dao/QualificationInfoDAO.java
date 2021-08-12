package company.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import company.model.dto.QualificationInfoDTO;
import company.model.util.DBUtil;

public class QualificationInfoDAO {
	
	private static Properties sql = DBUtil.getSql();
		
		//�ڰ����� ���(insert)
		public static boolean addQualificationInfo(QualificationInfoDTO company) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sql.getProperty("addQualificationInfo"));
				pstmt.setString(1, company.getCompanyName());
				pstmt.setString(2, company.getEducation());
				pstmt.setString(3, company.getMajor());
				pstmt.setString(4, company.getLang());
				
				int result = pstmt.executeUpdate();
			
				if(result == 1){
					return true;
				}
			}finally{
				DBUtil.close(con, pstmt);
			}
			return false;
		}
	
		//����  
		//ȸ���̸����� �ڰ����� �����ϱ�
		public static boolean updateQualificationInfo(String company, String education, String major, String lang) throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				con = DBUtil.getConnection();
				
				pstmt = con.prepareStatement(sql.getProperty("updateQualificationInfo"));
				pstmt.setString(1, education);
				pstmt.setString(2, major);
				pstmt.setString(3, lang);
				pstmt.setString(4, company);
				
				int result = pstmt.executeUpdate();
				if(result == 1){
					return true;
				}		
			}finally{
				DBUtil.close(con, pstmt);
			}
			return false;
		}

		//��� �����ڰ� �˻��ؼ� ��ȯ
		public static ArrayList<QualificationInfoDTO> getAllQualifications() throws SQLException{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			ArrayList<QualificationInfoDTO> all = null;

			try {
				con = DBUtil.getConnection(); 
				pstmt = con.prepareStatement(sql.getProperty("getAllQualifications")); 
				rset = pstmt.executeQuery();
				
				all = new ArrayList<>();

				while (rset.next()) {
					all.add(new QualificationInfoDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)));
				}

			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			} finally {
				DBUtil.close(con, pstmt, rset);
			}
			return all;
		}
		
}

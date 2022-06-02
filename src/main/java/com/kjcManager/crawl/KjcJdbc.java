package com.kjcManager.crawl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KjcJdbc {
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet resultSet = null;
	static String sql = null;
	static int sortId = 0;

	// ----------------------------链接部分----------------------------
	public static void connectionDB() throws Exception {
		String url = com.kjcManager.util.Jdbc.getUrl();
		String user = com.kjcManager.util.Jdbc.getDataname();
		String password = com.kjcManager.util.Jdbc.getDatapass();
		String driver = com.kjcManager.util.Jdbc.getProperty("jdbc.driver");
		System.out.println(url);
		System.out.println(user);
		System.out.println(password);
		System.out.println(driver);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ----------------------------写入部分----------------------------
	public static void writeContextIntoDB(String flagCode,String flagName,String deptCode,String deptName,String typeCode,String typeName,String checkId,String info,String year,String curPage) {
		sql = "INSERT INTO ws_a_cugb_dept(flagCode,flagName,deptCode,deptName,typeCode,typeName,checkId,info,year,curPage,addTime) VALUES (?,?,?,?,?,?,?,?,?,?,now())";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, flagCode);
			ps.setString(2, flagName);
			ps.setString(3, deptCode);
			ps.setString(4, deptName);
			ps.setString(5, typeCode);
			ps.setString(6, typeName);
			ps.setString(7, checkId);
			ps.setString(8, info);
			ps.setString(9, year);
			ps.setString(10, curPage);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ----------------------------校验部分----------------------------
	public static boolean checkDataFromDB(String flagCode,String deptCode,String paperTypeCode,String checkId,String year) throws SQLException{
		sql = "SELECT * FROM ws_a_cugb_dept WHERE flagCode = ? AND deptCode = ? AND typeCode = ? AND checkId = ? AND year = ?";
		ps = conn.prepareStatement(sql);
		ps.setString(1, flagCode);
		ps.setString(2, deptCode);
		ps.setString(3, paperTypeCode);
		ps.setInt(4, Integer.parseInt(checkId.trim()));
		ps.setString(5, year);
		resultSet = ps.executeQuery();
		if (resultSet.next()) {
			return true;
		}else{
			return false;
		}
	}
}
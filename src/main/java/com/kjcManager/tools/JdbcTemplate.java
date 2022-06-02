package com.kjcManager.tools;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTemplate {
	public void getUser(String url) {
		Connection con = null;// 创建一个数据库连接
		CallableStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
			Class.forName("com.mysql.jdbc.Driver");// 加载Oracle驱动程序
			//Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("开始尝试连接数据库！");
			// String user = "inituser";// 用户名,系统默认的账户名
			// String password = "initpass";// 你安装时选设置的密码
			String user = "laqgiF0NOj8=";// 用户名,系统默认的账户名
			String password = "faLhkmlb6j+TMQdMFS/O0w==";// 你安装时选设置的密码
			con = DriverManager.getConnection(url, user, password);// 获取连接
			System.out.println("连接成功！");
//			String sql = "{call SYSTEM.GETCOMMONUSERPASS(?,?)}";// 预编译语句，“？”代表参数
//			pre = con.prepareCall(sql);// 实例化预编译语句
//			pre.registerOutParameter(1, Types.BLOB);
//			pre.registerOutParameter(2, Types.BLOB);
//			pre.execute();// 执行查询，注意括号中不需要再加参数
//			// System.out.println(BLOB2String(pre.getBlob(1)));
//			System.out.println(BLOB2String(pre.getBlob(1)));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
				// 注意关闭的顺序，最后使用的最先关闭
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
				System.out.println("数据库连接已关闭！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// String url="jdbc:oracle:thin:@//166.111.71.241:1521/da";
		String url = "jdbc:mysql://127.0.0.1:3306/kjcManager?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true";
		// new JdbcTemplate().getUser(url);
		String username = "root";// 用户名,系统默认的账户名
		//String password = "APvTMLNldXub";// 你安装时选设置的密码
		String password = "Liwei3860919";// 你安装时选设置的密码
		tryConnect(url, username, password);
	}

	public static String BLOB2String(Object o) throws SQLException {
		String str = null;
		byte[] inbyte = null;
		if (o instanceof Blob) {
			Blob blob = (Blob) o;
			if (blob != null) {
				inbyte = blob.getBytes(1, (int) blob.length());
			}
			str = new String(inbyte);
		}
		return str;
	}

	public static Boolean tryConnect(String url, String username,
			String password) {
		Connection con = null;// 创建一个数据库连接
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
			//Class.forName("com.mysql.jdbc.Driver");
			System.out.println("开始尝试连接数据库！");
			con = DriverManager.getConnection(url, username, password);// 获取连接
			System.out.println("连接成功！");
			if (con != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("设置数据库用户、密码失败！");
		} finally {
			try {
				// 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
				// 注意关闭的顺序，最后使用的最先关闭
				if (con != null)
					con.close();
				System.out.println("数据库连接已关闭！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}

package com.zy.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {

	/**
	 * get jdbc connection
	 * 2010-5-7
	 * @return
	 */
	public  static Connection getConnection() {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		//PropertiesUtil u=PropertiesUtil.getInstance("zy");
		//String url=u.get("jdbc_dburl");
		String url = "jdbc:mysql://localhost:3306/zy";
		//String username=u.get("jdbc_dbusername");
		//String password=u.get("jdbc_dbpassword");
		
		String username ="root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
		} catch (Exception e) {
		throw new IllegalStateException(e);
		}
	}
	/**
	 * do select 
	 * 2010-5-7
	 * @param sql
	 * @return
	 */
	public static List<List<Object>> executeQuery(String sql)
	{
		List<List<Object>> result=new ArrayList<List<Object>>();
		Connection con =null;
		Statement smt =null;
		ResultSet rs=null;
		try
		{
			con=getConnection();
			smt =con.createStatement();
			rs=smt.executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();
			
			while(rs.next())
			{
				List<Object> row=new ArrayList<Object>();
				for(int i=0;i<rsmd.getColumnCount();i++)
				{
					Object column=rs.getObject(i+1);
					row.add(column);
				}
				result.add(row);
			}
			System.out.println("execute JDBC sql "+ sql +" successful...");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.releaseConnection(rs,smt,con);
		}
		return result;
	}
	/**
	 * do insert or update sql
	 * 2010-5-7
	 * @param sql
	 */
	public static synchronized void executeUpdate(String sql)
	{
		if(sql == null || "".equals(sql)) return;
		Connection con =null;
		Statement smt =null;
		try
		{
			con=getConnection();
			con.setAutoCommit(false);//禁止自动提交
			smt =con.createStatement();
			smt.executeUpdate(sql);
			con.commit();
			System.out.println("execute JDBC sql "+ sql +" successful...");
		}
		catch(Exception e)
		{
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.releaseConnection(null,smt,con);
		}
	}
	/**
	 * do insert or update sql
	 * 2010-5-7
	 * @param sql
	 */
	public static synchronized void executeBatch(String sql)
	{
		if(sql == null || "".equals(sql)) return;
		Connection con =null;
		Statement stmt =null;
		try
		{
			con=getConnection();
			con.setAutoCommit(false);//禁止自动提交
			stmt = con.createStatement();  
			String [] sql_z=sql.split(";");
			if(sql_z.length > 0)
			{
				for(int i=0;i<sql_z.length;i++)
				{
					stmt.addBatch(sql_z[i]);
				}
				stmt.executeBatch();
			}
			con.commit();
			System.out.println("execute JDBC sql "+ sql +" successful...");
		}
		catch(Exception e)
		{
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.releaseConnection(null,stmt,con);
		}
	}
	/**
	 * do insert or update sql for 1 sql
	 * 2010-5-7
	 * @param sql
	 */
	public static synchronized void executeBatch(String sql,List<String> params)
	{
		if(sql == null || "".equals(sql)) return;
		Connection con =null;
		java.sql.PreparedStatement pstmt =null;
		try
		{
			con=getConnection();
			con.setAutoCommit(false);//禁止自动提交
			pstmt =con.prepareStatement(sql);  
			if(params.size() > 0)
			{
				for(int i=0;i<params.size();i++)
				{
					System.out.println(params.get(i));
					pstmt.setString(1, params.get(i));
					pstmt.addBatch();
				}
				pstmt.executeBatch();
			}
			con.commit();
			System.out.println("execute JDBC sql "+ sql +" successful...");
		}
		catch(Exception e)
		{
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			JDBCUtil.releaseConnection(null,pstmt,con);
		}
	}
	/**
	 * release connection and statement and resultset
	 * 2010-5-7
	 * @param rs
	 * @param smt
	 * @param con
	 */
	public static void releaseConnection(ResultSet rs,Statement smt,Connection con)
	{
		try
		{
			if(rs != null){
				if(!rs.isClosed())
				{
					rs.close();
					rs =null;
				}
			}
			if(smt != null)
			{
				if(!smt.isClosed()){
					smt.close();
					smt= null;
				}
			}
			if(con != null)
			{
				if(!con.isClosed())
				{
					con.close();
					con =null;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

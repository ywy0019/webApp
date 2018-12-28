package com.ywy.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBconn {
	static String url = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
	static String username = "root";
	static String psswd = "admin";
	static Connection conn ;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	public static void init(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,psswd);
//			if(!conn.isClosed()){
//				System.out.println("succeeded connecting to the database");
//			}
		}catch(Exception e){
			System.out.println("init [SQL���������ʼ��ʧ�ܣ�]");
			e.printStackTrace();
		}
	}
	public static int addUpdDel(String sql){
		int i =0;
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			i= ps.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("sql���ݿ���ɾ���쳣");
			e.printStackTrace();
			
		}
		return i;
	}
	public static ResultSet selectSql(String sql){
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("sql���ݿ��ѯ�쳣");
			e.printStackTrace();
		}
		return rs;
	}
	public static void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("sql���ݿ�ر��쳣");
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		init();
//	}
}

package com.ywy.shop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestCaseDaoImpl implements TestCaseDao{
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;
	@Override
	public List<TestCase> getCaseAll() {
		// TODO Auto-generated method stub
		List<TestCase> list = new ArrayList<TestCase>();
		try {
			DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from testcase");
			while(rs.next()){
				TestCase testCase = new TestCase();
				testCase.setId(rs.getInt("caseId"));
				testCase.setCaseName(rs.getString("caseName"));
				testCase.setCaseDetail(rs.getString("caseDetail"));
				testCase.setCaseDevice(rs.getString("caseDevice"));
				
				list.add(testCase);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addCase(TestCase testCase) {
		// TODO Auto-generated method stub
		boolean flag = false;
		DBconn.init();
		int i = DBconn.addUpdDel("insert into user(caseName,caseDetail,caseDevice)"+"values('"
				+testCase.getCaseName()+"','"+testCase.getCaseDetail()+"','"
				+testCase.getCaseDevice()+"')");
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	@Override
	public boolean deleteCase(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		DBconn.init();
		String sql = "delete from testcase where caseId="+id;
		int i = DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	@Override
	public boolean updateCase(TestCase testCase) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

package com.ywy.shop;

import java.util.List;

public interface TestCaseDao {
	public List<TestCase> getCaseAll();
	public boolean addCase(TestCase testCase);
	public boolean deleteCase(int id);
	public boolean updateCase(TestCase testCase);
}

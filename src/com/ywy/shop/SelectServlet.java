package com.ywy.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class SelectServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServerException, IOException{
		TestCaseDaoImpl testCaseDaoImpl = new TestCaseDaoImpl();
		List<TestCase> list = testCaseDaoImpl.getCaseAll();
		List<TestCase> list1 = new ArrayList<>();
		int size = list.size();
		TestCase testCase;
		 resp.setContentType("text/plain");
	     resp.setCharacterEncoding("gb2312");
	     PrintWriter out = new PrintWriter(resp.getOutputStream());
		for(int i=0;i<size;i++){
			testCase = new TestCase();
			testCase.setId(list.get(i).getId());
			testCase.setCaseName(list.get(i).getCaseName());
			testCase.setCaseDetail(list.get(i).getCaseDetail());
			list1.add(testCase);
		}
		String page = req.getParameter("page");
		//��������ӵ�����
		List<TestCase> caselist = new ArrayList<TestCase>();
		
		//���´�������ҳ
		if(page==null||page.equals("0")||page==""){
			if(list1.size()>0){
				for(int i=0;i<list1.size();i++){
					caselist.add(list1.get(i));
				}
			}
		}else{
			//ʹ��������ʽ�ж������page�Ƿ�ȫ�����֣����������������ʾ
			Pattern pattern = Pattern.compile("^[0-9]*$");
			Matcher matcher = pattern.matcher((CharSequence)page);
			if(matcher.matches()){
				//�ж�page�ĳ��ȣ����page���ȳ���7�������������Ϣ
				if(page.length()>7){
					out.print("ҳ���������");
					out.flush();
				}else{
					int caseSize=list1.size();
					int actualPageNum = 0;
					if(caseSize%10==0){
						actualPageNum=caseSize/10;
					}else{
						actualPageNum=caseSize/10+1;
					}
					int receivedPageNum = Integer.parseInt(page);
					//�ж������page�Ƿ����ʵ�ʵ�ҳ����10������Ϊһҳ����������ڣ������������ʾ
					if(receivedPageNum>actualPageNum||receivedPageNum<=0){
						out.print("ҳ���������");
						out.flush();
					}
					else if(receivedPageNum<actualPageNum){
						for(int i = 10*receivedPageNum-10;i<10*receivedPageNum;i++){
							caselist.add(list1.get(i));
						}
					}
					else if(receivedPageNum==actualPageNum){
						for(int i = 10*receivedPageNum-10;i<list1.size();i++){
							caselist.add(list1.get(i));
							}
						}
					}
			}else{
					out.print("��������");
					out.flush();
				}
				
			}	
			TestCaseTotal nt = new TestCaseTotal(caselist.size(), caselist);

        // ����GSON jar���߰���װ�õ�toJson��������ֱ������JSON�ַ���
			Gson gson = new Gson();
			String json = gson.toJson(nt);
       
			out.print(json);
			out.flush();
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		  this.doGet(req, resp);
	}
}

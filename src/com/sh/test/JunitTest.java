package com.sh.test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.sh.member.MemberDAO;
import com.sh.member.MemberDTO;

public class JunitTest {
	
	@Test
	public void insert() throws Exception{
		String value = "2019-12-11";
		Date date = Date.valueOf(value);
		System.out.println(date);
	}
	
	/*
	@Test
	public void delete() throws Exception{
		
		MemberDAO memberDAO = new MemberDAO();
		
		int result = memberDAO.delete("opop");
		
		assertNotEquals(result, 0);  //0과 같지 않다면 성공 지금은 넣은 값이 없으니까 0이 나온다. 
	}*/
	
	
	/*
	@Test
	public void selectOne()throws Exception{
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		
		memberDAO.selectOne("opop");
		
		assertNotNull(memberDTO);
	}*/
}

package com.sh.input;

import java.sql.Date;
import java.util.Scanner;

import com.sh.member.MemberDTO;

public class MemberInput {
	
	private Scanner sc;
	
	public MemberInput() {
		
		sc = new Scanner(System.in);
	}
	
	public MemberDTO memberInput() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("ID :");
		memberDTO.setId(sc.next());
		
		System.out.println("Password :");
		memberDTO.setPw(sc.next());
		
		System.out.println("Name : ");
		memberDTO.setName(sc.next());
		
		System.out.println("Age : ");
		memberDTO.setAge(sc.nextInt());
		
		System.out.println("Birth : ");
		
		String birth = sc.next();  //문자열 -> Date
		
		Date date = Date.valueOf(birth);
		
		memberDTO.setBirth(date);
		
		return memberDTO;
	}
	
	public String setID(String str) {
		String id = null;
		
		System.out.println(str+"할 ID");
		
		id = sc.next();
		
		return id;
	}

}

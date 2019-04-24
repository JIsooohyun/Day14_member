package com.sh.view;

import java.util.ArrayList;

import com.sh.member.MemberDTO;

public class MemberView {

	public void view(String message) {
		System.out.println(message);
		
	}
	
	public void view(MemberDTO memberDTO) {
		
		System.out.println("ID : "+memberDTO.getId());
		System.out.println("Password : "+memberDTO.getPw());
		System.out.println("Name : "+memberDTO.getName());
		System.out.println("Age : "+memberDTO.getAge());
		System.out.println("Birth : "+memberDTO.getBirth());
		System.out.println("===============");
	}

	public void view(ArrayList<MemberDTO> ar) {
		for(MemberDTO memberDTO : ar) {
			this.view(memberDTO);
		}
	}
	
}

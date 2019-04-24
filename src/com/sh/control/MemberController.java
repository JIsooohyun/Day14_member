package com.sh.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.sh.input.MemberInput;
import com.sh.member.MemberDAO;
import com.sh.member.MemberDTO;
import com.sh.view.MemberView;

public class MemberController {

	private Scanner sc;
	private MemberDTO memberDTO;
	private MemberDAO memberDAO;
	private MemberInput memberInput;
	private MemberView memberView;
	
	public MemberController() {
		memberDTO = new MemberDTO();
		memberInput = new MemberInput();
		memberDAO = new MemberDAO();
		memberView = new MemberView();
		sc = new Scanner(System.in);
	}
	
	public void controller() throws Exception{
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		while(check) {
			System.out.println("1. 회원가입");
			System.out.println("2. 회원탈퇴");
			System.out.println("3. 회원정보검색");
			System.out.println("4. 회원전체정보검색");
			System.out.println("5. 회원일부분검색");
			System.out.println("6. 종료");
			
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				memberDTO = memberInput.memberInput();
				select  = memberDAO.insert(memberDTO);
				if(select>0) {
					memberView.view("추가 성공");
				}else {
					memberView.view("추가 실패");
				}
				
				break;
			case 2:
				String id = memberInput.setID("탈퇴");
				select = memberDAO.delete(id);
				if(select>0) {
					memberView.view("삭제 성공");
				}else {
					memberView.view("삭제 실패");
				}
				break;
			case 3:
				String id1 = memberInput.setID("조회");
				memberDTO = memberDAO.selectOne(id1);
				if(memberDTO!=null) {
					memberView.view(memberDTO);
				}else {
					memberView.view("없는 ID");
				}
				break;
				
			case 4:
				ar = memberDAO.selectAll();
				memberView.view(ar);
				
				break;
				
			case 5: 
				String id2 = memberInput.setID("조회");
				ar = memberDAO.searchMember(id2);
				memberView.view(ar);
				break;
			default:
				System.out.println("종료");
				check =! check;
				break;
			
			}
		}
	}
}

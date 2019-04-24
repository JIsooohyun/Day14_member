package com.sh.control;

public class StartMain {

	public static void main(String[] args) {

		MemberController mc = new MemberController();
		
		try {
			mc.controller();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

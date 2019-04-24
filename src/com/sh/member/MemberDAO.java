package com.sh.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sh.util.DBConnector;

public class MemberDAO {
	
	
	//serachMember(String id)
	public ArrayList<MemberDTO> searchMember(String id) throws Exception{
		MemberDTO memberDTO = null;
		ArrayList<MemberDTO> ar = new ArrayList<MemberDTO>();
		Connection conn = DBConnector.connect();
		
		String sql = "select * from member where id like ?";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, "%"+id+"%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString(1));
			memberDTO.setPw(rs.getString(2));
			memberDTO.setName(rs.getString(3));
			memberDTO.setAge(rs.getInt(4));
			memberDTO.setBirth(rs.getDate(5));
			ar.add(memberDTO);
		}
		
		DBConnector.disconnect(st, conn, rs);
		
		return ar;
		
	}

	public MemberDTO selectOne(String id) throws Exception { //id로 검색해서 한개의 열만 찾아오는 메서드
		MemberDTO memberDTO = null;
		Connection conn = DBConnector.connect();
		
		//sql
		String sql = "select * from member where id=?";
		
		//미리 전송
		PreparedStatement st = conn.prepareStatement(sql);
		
		//값 설정
		st.setString(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString(1));
			memberDTO.setPw(rs.getString(2));
			memberDTO.setName(rs.getString(3));
			memberDTO.setAge(rs.getInt(4));
			memberDTO.setBirth(rs.getDate(5));
		}
		
		DBConnector.disconnect(st, conn, rs);
		
		return memberDTO;
	}


	public ArrayList<MemberDTO> selectAll() throws Exception{ //전체검색

		ArrayList<MemberDTO> ar =  new ArrayList<MemberDTO>();
		MemberDTO memberDTO = null;
		
		Connection conn = DBConnector.connect();
		
		String sql = "select * from member";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString(1));
			memberDTO.setPw(rs.getString(2));
			memberDTO.setName(rs.getString(3));
			memberDTO.setAge(rs.getInt(4));
			memberDTO.setBirth(rs.getDate(5));
			ar .add(memberDTO);
		}
		
		DBConnector.disconnect(st, conn);
		
		return ar;
	}
	
	
	
	public int insert(MemberDTO memberDTO) throws Exception{ //검색
		
		Connection conn = DBConnector.connect();
		
		//4. sql
		//String sql = "insert into member values(?, ?, ?, ?, ?, to_date(?, yyyy-mm-dd))";
		String sql = "insert into member values(?, ?, ?, ?, ?)";
		//5. 미리 전송
		PreparedStatement st = conn.prepareStatement(sql);
		
		//6. 값 세팅
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setInt(4, memberDTO.getAge());
		st.setDate(5, memberDTO.getBirth());
		//st.setString(5, "to_date("+memberDTO.getBirth2()+"yyyy-mm-dd");  //이렇게 DB형변환은 안된다.
		//st.setString(5, memberDTO.getBirth2());  //이렇게 DB형변환은 안된다. 
		
		int result = st.executeUpdate();
		
		DBConnector.disconnect(st, conn);
		
		return result;
		
	}

	public int delete(String id) throws Exception{ //삭제

		MemberDTO memberDTO = new MemberDTO();
		Connection conn = DBConnector.connect();

		//4. sql
		String sql = "delete Member where id = ?";

		//5. 미리 전송
		PreparedStatement st = conn.prepareStatement(sql);

		//6. ?값 세팅
		st.setString(1, id);

		//7. 연결???
		int result = st.executeUpdate();

		//8. 연결 끊기
		DBConnector.disconnect(st, conn);

		return result;
	}



}

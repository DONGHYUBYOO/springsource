package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.domain.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String MEMBER_INSERT="insert into member values(?,?,?,?,?)";
	private final String MEMBER_UPDATE="update member set password=? where userid=? and password=?";
	private final String MEMBER_DELETE="delete from member where userid=? and password=?";
	private final String MEMBER_LIST="select * from member";
	private final String MEMBER_GET="select * from member where userid=? and password=?";
	/*static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con=null;
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="javadb";
		String password="12345";
		
		try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}*/
	
	public List<MemberVO> getList(){
		System.out.println("======> Spring JDBC SELECT 처리");
		return jdbcTemplate.query(MEMBER_LIST, new MemberRowMapper());
		
//		List<MemberVO> list = new ArrayList<>();
//		MemberVO vo=null;
//		
//		String sql="select * from member";
//		try(Connection con=ds.getConnection();
//				PreparedStatement pstmt=con.prepareStatement(sql);
//				ResultSet rs=pstmt.executeQuery()) {
//			
//			while(rs.next()) {
//				vo = new MemberVO();
//				vo.setUserid(rs.getString("userid"));
//				vo.setPassword(rs.getString("password"));
//				vo.setName(rs.getString("name"));
//				vo.setGender(rs.getString("gender"));
//				vo.setEmail(rs.getString("email"));
//				list.add(vo);
//			}			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//		return list;
	}
	
	//회원가입
	public int joinMember(MemberVO vo) {
		System.out.println("======> Spring JDBC INSERT 처리");
		return jdbcTemplate.update(MEMBER_INSERT, vo.getUserid(), vo.getPassword(), vo.getName(), vo.getGender(), vo.getEmail());
	}
	
	//비밀번호 수정
	public int updateMember(String userid, String current_password, String new_password) {
		System.out.println("======> Spring JDBC UPDATE 처리");
		return jdbcTemplate.update(MEMBER_UPDATE, new_password, userid, current_password);
	}
	
	//회원탈퇴
	public int leaveMember(String userid, String password) {
		System.out.println("======> Spring JDBC DELETE 처리");
		return jdbcTemplate.update(MEMBER_DELETE, userid, password);
	}
	
	//회원 검색
	public MemberVO isLogin(String userid, String password) {
		System.out.println("======> Spring JDBC GET 처리");
		Object info[] = {userid, password};
		return jdbcTemplate.queryForObject(MEMBER_GET, info, new MemberRowMapper());	
	}	
}

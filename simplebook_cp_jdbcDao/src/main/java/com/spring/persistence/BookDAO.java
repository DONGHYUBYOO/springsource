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
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.spring.domain.BookVO;

@Repository
public class BookDAO extends JdbcDaoSupport {
	
//	@Autowired	
//	private DataSource ds;
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
	private final String BOOK_INSERT="insert into bookTBL values(?,?,?,?)";
	private final String BOOK_UPDATE="update bookTBL set price=? where code=?";
	private final String BOOK_DELETE="delete from bookTBL where code=?";
	private final String BOOK_LIST="select * from bookTBL";
	private final String BOOK_GET="select * from bookTBL where code=?";
	
	
	@Autowired
	public void setSuperDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}	
	
	//책 리스트
	public List<BookVO> getList(){
		System.out.println("======> Spring JDBC_DAO SELECT 처리");
		return getJdbcTemplate().query(BOOK_LIST, new BookRowMapper());
		
//		List<BookVO> list = new ArrayList<>();
//		BookVO vo=null;
//		
//		String sql="select * from bookTBL";
//		try(Connection con=ds.getConnection();
//				PreparedStatement pstmt=con.prepareStatement(sql);
//				ResultSet rs=pstmt.executeQuery()) {
//			
//			while(rs.next()) {
//				vo = new BookVO();
//				vo.setCode(rs.getString("code"));
//				vo.setTitle(rs.getString("title"));
//				vo.setWriter(rs.getString("writer"));
//				vo.setPrice(rs.getInt("price"));
//				list.add(vo);
//			}			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
	}
	
	//책 검색
	public BookVO getBook(String code) {
		System.out.println("======> Spring JDBC_DAO GET 처리");
		Object info[]= {code};
		return getJdbcTemplate().queryForObject(BOOK_GET, info, new BookRowMapper());
	}
	
	//책 등록
	public int insertBook(BookVO vo) {
		System.out.println("======> Spring JDBC_DAO INSERT 처리");
		return getJdbcTemplate().update(BOOK_INSERT, vo.getCode(), vo.getTitle(), vo.getWriter(), vo.getPrice());
	}
	
	//책 가격 수정
	public int updateBook(int price, String code) {
		System.out.println("======> Spring JDBC_DAO UPDATE 처리");
		return getJdbcTemplate().update(BOOK_UPDATE, price, code);
	}
	
	//책 삭제
	public int deleteBook(String code) {
		System.out.println("======> Spring JDBC_DAO DELETE 처리");
		return getJdbcTemplate().update(BOOK_DELETE, code);
	}
}

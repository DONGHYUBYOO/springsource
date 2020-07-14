package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.domain.BoardVO;

//@Component
@Repository
public class BoardDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT="insert into spring_board(bno, title, content, writer) values(seq_board.nextval, ?, ?, ?)";
	private final String BOARD_LIST="select * from spring_board";
	private final String BOARD_GET="select * from spring_board where bno=?";
	private final String BOARD_UPDATE="update spring_board set title=?, content=? where bno=?";
	private final String BOARD_DELETE="delete from spring_board where bno=?";
	/*static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="javadb";
		String password="12345";
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	public int insertArticle(BoardVO vo) {
		System.out.println("======> Spring JDBC INSERT 처리");
		int result=jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getContent(), vo.getWriter());
//		String sql="insert into spring_board(bno, title, content, writer) values(seq_board.nextval, ?, ?, ?)";
//		try(Connection con=ds.getConnection();
//				PreparedStatement pstmt=con.prepareStatement(sql)) {
//			con.setAutoCommit(false);
//			pstmt.setString(1, vo.getTitle());
//			pstmt.setString(2, vo.getContent());
//			pstmt.setString(3, vo.getWriter());
//			
//			result=pstmt.executeUpdate();
//			if(result>0) {
//				con.commit();
//			}
//		} catch (Exception e) {
////			con.rollback();
//			e.printStackTrace();
//		}		
		return result;
	}
	
	public List<BoardVO> getList(){
		System.out.println("======> Spring JDBC SELECT 처리");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		
//		List<BoardVO> list = new ArrayList<>();
//		BoardVO vo=null;
//		
//		String sql="select * from spring_board";
//		try(Connection con=ds.getConnection();
//				PreparedStatement pstmt=con.prepareStatement(sql);
//				ResultSet rs=pstmt.executeQuery()) {
//			
//			while(rs.next()) {
//				vo = new BoardVO();
//				vo.setBno(rs.getInt("bno"));
//				vo.setTitle(rs.getString("title"));
//				vo.setContent(rs.getString("content"));
//				vo.setWriter(rs.getString("writer"));
//				vo.setRegdate(rs.getDate("regdate"));
//				vo.setUpdatedate(rs.getDate("updatedate"));
//				list.add(vo);
//			}			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//		return list;
	}
	
	//게시글 수정
	public int updateArticle(BoardVO vo) {
		System.out.println("======> Spring JDBC UPDATE 처리");		
		return jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getBno());
	}
	
	//게시글 삭제
	public int deleteArticle(BoardVO vo) {
		System.out.println("======> Spring JDBC DELETE 처리");		
		return jdbcTemplate.update(BOARD_DELETE, vo.getBno());
	}
	
	//게시글 하나 가져오기
	public BoardVO getArticle(int bno) {
		System.out.println("======> Spring JDBC GET 처리");
		Object args[]= {bno};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
}

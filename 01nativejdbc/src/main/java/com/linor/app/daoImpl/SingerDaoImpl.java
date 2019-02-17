package com.linor.app.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.linor.app.dao.SingerDao;
import com.linor.app.entity.Singer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingerDaoImpl implements SingerDao {
	private Connection getConnection() throws SQLException{
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			log.error("DB 드라이버 로드 에러!!", e);
			return null;
		}
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/spring?currentSchema=public", "spring", "spring1234");
	}
	
	private void closeConnection(Connection con) {
		if(con == null) {
			return;
		}
		try {
			con.close();
		}catch(SQLException e) {
			log.error("DB 연결 종료 에러!!", e);
		}
	}
	@Override
	public List<Singer> findAll() {
		List<Singer> singers = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = this.getConnection();
			stmt = con.prepareStatement("select * from singer");
			rs = stmt.executeQuery();
			while(rs.next()) {
				Singer singer = new Singer();
				singer.setId(rs.getInt("id"));
				singer.setFirstName(rs.getString("first_name"));
				singer.setLastName(rs.getString("last_name"));
				singer.setBirthDate(rs.getDate("birth_date"));
				singers.add(singer);
			}
			stmt.close();
		}catch(SQLException e) {
			log.error("SELECT문 실행 중 오류 발생!!", e);
		}finally {
			if(rs != null) try{rs.close();}catch(SQLException e) {}
			if(stmt != null) try{stmt.close();}catch(SQLException e) {}
			this.closeConnection(con);
		}
		return singers;
	}

	@Override
	public List<Singer> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findNameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findFirstNameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Singer singer) {
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs = null;
		try {
			con = this.getConnection();
			stmt = con.prepareStatement("insert into singer(id, first_name, last_name, birth_date)\n"+
					"values(default, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, singer.getFirstName());
			stmt.setString(2, singer.getLastName());
			stmt.setDate(3, new java.sql.Date(singer.getBirthDate().getTime()));
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				singer.setId(rs.getInt(1));
			}
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			log.error("ISERT문 실행중 오류발생 !!", e);
		}finally {
			if(rs != null) try{rs.close();}catch(SQLException e) {}
			if(stmt != null) try{stmt.close();}catch(SQLException e) {}
			this.closeConnection(con);
		}
	}

	@Override
	public void update(Singer singer) {
		Connection con = null;
		PreparedStatement stmt=null;
		try {
			con = getConnection();
			stmt =
					con.prepareStatement("UPDATE SINGER\n" + 
							"SET    FIRST_NAME = :FIRST_NAME,\n" + 
							"       LAST_NAME  = :LAST_NAME,\n" + 
							"       BIRTH_DATE = :BIRTH_DATE\n" + 
							"WHERE  ID         = :ID\n");
			stmt.setString(1, singer.getFirstName());
			stmt.setString(2, singer.getLastName());
			stmt.setDate(3, (Date) singer.getBirthDate());
			stmt.setLong(4, singer.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			log.error("UPDATE 실행중 오류!", e);
		}finally {
			if(stmt != null) try{stmt.close();}catch(SQLException e) {}
			closeConnection(con);
		}
	}

	@Override
	public void delete(int singerId) {
		Connection con = null;
		PreparedStatement stmt=null;
		try {
			con = getConnection();
			stmt =
					con.prepareStatement("delete from singer where id = ?");
			stmt.setLong(1, singerId);
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			log.error("DELETE 실행중 오류!", e);
		}finally {
			if(stmt != null) try{stmt.close();}catch(SQLException e) {}
			closeConnection(con);
		}
	}

	@Override
	public List<Singer> findAllWithAlbums() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertWithAlbum(Singer singer) {
		// TODO Auto-generated method stub

	}

}

package com.linor.app.dao;

import java.util.List;

import com.linor.app.entity.Singer;

public interface SingerDao {
	List<Singer> findAll();
	List<Singer> findByFirstName(String firstName);
	String findNameById(int id);
	String findFirstNameById(int id);
	void insert(Singer singer);
	void update(Singer singer);
	void delete(int singerId);
	List<Singer> findAllWithAlbums();
	void insertWithAlbum(Singer singer);
}

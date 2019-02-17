package com.linor.app.daoImpl;

import java.util.List;

import com.linor.app.dao.SingerDao;
import com.linor.app.entity.Singer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingerDaoImpl implements SingerDao {

	@Override
	public List<Singer> findAll() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Singer singer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int singerId) {
		// TODO Auto-generated method stub

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

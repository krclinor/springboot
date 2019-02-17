package com.linor.app.dao.test;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import com.linor.app.dao.SingerDao;
import com.linor.app.daoImpl.SingerDaoImpl;
import com.linor.app.entity.Singer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingerDaoTest {
	private SingerDao singerDao;
	
	public void setUp() {
		singerDao = new SingerDaoImpl();
	}
	
	@Test
	public void testFindAll() {
		List<Singer> singers = singerDao.findAll();
		assertNull(singers);
		log.info("등록된 가수가 없습니다");
	}
}

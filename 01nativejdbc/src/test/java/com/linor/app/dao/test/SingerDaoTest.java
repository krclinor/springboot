package com.linor.app.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.linor.app.dao.SingerDao;
import com.linor.app.daoImpl.SingerDaoImpl;
import com.linor.app.entity.Singer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingerDaoTest {
	private SingerDao singerDao;
	
	@Before
	public void setUp() {
		singerDao = new SingerDaoImpl();
	}
	
	@Test
	public void testFindAll() {
		List<Singer> singers = singerDao.findAll();
		assertNotNull(singers);
		assertTrue(singers.size() == 3);
		log.info("가수목록");
		listSingers(singers);
		
		Singer singer = new Singer();
		singer.setFirstName("길동");
		singer.setLastName("홍");
		singer.setBirthDate(new Date((new GregorianCalendar(1991, 0, 1)).getTime().getTime()));
		singerDao.insert(singer);
		
		singers = singerDao.findAll();
		assertTrue(singers.size() == 4);
		log.info("가수 추가 후 가수 목록");
		listSingers(singers);
		
		singerDao.delete(singer.getId());
		singers = singerDao.findAll();
		assertTrue(singers.size() == 3);
		log.info("가수 삭제 후 가수 목록");
		listSingers(singers);
	}
	private void listSingers(List<Singer> singers){
		for(Singer singer: singers){
			log.info(singer.toString());
		}
	}

}

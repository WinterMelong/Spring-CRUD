package com.study.ex01;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.domain.BoardVO;
import com.study.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
//Root-Context 참조하기
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class BoardDAOTest {

	@Inject
	private BoardDAO dao;

	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Test
	public void testCreate() throws Exception {
		BoardVO board = new BoardVO();
		board.setTitle("새로운 글을 넣습니다. ");
		board.setContent("새로운 글을 넣습니다. ");
		board.setWriter("user00");
		dao.create(board);
	}

	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(17).toString());
	}

	@Test
	public void testUpdate() throws Exception {
		BoardVO board = new BoardVO();
		board.setBno(17);
		board.setTitle("수정된 글 입니다.");
		board.setContent("수정 테스트 ");
		dao.update(board);
	}

	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
}

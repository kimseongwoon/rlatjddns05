package org.zerock.springex.mapper;

import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {
	String getTime();
	// 할일 등록
	void insert(TodoVO todoVO);
	// 할일 리스트 조회
	List<TodoVO> selectAll();
	// 할일 상세 조회
	TodoVO selectOne(Long tno);
	// 할일 삭제
	void delete(Long tno);
	// 할일 수정
	void update(TodoVO todoVO);
	
	// 페이징 기능으로 할일 리스트 조회
	List<TodoVO> selectList(PageRequestDTO pageRequestDTO);
	// 리스트 전체 개수 조회
	int getCount(PageRequestDTO pageRequestDTO);
}

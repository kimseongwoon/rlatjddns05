package org.zerock.t9.todo.service;

import org.modelmapper.ModelMapper;
import org.zerock.t9.todo.dao.TodoDAO;
import org.zerock.t9.todo.dto.TodoDTO;
import org.zerock.t9.todo.util.MapperUtil;
import org.zerock.t9.todo.vo.TodoVO;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.time.LocalDate;

public enum TodoService {
	INSTANCE;		// 싱글톤 패턴을 위한 변수

	private TodoDAO dao;
	private ModelMapper modelMapper;

	TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }
	
	/**
	 * 실제 Todo내용을 메모리에 저장
	 * @param todoDTO
	 */
	public void register(TodoDTO todoDTO) {
		System.out.println("DEBUG....... " + todoDTO);
	}
	
	/**
	 * 임의 Todo 10개 객체로 리스트 조회
	 * @return
	 */
	public List<TodoDTO> getList() {
		// 강제로 10개의 Todo객체를 생성
		List<TodoDTO> todoDTOS = IntStream.range(0, 10).mapToObj(i -> {
			TodoDTO dto = new TodoDTO();
			dto.setTno((long)i);
			dto.setTitle("Todo.." + i);
			dto.setDueDate(LocalDate.now());
			
			return dto;
		}).collect(Collectors.toList());
		
		return todoDTOS;
	}
	
	public TodoDTO get(Long tno){
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }

	public List<TodoDTO> listAll()throws Exception {
		List<TodoVO> voList = dao.selectAll();

//		log.info("voList.................");
//		log.info(voList);

		List<TodoDTO> dtoList = voList.stream()
				.map(vo -> modelMapper.map(vo,TodoDTO.class))
				.collect(Collectors.toList());

		return dtoList;
	}
}

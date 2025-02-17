package org.zerock.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.springex.domain.TodoVO;
import org.zerock.springex.dto.PageRequestDTO;
import org.zerock.springex.dto.PageResponseDTO;
import org.zerock.springex.dto.TodoDTO;
import org.zerock.springex.mapper.TodoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServicelmpl  implements TodoService  {
	private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
        log.info(modelMapper);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class );

        log.info(todoVO);

        todoMapper.insert(todoVO);
    }
    
    @Override
    public List<TodoDTO> getAll() {
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }
    
    @Override
    public TodoDTO getOne(Long tno) {
        TodoVO todoVO = todoMapper.selectOne(tno);
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);

        return todoDTO;
    }
    
    @Override
    public void remove(Long tno) {
        todoMapper.delete(tno);
    }
    
    @Override
    public void modify(TodoDTO todoDTO) {
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class );

        todoMapper.update(todoVO);
    }
    
    @Override
    public PageResponseDTO getList(PageRequestDTO pageRequestDTO) {
    	// 사용자에게 page 요청 정보에 맞게 할일 리스트를 보여줄 정보들
    	List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);
    	// view에 전달하기 위해 VO -> DTO로 변경
    	List<TodoDTO> dtoList = voList.stream()
                 .map(vo -> modelMapper.map(vo, TodoDTO.class))
                 .collect(Collectors.toList());
    	// 할일 전체 개수 조회
    	int total = todoMapper.getCount(pageRequestDTO);
    	 
    	// PageResponseDTO 객체로 변경
    	PageResponseDTO pageResponseDTO = PageResponseDTO.builder()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;

    }
}

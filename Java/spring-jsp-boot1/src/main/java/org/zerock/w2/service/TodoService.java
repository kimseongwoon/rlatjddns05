package org.zerock.w2.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.TodoDAO;
import org.zerock.w2.domain.TodoVO;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {
        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    /**
     * 할일 등록 기능 서비스
     * @return todoDTO
     * @throws Exception
     */
    public void register(TodoDTO todoDTO) throws Exception {
        // ModelMapper라이브러리를 이용해서 DTO -> VO로 변환하기
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        // 콘솔에 로그 찍기
        //System.out.println("todoVO: " + todoVO);
        log.info("todoVO: " + todoVO);

        dao.insert(todoVO);
    }

    /**
     * 할일 목록 조회 서비스
     * @return
     * @throws Exception
     */
    public List<TodoDTO> listAll() throws Exception {
        List<TodoVO> voList = dao.selectAll();
        log.info("voList.................");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo,TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    /**
     * 할일 상세조회 서비스
     * @param tno
     * @return
     * @throws Exception
     */
    public TodoDTO get(Long tno) throws Exception {
        log.info("tno: " + tno);

        // tno파라미터를 전달하여 DB에서 tno에 맞는 할일 정보를 VO 객체변수에 담아서 저장
        TodoVO todoVO = dao.selectOne(tno);
        // View에 전달하도록 VO 객체를 DTO객체로 변환작업
        TodoDTO todoDTO = modelMapper.map(todoVO, TodoDTO.class);

        return todoDTO;
    }

    /**
     * 할일 삭제 서비스
     * @param tno
     * @throws Exception
     */
    public void remove(Long tno) throws Exception {
        log.info("tno: " + tno);

        dao.deleteOne(tno);
    }

    /**
     * 할일 수정 서비스
     * @param todoDTO
     * @throws Exception
     */
    public void modify(TodoDTO todoDTO) throws Exception {
        log.info("todoDTO: " + todoDTO);

        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);

        dao.updateOne(todoVO);
    }
}

package org.zerock.w2.service;

import org.modelmapper.ModelMapper;
import org.zerock.w2.dao.MemberDAO;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.util.MapperUtil;
import org.zerock.w2.domain.MemberVO;

import lombok.extern.log4j.Log4j2;

@Log4j2
public enum MemberService {
	INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;
    
    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }
    
    // 실제 로그인 서비스 로직
    public MemberDTO login(String mid, String mpw) 
    		throws Exception {
    	MemberDTO memberDTO = null;
    	// DB에 접근해서 파라미터로 던진 mid와 mpw값으로 비교해서 값이 있으면 memberVO 객체 값이 있고
    	// 없으면 memberVO는 null이 됨
    	MemberVO memberVO = dao.getWithPassword(mid, mpw);
    	// VO -> DTO로 변환작업
    	memberDTO = modelMapper.map(memberVO, MemberDTO.class);
    	
    	return memberDTO;
    }
    
    public void updateUuid(String mid, String uuid)
    		throws Exception {
        dao.updateUuid(mid, uuid);
    }
    
    public MemberDTO getByUUID(String uuid) throws Exception {
        MemberVO vo = dao.selectUUID(uuid);
        MemberDTO memberDTO 
        	= modelMapper.map(vo, MemberDTO.class);

        return memberDTO;
    }
}

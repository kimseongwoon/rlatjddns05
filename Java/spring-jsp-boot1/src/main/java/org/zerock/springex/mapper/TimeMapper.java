package org.zerock.springex.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("select now()") // 해당 메소드가 실행되면 select now()가 실행되고 return값이 String으로 전달이 됨
    String getTime();  // DAO에서 불러올 메소드.

    @Select("selectbl_member where mid = 'user00'")
    String getMname();
}

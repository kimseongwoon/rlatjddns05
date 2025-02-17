package org.zerock.w2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.zerock.w2.domain.MemberVO;

import lombok.Cleanup;

public class MemberDAO {
	// id와 password가 일치하는 MemberVO 객체값을 가져오는 메소드
	public MemberVO getWithPassword(String mid, String mpw)
		throws Exception {
		MemberVO memberVO = null;
		
		String sqlQuery = "select mid, mpw, mname from tbl_member where mid = ? and mpw = ?";
		@Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, mid);
        preparedStatement.setString(2, mpw);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
		
        if(resultSet.next()) {
	        String id = resultSet.getString(1);  // sql에서 조회한 행이 있다면 mid값 가져오기
	        String pw = resultSet.getString(2);  // sql에서 조회한 행이 있다면 mpw값 가져오기
	        String name = resultSet.getString(3);  // sql에서 조회한 행이 있다면 mname값 가져오기
	        
	        //memberVO = new MemberVO(id, pw, name); 
	        memberVO = MemberVO.builder()
	        		.mid(id)
	        		.mpw(pw)
	        		.mname(name)
	        		.build();
        }
        
		return memberVO;
	}
	
	public void updateUuid(String mid, String uuid) 
			throws Exception {
		String sql = "update tbl_member set uuid =? where mid = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement =
                connection.prepareStatement(sql);

        preparedStatement.setString(1, uuid);
        preparedStatement.setString(2, mid);

        preparedStatement.executeUpdate();
	}
	
	// 쿠키의 값인 uuid값을 이용해서 사용자 조회
	public MemberVO selectUUID(String uuid)
		throws Exception {
		MemberVO memberVO = null;
		
		String query = "select mid, mpw, mname, uuid from tbl_member where uuid = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement =
                connection.prepareStatement(query);
        preparedStatement.setString(1, uuid);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next())
	        memberVO = MemberVO.builder()
	                .mid(resultSet.getString(1))
	                .mpw(resultSet.getString(2))
	                .mname(resultSet.getString(3))
	                .uuid(resultSet.getString(4))
	                .build();
		
		return memberVO;
	}
}

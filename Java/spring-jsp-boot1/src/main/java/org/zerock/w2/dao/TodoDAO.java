package org.zerock.w2.dao;

import lombok.Cleanup;
import org.zerock.w2.domain.TodoVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {
    /**
     * DB의 현재시간 가져오는 쿼리로 현재시간 가져오기
     * @return now
     */
    public String getTime() {
        String now = null;

        try(
            Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select now()");
            ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            // 실제 로직 처리. 여기서는 현재 시간 출력하는 코드로 대신
            resultSet.next();

            now = resultSet.getString(1);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return now;
    }

    /**
     * DB의 현재시간 가져오는 쿼리로 현재시간 가져오기(with 롬복의 @Cleanup사용)
     * @return
     * @throws Exception
     */
    public String getTime2() throws Exception {
        // @Cleanup 붙여주면 항상 메소드가 끝이 날 때 close()메소드 호출해주는 기능
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        // 실제 로직 처리. 여기서는 현재 시간 출력하는 코드로 대신
        resultSet.next();

        return resultSet.getString(1);
    }

    /**
     * 할 일 등록 기능 메소드(함수)
     * @param vo
     * @throws Exception
     */
    public void insert(TodoVO vo) throws Exception {
        String sql = "insert into tbl_todo (title, due_date, finished) values (?, ?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, vo.getTitle());
        preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
        preparedStatement.setBoolean(3, vo.isFinished());

        preparedStatement.executeUpdate();
    }

    /**
     * 할일 리스트 조회하기
     * @return
     * @throws Exception
     */
    public List<TodoVO> selectAll() throws Exception {
        String sql = "select * from tbl_todo order by due_date desc";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<TodoVO> list = new ArrayList<>();

        while(resultSet.next()) {
            TodoVO vo = TodoVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate( resultSet.getDate("due_date").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();

            list.add(vo);
        }

        return list;
    }

    /**
     * 할일 상세조회 기능
     * @param tno
     * @return
     * @throws Exception
     */
    public TodoVO selectOne(Long tno) throws Exception {
        String sql = "select * from tbl_todo where tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        TodoVO vo = TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("due_date").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();

        return vo;
    }

    public void deleteOne(Long tno) throws Exception {

        String sql = "delete from tbl_todo where tno = ?";

        @Cleanup Connection    connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1, tno);

        preparedStatement.executeUpdate();
    }

    public void updateOne(TodoVO todoVO)throws Exception{

        String sql = "update tbl_todo set title =?, due_date = ?, finished = ? where tno =?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, todoVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(todoVO.getDueDate()));
        preparedStatement.setBoolean(3, todoVO.isFinished());
        preparedStatement.setLong(4, todoVO.getTno());

        preparedStatement.executeUpdate();
    }
}

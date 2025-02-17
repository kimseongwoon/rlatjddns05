package ch15.exercise.problem7;

import java.util.*;
 
public class ListExample {
	 
	public static void main(String[] args) {
		// DAO(BoardDAO): Data Access Object
		//   cf) DTO(Board): Data Transfer OBject
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		for(Board board : list) {
			System.out.println(board.getTitle() + "-" + board.getContent());
		}

	}
}

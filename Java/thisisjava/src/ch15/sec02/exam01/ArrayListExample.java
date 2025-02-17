package ch15.sec02.exam01;

import java.util.*;

public class ArrayListExample {
	
	public static void main(String[] args) {
		// Board 클래스로 ArrayList 컬렉션 생성
		List<Board> list = new ArrayList<>();
		
		// add함수로 객체 추가
		list.add(new Board("제목1", "내용1", "글쓴이1")); // 인덱스 0
		list.add(new Board("제목2", "내용2", "글쓴이2")); // 인덱스 1
		list.add(new Board("제목3", "내용3", "글쓴이3")); // 인덱스 2
		list.add(new Board("제목4", "내용4", "글쓴이4")); // 인덱스 3
		list.add(new Board("제목5", "내용5", "글쓴이5")); // 인덱스 4
		
		// 저장된 총 객체 수 조회
		int size = list.size();  // 5
		System.out.println("총 객체 수: " + size);
		System.out.println();
		
		// 특정 인덱스의 객체 가져오기(2인덱스의 값 객체 조회)
		Board board = list.get(2); // 제목이 '제목3'인 객체를 가져옴
		System.out.println(board.getSubject() + "\t" 
				+ board.getContent() + "\t" 
				+ board.getWriter());
		System.out.println();
		
		// 모든 객체를 하나씩 가져오기(how1)
		for(int i = 0; i < list.size(); i++) {
			Board b = list.get(i);
			System.out.println(b.getSubject() + "\t" 
					+ b.getContent() + "\t" 
					+ b.getWriter());
		}
		System.out.println();
		// 모든 객체를 하나씩 가져오기(how2)
		for(Board b : list) {
			System.out.println(b.getSubject() + "\t" 
					+ b.getContent() + "\t" 
					+ b.getWriter());
		}
		System.out.println();
		
		// 리스트 객체 삭제
		list.remove(2);  // 1. 2인덱스를 삭제, 2. 뒤에 있는 객체들을 앞으로 당김
		list.remove(2);  // 1. 2인덱스를 삭제, 2. 뒤에 있는 객체들을 앞으로 당김
		// 결국 2,3인덱스가 삭제가 됨
		for(Board b : list) {
			System.out.println(b.getSubject() + "\t" 
					+ b.getContent() + "\t" 
					+ b.getWriter());
		}
		System.out.println();
		
		// 리스트 객체 수정(0인덱스의 객체 제목을 변경)
		Board updateBoard = list.get(0);
		updateBoard.setSubject("제목바꿈");
		for(Board b : list) {
			System.out.println(b.getSubject() + "\t" 
					+ b.getContent() + "\t" 
					+ b.getWriter());
		}
	}
}



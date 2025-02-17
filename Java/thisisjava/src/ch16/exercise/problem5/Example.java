package ch16.exercise.problem5;

import ch16.sec02.exam02.Button;

public class Example {
	
	public static void main(String[] args) {
		// Ok버튼
				Button btnOk = new Button();
				btnOk.setClickListener(() -> {
					System.out.println("Ok 버튼을 클릭했습니다.");
				});
				// 실제 Ok버튼 클릭
				btnOk.click();
				
				//Cancel 버튼 객체 생성
				Button btnCancel = new Button();
				//Cancel 버튼 객체에 람다식(ClickListener 익명 구현 객체) 주입
				btnCancel.setClickListener(() -> {
					System.out.println("Cancel 버튼을 클릭했습니다.");
				});
				//Cancel 버튼 클릭하기
				btnCancel.click();

	}
}

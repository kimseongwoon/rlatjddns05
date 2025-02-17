package ch16.exercise.problem5;

public class Button {
	@FunctionalInterface
	public static interface ClickListener {
		void onClick();
	}
	
	private ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	// 실제 클릭 메소드
	public void click() {
		this.clickListener.onClick();
	}
}

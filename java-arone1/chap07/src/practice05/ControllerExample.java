package practice05;

public class ControllerExample {
	public static void main(String[] args) {
		/*
		Controller controller = new Controller();
		controller.setService();
		*/
		
		Controller controller = new Controller();
		controller.setService(new MemberService());
		controller.service.login(); // 멤버 로그인

		controller.setService(new AService());
		controller.service.login(); // A 로그인
	}
}

package practice04;

public class MemberService {
	int a;	// 인스턴스 멤버 변수
	
	public boolean login(String id, String password) { // 인스턴스 멤버 메소드
		if (id.equals("hong") && password.equals("12345"))
			return true;
		
		return false;
	}
	
	public void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
}
package ch16.sec05.exam02;

public class ContructorReferenceExample {

	public static void main(String[] args) {
		Person person = new Person();
		
		// 생성자 참조
		Member member1 = person.getMember1(Member::new);
		// 일반 람다 사용
		Member member2 = person.getMember1(memberStr -> {
			return new Member(memberStr);
		});
		System.out.println(member1);
		System.out.println(member2);

		// 생성자 참조
		Member member3 = person.getMember2(Member::new);
		// 일반 람다 사용
		Member member4 = person.getMember2(
				(memberId, memberName) -> {
					return new Member(memberId, memberName);
		});
		System.out.println(member3);
		System.out.println(member4);
	}
}

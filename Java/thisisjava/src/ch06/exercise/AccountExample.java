package ch06.exercise;

public class AccountExample {
	
	public static void main(String[] args) {
		Account account = new Account();
		
		account.setBalance(10000);
		// 현재 잔고: 10000
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(-100);
		// 현재 잔고: 10000
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(2000000);
		// 현재 잔고: 10000
		System.out.println("현재 잔고: " + account.getBalance());
		
		account.setBalance(300000);
		// 현재 잔고: 300000
		System.out.println("현재 잔고: " + account.getBalance());
	}

}

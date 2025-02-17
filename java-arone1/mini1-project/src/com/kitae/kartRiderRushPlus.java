package com.kitae;

import java.util.Random;
import java.util.Scanner;

public class kartRiderRushPlus {
	public static void main(String[] args) {
		final int TRACK_LENGTH = 100;
		int player1position = 0;
		int player2position = 0;
		Random random = new Random();
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("카트라이더 러쉬플러스 미니 게임 시작!");
		
		while (player1position < TRACK_LENGTH && player2position < TRACK_LENGTH) { 
			System.out.println("Enter를 눌러서 주행하세요...");
			scanner.nextLine();
			
			int player1Move = random.nextInt(10) + 1; // 1에서 10 사이의 난수 
	        int player2Move = random.nextInt(10) + 1; // 1에서 10 사이의 난수 
	        
	        player1position += player1Move;
	        player2position += player2Move;
	        
	        System.out.println("플레이어 1이 " + player1Move + " 만큼 전진했습니다. 현재 위치: " + player1position);
		    System.out.println("플레이어 2가 " + player2Move + " 만큼 전진했습니다. 현재 위치: " + player2position);
		}
		
		if (player1position >= TRACK_LENGTH && player2position >= TRACK_LENGTH) {
			System.out.println("무승부입니다!");
		} else if (player1position >= TRACK_LENGTH) {
			System.out.println("플레이어 1이 승리했습니다!");
	    } else { 
	    	System.out.println("플레이어 2이 승리했습니다!");
	    }
	    
		scanner.close();
	}
}

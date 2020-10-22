package study_baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SQ5567_결혼식 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//하객수
		int guestCount = 0;
		
		//동기 수
		int friends = in.nextInt();
		
		//리스트의 길이 m
		int relation = in.nextInt();
		
		//boolean 1byte
		List<Integer> sanglist = new ArrayList<Integer>();
		List<Integer> ffList = new ArrayList<Integer>();
		
		//친구관계를 저장할 2차원 int배열
		int[][] friendsList = new int[relation][2];
		//친구관계 입력
		for(int i=0; i<relation; i++) {
			friendsList[i][0] = in.nextInt();
			friendsList[i][1] = in.nextInt();
		}
		
		//상근이 친구 추가
		for(int i=0; i<friendsList.length; i++) {
			if(friendsList[i][0] == 1) {
				sanglist.add(friendsList[i][1]);
				guestCount++;
			}
		}
		
		//상근이 친구의 친구 추가
		for(int i=0; i<sanglist.size(); i++) {
			int friend = sanglist.get(i);
			for(int j=0; j<friendsList.length; j++) {
				if(friend == friendsList[j][0] && !sanglist.contains(friendsList[j][1]) && !ffList.contains(friendsList[j][1])){
					ffList.add(friendsList[j][1]);
					guestCount++;
				}
			}
		}
		
		System.out.println(guestCount);
	}
	//친구의친구의친구까지 된다.
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		
//		//하객 수
//		int answer = 0;
//		
//		//첫째줄 : 상근이의 동기 수 n
//		int friends = in.nextInt();
//		
//		//둘째줄 : 리스트의 길이 m
//		int relationshipNum = in.nextInt();
//		
//		//다음줄부터 m개의 줄에는 친구관계 ai, bi 주어짐
//		//ai와 bi가 친구라는 뜻
//		//상근이 녀석은 뻔뻔하게도 자신의 친구와 친구의 친구를 초대하기로 했다.
//		
//		//친구관계를 저장할 2차원 int배열
//		int[][] relationshipList = new int[relationshipNum][2];
//	
//		//친구의 친구를 찾을 리스트
//		boolean[] inviteList = new boolean[friends]; 
//		
//		for(int i=0; i<relationshipNum; i++) {
//			relationshipList[i][0] = in.nextInt();
//			relationshipList[i][1] = in.nextInt();
//		}
//		
//		for(int i=0; i<relationshipNum; i++) {
//			//상근이의 친구 체크
//			if(relationshipList[i][0] == 1) {
//				inviteList[relationshipList[i][1]] = true;
//			}
//		}
//		
//		for(int i=0; i<inviteList.length; i++) {
//			//친구의 친구 체크
//			if(inviteList[i]){
//				for(int j=0; j<relationshipList.length; j++) {
//					if(relationshipList[j][0] == i) {
//						inviteList[relationshipList[j][1]] = true;
//					}
//				}
//			}
//		} 
//		
//		for(int i=0; i<inviteList.length; i++) {
//			if(inviteList[i]) {
//				answer++;
//			}
//		}
//		System.out.println(answer);		
//	}
}
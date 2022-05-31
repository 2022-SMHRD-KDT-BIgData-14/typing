package gameplay;

import java.util.Scanner;

import rank.rankViewDAO;

public class Gameplay {

	public void gamePlay() {
		GameOption model = new GameOption();
		Scanner sc = new Scanner(System.in);
		int[] bossHp = {10000, 15000,20000, 25000, 30000, 35000, 40000, 45000, 50000,55000};
		int bossAtt = 5;
		int heroHp = 200;
		int heroDef = 4;
		int heroAtt = 50;
		int round =1;
		int i =0;
		rankViewDAO rankview = new rankViewDAO();
		while (true) {
			System.out.println("ROUND"+round++);
			System.out.println("============================================");
// 타이핑 공격
			int cnt =0;
			while (bossHp[i] > 0) {
				int fever =1;
// hp바  
				System.out.println("남은 보스 체력 : " + bossHp[i]);
				int hpBar = bossHp[i] / 1000;
				for (int j = 0; j < hpBar + 1; j++) {
					System.out.print("■");
				}
				for (int j = 0; j < 10 - hpBar; j++) {
					System.out.print("□");
				}
				System.out.println();
//-------------------------------------------------------				
				int attack = (int) model.typingSec() * heroAtt *fever;
				// fever 버프
				if((int) model.typingSec()!=0) {
					cnt++;
				}
				else {
					cnt=0;
				}
				if(cnt==5) {
					System.out.println("5연속 공격 성공 && 공격력 강화!!!");
					fever++;
				}
				bossHp[i] -= attack;
// 방어하기		
				heroHp -= bossAtt - heroDef;
				System.out.println("벌레체력 : " + heroHp);
				if (heroHp <= 0) {
					System.out.println("YOU die");
					break;
				}
				
			}
			if (heroHp <= 0) {
				break;
			}
			i++;
			System.out.println("==============클리어==============");
			System.out.println("[1]다음 라운드  [2]랭킹 등록  [3]종료");
			int input =sc.nextInt();
			if(input==3) {
				break;
			}
			else if(input ==2) {
				rankview.rankView();
			}
		}

	}
}

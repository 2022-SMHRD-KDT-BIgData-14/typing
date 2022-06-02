package gameplay;

import java.util.Scanner;

import character.CharacterDTO;
import javazoom.jl.player.MP3Player;
import rank.rankViewDAO;

public class Gameplay {

	public int gamePlay(CharacterDTO charNic) {
		GameOption option = new GameOption();
		GameDAO dao = new GameDAO();
		Scanner sc = new Scanner(System.in);
		dao.connect();
		MP3Player mp3 = new MP3Player();
	
		int[] bossHp = {10000, 15000,20000, 25000, 30000, 35000, 40000, 45000, 50000,55000};
		int bossAtt = 120;
		int heroHp = dao.characterStat(3,charNic);
		int heroDef = dao.characterStat(2,charNic);
		int heroAtt = dao.characterStat(1,charNic);
		int round =1;
		int i =0;
		int turn =1;
		dao.close();

	
		
// 타이핑 공격
		while (true) {
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(".\\music\\게임진행1_사용자턴 배경음.mp3");
			
			System.out.println("ROUND"+round++);
			System.out.println("============================================");
			int cnt =0;
			turn=1;
			while (bossHp[i] > 0) {
				System.out.println("==============="+turn+"턴===============");
				turn++;
				int fever =1;
// hp바  		
				option.HpBar(bossHp[i], i);
//-------------------------------------------------------				
				int typingAtt=(int) option.typingSec();
				int attack = typingAtt * heroAtt *fever;
				// fever 버프
				if(typingAtt!=0) {
					cnt++;
				}
				else {
					cnt=0;
				}
				if(cnt>=5) {
					System.out.println(cnt+"연속 공격 성공 && 공격력 강화!!!");
					fever++;
				}
				bossHp[i] -= attack;
// 방어하기		
				heroHp -= (bossAtt - heroDef);
				System.out.println("벌레체력 : " + heroHp);
				if (heroHp <= 0) {
					System.out.println("YOU die");
					break;
				}
				
			}
			if (heroHp <= 0) {
				if(mp3.isPlaying()) {
					mp3.stop();
				}
				System.out.println("게임이 종료되었습니다");
				mp3.play(".\\music\\게임종료화면 배경음.mp3");
				break;
			}
			i++;
			System.out.println("=============="+round+"라운드 클리어==============");
			
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(".\\music\\게임진행3_라운드상승 배경음.mp3");
			
			System.out.println("[1]다음 라운드    [2]종료");
			int input =sc.nextInt();
			if(input==2) {
				break;
			}
		}
		return round;
	}
}

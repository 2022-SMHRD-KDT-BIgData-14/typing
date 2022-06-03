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
		CharacterDTO dto = new CharacterDTO();
		GameVO gvo = new GameVO(0,true);

		int[] bossHp = { 15000, 17000, 19000, 23000, 26000, 30000, 34000, 38000, 43000, 48000 };
		int bossAtt = 20;
		int heroHp = dao.characterStat(3, charNic);
		int heroDef = dao.characterStat(2, charNic);
		int heroAtt = dao.characterStat(1, charNic);
		int round = 1;
		int i = 0;
		int turn = 1;
		dao.close();

// 타이핑 공격
		while (true) {
			if (mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(".\\music\\게임진행1_사용자턴 배경음.mp3");

			System.out.println("== 현재 라운드 : " + round++ + "|| 전체 라운드 : 10 ==");
			System.out.println("===================================");
			int cnt = 0;
			turn = 1;
			while (bossHp[i] > 0) {
				System.out.println("================" + turn + "턴================");
				turn++;
				int fever = 1;
// hp바  		
				option.HpBar(bossHp[i], i);
				if (round == 2) {
					dto.boss1();
				}
				if (round == 3) {
					dto.boss2();
				}
				if (round == 4) {
					dto.boss3();
				}
				if (round == 5) {
					dto.boss4();
				}
				if (round == 6) {
					dto.boss5();
				}
				if (round == 7) {
					dto.boss6();
				}
				if (round == 8) {
					dto.boss7();
				}
				if (round == 9) {
					dto.boss8();
				}
				if (round == 10) {
					dto.boss9();
				}
				if (round == 11) {
					dto.boss10();
				}
				
				if (gvo.getStrEquals()) {
					System.out.println((int)gvo.getTypingSpeed() + "타");
				} else {
					System.out.println("Miss");
				} //
				gvo = option.typingSec();
				int typingAtt = (int)gvo.getTypingSpeed();
				int attack = typingAtt * heroAtt * fever;
				// fever 버프
				if (typingAtt != 0) {
					cnt++;
				} else {
					cnt = 0;
				}
				if (cnt >= 5) {
					System.out.println(cnt + "연속 공격 성공 && 공격력 강화!!!");
					fever++;
				}
				bossHp[i] -= attack;
// 방어하기		
				heroHp -= (bossAtt - heroDef);
				System.out.println("FBI 체력 : " + heroHp);
				if (heroHp <= 0) {
					dto.failask();
					break;
				}

			}
			if (heroHp <= 0) {
				if (mp3.isPlaying()) {
					mp3.stop();
				}
				System.out.println("게임이 종료되었습니다");
				mp3.play(".\\music\\게임종료화면 배경음.mp3");
				break;
			}
			i++;
			System.out.println("==============" + (round - 1) + "라운드 클리어==============");
			gvo = new GameVO(0,true);
			if (mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(".\\music\\게임진행3_라운드상승 배경음.mp3");

			if (round == 11) {
				dto.endingask();
				System.out.println();
				// 시간 남으면 시간으로 나오기
				String str = "돼지감자 퇴치이후 좀비 확찐자 바이러스는 영원히 소멸되었다.\r\n" + "잠시 혼란스러웠던 대관령은 모두의 협조를 통해 빠르게 복구되었고\r\n"
						+ "평화를 되찾았다.";
				char[] arr = new char[str.length()];

				try {
					for (int j = 0; j < str.length(); j++) {
						arr[j] = str.charAt(j);
						System.out.print(arr[j]);
						Thread.sleep(50);
					}
				} catch (InterruptedException e) {
				}
				System.out.println();
				break;
			}
			System.out.println("[1]다음 라운드    [2]종료");
			int input = sc.nextInt();
			if (input == 2) {
				break;
			}

		}
		return round;
	}
}

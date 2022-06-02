package gameplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import character.CharacterDAO;
import character.CharacterDTO;
import character.TEst;
import javazoom.jl.player.MP3Player;
import user.userDTO;

public class GameOption {
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	TEst test = new TEst();
	CharacterDAO cdao = new CharacterDAO();

//타이핑 속도 측정
	public long typingSec() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("감자");
		arr.add("고구마");
		arr.add("당근");
		arr.add("양배추");
		arr.add("딸기");
		arr.add("사과");
		arr.add("독수리");
		arr.add("마");
		int i = r.nextInt(arr.size());
		System.out.print(arr.get(i) + " >> ");
		long timeFirst = System.currentTimeMillis();
		String str = sc.next();
		long timeDif = System.currentTimeMillis() - timeFirst;
		long typing = str.length() * 5 * 6 / ((timeDif / 1000) + 1);
		System.out.println(typing + "타");
		if (arr.get(i).equals(str)) {
			return typing;
		} else {
			System.out.println("Miss");
			return 0;
		} //
	}

// 보스 체력바	
	public void HpBar(int bossHp, int i) {
		System.out.println("남은 보스 체력 : " + bossHp);
		int hpBar = bossHp / (1000 + 500 * i);
		for (int j = 0; j < hpBar + 1; j++) {
			System.out.print("■");
		}
		for (int j = 0; j < 10 - hpBar; j++) {
			System.out.print("□");
		}
		System.out.println();
	}

// 캐릭터 생성
	public CharacterDTO characterProduct(int num, String user_id) {

		while (true) {
			CharacterDTO cdto = test.mainchar();
			System.out.println("캐릭터 능력치를 돌리겠습니까");
			System.out.println("[1] 돌린다 [2] 이대로 간다");
			num = sc.nextInt();
			if (num == 2) {
				// 만든 캐릭터를 등록시킨다
				cdao.CharacterBuild(cdto, user_id);
				return cdto;
			}
		}
	}
}

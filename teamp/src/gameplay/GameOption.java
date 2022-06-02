package gameplay;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import character.CharacterDAO;
import character.CharacterDTO;
import character.CharacterGenerator;

public class GameOption {
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	CharacterGenerator charGenerator = new CharacterGenerator();
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
			CharacterDTO cdto = charGenerator.mainchar();
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
// 게임 오프닝 문구
	public void opening() {
		String str = "때는 20XX년\r\n" + "강원도 대관령에서 감자 품질향상 연구 진행 중\r\n"
				+ "연구원의 실수로 감자가 아닌 '돼지감자에 감자DNA를 투여하여 좀비 확찐자 바이러스가 발발'했다.\r\n"
				+ "한국정부는 좀비 확찐자 바이러스를 없애기위해 미국정부에 FBI 지원요청을 하여\r\n" + "좀비 확찐자 바이러스를 없애기 시작한다.";
		char[] arr = new char[str.length()];

		try {
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
				System.out.print(arr[i]);
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		System.out.println();
	}

}

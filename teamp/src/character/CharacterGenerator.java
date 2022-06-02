package character;

import java.util.Random;
import java.util.Scanner;

public class CharacterGenerator {

	String nickname;

	public String charNickname() {
		Scanner sc = new Scanner(System.in);
		System.out.println("캐릭터명을 입력하세요★");
		System.out.print("캐릭터명: ");
		nickname = sc.next();
		return nickname;
	}

	public CharacterDTO mainchar(String nickname) {
		int num = 1;
		int att = 0;
		int def = 0;
		int hp = 0;

		while (num == 1) {

			Random r = new Random();

			def = r.nextInt(10);
			System.out.println("방어력 : " + def);

			hp = 100000 + r.nextInt(10);
			System.out.println("체력: " + hp);
			att = 110000 - (def + hp);
			System.out.println("공격력 : " + att);

			break;

		}
		return new CharacterDTO(hp, att, def, nickname);

	}

}

package character;

import java.util.Random;

public class TEst {
	
	public void mainchar() {
		int num = 1;
		while(num == 1) {

		int[] stats = { 330, 340, 350 };
		Random r = new Random();
	
		if (stats[r.nextInt(3)] == 330) {
			int att = r.nextInt(110) + 71;
			System.out.println("공격력 : "+att);

			int def = r.nextInt(30) + 21;
			System.out.println("방어력 : "+def);

			int hp = 0;
			System.out.println("체력: "+(stats[0] - (att + def)));
			
			System.out.println("당신은 도적입니다");
			break;
			
		} else if (stats[r.nextInt(3)] == 340) {
			int att = r.nextInt(80) + 110;
			System.out.println("공격력 : "+att);

			int def = r.nextInt(50) + 51;
			System.out.println("방어력 : "+ def);

			int hp = 0;
			System.out.println("체력 : "+(stats[1] - (att + def)));
			
			System.out.println("당신은 마법사입니다");
			break;
			
		} else {
			int att = r.nextInt(70) + 71;
			System.out.println("공격력 : "+att);

			int def = r.nextInt(100) + 31;
			System.out.println("방어력 : "+def);

			int hp = 0;
			System.out.println("체력: "+(stats[2] - (att + def)));
		
			System.out.println("당신은 전사입니다");
			break;
		}

	}
	}
}

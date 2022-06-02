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

//Ÿ���� �ӵ� ����
	public long typingSec() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("����");
		arr.add("����");
		arr.add("���");
		arr.add("�����");
		arr.add("����");
		arr.add("���");
		arr.add("������");
		arr.add("��");
		int i = r.nextInt(arr.size());
		System.out.print(arr.get(i) + " >> ");
		long timeFirst = System.currentTimeMillis();
		String str = sc.next();
		long timeDif = System.currentTimeMillis() - timeFirst;
		long typing = str.length() * 5 * 6 / ((timeDif / 1000) + 1);
		System.out.println(typing + "Ÿ");
		if (arr.get(i).equals(str)) {
			return typing;
		} else {
			System.out.println("Miss");
			return 0;
		} //
	}

// ���� ü�¹�	
	public void HpBar(int bossHp, int i) {
		System.out.println("���� ���� ü�� : " + bossHp);
		int hpBar = bossHp / (1000 + 500 * i);
		for (int j = 0; j < hpBar + 1; j++) {
			System.out.print("��");
		}
		for (int j = 0; j < 10 - hpBar; j++) {
			System.out.print("��");
		}
		System.out.println();
	}

// ĳ���� ����
	public CharacterDTO characterProduct(int num, String user_id) {

		while (true) {
			CharacterDTO cdto = test.mainchar();
			System.out.println("ĳ���� �ɷ�ġ�� �����ڽ��ϱ�");
			System.out.println("[1] ������ [2] �̴�� ����");
			num = sc.nextInt();
			if (num == 2) {
				// ���� ĳ���͸� ��Ͻ�Ų��
				cdao.CharacterBuild(cdto, user_id);
				return cdto;
			}
		}
	}
}

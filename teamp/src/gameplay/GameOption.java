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
	GameDAO dao = new GameDAO();

	String[] bossname = { "���� ��", "���� �� ��", "���� �˰���", "���� ����ũ", "���� ������", "���� ���ܰ��", "���� ����", "���� ����", "���� ���ﰨ��",
			"���� ��������" };

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
		System.out.println("--"+arr.get(i) + "-- �Է���");
		for(int j=3 ; j>0; j--) {
			try {
			System.out.println(j);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
//				e.printStackTrace();
			}
		}
		System.out.println("�Է��ϼ���");
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

// ���� ü�¹�	, ��������
	public void HpBar(int bossHp, int i) {
		System.out.println("---" + bossname[i] + "---");
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
			CharacterDTO cdto = charGenerator.mainchar();
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

// ���� ������ ����
	public void opening() {
		String str = "���� 20XX��\r\n" + "������ ����ɿ��� ����ǰ�� ����� ���� �����ϴٰ�\r\n"
				+ "�������� �Ǽ��� ���ڰ��ƴ� �������ڿ� ����DNA�� �����Ͽ� ���� Ȯ���� ���̷����� �߹��ߴ�.\r\n"
				+ "���� Ȯ���� ���̷����� ���ֱ����� �ѱ����δ� �̱����ο� FBI ������û�� �Ͽ�\r\n" + "���� Ȯ���� ���̷����� ���ֱ� �����Ѵ�.";
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

// ĳ���� ���� ���
	public void characterView(String user_id) {
		dao.connect();
		dao.characterView(user_id);
		dao.close();
	}

}

package teamp;

import java.util.Scanner;

import character.CharacterDAO;
import character.CharacterDTO;
import character.CharacterGenerator;
import gameplay.GameOption;
import gameplay.Gameplay;
import rank.rankDAO;
import rank.rankDTO;
import rank.rankViewDAO;
import user.loginDAO;
import user.userDAO;
import user.userDTO;

public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		rankDAO rankdao = new rankDAO();
		rankViewDAO rankview = new rankViewDAO();
		View view = new View();
		Gameplay play = new Gameplay();
		CharacterDTO cdto;
		GameOption option = new GameOption();
		int num;
		String user_id = "";

		// �ʱ� ȭ��
		while (true) {
			System.out.println("[1]ȸ������ [2] �α��� [3] ����");
			num = sc.nextInt();

			// ����
			if (num == 3) {
				view.Exit();
			}
			// ȸ������
			else if (num == 1) {
				view.viewSign();
			}
			// �α���
			else if (num == 2) {
				if (view.viewlogin()) {
					user_id = view.getUser_id();
					break;
				}
			}
			// �߸� �Է� ������
			else {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
			}

		}
		// �α��� �� ȭ��
		while (num == 2) {
			System.out.println("[1]���ӽ��� [2] ��ŷ��ȸ [3]����");
			num = sc.nextInt();
			if (num == 1) {

				// ĳ���� ����
				cdto = option.characterProduct(num, user_id);

				// ���� ����
				int round = play.gamePlay(cdto);

				System.out.println("��ŷ�� ��� �Ͻðڽ��ϱ�");
				System.out.println("[1]��� [2]����");
				num = sc.nextInt();
				if (num == 1) {
					rankDTO rankdto = new rankDTO(cdto.getnickname(), round);
					rankdao.rankInsert(rankdto);
					System.out.println("��ŷ��� �Ϸ�");
				} else if (num == 2) {
					System.out.println("��ŷ���â ���� �մϴ�.");
				} else {
					System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				}
				num = 2;

			}
			// ��ŷ ��ȸ
			else if (num == 2) {
				rankview.rankView();
				num = 2;
			}
			// ���� ����
			else if (num == 3) {
				view.Exit();
				break;
			}
			// �߸� �Է� ������
			else {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				num = 2;
			}
		}

//		��ŷ ��Ϲ� ��ȸ //�������ɼ�����

		System.out.println("�ٺ�");

	}

}

package teamp;

import java.util.Scanner;

import character.CharacterDTO;
import gameplay.GameOption;
import gameplay.Gameplay;
import javazoom.jl.player.MP3Player;
import rank.rankDAO;
import rank.rankDTO;
import rank.rankViewDAO;

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
		MP3Player mp3 = new MP3Player();
		
		if(mp3.isPlaying()) {
			mp3.stop();
		}
		// �ʱ� ȭ��
		while (true) {
			
			mp3.play(".\\Music\\����ȭ�� �����.mp3");
			
			System.out.println("[1]ȸ������  [2]�α���  [3]����");
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
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(".\\music\\�޴����ý� ȿ����.mp3");
			System.out.println("[1]���ӽ���  [2]��ŷ��ȸ  [3]����");
			num = sc.nextInt();
			
			
			if (num == 1) {

				if(mp3.isPlaying()) {
					mp3.stop();
				}
				mp3.play(".\\music\\ĳ���ͻ���ȭ�� �����.mp3");
				
				// ĳ���� ����
				cdto = option.characterProduct(num, user_id);

				// ���� ����
				if(mp3.isPlaying()) {
					mp3.stop();
				}
				int round = play.gamePlay(cdto);

				System.out.println("��ŷ�� ��� �Ͻðڽ��ϱ�");
				System.out.println("[1]���  [2]����");
				num = sc.nextInt();
				if (num == 1) {
					rankDTO rankdto = new rankDTO(cdto.getnickname(), round);
					rankdao.rankInsert(rankdto);
					
					System.out.println("��ŷ��� �Ϸ�");
					if(mp3.isPlaying()) {
						mp3.stop();
					}
					
				} else if (num == 2) {
					System.out.println("��ŷ���â ���� �մϴ�.");
					if(mp3.isPlaying()) {
						mp3.stop();
					}
					
				} else {
					System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
					if(mp3.isPlaying()) {
						mp3.stop();
					}
					
				}
				num = 2;

			}
			// ��ŷ ��ȸ
			else if (num == 2) {
				if(mp3.isPlaying()) {
					mp3.stop();
				}
				mp3.play(".\\music\\��ŷ��ȸȭ�� �����.mp3");
				
				rankview.rankView();
				num = 2;
			}
			// ���� ����
			else if (num == 3) {
				if(mp3.isPlaying()) {
					mp3.stop();
				}
				mp3.play(".\\music\\��������ȭ�� �����.mp3");
				
				view.Exit();
				break;
			}
			// �߸� �Է� ������
			else {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				num = 2;
			}
		}

//	 ���� ������ ȭ��

	}

}

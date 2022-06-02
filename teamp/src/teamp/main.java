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

		// 초기 화면
		while (true) {
			System.out.println("[1]회원가입 [2] 로그인 [3] 종료");
			num = sc.nextInt();

			// 종료
			if (num == 3) {
				view.Exit();
			}
			// 회원가입
			else if (num == 1) {
				view.viewSign();
			}
			// 로그인
			else if (num == 2) {
				if (view.viewlogin()) {
					user_id = view.getUser_id();
					break;
				}
			}
			// 잘못 입력 했을때
			else {
				System.out.println("잘못 입력 하셨습니다.");
			}

		}
		// 로그인 후 화면
		while (num == 2) {
			System.out.println("[1]게임시작 [2] 랭킹조회 [3]종료");
			num = sc.nextInt();
			if (num == 1) {

				// 캐릭터 생성
				cdto = option.characterProduct(num, user_id);

				// 게임 실행
				int round = play.gamePlay(cdto);

				System.out.println("랭킹을 등록 하시겠습니까");
				System.out.println("[1]등록 [2]종료");
				num = sc.nextInt();
				if (num == 1) {
					rankDTO rankdto = new rankDTO(cdto.getnickname(), round);
					rankdao.rankInsert(rankdto);
					System.out.println("랭킹등록 완료");
				} else if (num == 2) {
					System.out.println("랭킹등록창 종료 합니다.");
				} else {
					System.out.println("잘못 입력 하셨습니다.");
				}
				num = 2;

			}
			// 랭킹 조회
			else if (num == 2) {
				rankview.rankView();
				num = 2;
			}
			// 게임 종료
			else if (num == 3) {
				view.Exit();
				break;
			}
			// 잘못 입력 했을때
			else {
				System.out.println("잘못 입력 하셨습니다.");
				num = 2;
			}
		}

//		랭킹 등록및 조회 //수정가능성있음

		System.out.println("바보");

	}

}

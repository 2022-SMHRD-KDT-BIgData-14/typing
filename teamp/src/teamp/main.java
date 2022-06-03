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
		CharacterDTO dto = new CharacterDTO();
		
		if(mp3.isPlaying()) {
			mp3.stop();
		}
		// 초기 화면
		dto.openask();
		option.opening();
		while (true) {
			
			mp3.play(".\\Music\\시작화면 배경음.mp3");
			
			System.out.println("[1]회원가입  [2]로그인  [3]종료");
			num = sc.nextInt();

			// 종료
			if (num == 3) {
				view.Exit();
				if(mp3.isPlaying()) {
					mp3.stop();
				}
				break;
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
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			mp3.play(".\\music\\메뉴선택시 효과음.mp3");
			System.out.println("[1]게임시작  [2]랭킹조회  [3]캐릭터 정보 [4]종료");
			num = sc.nextInt();
			
			
			if (num == 1) {

				if(mp3.isPlaying()) {
					mp3.stop();
				}
				mp3.play(".\\music\\캐릭터생성화면 배경음.mp3");
				
				// 캐릭터 생성
				cdto = option.characterProduct(num, user_id);

				// 게임 실행
				if(mp3.isPlaying()) {
					mp3.stop();
				}
				int round = play.gamePlay(cdto);
				
				System.out.println("랭킹을 등록 하시겠습니까");
				while (true) {
					System.out.println("[1]등록  [2]종료");
					num = sc.nextInt();
					if (num == 1) {
						rankDTO rankdto = new rankDTO(cdto.getnickname(), round-1);
						rankdao.rankInsert(rankdto);

						System.out.println("랭킹등록 완료");
						if (mp3.isPlaying()) {
							mp3.stop();
						}
							num = 2;
							break;
					} else if (num == 2) {
						System.out.println("랭킹등록창 종료 합니다.");
						if (mp3.isPlaying()) {
							mp3.stop();
						}
						break;
						
					} else {
						System.out.println("잘못 입력 하셨습니다.");
						if (mp3.isPlaying()) {
							mp3.stop();
						}

					}
				}

			}
			// 랭킹 조회
			else if (num == 2) {
				if(mp3.isPlaying()) {
					mp3.stop();
				}
				mp3.play(".\\music\\랭킹조회화면 배경음.mp3");
				
				rankview.rankView();
				num = 2;
			}
			else if (num == 3) {
				option.characterView(user_id);
				num = 2;
			}
			// 게임 종료
			else if (num == 4) {
				if(mp3.isPlaying()) {
					mp3.stop();
				}
				mp3.play(".\\music\\게임종료화면 배경음.mp3");
				
				view.Exit();
				break;
			}
			// 잘못 입력 했을때
			else {
				System.out.println("잘못 입력 하셨습니다.");
				num = 2;
			}
		}


	}

}

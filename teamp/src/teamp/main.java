package teamp;

import java.util.Scanner;

import character.CharacterDAO;
import character.CharacterDTO;
import character.TEst;
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
		int num;
		String user_id="";
		while (true) {
			System.out.println("[1]회원가입 [2] 로그인 [3] 종료");
			num = sc.nextInt();
			if (num == 3) { // 종료
				System.out.println("종료 되었습니다.");
				break;
			} else if (num == 1) { // 회원가입
				System.out.print("아이디 >>> ");
				String id = sc.next();
				System.out.print("비밀번호 >>> ");
				String pw = sc.next();

				userDTO dto = new userDTO(user_id, pw);
				userDAO dao = new userDAO(); 
				dao.userInsert(dto);
			} else if(num == 2){ // 로그인
				System.out.print("아이디 >>> ");
				user_id = sc.next();
				System.out.print("비밀번호 >>> ");
				String user_pw = sc.next();
				
				userDTO user_dto = new userDTO(user_id, user_pw);
				loginDAO userlogin = new loginDAO();
				String stt = userlogin.login(user_dto);
				
				if (stt.equals("로그인 성공")) {
					System.out.println("로그인 성공");
					break;
				}else if(stt.equals("로그인 실패")) {
					System.out.println("로그인 실패");
				}else {
					System.out.println("아이디가 틀렸습니다.");
				}
			}else { // 잘못 입력 했을때
				System.out.println("잘못 입력 하셨습니다.");
			}
			
			}
		while(num ==2 ) {
			System.out.println("[1]게임시작 [2] 랭킹조회 [3]종료");
			num = sc.nextInt();
			if(num == 1) {
				//게임 코드 적어주세요
			
				TEst test = new TEst();
				
				CharacterDAO cdao = new CharacterDAO();
				while (true) {
					CharacterDTO cdto = test.mainchar();
					System.out.println("캐릭터 능력치를 돌리겠습니까");
					System.out.println("[1] 돌린다 [2] 이대로 간다");
					num = sc.nextInt();
					if (num == 2) {
						// 만든 캐릭터를 등록시킨다
						cdao.CharacterBuild(cdto , user_id);
						
						break;
					}
					
				}
				Gameplay play = new Gameplay();
				play.gamePlay();
				
				
				num = 2;
				
			}else if(num == 2) { // 랭킹 조회
				rankview.rankView();
				num = 2; 
			}else if(num == 3) { // 종료
				System.out.println("종료 되었습니다.");
				break;
			}else { // 잘못 입력 했을때
				System.out.println("잘못 입력 하셨습니다.");
				num = 2;
			}
		}

//		랭킹 등록및 조회 //수정가능성있음
//		rankDTO rankdto = new rankDTO("20.05.18 07:41:22.0","nick_i" ,50 );
		
//		rankdao.rankInsert(rankdto);
		
		
		
		
	}

}

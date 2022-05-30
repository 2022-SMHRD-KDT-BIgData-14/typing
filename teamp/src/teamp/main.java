package teamp;

import java.util.Scanner;

import rank.rankDAO;
import rank.rankDTO;
import rank.rankViewDAO;
import user.loginDAO;
import user.userDAO;
import user.userDTO;

public class main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		while (true) {
			System.out.println("[1]회원가입 [2] 로그인 [3] 종료");
			num = sc.nextInt();
			if (num == 3) {
				System.out.println("종료 되었습니다.");
				break;
			} else if (num == 1) {
				System.out.print("아이디 >>> ");
				String id = sc.next();
				System.out.print("비밀번호 >>> ");
				String pw = sc.next();

				userDTO dto = new userDTO(id, pw);
				userDAO dao = new userDAO(); 
				dao.userInsert(dto);
			} else if(num == 2){
				System.out.print("아이디 >>> ");
				String user_id = sc.next();
				System.out.print("비밀번호 >>> ");
				String user_pw = sc.next();
				
				userDTO user_dto = new userDTO(user_id, user_pw);
				loginDAO userlogin = new loginDAO();
				userlogin.login(user_dto);
				
				if (userlogin.login(user_dto).equals("로그인 성공")) {
					System.out.println("로그인 성공");
					break;
				}
				if(userlogin.login(user_dto).equals("로그인 실패")) {
					System.out.println("로그인 실패");
				}
			}else {
				System.out.println("잘못 입력 하셨습니다.");
			}
		}
		
		
		

//		랭킹 등록및 조회 //수정가능성있음
//		rankDTO rankdto = new rankDTO("20.05.18 07:41:22.0","nick_i" ,50 );
		rankDAO rankdao = new rankDAO();
		
//		rankdao.rankInsert(rankdto);
		
		
		rankViewDAO rankview = new rankViewDAO();
		rankview.rankView();
		
		
	}

}

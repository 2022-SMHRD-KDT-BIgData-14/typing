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
		
		//회원가입
		System.out.print("아이디 >>> ");
		String id = sc.next();
		System.out.print("비밀번호 >>> ");
		String pw = sc.next();
		
		userDTO dto = new userDTO(id, pw);
		userDAO dao = new userDAO(); 		
		
		//로그인
		System.out.print("아이디 >>> ");
		String user_id = sc.next();
		System.out.print("비밀번호 >>> ");
		String user_pw = sc.next();
		
		userDTO user_dto = new userDTO(user_id, user_pw);
		loginDAO userlogin = new loginDAO();
		userlogin.login(user_dto);
		
		
		//랭킹 등록및 조회 //수정가능성있음
		rankDTO rankdto = new rankDTO("20.05.07","nick_ik" ,50 );
		
		rankViewDAO rankview = new rankViewDAO();
		
		rankDAO rankdao = new rankDAO();
		
		rankdao.rankInsert(rankdto);
		rankview.rankView(rankdto);
		
		
	}

}

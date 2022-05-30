package teamp;

import java.util.Scanner;

import user.loginDAO;
import user.userDAO;
import user.userDTO;

public class main {
	
	public main() {
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
		
	}

}

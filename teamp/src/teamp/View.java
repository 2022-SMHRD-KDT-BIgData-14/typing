package teamp;

import java.util.Scanner;

import user.loginDAO;
import user.userDAO;
import user.userDTO;

public class View {
	Scanner sc = new Scanner(System.in);
	String user_id;
	
	//종료
	public void Exit() {
		System.out.println("종료 되었습니다.");
		
	}
	//회원가입
	public void viewSign() {
		System.out.print("아이디 >>> ");
		user_id = sc.next();
		System.out.print("비밀번호 >>> ");
		String pw = sc.next();

		userDTO dto = new userDTO(user_id, pw);
		userDAO dao = new userDAO(); 
		
		dao.userInsert(dto);
		
	}
	//로그인
	public boolean viewlogin() { 
		System.out.print("아이디 >>> ");

		 user_id = sc.next();
		 
		System.out.print("비밀번호 >>> ");
		String user_pw = sc.next();
		
		userDTO user_dto = new userDTO(user_id, user_pw);
		loginDAO userlogin = new loginDAO();
		String stt = userlogin.login(user_dto);
		
		if (stt.equals("로그인 성공")) {
			System.out.println("로그인 성공");
			return true;
		}else if(stt.equals("로그인 실패")) {
			System.out.println("로그인 실패");
			return false;
		}else {
			System.out.println("아이디가 틀렸습니다.");
			return false;
		}
	
		
	}
	public String getUser_id() {
		return user_id;
	}

}

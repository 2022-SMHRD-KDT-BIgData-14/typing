package teamp;

import java.util.Scanner;

import user.loginDAO;
import user.userDAO;
import user.userDTO;

public class View {
	Scanner sc = new Scanner(System.in);
	String user_id;
	
	//����
	public void Exit() {
		System.out.println("���� �Ǿ����ϴ�.");
		
	}
	//ȸ������
	public void viewSign() {
		System.out.print("���̵� >>> ");
		user_id = sc.next();
		System.out.print("��й�ȣ >>> ");
		String pw = sc.next();

		userDTO dto = new userDTO(user_id, pw);
		userDAO dao = new userDAO(); 
		
		dao.userInsert(dto);
		
	}
	//�α���
	public boolean viewlogin() { 
		System.out.print("���̵� >>> ");

		 user_id = sc.next();
		 
		System.out.print("��й�ȣ >>> ");
		String user_pw = sc.next();
		
		userDTO user_dto = new userDTO(user_id, user_pw);
		loginDAO userlogin = new loginDAO();
		String stt = userlogin.login(user_dto);
		
		if (stt.equals("�α��� ����")) {
			System.out.println("�α��� ����");
			return true;
		}else if(stt.equals("�α��� ����")) {
			System.out.println("�α��� ����");
			return false;
		}else {
			System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
			return false;
		}
	
		
	}
	public String getUser_id() {
		return user_id;
	}

}

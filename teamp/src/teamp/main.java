package teamp;

import java.util.Scanner;

import rank.rankDAO;
import rank.rankDTO;
import rank.rankViewDAO;
import user.loginDAO;
import user.userDAO;
import user.userDTO;

public class main {
	
	public main() {
		Scanner sc = new Scanner(System.in);
		
		//ȸ������
		System.out.print("���̵� >>> ");
		String id = sc.next();
		System.out.print("��й�ȣ >>> ");
		String pw = sc.next();
		
		userDTO dto = new userDTO(id, pw);
		userDAO dao = new userDAO(); 		
		
		//�α���
		System.out.print("���̵� >>> ");
		String user_id = sc.next();
		System.out.print("��й�ȣ >>> ");
		String user_pw = sc.next();
		
		userDTO user_dto = new userDTO(user_id, user_pw);
		loginDAO userlogin = new loginDAO();
		userlogin.login(user_dto);
		
		
		//��ŷ ��Ϲ� ��ȸ //�������ɼ�����
		rankDTO rankdto = new rankDTO(pw, user_id, user_pw);
		
		rankViewDAO rankview = new rankViewDAO();
		
		rankDAO rankdao = new rankDAO();
		
		rankdao.rankInsert(rankdto);
		rankview.rankView(rankdto);
		
		
	}

}

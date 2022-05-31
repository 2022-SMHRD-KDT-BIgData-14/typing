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
		CharacterDTO cdto;
		int num;
		String user_id="";
		while (true) {
			System.out.println("[1]ȸ������ [2] �α��� [3] ����");
			num = sc.nextInt();
			if (num == 3) { // ����
				System.out.println("���� �Ǿ����ϴ�.");
				break;
			} else if (num == 1) { // ȸ������
				System.out.print("���̵� >>> ");
				String id = sc.next();
				System.out.print("��й�ȣ >>> ");
				String pw = sc.next();

				userDTO dto = new userDTO(user_id, pw);
				userDAO dao = new userDAO(); 
				dao.userInsert(dto);
			} else if(num == 2){ // �α���
				System.out.print("���̵� >>> ");

				 user_id = sc.next();
				System.out.print("��й�ȣ >>> ");
				String user_pw = sc.next();
				
				userDTO user_dto = new userDTO(user_id, user_pw);
				loginDAO userlogin = new loginDAO();
				String stt = userlogin.login(user_dto);
				
				if (stt.equals("�α��� ����")) {
					System.out.println("�α��� ����");
					break;
				}else if(stt.equals("�α��� ����")) {
					System.out.println("�α��� ����");
				}else {
					System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
				}
			}else { // �߸� �Է� ������
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
			}
			
			}
		while(num ==2 ) {
			System.out.println("[1]���ӽ��� [2] ��ŷ��ȸ [3]����");
			num = sc.nextInt();
			if(num == 1) {
				//���� �ڵ� �����ּ���
			
				TEst test = new TEst();
				
				CharacterDAO cdao = new CharacterDAO();
				
				while (true) {
					cdto = test.mainchar();
					System.out.println("ĳ���� �ɷ�ġ�� �����ڽ��ϱ�");
					System.out.println("[1] ������ [2] �̴�� ����");
					num = sc.nextInt();
					if (num == 2) {
						// ���� ĳ���͸� ��Ͻ�Ų��
						cdao.CharacterBuild(cdto , user_id);
						cdto.getnickname();
						
						break;
					}
					
				}
				
				Gameplay play = new Gameplay();
				play.gamePlay();
				
				System.out.println("��ŷ�� ��� �Ͻðڽ��ϱ�");
				System.out.println("[1]��� [2]����");
				num = sc.nextInt();
				if(num == 1) {
				rankDTO rankdto = new rankDTO(cdto.getnickname(), num);
				rankdao.rankInsert(rankdto);
				System.out.println("��ŷ��� �Ϸ�");
				}else if (num==2){
					System.out.println("��ŷ���â ���� �մϴ�.");
				}else {
					System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				}
				num = 2;
				
			}else if(num == 2) { // ��ŷ ��ȸ
				rankview.rankView();
				num = 2; 
			}else if(num == 3) { // ����
				System.out.println("���� �Ǿ����ϴ�.");
				break;
			}else { // �߸� �Է� ������
				System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
				num = 2;
			}
		}

//		��ŷ ��Ϲ� ��ȸ //�������ɼ�����
		
		// ���� �����뤱
		
		System.out.println("�ٺ�");
		
	}

}

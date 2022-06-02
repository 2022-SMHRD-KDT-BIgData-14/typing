package gameplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import character.CharacterDTO;

public class GameDAO {
	ResultSet rs;
	Connection conn = null;
	PreparedStatement psmt = null;

	
	// 서버 연결
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		}

		String db = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_f_0516_3";
		String db_pw = "smhrd3";

		try {
			conn = DriverManager.getConnection(db, db_id, db_pw);
		} catch (SQLException e) {
//			e.printStackTrace();
		}
	}

	// 케릭터 정보 가져오기
	public int characterStat(int num,CharacterDTO charNic) {
		String str = charNic.getnickname();
		String sql = "select att, def, hp from character where nickname = "+"'"+str+"'";
		int att=0;
		int def=0;
		int hp =0;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			System.out.println("");
			while (rs.next()) {
				att = rs.getInt(1);
				def = rs.getInt(2);
				hp = rs.getInt(3);
				
			}

		} catch (SQLException e) {
//			e.printStackTrace();
		}
		if (num == 1) {
			return att;
		} else if (num == 2) {
			return def;
		} else if (num == 3) {
			return hp;
		} else {
			return 0;
		}

	}
	// 캐릭터 정보 출력
	public void characterView(String user_id) {
		
		String sql = "select * from character where id = "+"'"+user_id+"'";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			System.out.println("");
			 System.out.println("닉네임\t\t공격력\t방어력\t체력");
			while (rs.next()) {
				System.out.print(rs.getString(4)+"\t\t"+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\n");
			}
			
		} catch (SQLException e) {
//			e.printStackTrace();
		}
		
		
	}

// 서버 닫기
	public void close() {
		try {
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
//			e.printStackTrace();
		}
	}

}

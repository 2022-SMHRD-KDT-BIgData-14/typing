package gameplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO {
	ResultSet rs;
	Connection conn = null;
	PreparedStatement psmt = null;
	// 서버 연결
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String db = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_f_0516_3";
		String db_pw = "smhrd3";

		try {
			conn = DriverManager.getConnection(db, db_id, db_pw);
//			System.out.println("연결성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 케릭터 정보 가져오기 (수정요망)
	public int characterStat(int num) {
		String sql = "select * from character";
		String att = "";
		String def = "";
		String hp = "";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
//			System.out.print("ID" + "\t");
//			System.out.print("NICNAME" + "\t");
			System.out.print("ATT" + "\t");
			System.out.print("DEF" + "\t");
			System.out.print("HP" + "\t");
			System.out.println("");
			while (rs.next()) {
				att = rs.getString(1);
				def = rs.getString(2);
				hp = rs.getString(3);
				System.out.print(att + "\t");
				System.out.print(def + "\t");
				System.out.println(hp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		int attack = Integer.parseInt(att);
		int defend = Integer.parseInt(def);
		int health = Integer.parseInt(hp);
		if (num == 1) {
			return attack;
		} else if (num == 2) {
			return defend;
		} else if (num == 3) {
			return health;
		} else {
			return 0;
		}

	}

// 서버 닫기
	public void close() {
		try {
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
//			System.out.println("닫힘성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

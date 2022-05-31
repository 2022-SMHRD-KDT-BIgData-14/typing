package gameplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameOption {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	Scanner sc = new Scanner(System.in);
	Random r = new Random();
	
	
//타이핑 게임
	public long typingSec() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("감자");
		arr.add("고구마");
		arr.add("당근");
		arr.add("양배추");
		arr.add("딸기");
		arr.add("사과");
		arr.add("독수리");
		arr.add("마");
		int i = r.nextInt(arr.size());
		System.out.print(arr.get(i)+" >> ");
		long timeFirst = System.currentTimeMillis();
		String str = sc.next();
		long timeDif = System.currentTimeMillis() - timeFirst;
//			System.out.println(timeDif);
		long typing = str.length() * 5 * 6 / ((timeDif / 1000) + 1);
		System.out.println(typing + "타");
		if (arr.get(i).equals(str)) {
			return typing;
		} else {
			System.out.println("Miss");
			return 0;
		}
	}

	// 케릭터 정보 가져오기
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

}

package gameplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;
import user.userDTO;

public class GameOption {
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
		}//
	}
	

}

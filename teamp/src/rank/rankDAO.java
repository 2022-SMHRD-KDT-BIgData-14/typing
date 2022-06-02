package rank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class rankDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	public int rankInsert(rankDTO rankdto) {
		int cnt = 0;

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
			System.out.println("로딩성공");
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		try {
			String name = rankdto.getNickname();
			int round = rankdto.getBestround();
			String sql = "insert into rank values(SYSDATE,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setInt(2, round);
			cnt = psmt.executeUpdate();
			System.out.println("등록성공");
		} catch (SQLException e) {
//			e.printStackTrace();
		} finally {
			try {
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

//				e.printStackTrace();
			}
		}
		return cnt;
	}

}

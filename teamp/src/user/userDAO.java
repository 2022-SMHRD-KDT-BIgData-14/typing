package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class userDAO {
	public int userInsert(userDTO dto) {
		Connection conn = null;
		PreparedStatement psmt = null;
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
		} catch (SQLException e) {
//			e.printStackTrace();
		}

		String id = dto.getId();
		String pw = dto.getPw();

		String sql = "insert into member values(?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			cnt = psmt.executeUpdate();
			System.out.println("회원가입이 되었습니다.");
		} catch (SQLException e) {
			System.out.println("아이디가 중복되었습니다.");
//			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}

		return cnt;
	}
}

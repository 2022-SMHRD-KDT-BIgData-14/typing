package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	String str = "아이디가 틀렸습니다.";
	public String login(userDTO dto) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String id = dto.getId();
		String pw = dto.getPw();

		String sql = "select pw from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			rs = psmt.executeQuery();

			if (rs.next()) {
				String result = rs.getString(1);
				if (result.equals(dto.getPw())) {
					str = "로그인 성공";
				}
				else{
					str = "로그인 실패";
				}
			}

		} catch (SQLException e) {
			str = "아이디가 틀렸습니다.";
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
}

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

	public void login(userDTO dto) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String db = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String db_id = "hr";
		String db_pw = "hr";

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
			// ?는 반드시 execute전에 설정이 되어 있어야 한다
			psmt.setString(1, dto.getId());
			rs = psmt.executeQuery();

			if (rs.next()) {
				String result = rs.getString(1);
				if (result.equals(dto.getPw())) {
					System.out.println("로그인성공");
				} else {
					System.out.println("로그인 실패");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
	}
}

package character;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CharacterDAO {

	public class rankDAO {
		Connection conn;
		PreparedStatement psmt;
		ResultSet rs;

		public void rankInsert(CharacterDTO characterdto) {

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

			try {
				int hp = characterdto.gethp();
				int att = characterdto.getAtt();
				int def = characterdto.getDef();
				String sql = "insert into character values(?,?,?)";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, hp);
				psmt.setInt(2, att);
				psmt.setInt(3, def);
				psmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (psmt != null) {
						psmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

	}
}

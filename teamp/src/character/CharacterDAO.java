package character;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CharacterDAO {

	
		Connection conn;
		PreparedStatement psmt;
		ResultSet rs;

		public int CharacterBuild(CharacterDTO characterdto ,String id) {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
			}
			String db = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_f_0516_3";
			String db_pw = "smhrd3";

			try {
				conn = DriverManager.getConnection(db, db_id, db_pw);
			} catch (SQLException e) {
//				e.printStackTrace();
			}
			try {
				int hp = characterdto.gethp();
				int att = characterdto.getAtt();
				int def = characterdto.getDef();
				String nickname = characterdto.getnickname();
				String sql = "insert into character values(?,?,?,?,?)";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, att);
				psmt.setInt(2, def);
				psmt.setInt(3, hp);
				psmt.setString(4, nickname);
				psmt.setString(5, id);
				psmt.executeUpdate();
				return 0;
			} catch (SQLException e) {
//				e.printStackTrace();
				return 1;
			}
			 finally {
				try {
					if (psmt != null) {
						psmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {

//					e.printStackTrace();
				}
			}
		}

	}


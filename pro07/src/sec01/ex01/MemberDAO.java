package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd = "tiger";
	
	private Statement stmt;
	private Connection con;
	
	public List<MemberVO> listMembers() {
		
		List<MemberVO> list = new ArrayList<>();
		
		try {
			
			connDB();
			String query = "SELECT * FROM T_MEMBER ";
			System.out.println(query);
			
			/* 쿼리를 수행해서 테이블 조회 */
			ResultSet rs = stmt.executeQuery(query);
			
			
			/* 조회한 레코드의 각 컬럼 값 */
			while (rs.next()) {
				
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			
			rs.close();
			stmt.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	/* db connection by <driver, url, user, pwd> */
	private void connDB() {
		
		try {
			Class.forName(driver);
			System.out.println("Oracle Driver Loading Success");
			
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Create Connection Success");
			
			stmt = con.createStatement();
			System.out.println("Create Statement Success");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

import java.sql.*;

public class Database {
	public static Connection connect;
	public static Statement statement;
	static {
		try {
				connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "");
				statement = connect.createStatement();
			}
		catch (SQLException e) {
			System.out.println(e);
		}
	}
}
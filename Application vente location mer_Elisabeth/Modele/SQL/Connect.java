package SQL;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect
{
	private static Connection connection = null;

	public static Connection getConnection() throws Exception
	{
		if ((connection == null) || (connection.isClosed()))
		{
			DriverManager.setLogWriter(new PrintWriter(System.out));
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/application_vente_location";
			String user = "root";
			String passwd = "";

			connection = DriverManager.getConnection(url, user, passwd);
		}
		
		return connection;
	}
}


package zqu.eqms.util;
import java.sql.*;
public class JobUtil {
	//声明连接数据库的信息，如数据库URL、用户名及密码
	private static final String URL = "jdbc:MySQL://localhost:3306/javajob?useUnicode=true&characterEncoding=utf-8";
	//  "jdbc:MySQL://localhost:3306/bookstore?useUnicode=true&characterEncoding=utf-8"
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static synchronized Connection getConnection()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("数据库连接成功!!!");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("数据库连接失败!!!");
		}
		return conn;
	}
	
	public static void close()
	{
		try
		{
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();	
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("数据库关闭失败!!!");
		}
	}
	

}

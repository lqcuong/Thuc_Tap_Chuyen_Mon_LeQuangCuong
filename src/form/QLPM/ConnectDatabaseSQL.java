package form.QLPM;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabaseSQL {
	public static Connection connectSQL() {
		String connectionURL="jdbc:sqlserver://LQC\\SQLEXPRESS:1433;databaseName=QuanLyPhongMachTu;integratedSecurity=true;";
		Connection connection=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection=DriverManager.getConnection(connectionURL, "sa", "admin");
		} catch (Exception e) {
			System.out.println("Kết nối thất bại: "+e.getMessage()+"/n"+e.getClass()+"/n"+e.getCause());
		}
		return connection;
	}
	public static void closeDatabaseSQL(Connection con) {
		if(con!=null) {
			try {
				con.close();
			}catch(Exception ex) {
				System.out.println("Lỗi!!! Không thể đóng database: "+ex.getMessage());
			}
		}
	}
}

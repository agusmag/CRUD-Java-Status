package connectionDB_notUsed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MySQLConnection {
	
	public static Connection getConnection() {
		
		//Se instancia la comunicacion con la BD
		Connection com = null;
		
		//Se tienen que cargar los drivers de mySQL.
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/status";
			String user = "root";
			String password = "mysql";
			
			com = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Hubo un error con la carga de drivers");
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al cargar la Base de Datos");
			e.printStackTrace();
		}
		
		return com;
	}
}

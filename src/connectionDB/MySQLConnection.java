package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MySQLConnection {
	public static Connection getConexion() {
		
		//Se instancia la comunicacion con la BD
		Connection com = null;
		
		//Se tienen que cargar los drivers de mySQL.
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbcmysql://localhost/bd_Student Status";
			String user = "root";
			String password = "";
			
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

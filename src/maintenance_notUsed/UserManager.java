package maintenance_notUsed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Student;

public class UserManager {

	public Student getStudent(Student user){
		
		Student stdUser = null;
		Connection com = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			//Se inicializa la conexion con la Base de Datos
			com = connectionDB_notUsed.MySQLConnection.getConnection();
			//Aqui se introduce la sentencia de SQL
			String sql = "select * from Students where username = ? and password = ?";
			//Se inicializa el pst
			pst = com.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			//Se ejecuta el pst
			rs = pst.executeQuery();
			
			while (rs.next()){
			//	stdUser = new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getShort(5));
			}
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Hubo un error con el usuario o la contraseña");
		}
		
		return stdUser;
	}
	
	public void setStudent(Student user){
		Student stdUser = null;
		Connection com = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql;
		
		try {
			//Se inicializa la conexion con la Base de Datos
			com = connectionDB_notUsed.MySQLConnection.getConnection();
			//Se introduce la sentencia de SQL
			sql = "insert students(username, password, Carrers_idCarrer) values ( ?, ?, ?)";
			//Se carga el pst
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setInt(3, user.getCarrer().getIdCarrer());
			
			pst.execute();
			
			JOptionPane.showMessageDialog(null, "El usuario fue ingresado correctamente");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error con la carga de datos");
		}
	}
}

package maintenance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import entity.Student;

public class UserGestion {

	public Student getStudent(Student user){
		
		Student stdUser = null;
		Connection com = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
			//Se inicializa la conexion con la Base de Datos
			com = connectionDB.MySQLConnection.getConnection();
			//Aqui se introduce la sentencia de SQL
			String sql = "select * from Students where username = ? and password = ?";
			//Se inicializa el pst
			pst = com.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			//Se ejecuta el pst
			rs = pst.executeQuery();
			
			while (rs.next()){
				stdUser = new Student(rs.getString(1),rs.getString(2),rs.getShort(3));
			}
		} catch (Exception e){
			JOptionPane.showMessageDialog(null, "Hubo un error con el usuario o la contraseña");
		}
		
		return stdUser;
	}
}

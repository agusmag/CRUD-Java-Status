package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.HibernateConfig;
import model.Student;

import java.awt.Dimension;
import java.awt.Insets;

public class LoginMenu {

	private JFrame frmLogin;
	private JTextField txtUser;
	private JPasswordField passField;
	private JButton btnExit;
	private JButton btnConfirm;
	
	private Session session;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMenu window = new LoginMenu();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(253, 116, 113, 39);
		btnConfirm.setEnabled(false);
		btnConfirm.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 432, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setLocationRelativeTo(null);
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		
		btnExit = new JButton("Exit");
		btnExit.setMargin(new Insets(0, 0, 0, 0));
		btnExit.setMinimumSize(new Dimension(32, 32));
		btnExit.setMaximumSize(new Dimension(32, 32));
		btnExit.setIconTextGap(0);
		btnExit.setBounds(12, 205, 391, 35);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit();
			}
		});

		btnExit.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		txtUser = new JTextField();
		txtUser.setBounds(228, 23, 155, 25);
		txtUser.setHorizontalAlignment(SwingConstants.LEFT);
		txtUser.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(86, 23, 130, 29);
		lblUsername.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(86, 67, 130, 30);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		passField = new JPasswordField();
		passField.setBounds(228, 70, 155, 27);
		passField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (txtUser.getText() != "" && String.valueOf(passField.getPassword()) != ""){
					btnConfirm.setEnabled(true);
				}
			}
		});
		frmLogin.getContentPane().setLayout(null);
		frmLogin.getContentPane().add(lblUsername);
		frmLogin.getContentPane().add(lblPassword);
		frmLogin.getContentPane().add(passField);
		frmLogin.getContentPane().add(txtUser);
		frmLogin.getContentPane().add(btnConfirm);
		frmLogin.getContentPane().add(btnExit);
		
		JLabel label = new JLabel("");
		label.setVisible(false);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setIcon(new ImageIcon(LoginMenu.class.getResource("/background/if_User_Interface-35_2044253.png")));
		label.setBounds(367, 13, 38, 39);
		frmLogin.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setVisible(false);
		label_1.setIcon(new ImageIcon(LoginMenu.class.getResource("/background/if_User_Interface-35_2044253.png")));
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(367, 61, 38, 39);
		frmLogin.getContentPane().add(label_1);
	}
		
	public JFrame getFrmLogin() {
		return frmLogin;
	}

	public void setFrmLogin(JFrame frmLogin) {
		this.frmLogin = frmLogin;
		}

	private void exit() {
		frmLogin.dispose();
		StartMenu stMenu = new StartMenu();
		stMenu.getFrmUniversity().setVisible(true);
		
	}

	private Student login() {
		String username = txtUser.getText();
		String password = String.valueOf(passField.getPassword()); //Se convierte a String ya que esta en otro formato
		Student std = new Student();
		/*	
		UserManager um = new UserManager();
			
		Student std2 = new Student();
		std2.setUsername(username);
		std2.setPassword(password);

		//Student std = um.getStudent(std2);
			
		if (std != null){
			JOptionPane.showMessageDialog(null, "Bienvenido");
			StatusMenu stMenu = new StatusMenu();
		stMenu.getFrmStatus().setVisible(true);
		frmLogin.dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Problema con el usuario o Contraseña", "Error", JOptionPane.ERROR_MESSAGE);
			txtUser.setText("");
			passField.setText("");
			txtUser.requestFocus();
			btnConfirm.setEnabled(false);
		}
		*/
		
		//Se obtiene la sesion brindada por Hibernate
		session = HibernateConfig.getCurrentSession();
		//Se informa que se va transmitir informacion a la Base de Datos
				
		try {
			//Se guarda el estudiante en la session para luego enviarse mediante el commit hacia la Base de Datos
			// Y luego se cierra la sesion.
			std = (Student) session.get(Student.class, std);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar el usuario en la Base de Datos");
		}
		return std;
	}
}
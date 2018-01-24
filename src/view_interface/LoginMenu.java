package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import entity.Student;
import maintenance.UserGestion;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginMenu {

	private JFrame frmLogin;
	private JTextField txtUser;
	private JPasswordField passField;

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
		JButton btnConfirm = new JButton("Confirm");
		
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(SystemColor.menu);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 450, 263);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		btnConfirm.setEnabled(false);
		btnConfirm.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit();
			}
		});

		btnExit.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		txtUser = new JTextField();
		txtUser.setHorizontalAlignment(SwingConstants.LEFT);
		txtUser.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		passField = new JPasswordField();
		passField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (txtUser.getText() != "" && String.valueOf(passField.getPassword()) != ""){
					btnConfirm.setEnabled(true);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
								.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passField)
								.addComponent(txtUser, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
							.addGap(18)
							.addComponent(btnConfirm)
							.addGap(9))
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(passField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(btnConfirm, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frmLogin.getContentPane().setLayout(groupLayout);
	}
		
		protected void exit() {
			
			frmLogin.dispose();
	}

		protected void login() {
			
			String username = txtUser.getText();
			String password = String.valueOf(passField.getPassword()); //Se convierte a String ya que esta en otro formato
			
			UserGestion ug = new UserGestion();
			
			Student std2 = new Student();
			std2.setUsername(username);
			std2.setPassword(password);

			Student std = ug.getStudent(std2);
			
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
			}
		}
}
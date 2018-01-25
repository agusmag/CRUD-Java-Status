package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.HibernateConfig;
import maintenance_notUsed.UserManager;
import model.Student;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterMenu {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnConfirm;
	private JButton btnExit;
	private JComboBox<String> comboBoxCarrer;
	
	private Session session;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterMenu window = new RegisterMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Consolas", Font.PLAIN, 18));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(26, 210, 111, 31);
		btnConfirm.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnConfirm.setEnabled(false);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
				exit();
			}
		});
		
		textField = new JTextField();
		textField.setBounds(172, 40, 184, 25);
		textField.setFont(new Font("Consolas", Font.PLAIN, 13));
		textField.setColumns(10);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(301, 210, 111, 30);
		btnExit.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(74, 42, 91, 23);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(76, 90, 89, 23);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		JLabel lblDegree = new JLabel("Carrer");
		lblDegree.setVerticalAlignment(SwingConstants.TOP);
		lblDegree.setBounds(74, 139, 91, 25);
		lblDegree.setHorizontalAlignment(SwingConstants.CENTER);
		lblDegree.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 88, 184, 25);
		passwordField.setFont(new Font("Consolas", Font.PLAIN, 13));
		
		comboBoxCarrer = new JComboBox<String>();
		comboBoxCarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int valueBox = comboBoxCarrer.getSelectedIndex();
				if (textField.getText() != "" && String.valueOf(passwordField.getPassword()) != ""
						&& valueBox != 0){
					btnConfirm.setEnabled(true);
				}
			}
		});
		comboBoxCarrer.addItem("Choose a Carrer");
		comboBoxCarrer.addItem("ING.EN INFORMATICA");
		comboBoxCarrer.setSelectedItem(0);
		comboBoxCarrer.setBounds(172, 139, 184, 27);
		comboBoxCarrer.setFont(new Font("Consolas", Font.PLAIN, 14));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnConfirm);
		frame.getContentPane().add(btnExit);
		frame.getContentPane().add(lblUsername);
		frame.getContentPane().add(lblPassword);
		frame.getContentPane().add(lblDegree);
		frame.getContentPane().add(comboBoxCarrer);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(passwordField);
	}

	private void register() {
		//Se crea un estudiante para almacenar la informacion ingresada por el usuario
		int valueCombo = comboBoxCarrer.getSelectedIndex();
		Student std = new Student(this.textField.getText(),
				String.valueOf(passwordField.getPassword()), valueCombo);
		
		//Se inicia sesion de Hibernate con la Base de Datos
		session = HibernateConfig.getCurrentSession();
		//Se informa que se va transmitir informacion a la Base de Datos
		try {
			//Se guarda el estudiante en la session para luego enviarse mediante el commit hacia la Base de Datos
			// Y luego se cierra la sesion.
			session.beginTransaction();
			session.save(std);
			session.getTransaction().commit();
			session.close();
			
			JOptionPane.showMessageDialog(null, "Registro completado");
		} catch (Exception e) {
			//En caso de que haya algun error se realiza un rollback(Se retorna la Base de Datos a un punto seguro).
			JOptionPane.showMessageDialog(null, "Error al cargar el usuario en la Base de Datos");
		}
	}

	private void exit() {
		frame.dispose();
		StartMenu stMenu = new StartMenu();
		stMenu.getFrmUniversity().setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}

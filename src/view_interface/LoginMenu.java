package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import org.hibernate.query.Query;
import hibernate.HibernateConfig;
import model.Student;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class LoginMenu {
	
	private JTextField textFieldLg;
	private JPasswordField passwordFieldLg;
	private JFrame frmLogin;
	private JButton btnExit;
	private JButton btnConfirm;
	
	private Student std;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	
	private int xx;
	private int xy;
	private JLabel lblNewLabel_2;

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
		
		frmLogin = new JFrame();
		frmLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		frmLogin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				
				frmLogin.setLocation(x - xx, y - xy);
			}
		});
		frmLogin.setUndecorated(true);
		frmLogin.getContentPane().setBackground(new Color(0, 0, 0));
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 432, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setLocationRelativeTo(null);
		
		btnExit = new JButton("");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(new Color(153, 153, 153));
			}
		});
		btnExit.setToolTipText("Volver atras");
		btnExit.setBorderPainted(false);
		btnExit.setIcon(new ImageIcon(LoginMenu.class.getResource("/background/if_User_Interface-09_2044237.png")));
		btnExit.setBackground(new Color(153, 153, 153));
		btnExit.setMargin(new Insets(0, 0, 0, 0));
		btnExit.setMinimumSize(new Dimension(32, 32));
		btnExit.setMaximumSize(new Dimension(32, 32));
		btnExit.setIconTextGap(0);
		btnExit.setBounds(315, 255, 97, 39);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				exit();
			}
		});

		btnExit.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		textFieldLg = new JTextField();
		textFieldLg.setToolTipText("Ingrese un usuario para la cuenta.");
		textFieldLg.setBounds(196, 95, 155, 25);
		textFieldLg.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldLg.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(51, 204, 51));
		lblUsername.setBounds(54, 92, 130, 29);
		lblUsername.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(51, 204, 51));
		lblPassword.setBounds(54, 139, 130, 30);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		passwordFieldLg = new JPasswordField();
		passwordFieldLg.setToolTipText("Ingrese una contrase\u00F1a para la cuenta.");
		passwordFieldLg.setBounds(196, 142, 155, 27);
		passwordFieldLg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (textFieldLg.getText() != "" && String.valueOf(passwordFieldLg.getPassword()) != ""){
					btnConfirm.setEnabled(true);
				}
			}
		});
		frmLogin.getContentPane().setLayout(null);
		frmLogin.getContentPane().add(lblUsername);
		frmLogin.getContentPane().add(lblPassword);
		frmLogin.getContentPane().add(passwordFieldLg);
		frmLogin.getContentPane().add(textFieldLg);
		frmLogin.getContentPane().add(btnExit);
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 432, 57);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(new Color(153, 153, 153));
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(LoginMenu.class.getResource("/background/if_User_Interface-02_2044283.png")));
		lblNewLabel.setBackground(new Color(153, 153, 153));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(new Rectangle(390, 14, 32, 32));
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(51, 204, 51));
		lblNewLabel_1.setFont(new Font("LLPixel", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 2, 124, 44);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmLogin.setState(Frame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setBackground(new Color(153, 153, 153));
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(LoginMenu.class.getResource("/background/if_window-minimize_1954552.png")));
		lblNewLabel_2.setBackground(new Color(153, 153, 153));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(338, 14, 32, 32);
		panel.add(lblNewLabel_2);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(0, 248, 432, 52);
		frmLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		btnConfirm = new JButton("");
		btnConfirm.setBorderPainted(false);
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btnConfirm.isEnabled())
					btnConfirm.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnConfirm.setBackground(new Color(153, 153, 153));
			}
		});
		btnConfirm.setToolTipText("Confirmar login");
		btnConfirm.setBounds(20, 7, 97, 39);
		panel_1.add(btnConfirm);
		btnConfirm.setBackground(new Color(153, 153, 153));
		btnConfirm.setIcon(new ImageIcon(LoginMenu.class.getResource("/background/if_User_Interface-04_2044281.png")));
		btnConfirm.setEnabled(false);
		btnConfirm.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				std = login();
				
				if (std == null){
					JOptionPane.showMessageDialog(null, "Nombre de Usuario o Contraseņa incorrectos");
					textFieldLg.setText("");
					passwordFieldLg.setText("");
					textFieldLg.requestFocus();
					btnConfirm.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "Bienvenido");
					StatusMenu stMenu = new StatusMenu();
					stMenu.setStd(std);
					stMenu.getFrmStatus().setVisible(true);
					frmLogin.dispose();
				}
			}
		});
	}
		
	public JFrame getFrmLogin() {
		return frmLogin;
	}

	public void setFrmLogin(JFrame frmLogin) {
		this.frmLogin = frmLogin;
		}

	public JTextField getTextField() {
		return textFieldLg;
	}

	public void setTextField(JTextField txtUser) {
		this.textFieldLg = txtUser;
	}

	public JPasswordField getPasswodField() {
		return passwordFieldLg;
	}

	public void setPasswodField(JPasswordField passField) {
		this.passwordFieldLg = passField;
	}

	private void exit() {
		frmLogin.dispose();
		StartMenu stMenu = new StartMenu();
		stMenu.getFrmUniversity().setVisible(true);
		
	}

	private Student login() {
		//Se crea un estudiante para recibir la consulta de la Base de Datos
		//Se crea un String username y una password para utilizarlo como filtro de busqueda.
		Student stdLocal = new Student();
		stdLocal.setUsername(textFieldLg.getText());
		stdLocal.setPassword(String.valueOf(passwordFieldLg.getPassword()));
		
		/*
		 * CODIGO NO UTILIZADO, FORMA DIRECTA DE ACCEDER A LA BASE DE DATOS
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
			JOptionPane.showMessageDialog(null, "Problema con el usuario o Contraseņa", "Error", JOptionPane.ERROR_MESSAGE);
			txtUser.setText("");
			passField.setText("");
			txtUser.requestFocus();
			btnConfirm.setEnabled(false);
		}
		* FIN CODIGO NO UTILIZADO
		*/
		
		//Se obtiene la sesion brindada por Hibernate y se crea una Query para obtener el usuario correcto
		Query query = HibernateConfig.getCurrentSession().createQuery("FROM Student s WHERE s.username = :username AND s.password = :password");
		query.setParameter("username", stdLocal.getUsername());
		query.setParameter("password", stdLocal.getPassword());
		//Se informa que se va transmitir informacion a la Base de Datos
		try {
			//Se guarda el estudiante en la session para luego enviarse mediante el commit hacia la Base de Datos
			// Y luego se cierra la sesion.
			stdLocal = (Student) query.uniqueResult();
			return stdLocal;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar el usuario en la Base de Datos");
			return null;
		}
		
	}
}
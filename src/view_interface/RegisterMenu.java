package view_interface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.hibernate.Session;
import hibernate.HibernateConfig;
import model.Carrer;
import model.Student;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RegisterMenu {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnConfirm;
	private JButton btnExit;
	private JComboBox<String> comboBoxCarrer;
	
	private Session session;
	private JLabel lblName;
	private JLabel lblLastname;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
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
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				
				frame.setLocation(x - xx, y - xy);
			}
		});
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setUndecorated(true);
		frame.getContentPane().setFont(new Font("Consolas", Font.PLAIN, 18));
		frame.setBounds(100, 100, 450, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		btnConfirm = new JButton("");
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
		btnConfirm.setBorderPainted(false);
		btnConfirm.setBackground(new Color(153, 153, 153));
		btnConfirm.setIcon(new ImageIcon(RegisterMenu.class.getResource("/background/if_User_Interface-04_2044281.png")));
		btnConfirm.setBounds(41, 494, 111, 31);
		btnConfirm.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnConfirm.setEnabled(false);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerUser();
				
				exit();
			}
		});
		
		textField = new JTextField();
		textField.setBounds(51, 110, 184, 25);
		textField.setFont(new Font("Consolas", Font.PLAIN, 13));
		textField.setColumns(10);
		
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
		btnExit.setBorderPainted(false);
		btnExit.setBackground(new Color(153, 153, 153));
		btnExit.setIcon(new ImageIcon(RegisterMenu.class.getResource("/background/if_User_Interface-09_2044237.png")));
		btnExit.setBounds(294, 494, 111, 30);
		btnExit.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(51, 204, 51));
		lblUsername.setBounds(51, 74, 91, 23);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(51, 204, 51));
		lblPassword.setBounds(51, 148, 89, 23);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		JLabel lblDegree = new JLabel("Carrer");
		lblDegree.setForeground(new Color(51, 204, 51));
		lblDegree.setVerticalAlignment(SwingConstants.TOP);
		lblDegree.setBounds(51, 381, 91, 25);
		lblDegree.setHorizontalAlignment(SwingConstants.LEFT);
		lblDegree.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(51, 184, 184, 25);
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
		comboBoxCarrer.setBounds(51, 424, 184, 27);
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
		
		lblName = new JLabel("Name");
		lblName.setForeground(new Color(51, 204, 51));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblName.setBounds(51, 233, 91, 16);
		frame.getContentPane().add(lblName);
		
		lblLastname = new JLabel("Lastname");
		lblLastname.setForeground(new Color(51, 204, 51));
		lblLastname.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastname.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblLastname.setBounds(51, 300, 101, 23);
		frame.getContentPane().add(lblLastname);
		
		textField_1 = new JTextField();
		textField_1.setBounds(51, 262, 184, 25);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(51, 343, 184, 25);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 450, 52);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Register");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(51, 204, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("LLPixel", Font.BOLD, 29));
		lblNewLabel.setBounds(0, 5, 173, 44);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(153, 153, 153));
			}
		});
		lblNewLabel_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(RegisterMenu.class.getResource("/background/if_User_Interface-02_2044283.png")));
		lblNewLabel_1.setForeground(new Color(204, 51, 51));
		lblNewLabel_1.setBounds(408, 14, 32, 32);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(Frame.ICONIFIED);
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
		lblNewLabel_2.setBackground(new Color(153, 153, 153));
		lblNewLabel_2.setIcon(new ImageIcon(RegisterMenu.class.getResource("/background/if_window-minimize_1954552.png")));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(356, 14, 32, 32);
		panel.add(lblNewLabel_2);
	}

	private void registerUser() {
		//Se crea un usuario para almacenar la informacion ingresada por el teclado
		int valueCombo = comboBoxCarrer.getSelectedIndex();
		Student user = new Student(this.textField.getText(),
				String.valueOf(passwordField.getPassword()), this.textField_1.getText(), this.textField_2.getText(),
				new Carrer(valueCombo, String.valueOf(comboBoxCarrer.getSelectedItem())),null);
		//Se inicia sesion de Hibernate con la Base de Datos
		session = HibernateConfig.getCurrentSession();
		//Se informa que se va transmitir informacion a la Base de Datos
		try {
			//Se guarda el user en la session para luego enviarse mediante el commit hacia la Base de Datos
			// Y luego se cierra la sesion.
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			
			JOptionPane.showMessageDialog(null, "Registro completado");
		} catch (Exception e) {
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

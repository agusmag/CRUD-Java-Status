package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import hibernate.HibernateConfig;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartMenu {

	private JFrame frmUniversity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Se crea una factoria.
					HibernateConfig.buildSessionFactory();
					StartMenu window = new StartMenu();
					window.frmUniversity.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUniversity = new JFrame();
		frmUniversity.setTitle("University CRUD");
		frmUniversity.setBounds(100, 100, 448, 550);
		frmUniversity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUniversity.setLocationRelativeTo(null);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmUniversity.dispose();
				LoginMenu lgMenu = new LoginMenu();
				lgMenu.getFrmLogin().setVisible(true);
			}
		});
		btnLogin.setBounds(12, 442, 103, 37);
		btnLogin.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnExit.setBounds(310, 442, 108, 37);
		btnExit.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUniversity.dispose();
				RegisterMenu rgMenu = new RegisterMenu();
				rgMenu.getFrame().setVisible(true);
			}
		});
		btnRegister.setBounds(150, 442, 127, 36);
		btnRegister.setFont(new Font("Consolas", Font.PLAIN, 18));
		frmUniversity.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(181, 391, 72, 64);
		label.setIcon(new ImageIcon(StartMenu.class.getResource("/background/if_User_Interface-20_2044268.png")));
		frmUniversity.getContentPane().add(label);
		frmUniversity.getContentPane().add(btnLogin);
		frmUniversity.getContentPane().add(btnRegister);
		frmUniversity.getContentPane().add(btnExit);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(StartMenu.class.getResource("/background/if_User_Interface-45_2044243.png")));
		label_1.setBounds(35, 404, 56, 37);
		frmUniversity.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(StartMenu.class.getResource("/background/if_User_Interface-02_2044283.png")));
		label_2.setBounds(330, 408, 56, 33);
		frmUniversity.getContentPane().add(label_2);
	}

	protected void exit() {
		System.exit(0);
	}

	public JFrame getFrmUniversity() {
		return frmUniversity;
	}

	public void setFrmUniversity(JFrame frmUniversity) {
		this.frmUniversity = frmUniversity;
	}
	
}

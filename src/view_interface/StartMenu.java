package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import hibernate.HibernateConfig;

import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.UIManager;

import org.omg.CORBA_2_3.portable.InputStream;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import java.awt.Rectangle;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

public class StartMenu {

	private JFrame frmUniversity;
	private int xx;
	private int xy;

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
		frmUniversity.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				xx = arg0.getX();
				xy = arg0.getY();
			}
		});
		frmUniversity.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				
				frmUniversity.setLocation(x - xx, y - xy);
			}
		});
		frmUniversity.setUndecorated(true);
		frmUniversity.getContentPane().setBackground(new Color(0, 0, 0));
		frmUniversity.setTitle("University CRUD");
		frmUniversity.setBounds(100, 100, 449, 428);
		frmUniversity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUniversity.setLocationRelativeTo(null);
		frmUniversity.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBounds(0, 342, 449, 86);
		frmUniversity.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblExit = new JLabel("");
		lblExit.setToolTipText("Salir del programa");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setBackground(new Color(153, 153, 153));
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBackground(new Color(153, 153, 153));
		lblExit.setOpaque(true);
		lblExit.setBounds(285, 11, 109, 64);
		panel.add(lblExit);
		lblExit.setIcon(new ImageIcon(StartMenu.class.getResource("/background/if_User_Interface-02_2044283.png")));
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setToolTipText("Logueate con tu cuenta de estudiante.");
		lblLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmUniversity.dispose();
				LoginMenu lgMenu = new LoginMenu();
				lgMenu.getFrmLogin().setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogin.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblLogin.setBackground(new Color(153, 153, 153));
			}
		});
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setOpaque(true);
		lblLogin.setBackground(new Color(153, 153, 153));
		lblLogin.setBounds(60, 11, 109, 64);
		panel.add(lblLogin);
		lblLogin.setIcon(new ImageIcon(StartMenu.class.getResource("/background/if_User_Interface-45_2044243.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 153, 153));
		panel_2.setBounds(60, 11, 334, 64);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblRegister = new JLabel("");
		lblRegister.setBounds(new Rectangle(115, 0, 109, 64));
		panel_2.add(lblRegister);
		lblRegister.setToolTipText("Registrate como estudiante.");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmUniversity.dispose();
				RegisterMenu rgMenu = new RegisterMenu();
				rgMenu.getFrame().setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegister.setBackground(new Color(102, 102, 102));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblRegister.setBackground(new Color(153, 153, 153));
			}
		});
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBackground(new Color(153, 153, 153));
		lblRegister.setOpaque(true);
		lblRegister.setIcon(new ImageIcon(StartMenu.class.getResource("/background/if_User_Interface-20_2044268.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(0, 0, 449, 59);
		frmUniversity.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setToolTipText("Cerrar el programa");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(51, 204, 0));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				exit();
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
		lblNewLabel_1.setBounds(400, 14, 32, 32);
		lblNewLabel_1.setIcon(new ImageIcon(StartMenu.class.getResource("/background/if_User_Interface-02_2044283.png")));
		lblNewLabel_1.setOpaque(true);
		panel_1.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setToolTipText("Minimizar el programa");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmUniversity.setState(Frame.ICONIFIED);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setBackground(new Color(153, 153, 153));
			}
		});
		label.setVerticalTextPosition(SwingConstants.TOP);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(StartMenu.class.getResource("/background/if_window-minimize_1954552.png")));
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(51, 204, 0));
		label.setBackground(new Color(153, 153, 153));
		label.setBounds(348, 14, 32, 32);
		panel_1.add(label);
		
		JLabel lblNewLabel = new JLabel("CRUD University");
		lblNewLabel.setForeground(new Color(51, 204, 51));
		lblNewLabel.setFont(new Font("LLPixel", Font.BOLD, 29));
		lblNewLabel.setBounds(12, 13, 289, 33);
		panel_1.add(lblNewLabel);
		
		JLabel lblClose = new JLabel("");
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setIcon(new ImageIcon(StartMenu.class.getResource("/background/background startMenu.jpg")));
		lblClose.setBackground(new Color(0, 0, 0));
		lblClose.setOpaque(true);
		lblClose.setBounds(16, 69, 415, 261);
		frmUniversity.getContentPane().add(lblClose);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 204, 51));
		panel_3.setBounds(10, 63, 427, 273);
		frmUniversity.getContentPane().add(panel_3);
	}

	protected void exit() {
		HibernateConfig.closeSessionFactory();
		System.exit(0);
	}

	public JFrame getFrmUniversity() {
		return frmUniversity;
	}

	public void setFrmUniversity(JFrame frmUniversity) {
		this.frmUniversity = frmUniversity;
	}
}

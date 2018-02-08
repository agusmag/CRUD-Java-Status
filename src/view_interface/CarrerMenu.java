package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import hibernate.HibernateConfig;
import model.Carrer;
import model.Student;

import java.awt.event.MouseMotionAdapter;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CarrerMenu {

	private JFrame frmCarrerMenu;
	
	private Student std;
	private JLabel lblNewLabel_4;
	private JComboBox comboBox;
	
	private int xx;
	private int xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CarrerMenu window = new CarrerMenu();
					window.frmCarrerMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CarrerMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCarrerMenu = new JFrame();
		frmCarrerMenu.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				getActualCarrer();
				getCarrers(comboBox);
			}
		});
		frmCarrerMenu.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				
				frmCarrerMenu.setLocation(x - xx, y - xy);
			}
		});
		frmCarrerMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		frmCarrerMenu.getContentPane().setBackground(new Color(0, 0, 0));
		frmCarrerMenu.setUndecorated(true);
		frmCarrerMenu.setBounds(100, 100, 392, 233);
		frmCarrerMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCarrerMenu.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(0, 0, 0, 53));
		panel.setBackground(new Color(51, 51, 51));
		
		JLabel lblNewLabel_2 = new JLabel("Choose Carrer");
		lblNewLabel_2.setForeground(new Color(51, 204, 51));
		lblNewLabel_2.setFont(new Font("LLPixel", Font.BOLD, 19));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(new Color(153, 153, 153));
			}
		});
		btnNewButton.setEnabled(false);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() != 0) {
					btnNewButton.setEnabled(true);
				}
			}
		});
		comboBox.addItem("Waiting Choise");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						Session session = HibernateConfig.getCurrentSession();
						
						int answer = JOptionPane.showConfirmDialog(null, "Estas seguro que desea cambiar de carrera? Todo su progreso se eliminará.");
						
						if (answer == JOptionPane.YES_OPTION) {
							session.beginTransaction();
							session.save(std);
							session.getTransaction().commit();
							session.close();
						}
						JOptionPane.showMessageDialog(null, "Carrera cambiada con exito.");
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Error al cambiar de carrera.");
					}
				}
		});
		btnNewButton.setBackground(new Color(153, 153, 153));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(CarrerMenu.class.getResource("/background/if_User_Interface-04_2044281.png")));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatusMenu stMenu = new StatusMenu();
				stMenu.setStd(std);
				stMenu.getFrmStatus().setVisible(true);
				frmCarrerMenu.dispose();
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(new Color(153, 153, 153));
			}
		});
		btnNewButton_1.setBackground(new Color(153, 153, 153));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(CarrerMenu.class.getResource("/background/if_User_Interface-09_2044237.png")));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
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
		lblNewLabel.setIcon(new ImageIcon(CarrerMenu.class.getResource("/background/if_User_Interface-02_2044283.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(153, 153, 153));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(348, 13, 32, 32);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmCarrerMenu.setState(Frame.ICONIFIED);
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
		label.setIcon(new ImageIcon(CarrerMenu.class.getResource("/background/if_window-minimize_1954552.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBackground(new Color(153, 153, 153));
		label.setBounds(304, 13, 32, 32);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Carrer");
		lblNewLabel_1.setForeground(new Color(51, 204, 51));
		lblNewLabel_1.setFont(new Font("LLPixel", Font.BOLD, 29));
		lblNewLabel_1.setBounds(12, 13, 135, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Actual Carrer");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(0, 0, 0));
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(new Color(51, 204, 51));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(frmCarrerMenu.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(13))
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
						.addComponent(comboBox, 0, 198, Short.MAX_VALUE))
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		frmCarrerMenu.getContentPane().setLayout(groupLayout);
	}
	
	private void getActualCarrer() {
		//Se obtienen las carreras y se almacenan en una lista
		try {
			Query query = HibernateConfig.getCurrentSession().createQuery("FROM Student s WHERE s.username = :username AND s.carrer.idCarrer = :idCarrer");
			query.setParameter("username", std.getUsername());
			query.setParameter("idCarrer", std.getCarrer().getIdCarrer());
			std = (Student) query.uniqueResult();
					
			//Se carga la carrera actual en la label.
			lblNewLabel_4.setText(std.getCarrer().getName());
				
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener la carrera actual del estudiante.");
		}
		
	}

	private void getCarrers(JComboBox comboBox) {
		//Se obtienen las carreras y se almacenan en una lista
		try {
			
			Query query = HibernateConfig.getCurrentSession().createQuery("FROM Carrer");
			List<Carrer> carrerList = query.list();
			
			//Se cargan en el comboBox
			for (Carrer carrer : carrerList) {
				if (!carrer.getName().equals(std.getCarrer().getName()))
					comboBox.addItem(carrer.getName());
			}
			comboBox.setSelectedIndex(0);
		
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener las carreras.");
		}
	}

	public JFrame getCarrerMenu() {
		return frmCarrerMenu;
	}

	public void setCarrerMenu(JFrame carrerMenu) {
		frmCarrerMenu = carrerMenu;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}
	
}

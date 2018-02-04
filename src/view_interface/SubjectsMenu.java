package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import hibernate.HibernateConfig;
import model.Enrollment;
import model.Student;
import model.Subject;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class SubjectsMenu {

	private JFrame frmSubjects;
	private JList listProgress;
	private JList listComplete;
	private JList listNext;
	
	private int xx;
	private int xy;

	private Student std;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubjectsMenu window = new SubjectsMenu();
					window.frmSubjects.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SubjectsMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSubjects = new JFrame();
		frmSubjects.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy= e.getY();
			}
		});
		frmSubjects.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				
				frmSubjects.setLocation(x - xx, y - xy);
			}
		});
		frmSubjects.getContentPane().setBackground(new Color(0, 0, 0));
		frmSubjects.setUndecorated(true);
		frmSubjects.addComponentListener(new ComponentAdapter() {
		});
		frmSubjects.setTitle("Subjects");
		frmSubjects.setBounds(100, 100, 884, 564);
		frmSubjects.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSubjects.setLocationRelativeTo(null);
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		DefaultListModel<String> listModelC = new DefaultListModel<String>();

		JButton btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setBackground(new Color(153, 153, 153));
			}
		});
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(153, 153, 153));
		btnBack.setIcon(new ImageIcon(SubjectsMenu.class.getResource("/background/if_User_Interface-09_2044237.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatusMenu stMenu = new StatusMenu();
				stMenu.setStd(std);
				frmSubjects.dispose();
				stMenu.getFrmStatus().setVisible(true);
			}
		});
		btnBack.setBounds(667, 518, 153, 33);
		btnBack.setFont(new Font("Consolas", Font.PLAIN, 18));

		frmSubjects.getContentPane().setLayout(null);
		frmSubjects.getContentPane().add(btnBack);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(578, 0, 11, 444);

		JSeparator separator = new JSeparator();
		separator.setBounds(285, 52, 4, 451);
		frmSubjects.getContentPane().add(separator);
		separator.setOpaque(true);
		separator.setBackground(new Color(51, 204, 51));
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOpaque(true);
		separator_2.setBackground(new Color(51, 204, 51));
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(0, 503, 884, 4);
		frmSubjects.getContentPane().add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(585, 52, 4, 451);
		frmSubjects.getContentPane().add(separator_3);
		separator_3.setBackground(new Color(51, 204, 51));
		separator_3.setOpaque(true);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.BLACK);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 884, 53);
		frmSubjects.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setBackground(new Color(153, 153, 153));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel
				.setIcon(new ImageIcon(SubjectsMenu.class.getResource("/background/if_User_Interface-02_2044283.png")));
		lblNewLabel.setBackground(new Color(153, 153, 153));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(840, 13, 32, 32);
		panel.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				label.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				label.setBackground(new Color(153, 153, 153));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frmSubjects.setState(Frame.ICONIFIED);
			}
		});
		label.setIcon(new ImageIcon(SubjectsMenu.class.getResource("/background/if_window-minimize_1954552.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setOpaque(true);
		label.setBackground(new Color(153, 153, 153));
		label.setBounds(796, 13, 32, 32);
		panel.add(label);

		JLabel lblNewLabel_1 = new JLabel("Subject");
		lblNewLabel_1.setForeground(new Color(51, 204, 51));
		lblNewLabel_1.setFont(new Font("LLPixel", Font.BOLD, 29));
		lblNewLabel_1.setBounds(12, 13, 145, 32);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(0, 0, 0));
			}
		});
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setForeground(new Color(51, 51, 51));
		panel_1.setBounds(0, 52, 285, 451);
		frmSubjects.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblInProgress = new JLabel("In Progress");
		lblInProgress.setForeground(new Color(51, 204, 51));
		lblInProgress.setBounds(0, 0, 288, 49);
		panel_1.add(lblInProgress);
		lblInProgress.setFont(new Font("LLPixel", Font.PLAIN, 20));
		lblInProgress.setHorizontalAlignment(SwingConstants.CENTER);

		listProgress = new JList();
		listProgress.setBounds(12, 55, 260, 234);
		panel_1.add(listProgress);
		listProgress.setVisibleRowCount(5);
		listProgress.setFont(new Font("Consolas", Font.PLAIN, 14));
		listProgress.setModel(listModel);

		JButton btnAddSubject = new JButton("Add");
		btnAddSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAddSubject.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAddSubject.setBackground(new Color(153, 153, 153));
			}
		});
		btnAddSubject.setBorderPainted(false);
		btnAddSubject.setBackground(new Color(153, 153, 153));
		btnAddSubject.setBounds(81, 308, 128, 49);
		panel_1.add(btnAddSubject);
		btnAddSubject.setVisible(false);
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSubjects.dispose();
				AddSubjectMenu asMenu = new AddSubjectMenu();
				asMenu.setStd(std);
				asMenu.setSbj(new Subject());
				asMenu.getFrmAddSubject().setVisible(true);
			}
		});
		btnAddSubject.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddSubject.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton btnModify = new JButton("Modify");
		btnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnModify.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnModify.setBackground(new Color(153, 153, 153));
			}
		});
		btnModify.setBorderPainted(false);
		btnModify.setBackground(new Color(153, 153, 153));
		btnModify.setBounds(81, 355, 128, 49);
		panel_1.add(btnModify);
		btnModify.setVisible(false);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listProgress.isSelectionEmpty()) {
					// Se carga la materia seleccionada por el usuario en la
					// lista de materias.
					ModifySubjectMenu msMenu = new ModifySubjectMenu();
					msMenu.setStd(std);
					msMenu.getSubjectsCombo().addItem(listProgress.getSelectedValue());
					msMenu.getSubjectsCombo().setSelectedItem(listProgress.getSelectedValue());
					msMenu.getFrame().setVisible(true);
					frmSubjects.dispose();
				}
			}
		});
		btnModify.setFont(new Font("Consolas", Font.PLAIN, 18));

		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDelete.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDelete.setBackground(new Color(153, 153, 153));
			}
		});
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(153, 153, 153));
		btnDelete.setBounds(81, 402, 128, 49);
		panel_1.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listProgress.isSelectionEmpty()) {

					JOptionPane jpane = new JOptionPane();
					int answer = jpane.showConfirmDialog(null, "Estas seguro que deseas eliminar la materia?.");

					if (answer == jpane.YES_OPTION) {
						String sbjName = (String) listProgress.getSelectedValue();
						Enrollment enrollmentLocal = std.getEnrollment(sbjName);
						std.getEnrollments().remove(enrollmentLocal);
						listModel.removeElement(sbjName);

						try {
							Session session = HibernateConfig.getCurrentSession();
							session.beginTransaction();
							session.delete(enrollmentLocal);
							session.getTransaction().commit();
							session.close();

							JOptionPane.showMessageDialog(null, "Materia eliminada correctamente.");
						} catch (Exception m) {
							JOptionPane.showMessageDialog(null, "Error al eliminar la materia seleccionada.");
						}
					}
				}
			}
		});
		btnDelete.setVisible(false);
		btnDelete.setFont(new Font("Consolas", Font.PLAIN, 18));

		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_2.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(0, 0, 0));
			}
		});
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(290, 52, 295, 451);
		frmSubjects.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNextStep = new JLabel("Next Step");
		lblNextStep.setForeground(new Color(51, 204, 51));
		lblNextStep.setBounds(2, 0, 288, 49);
		panel_2.add(lblNextStep);
		lblNextStep.setFont(new Font("LLPixel", Font.PLAIN, 20));
		lblNextStep.setHorizontalAlignment(SwingConstants.CENTER);

		listNext = new JList();
		listNext.setBounds(16, 50, 260, 237);
		panel_2.add(listNext);
		listNext.setFont(new Font("Consolas", Font.PLAIN, 14));

		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(0, 0, 0));
			}
		});
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(590, 53, 294, 451);
		frmSubjects.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblComplete = new JLabel("Complete");
		lblComplete.setForeground(new Color(51, 204, 51));
		lblComplete.setBounds(0, 0, 301, 49);
		panel_3.add(lblComplete);
		lblComplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplete.setFont(new Font("LLPixel", Font.PLAIN, 20));

		listComplete = new JList();
		listComplete.setBounds(20, 50, 260, 238);
		panel_3.add(listComplete);
		listComplete.setFont(new Font("Consolas", Font.PLAIN, 14));
		listComplete.setModel(listModelC);

		JButton btnDeleteComplete = new JButton("Delete");
		btnDeleteComplete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDeleteComplete.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDeleteComplete.setBackground(new Color(153, 153, 153));
			}
		});
		btnDeleteComplete.setBorderPainted(false);
		btnDeleteComplete.setBackground(new Color(153, 153, 153));
		btnDeleteComplete.setBounds(95, 301, 128, 49);
		panel_3.add(btnDeleteComplete);
		btnDeleteComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listComplete.isSelectionEmpty()) {

					JOptionPane jpane = new JOptionPane();
					int answer = jpane.showConfirmDialog(null, "Estas seguro que deseas eliminar la materia?.");

					if (answer == jpane.YES_OPTION) {
						String sbjName = (String) listComplete.getSelectedValue();
						Enrollment enrollmentLocal = std.getEnrollment(sbjName);
						std.getEnrollments().remove(enrollmentLocal);
						listModelC.removeElement(sbjName);

						try {
							Session session = HibernateConfig.getCurrentSession();
							session.beginTransaction();
							session.delete(enrollmentLocal);
							session.getTransaction().commit();
							session.close();

							JOptionPane.showMessageDialog(null, "Materia eliminada correctamente.");
						} catch (Exception m) {
							JOptionPane.showMessageDialog(null, "Error al eliminar la materia seleccionada.");
						}
					}
				}
			}
		});
		btnDeleteComplete.setVisible(false);
		btnDeleteComplete.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton btnShow = new JButton("Show");
		btnShow.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnShow.setHorizontalTextPosition(SwingConstants.CENTER);
		btnShow.setIcon(new ImageIcon(SubjectsMenu.class.getResource("/background/if_User_Interface-39_2044249SMALL.png")));
		btnShow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnShow.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnShow.setBackground(new Color(153, 153, 153));
			}
		});
		btnShow.setBorderPainted(false);
		btnShow.setBackground(new Color(153, 153, 153));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getInformation(listModel, listModelC);
				btnAddSubject.setVisible(true);
				btnModify.setVisible(true);
				btnDeleteComplete.setVisible(true);
				btnDelete.setVisible(true);
				btnShow.setEnabled(false);
			}
		});
		btnShow.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnShow.setBounds(359, 509, 153, 56);
		frmSubjects.getContentPane().add(btnShow);

	}

	protected void getInformation(DefaultListModel<String> listModel, DefaultListModel<String> listModelC) {
		// Se realiza una query para almacenar todas las materias que tiene el
		// alumno actualmente.

		try {
			Query query = HibernateConfig.getCurrentSession()
					.createQuery("FROM Enrollment e WHERE e.student.username = :Students_username");
			query.setParameter("Students_username", std.getUsername());
			List<Enrollment> enrollmentsLocal = query.list();
			std.setEnrollments(enrollmentsLocal);

			for (Enrollment enrollment : std.getEnrollments()) {
				if (enrollment.getStatus().equals("CURSANDO") || enrollment.getStatus().equals("FINAL")) {
					listModel.addElement(enrollment.getSubject().getName());
				} else if (enrollment.getStatus().equals("APROBADA")) {
					listModelC.addElement(enrollment.getSubject().getName());
				}

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener las materias del estudiante");
		}
	}

	public JFrame getFrmSubjets() {
		return frmSubjects;
	}

	public void setFrmSubjets(JFrame frmSubjets) {
		this.frmSubjects = frmSubjets;
	}

	public JFrame getFrmSubjects() {
		return frmSubjects;
	}

	public void setFrmSubjects(JFrame frmSubjects) {
		this.frmSubjects = frmSubjects;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}
}

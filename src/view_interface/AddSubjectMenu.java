package view_interface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import org.hibernate.Session;
import org.hibernate.query.Query;
import hibernate.HibernateConfig;
import model.Enrollment;
import model.Student;
import model.Subject;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Frame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class AddSubjectMenu {

	private JFrame frmAddSubject;
	private JTextField textName;
	private JTextField textCode;
	private JTextField textCorrelatives;
	private JTextField textHsWeek;
	private Student std;
	private Enrollment enrollment = new Enrollment();
	private Subject sbj;
	
	private int xx;
	private int xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSubjectMenu window = new AddSubjectMenu();
					window.frmAddSubject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddSubjectMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JLabel lblNameTag = new JLabel("Name");
		lblNameTag.setForeground(new Color(51, 204, 51));
		lblNameTag.setBounds(19, 163, 107, 29);
		lblNameTag.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblNameTag.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCodeTag = new JLabel("Code");
		lblCodeTag.setForeground(new Color(51, 204, 51));
		lblCodeTag.setBounds(17, 209, 65, 24);
		lblCodeTag.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblCodeTag.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCorrelativeTag = new JLabel("Correlative");
		lblCorrelativeTag.setForeground(new Color(51, 204, 51));
		lblCorrelativeTag.setBounds(17, 255, 109, 29);
		lblCorrelativeTag.setVerticalAlignment(SwingConstants.TOP);
		lblCorrelativeTag.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblCorrelativeTag.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblHsWeekTag = new JLabel("Hs/Week");
		lblHsWeekTag.setForeground(new Color(51, 204, 51));
		lblHsWeekTag.setBounds(17, 299, 109, 25);
		lblHsWeekTag.setVerticalAlignment(SwingConstants.TOP);
		lblHsWeekTag.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblHsWeekTag.setHorizontalAlignment(SwingConstants.LEFT);
		
		textName = new JTextField();
		textName.setEnabled(false);
		textName.setBounds(135, 157, 228, 46);
		textName.setColumns(10);
		
		textCode = new JTextField();
		textCode.setEnabled(false);
		textCode.setBounds(135, 201, 228, 46);
		textCode.setColumns(10);
		
		textCorrelatives = new JTextField();
		textCorrelatives.setEnabled(false);
		textCorrelatives.setBounds(135, 246, 228, 46);
		textCorrelatives.setColumns(10);
		
		textHsWeek = new JTextField();
		textHsWeek.setEnabled(false);
		textHsWeek.setBounds(135, 290, 228, 46);
		textHsWeek.setColumns(10);
		
		JLabel lblcode = new JLabel("(Code/Code/etc)");
		lblcode.setBounds(375, 260, 106, 16);
		lblcode.setVerticalAlignment(SwingConstants.BOTTOM);
		lblcode.setForeground(new Color(128, 128, 128));
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(51, 204, 51));
		lblStatus.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(17, 347, 109, 22);
		
		JComboBox statusCombo = new JComboBox();
		statusCombo.setEnabled(false);
		statusCombo.setBounds(135, 336, 228, 46);
		statusCombo.addItem("");
		statusCombo.addItem("NO CURSADA");
		
		JComboBox subjectsCombo = new JComboBox();
		subjectsCombo.setFont(new Font("Consolas", Font.PLAIN, 15));
		subjectsCombo.addItem("           Select a Subject");
		subjectsCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se realiza una consulta para obtener las materias para que el estudiante las agregue a su lista
				try {
					if (subjectsCombo.getSelectedIndex() != 0) {
						Query query = HibernateConfig.getCurrentSession().createQuery("FROM Subject s WHERE s.name = :nameSubject");
						query.setParameter("nameSubject", (String) subjectsCombo.getSelectedItem());
						enrollment.setSubject((Subject)query.uniqueResult());
						textName.setText(enrollment.getSubject().getName());
						textCode.setText(String.valueOf(enrollment.getSubject().getCode()));
						textCorrelatives.setText(enrollment.getSubject().getCorrelatives());
						textHsWeek.setText(String.valueOf(enrollment.getSubject().getHoursWeek()));
						statusCombo.setSelectedItem("NO CURSADA");
					} else {
						textName.setText("");
						textCode.setText("");
						textCorrelatives.setText("");
						textHsWeek.setText("");
						statusCombo.setSelectedItem("");
					}
				} catch (Exception m) {
						JOptionPane.showMessageDialog(null, "Error al obtener los datos de la materia seleccionada");
				}
			}
		});
		subjectsCombo.setBounds(95, 66, 304, 71);
		
		JButton btnConfirm = new JButton("");
		btnConfirm.setToolTipText("Agregar materia a la cursada actual.");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnConfirm.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnConfirm.setBackground(new Color(153, 153, 153));
			}
		});
		btnConfirm.setIcon(new ImageIcon(AddSubjectMenu.class.getResource("/background/if_User_Interface-04_2044281.png")));
		btnConfirm.setBackground(new Color(153, 153, 153));
		btnConfirm.setBorderPainted(false);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se verifica que cumpla con las correlativas
				if (checkCorrelatives()) {
					//Se completa la informacion del enrollment y se agrega a las listas de su respectivo usuario y su respectiva materia.
					enrollment.setStudent(std);
					enrollment.setStatus("CURSANDO");
					sbj.getEnrollments().add(enrollment);
					std.getEnrollments().add(enrollment);
					try {
						//Se crea una session y se guarda el enrollment correspondiente.
						
						Session session = HibernateConfig.getCurrentSession();
						session.beginTransaction();
						session.save(enrollment);
						session.getTransaction().commit();
						session.close();
						
						JOptionPane.showMessageDialog(null, "Materia Agregada a la cursada.");
						subjectsCombo.removeItem(enrollment.getSubject().getName());
						subjectsCombo.setSelectedItem("           Select a Subject");
						
					}catch (Exception m) {
						JOptionPane.showMessageDialog(null, "Error al incorporar la materia.");
					}
				} else {
					JOptionPane jp = new JOptionPane();
					JOptionPane.showMessageDialog(null, "Primero debes aprobar las correlativas que tiene esta materia.");
				}
			}
		});
		btnConfirm.setBounds(91, 435, 132, 35);
		btnConfirm.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		frmAddSubject = new JFrame();
		frmAddSubject.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				
				frmAddSubject.setLocation(x - xx, y - xy);
			}
		});
		frmAddSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				xx = arg0.getX();
				xy = arg0.getY();
			}
		});
		frmAddSubject.getContentPane().setBackground(new Color(0, 0, 0));
		frmAddSubject.getContentPane().setForeground(new Color(0, 0, 0));
		frmAddSubject.setUndecorated(true);
		frmAddSubject.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				getInformation(subjectsCombo);
			}
		});
		frmAddSubject.setTitle("Add a Subject");
		frmAddSubject.setBounds(100, 100, 500, 483);
		frmAddSubject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddSubject.setLocationRelativeTo(null);
		
		JButton Cancel = new JButton("");
		Cancel.setToolTipText("Cancelar la inscripcion a la materia.");
		Cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cancel.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Cancel.setBackground(new Color(153, 153, 153));
			}
		});
		Cancel.setIcon(new ImageIcon(AddSubjectMenu.class.getResource("/background/if_User_Interface-09_2044237.png")));
		Cancel.setBorderPainted(false);
		Cancel.setBackground(new Color(153, 153, 153));
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectsMenu sbMenu = new SubjectsMenu();
				sbMenu.setStd(std);
				sbMenu.getFrmSubjets().setVisible(true);
				frmAddSubject.dispose();
			}
		});
		Cancel.setBounds(259, 436, 136, 33);
		Cancel.setFont(new Font("Consolas", Font.PLAIN, 18));
		frmAddSubject.getContentPane().add(subjectsCombo);
		frmAddSubject.getContentPane().setLayout(null);
		frmAddSubject.getContentPane().add(lblCorrelativeTag);
		frmAddSubject.getContentPane().add(lblHsWeekTag);
		frmAddSubject.getContentPane().add(textHsWeek);
		frmAddSubject.getContentPane().add(textCorrelatives);
		frmAddSubject.getContentPane().add(lblCodeTag);
		frmAddSubject.getContentPane().add(lblNameTag);
		frmAddSubject.getContentPane().add(textName);
		frmAddSubject.getContentPane().add(textCode);
		frmAddSubject.getContentPane().add(lblcode);
		frmAddSubject.getContentPane().add(statusCombo);
		frmAddSubject.getContentPane().add(lblStatus);
		frmAddSubject.getContentPane().add(btnConfirm);
		frmAddSubject.getContentPane().add(Cancel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 500, 53);
		frmAddSubject.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		lblNewLabel.setIcon(new ImageIcon(AddSubjectMenu.class.getResource("/background/if_User_Interface-02_2044283.png")));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(153, 153, 153));
		lblNewLabel.setBounds(456, 13, 32, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAddSubject.setState(Frame.ICONIFIED);
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
		lblNewLabel_1.setIcon(new ImageIcon(AddSubjectMenu.class.getResource("/background/if_window-minimize_1954552.png")));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_1.setBounds(412, 13, 32, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Add Subject");
		lblNewLabel_2.setForeground(new Color(51, 204, 51));
		lblNewLabel_2.setFont(new Font("LLPixel", Font.BOLD, 29));
		lblNewLabel_2.setBounds(12, 13, 213, 32);
		panel.add(lblNewLabel_2);
		
	}

	protected boolean checkCorrelatives() {
	String [] strCorrelatives = enrollment.getSubject().getCorrelatives().split("/");
		ArrayList<String> strStdComplete = new ArrayList<>();

		//Se cargan todas las materias aprobadas del alumno.
		for (Enrollment enrollmentLocal : std.getEnrollments()) {
			if (enrollmentLocal.getStatus().equals("APROBADA"))
				strStdComplete.add(String.valueOf(enrollmentLocal.getSubject().getCode()));
		}

		//Se comprueba que las correlativas, si existe alguna, se encuentren dentro de las aprobadas.
		if (!strCorrelatives[0].equals("")) {
			for (int i = 0; i < strCorrelatives.length; i++) {
				if (!strStdComplete.contains(strCorrelatives[i]))
					return false;
			}
			return true;
		}
		return true;
	}

	private void getInformation(JComboBox subjectsCombo) {
		List<Subject> sbjList;
		String subjectName;
		//try {
			//Se realiza una consulta para obtener las materias de la carrera.
			Query query = HibernateConfig.getCurrentSession().createQuery("FROM Subject s WHERE s.carrer.idCarrer = :Carrers_idCarrer");
			query.setParameter("Carrers_idCarrer", std.getCarrer().getIdCarrer());
			sbjList = query.list();
			
			for (Subject subject : sbjList) {
				if (!std.containSubject(subject.getName())) {
					subjectsCombo.addItem(subject.getName());					
				}
			}
			
		//} catch (Exception e) {
		//	JOptionPane.showMessageDialog(null, "Error al obtener las materias de la carrera");
		//}
	}

	public JFrame getFrmAddSubject() {
		return frmAddSubject;
	}

	public void setFrmAddSubject(JFrame frmAddSubject) {
		this.frmAddSubject = frmAddSubject;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}

	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}

	public Subject getSbj() {
		return sbj;
	}

	public void setSbj(Subject sbj) {
		this.sbj = sbj;
	}
}

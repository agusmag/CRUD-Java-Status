package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.transaction.Transactional.TxType;
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
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JSeparator;
import java.awt.Frame;

public class AddSubjectMenu {

	private JFrame frmAddSubject;
	private JTextField textName;
	private JTextField textCode;
	private JTextField textCorrelatives;
	private JTextField textHsWeek;
	private Student std;
	private Enrollment enrollment = new Enrollment();
	private Subject sbj;

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
		lblNameTag.setBounds(20, 93, 107, 29);
		lblNameTag.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblNameTag.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCodeTag = new JLabel("Code");
		lblCodeTag.setBounds(20, 138, 65, 24);
		lblCodeTag.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblCodeTag.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCorrelativeTag = new JLabel("Correlative");
		lblCorrelativeTag.setBounds(20, 183, 109, 29);
		lblCorrelativeTag.setVerticalAlignment(SwingConstants.TOP);
		lblCorrelativeTag.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblCorrelativeTag.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblHsWeekTag = new JLabel("Hs/Week");
		lblHsWeekTag.setBounds(20, 228, 109, 25);
		lblHsWeekTag.setVerticalAlignment(SwingConstants.TOP);
		lblHsWeekTag.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblHsWeekTag.setHorizontalAlignment(SwingConstants.LEFT);
		
		textName = new JTextField();
		textName.setEnabled(false);
		textName.setBounds(140, 93, 228, 25);
		textName.setColumns(10);
		
		textCode = new JTextField();
		textCode.setEnabled(false);
		textCode.setBounds(140, 138, 228, 25);
		textCode.setColumns(10);
		
		textCorrelatives = new JTextField();
		textCorrelatives.setEnabled(false);
		textCorrelatives.setBounds(141, 183, 228, 25);
		textCorrelatives.setColumns(10);
		
		textHsWeek = new JTextField();
		textHsWeek.setEnabled(false);
		textHsWeek.setBounds(141, 228, 228, 25);
		textHsWeek.setColumns(10);
		
		JLabel lblcode = new JLabel("(Code/Code/etc)");
		lblcode.setBounds(376, 186, 106, 16);
		lblcode.setVerticalAlignment(SwingConstants.BOTTOM);
		lblcode.setForeground(new Color(128, 128, 128));
		
		JLabel lblSelectASubject = new JLabel("Select a subject");
		lblSelectASubject.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblSelectASubject.setBounds(18, 31, 179, 38);		
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(18, 272, 109, 22);
		
		JComboBox statusCombo = new JComboBox();
		statusCombo.setEnabled(false);
		statusCombo.setBounds(139, 272, 228, 25);
		
		JComboBox subjectsCombo = new JComboBox();
		subjectsCombo.addItem("Select a Subject");
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
						statusCombo.addItem("NO CURSADA");
						statusCombo.setSelectedItem("NO CURSADA");
					}
				} catch (Exception m) {
						JOptionPane.showMessageDialog(null, "Error al obtener los datos de la materia seleccionada");
				}
			}
		});
		subjectsCombo.setBounds(204, 37, 198, 27);
		
		JButton btnConfirm = new JButton("Confirm");
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
						subjectsCombo.setSelectedItem(0);
						
					}catch (Exception m) {
						JOptionPane.showMessageDialog(null, "Error al incorporar la materia.");
					}
				} else {
					JOptionPane jp = new JOptionPane();
					jp.showMessageDialog(null, "Primero debes aprobar las correlativas que tiene esta materia.");
				}
			}
		});
		btnConfirm.setBounds(91, 348, 132, 35);
		btnConfirm.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		frmAddSubject = new JFrame();
		frmAddSubject.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				getInformation(subjectsCombo);
			}
		});
		frmAddSubject.setTitle("Add a Subject");
		frmAddSubject.setBounds(100, 100, 500, 443);
		frmAddSubject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddSubject.setLocationRelativeTo(null);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectsMenu sbMenu = new SubjectsMenu();
				sbMenu.setStd(std);
				sbMenu.getFrmSubjets().setVisible(true);
				frmAddSubject.dispose();
			}
		});
		Cancel.setBounds(259, 349, 136, 33);
		Cancel.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		frmAddSubject.getContentPane().add(lblSelectASubject);
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
				if (strStdComplete.contains(strCorrelatives[i]))
					return true;
			}
			return false;
		}
		return true;
	}

	private void getInformation(JComboBox subjectsCombo) {
		List<Subject> sbjList;
		String subjectName;
		try {
			//Se realiza una consulta para obtener las materias de la carrera.
			Query query = HibernateConfig.getCurrentSession().createQuery("FROM Subject s WHERE s.carrer.idCarrer = :Carrers_idCarrer");
			query.setParameter("Carrers_idCarrer", std.getCarrer().getIdCarrer());
			sbjList = query.list();
			
			for (Subject subject : sbjList) {
				if (!std.containSubject(subject.getName())) {
					subjectsCombo.addItem(subject.getName());					
				}
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener las materias de la carrera");
		}
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

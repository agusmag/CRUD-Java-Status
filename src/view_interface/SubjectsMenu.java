package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

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

public class SubjectsMenu {

	private JFrame frmSubjects;
	private JList listProgress;
	private JList listComplete;
	private JList listNext;
	
	private String user;
	private String pass;
	private int idCarrer;

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
		frmSubjects.addComponentListener(new ComponentAdapter() {
		});
		frmSubjects.setTitle("Subjects");
		frmSubjects.setBounds(100, 100, 712, 564);
		frmSubjects.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSubjects.setLocationRelativeTo(null);
		
		JButton btnAddSubject = new JButton("Add");
		btnAddSubject.setVisible(false);
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSubjects.dispose();
				ChangeSubjectMenu csMenu = new ChangeSubjectMenu();
				csMenu.setUser(user);
				csMenu.setIdCarrer(idCarrer);
				csMenu.getFrmChangeSubject().setVisible(true);
			}
		});
		btnAddSubject.setBounds(35, 289, 186, 31);
		btnAddSubject.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddSubject.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatusMenu stMenu = new StatusMenu();
				stMenu.setUser(user);
				stMenu.setPass(pass);
				frmSubjects.dispose();
				stMenu.getFrmStatus().setVisible(true);
			}
		});
		btnBack.setBounds(267, 471, 153, 33);
		btnBack.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(239, 0, 11, 405);
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblInProgress = new JLabel("In Progress");
		lblInProgress.setBounds(59, 24, 138, 31);
		lblInProgress.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblInProgress.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNextStep = new JLabel("Next Step");
		lblNextStep.setBounds(297, 24, 108, 31);
		lblNextStep.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNextStep.setHorizontalAlignment(SwingConstants.CENTER);
		
		listProgress = new JList();
		listProgress.setVisibleRowCount(5);
		listProgress.setFont(new Font("Consolas", Font.PLAIN, 14));
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listProgress.setModel(listModel);
		
		
		listNext = new JList();
		listNext.setBounds(257, 61, 186, 204);
		
		listComplete = new JList();
		listComplete.setBounds(473, 61, 186, 331);
		DefaultListModel<String> listModelC = new DefaultListModel<String>();
		listComplete.setModel(listModelC);
		
		listProgress.setBounds(35, 61, 186, 204);
		frmSubjects.getContentPane().setLayout(null);
		frmSubjects.getContentPane().add(btnAddSubject);
		frmSubjects.getContentPane().add(listProgress);
		frmSubjects.getContentPane().add(lblInProgress);
		frmSubjects.getContentPane().add(separator);
		frmSubjects.getContentPane().add(btnBack);
		frmSubjects.getContentPane().add(lblNextStep);
		frmSubjects.getContentPane().add(listComplete);
		frmSubjects.getContentPane().add(listNext);

		JButton btnShow = new JButton("Show");
		btnShow.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnShow.setBounds(267, 423, 153, 35);
		frmSubjects.getContentPane().add(btnShow);
		
		JButton btnModify = new JButton("Modify");
		btnModify.setVisible(false);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifySubjectMenu msMenu = new ModifySubjectMenu();
				for (int i = 0; i < listModel.size(); i++) {
					msMenu.getSubjectsCombo().addItem(listModel.getElementAt(i));
				}
				msMenu.getFrame().setVisible(true);
				frmSubjects.dispose();
				/*
				//Se realiza una consulta para obtener el estado y notas de la materia seleccionada
				query = HibernateConfig.getCurrentSession().createQuery
						("FROM Enrollment e WHERE e.student_username = :Students_username AND e.subject_code = :Subjects_code");
				query.setParameter("Students_username", user);
				query.setParameter("Subjects_code", sbj.getCode());
				enrollment = (Enrollment) query.uniqueResult();
				if (enrollment.getStatus() != null) {
					System.out.println("ENTRE");
					switch (enrollment.getStatus()) {
						case"APROBADA":
						case"REPROBADA":
							lblMarkOne.setText(String.valueOf(enrollment.getMarkOne()));
							lblMarkTwo.setText(String.valueOf(enrollment.getMarkTwo()));;
							markOneCombo.setVisible(true);
							markTwoCombo.setVisible(true);
							break;
						case"CURSANDO":
							lblFirstMark.setVisible(true);
							lblSecondMark.setVisible(true);
							for (int i = 1; i < 11; i++) {
								markOneCombo.addItem(i);
								markTwoCombo.addItem(i);
							}
							markOneCombo.setVisible(true);
							markTwoCombo.setVisible(true);
							break;
					}
					btnConfirm.setText("Modify Subject");
				} else {
					statusCombo.setSelectedItem("NO CURSANDO");
					btnConfirm.setText("Add Subject");
				}
				*/
			}
		});
		btnModify.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnModify.setBounds(35, 333, 186, 31);
		frmSubjects.getContentPane().add(btnModify);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(455, 0, 11, 405);
		frmSubjects.getContentPane().add(separator_1);
		
		
		JLabel lblComplete = new JLabel("Complete");
		lblComplete.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplete.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblComplete.setBounds(513, 24, 108, 31);
		frmSubjects.getContentPane().add(lblComplete);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLACK);
		separator_2.setBounds(12, 405, 670, 13);
		frmSubjects.getContentPane().add(separator_2);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			getInformation(listModel, listModelC);
			btnAddSubject.setVisible(true);
			btnModify.setVisible(true);
		}
		});
	}

	protected void getInformation(DefaultListModel listModel, DefaultListModel listModelC) {
		//Se realiza una query para almacenar todas las materias que tiene el alumno actualmente.
		try {
			Query query = HibernateConfig.getCurrentSession().createQuery("FROM Enrollment e WHERE e.student_username = :Students_username");
			query.setParameter("Students_username", user);
			List<Enrollment> enrollments = query.list();
			//Una vez obtenida la materia, se consulta por el nombre de la materia con el codigo obtenido.
			Subject subject = new Subject();
			for (Enrollment enrollment : enrollments) {
				query = HibernateConfig.getCurrentSession().createQuery("FROM Subject s WHERE s.code = :code");
				query.setParameter("code", enrollment.getSubject().getCode());
				subject = (Subject) query.uniqueResult();
					if (enrollment.getStatus() == "CURSANDO") {
					listModel.addElement(subject.toString());
				} else if (enrollment.getStatus() == "APROBADA"){
					listModelC.addElement(subject.toString());
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIdCarrer() {
		return idCarrer;
	}

	public void setIdCarrer(int idCarrer) {
		this.idCarrer = idCarrer;
	}
	
}

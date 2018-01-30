package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import org.hibernate.Hibernate;
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
				AddSubjectMenu asMenu = new AddSubjectMenu();
				asMenu.setStd(std);
				asMenu.setSbj(new Subject());
				asMenu.getFrmAddSubject().setVisible(true);
			}
		});
		btnAddSubject.setBounds(35, 289, 186, 31);
		btnAddSubject.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddSubject.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatusMenu stMenu = new StatusMenu();
				stMenu.setStd(std);
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
		listComplete.setBounds(473, 61, 186, 204);
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
				//Se cargan las materias que actualmente cursa el usuario en el comboBox para poder modificarse.
				ModifySubjectMenu msMenu = new ModifySubjectMenu();
				msMenu.setStd(std);
				for (int i = 0; i < listModel.size(); i++) {
					msMenu.getSubjectsCombo().addItem(listModel.getElementAt(i));
				}
				
				msMenu.getFrame().setVisible(true);
				frmSubjects.dispose();
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

	protected void getInformation(DefaultListModel<String> listModel, DefaultListModel<String> listModelC) {
		//Se realiza una query para almacenar todas las materias que tiene el alumno actualmente.
		
		try {
			Query query = HibernateConfig.getCurrentSession().createQuery
					("FROM Enrollment e WHERE e.student.username = :Students_username");
			query.setParameter("Students_username", std.getUsername());
			List<Enrollment> enrollmentsLocal = query.list();
			std.setEnrollments(enrollmentsLocal);

			for (Enrollment enrollment : std.getEnrollments()) {
				if (enrollment.getStatus().equals("CURSANDO")) {
					listModel.addElement(enrollment.getSubject().getName());
				} else if(enrollment.getStatus().equals("APROBADA")) {
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

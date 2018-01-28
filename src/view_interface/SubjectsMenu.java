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
		frmSubjects.setBounds(100, 100, 450, 430);
		frmSubjects.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSubjects.setLocationRelativeTo(null);
		
		JButton btnAddSubject = new JButton("Add/Modify");
		btnAddSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSubjects.dispose();
				ChangeSubjectMenu csMenu = new ChangeSubjectMenu();
				csMenu.setUser(user);
				csMenu.setIdCarrer(idCarrer);
				csMenu.getFrmChangeSubject().setVisible(true);
			}
		});
		btnAddSubject.setBounds(14, 327, 186, 31);
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
		btnBack.setBounds(267, 325, 153, 33);
		btnBack.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(216, 0, 11, 383);
		separator.setForeground(new Color(0, 0, 0));
		separator.setOrientation(SwingConstants.VERTICAL);
		
		JLabel lblInProgress = new JLabel("In Progress");
		lblInProgress.setBounds(36, 24, 138, 31);
		lblInProgress.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblInProgress.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNextStep = new JLabel("Next Step");
		lblNextStep.setBounds(274, 31, 108, 31);
		lblNextStep.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblNextStep.setHorizontalAlignment(SwingConstants.CENTER);
		
		listProgress = new JList();
		listProgress.setVisibleRowCount(5);
		listProgress.setFont(new Font("Consolas", Font.PLAIN, 14));
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listProgress.setModel(listModel);
		
		listProgress.setBounds(12, 61, 186, 204);
		frmSubjects.getContentPane().setLayout(null);
		frmSubjects.getContentPane().add(btnAddSubject);
		frmSubjects.getContentPane().add(listProgress);
		frmSubjects.getContentPane().add(lblInProgress);
		frmSubjects.getContentPane().add(separator);
		frmSubjects.getContentPane().add(btnBack);
		frmSubjects.getContentPane().add(lblNextStep);
		
		JList listNext = new JList();
		listNext.setBounds(234, 61, 186, 204);
		frmSubjects.getContentPane().add(listNext);
		
		JButton btnShow = new JButton("Show");
		btnShow.setFont(new Font("Consolas", Font.PLAIN, 18));
		btnShow.setBounds(36, 279, 138, 35);
		frmSubjects.getContentPane().add(btnShow);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			getInformation(listModel);
		}
		});
	}

	protected void getInformation(DefaultListModel listModel) {
		//Se realiza una query para almacenar todas las materias que tiene el alumno actualmente.
		try {
			Query query = HibernateConfig.getCurrentSession().createQuery("FROM Enrollment e WHERE e.student_username = :Students_username");
			query.setParameter("Students_username", user);
			List<Enrollment> enrollments = query.list();
			//Una vez obtenida la materia, consulto por el nombre de la materia con el codigo obtenido.
			Subject subject = new Subject();
			for (Enrollment enrollment : enrollments) {
				query = HibernateConfig.getCurrentSession().createQuery("FROM Subject s WHERE s.code = :code");
				query.setParameter("code", enrollment.getSubject_code());
				subject = (Subject) query.uniqueResult();
				listModel.addElement(subject.toString());
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

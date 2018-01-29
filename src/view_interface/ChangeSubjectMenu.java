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
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JSeparator;
import java.awt.Frame;

public class ChangeSubjectMenu {

	private JFrame frmChangeSubject;
	private JTextField textName;
	private JTextField textCode;
	private JTextField textCorrelatives;
	private JTextField textHsWeek;
	private List<Subject> subjects;
	private String user;
	private int idCarrer;
	private Enrollment enrollment;
	private Subject sbj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeSubjectMenu window = new ChangeSubjectMenu();
					window.frmChangeSubject.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChangeSubjectMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		enrollment = new Enrollment();
		
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
		subjectsCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se realiza una consulta para obtener las materias para que el estudiante las agregue a su lista
				try {
					if (subjectsCombo.getSelectedIndex() != 0) {
						String sbjName = (String) subjectsCombo.getSelectedItem();
						Query query = HibernateConfig.getCurrentSession().createQuery("FROM Subject s WHERE s.name = :nameSubject");
						query.setParameter("nameSubject", sbjName);
						sbj = (Subject) query.uniqueResult();
						textName.setText(sbj.getName());
						textCode.setText(String.valueOf(sbj.getCode()));
						textCorrelatives.setText(sbj.getCorrelatives());
						textHsWeek.setText(String.valueOf(sbj.getHoursWeek()));
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
				//Se realiza una consulta para saber si la materia ya esta ingresada.
				Session session = HibernateConfig.getCurrentSession();
				enrollment = new Enrollment();
				enrollment.getStudent().setUsername(user);
				enrollment.getSubject().setCode((Integer.parseInt(textCode.getText())));
				enrollment.setStatus("CURSANDO");
				
				try {
				session.beginTransaction();
				session.save(enrollment);
				session.getTransaction().commit();
				session.close();
				
				Query query = HibernateConfig.getCurrentSession().createQuery
						("FROM Enrollment e WHERE e.student_username = :Students_username AND e.subject_code = :Subjects_code");
				query.setParameter("Students_username", user);
				query.setParameter("Subjects_code", sbj.getCode());
				enrollment = (Enrollment) query.uniqueResult();
				System.out.println(enrollment.getSubject().getCode());
				JOptionPane.showMessageDialog(null, "Materia Agregada a la cursada.");
				}catch (Exception m) {
					JOptionPane.showMessageDialog(null, "Error al incorporar la materia.");
					
				}
			}
		});
		btnConfirm.setBounds(91, 348, 132, 35);
		btnConfirm.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		frmChangeSubject = new JFrame();
		frmChangeSubject.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				getInformation(subjectsCombo);
			}
		});
		frmChangeSubject.setTitle("Add a Subject");
		frmChangeSubject.setBounds(100, 100, 500, 443);
		frmChangeSubject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmChangeSubject.setLocationRelativeTo(null);
		
		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubjectsMenu sbMenu = new SubjectsMenu();
				sbMenu.setUser(user);
				sbMenu.getFrmSubjets().setVisible(true);
				frmChangeSubject.dispose();
			}
		});
		Cancel.setBounds(259, 349, 136, 33);
		Cancel.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		frmChangeSubject.getContentPane().add(lblSelectASubject);
		frmChangeSubject.getContentPane().add(subjectsCombo);
		frmChangeSubject.getContentPane().setLayout(null);
		frmChangeSubject.getContentPane().add(lblCorrelativeTag);
		frmChangeSubject.getContentPane().add(lblHsWeekTag);
		frmChangeSubject.getContentPane().add(textHsWeek);
		frmChangeSubject.getContentPane().add(textCorrelatives);
		frmChangeSubject.getContentPane().add(lblCodeTag);
		frmChangeSubject.getContentPane().add(lblNameTag);
		frmChangeSubject.getContentPane().add(textName);
		frmChangeSubject.getContentPane().add(textCode);
		frmChangeSubject.getContentPane().add(lblcode);
		frmChangeSubject.getContentPane().add(statusCombo);
		frmChangeSubject.getContentPane().add(lblStatus);
		frmChangeSubject.getContentPane().add(btnConfirm);
		frmChangeSubject.getContentPane().add(Cancel);
		
	}

	private void getInformation(JComboBox subjectsCombo) {
		//Se realiza una consulta para obtener las materias de la carrera.
		try {
			Query query = HibernateConfig.getCurrentSession().createQuery("FROM Subject s WHERE s.idCarrer = :Carrers_idCarrer");
			query.setParameter("Carrers_idCarrer", idCarrer);
			subjects = query.list();
			subjectsCombo.addItem("Select a Subject");
			for (Subject subject : subjects) {
				subjectsCombo.addItem(subject.toString());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener las materias de la carrera");
		}
	}

	public List<Subject> getSbj() {
		return subjects;
	}

	public void setSbj(List<Subject> sbj) {
		this.subjects = sbj;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getIdCarrer() {
		return idCarrer;
	}

	public void setIdCarrer(int idCarrer) {
		this.idCarrer = idCarrer;
	}

	public JFrame getFrmChangeSubject() {
		return frmChangeSubject;
	}

	public void setFrmChangeSubject(JFrame frmAddToSubjects) {
		this.frmChangeSubject = frmAddToSubjects;
	}
}

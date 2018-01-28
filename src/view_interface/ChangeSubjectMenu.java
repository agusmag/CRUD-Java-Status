package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

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
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(12, 422, 132, 35);
		btnConfirm.setEnabled(false);
		btnConfirm.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBounds(20, 93, 65, 29);
		lblNewLabel.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("Code");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setBounds(20, 138, 65, 24);
		lblNewLabel_1.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_2 = new JLabel("Correlative");
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setBounds(20, 183, 109, 29);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_3 = new JLabel("Hs/Week");
		lblNewLabel_3.setEnabled(false);
		lblNewLabel_3.setBounds(20, 228, 109, 25);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		
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
		
		JLabel lblFirstMark = new JLabel("First Mark");
		lblFirstMark.setVisible(false);
		lblFirstMark.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblFirstMark.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstMark.setBounds(75, 321, 109, 25);
		
		JLabel lblSecondMark = new JLabel("Second Mark");
		lblSecondMark.setVisible(false);
		lblSecondMark.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblSecondMark.setHorizontalAlignment(SwingConstants.LEFT);
		lblSecondMark.setBounds(75, 366, 121, 25);
		
		JLabel lblSelectASubject = new JLabel("Select a subject");
		lblSelectASubject.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblSelectASubject.setBounds(18, 31, 179, 38);		
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setEnabled(false);
		lblStatus.setFont(new Font("LLPixel", Font.PLAIN, 18));
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(18, 272, 109, 22);
		
		JComboBox statusCombo = new JComboBox();
		statusCombo.setEnabled(false);
		statusCombo.setBounds(139, 272, 228, 25);
		
		JComboBox markOneCombo = new JComboBox();
		markOneCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enrollment.setMarkOne(markOneCombo.getSelectedIndex());
			}
		});
		markOneCombo.setVisible(false);
		markOneCombo.setBounds(204, 325, 106, 25);
		
		JComboBox markTwoCombo = new JComboBox();
		markTwoCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enrollment.setMarkTwo(markTwoCombo.getSelectedIndex());
			}
		});
		markTwoCombo.setVisible(false);
		markTwoCombo.setBounds(204, 370, 106, 25);
			
		JLabel lblMarkOne = new JLabel("");
		lblMarkOne.setVisible(false);
		lblMarkOne.setOpaque(true);
		lblMarkOne.setBackground(Color.ORANGE);
		lblMarkOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarkOne.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMarkOne.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblMarkOne.setBounds(232, 325, 56, 25);
		
		JLabel lblMarkTwo = new JLabel("");
		lblMarkTwo.setVisible(false);
		lblMarkTwo.setOpaque(true);
		lblMarkTwo.setBackground(Color.ORANGE);
		lblMarkTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarkTwo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMarkTwo.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblMarkTwo.setBounds(232, 370, 56, 25);
		
		JComboBox subjectsCombo = new JComboBox();
		subjectsCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Se realiza una consulta para obtener las materias para que el estudiante las agregue a su lista
				try {
					if (subjectsCombo.getSelectedIndex() != 0) {
						String sbjName = (String) subjectsCombo.getSelectedItem();
						Query query = HibernateConfig.getCurrentSession().createQuery("FROM Subject s WHERE s.name = :nameSubject");
						query.setParameter("nameSubject", sbjName);
						Subject sbj = (Subject) query.uniqueResult();
						textName.setText(sbj.getName());
						textCode.setText(String.valueOf(sbj.getCode()));
						textCorrelatives.setText(sbj.getCorrelatives());
						textHsWeek.setText(String.valueOf(sbj.getHoursWeek()));
						//Se realiza una consulta para obtener el estado y notas de la materia seleccionada
						query = HibernateConfig.getCurrentSession().createQuery
								("FROM Enrollment e WHERE e.student_username = :Students_username AND e.subject_code = :Subjects_code");
						query.setParameter("Students_username", user);
						query.setParameter("Subjects_code", sbj.getCode());
						enrollment = (Enrollment) query.uniqueResult();
						if (enrollment.getStatus() != null) {
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
					}
						} catch (Exception m) {
							JOptionPane.showMessageDialog(null, "Error al obtener los datos de la materia seleccionada");
						}
			}
		});
		subjectsCombo.setBounds(204, 37, 198, 27);
		
		frmChangeSubject = new JFrame();
		frmChangeSubject.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				getInformation(subjectsCombo);
			}
		});
		frmChangeSubject.setTitle("Add/Modify Subject");
		frmChangeSubject.setBounds(100, 100, 500, 517);
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
		Cancel.setBounds(319, 423, 136, 33);
		Cancel.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		frmChangeSubject.getContentPane().add(lblSelectASubject);
		frmChangeSubject.getContentPane().add(subjectsCombo);
		frmChangeSubject.getContentPane().setLayout(null);
		frmChangeSubject.getContentPane().add(lblNewLabel_2);
		frmChangeSubject.getContentPane().add(lblNewLabel_3);
		frmChangeSubject.getContentPane().add(textHsWeek);
		frmChangeSubject.getContentPane().add(textCorrelatives);
		frmChangeSubject.getContentPane().add(lblNewLabel_1);
		frmChangeSubject.getContentPane().add(lblNewLabel);
		frmChangeSubject.getContentPane().add(textName);
		frmChangeSubject.getContentPane().add(textCode);
		frmChangeSubject.getContentPane().add(lblcode);
		frmChangeSubject.getContentPane().add(lblFirstMark);
		frmChangeSubject.getContentPane().add(markOneCombo);
		frmChangeSubject.getContentPane().add(lblMarkOne);
		frmChangeSubject.getContentPane().add(lblSecondMark);
		frmChangeSubject.getContentPane().add(markTwoCombo);
		frmChangeSubject.getContentPane().add(lblMarkTwo);
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

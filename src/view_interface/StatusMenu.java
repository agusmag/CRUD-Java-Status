package view_interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.security.auth.Subject;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;

import org.hibernate.Session;
import org.hibernate.query.Query;

import hibernate.HibernateConfig;
import model.Carrer;
import model.Enrollment;
import model.Student;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class StatusMenu {

	private JFrame frmStatus;
	private JButton btnSubjets;
	private JButton btnCarrer;
	private JButton btnShowStatus;
	private JButton btnBack;
	private JLabel lblCarrer;
	private JLabel lblAvg;
	private JLabel lblSubjectsIn;
	private JLabel lblYearsIn;
	private JLabel lbl_infoAvg;
	private JLabel lbl_infoSI;
	private JLabel lbl_infoYI;
	private JLabel lbl_infoCar;
	private JLabel lblLastname;
	private JLabel lblName;
	private JLabel lbl_infoLastName;
	private JLabel lbl_infoName;
	
	private Student std;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusMenu window = new StatusMenu();
					window.frmStatus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StatusMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStatus = new JFrame();
		frmStatus.setBackground(Color.ORANGE);
		frmStatus.setTitle("Status");
		frmStatus.setBounds(100, 100, 523, 437);
		frmStatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStatus.setLocationRelativeTo(null);
		
		btnCarrer = new JButton("Carrer");
		btnCarrer.setBounds(12, 73, 157, 33);
		btnCarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarrer.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		btnShowStatus = new JButton("Show Status");
		btnShowStatus.setBounds(12, 186, 157, 91);
		btnShowStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show();
			}
		});
		btnShowStatus.setHorizontalTextPosition(SwingConstants.CENTER);
		btnShowStatus.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		btnSubjets = new JButton("Subjects");
		btnSubjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubjectsMenu sbMenu = new SubjectsMenu();
				frmStatus.dispose();
				sbMenu.setStd(std);
				sbMenu.getFrmSubjets().setVisible(true);
			}
		});
		btnSubjets.setBounds(12, 131, 157, 33);
		btnSubjets.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		lblCarrer = new JLabel("Carrer");
		lblCarrer.setBounds(211, 139, 128, 26);
		lblCarrer.setOpaque(true);
		lblCarrer.setForeground(Color.BLACK);
		lblCarrer.setVisible(false);
		lblCarrer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCarrer.setFont(new Font("Consolas", Font.BOLD, 14));
		lblCarrer.setBackground(Color.ORANGE);
		
		lblAvg = new JLabel("Average");
		lblAvg.setBounds(211, 186, 128, 26);
		lblAvg.setOpaque(true);
		lblAvg.setVisible(false);
		lblAvg.setFont(new Font("Consolas", Font.BOLD, 14));
		lblAvg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvg.setBackground(Color.ORANGE);
		
		lblSubjectsIn = new JLabel("Subjects IN");
		lblSubjectsIn.setBounds(211, 233, 128, 26);
		lblSubjectsIn.setOpaque(true);
		lblSubjectsIn.setVisible(false);
		lblSubjectsIn.setFont(new Font("Consolas", Font.BOLD, 14));
		lblSubjectsIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjectsIn.setBackground(Color.ORANGE);
		
		lblYearsIn = new JLabel("Years IN");
		lblYearsIn.setBounds(211, 280, 128, 26);
		lblYearsIn.setOpaque(true);
		lblYearsIn.setVisible(false);
		lblYearsIn.setFont(new Font("Consolas", Font.BOLD, 14));
		lblYearsIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearsIn.setBackground(Color.ORANGE);
		
		lbl_infoAvg = new JLabel("");
		lbl_infoAvg.setVisible(false);
		lbl_infoAvg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoAvg.setBounds(346, 186, 128, 26);
		lbl_infoAvg.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoAvg.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_infoAvg.setBackground(new Color(102, 205, 170));
		
		lbl_infoSI = new JLabel("");
		lbl_infoSI.setVisible(false);
		lbl_infoSI.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoSI.setBounds(346, 233, 128, 27);
		lbl_infoSI.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoSI.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_infoSI.setBackground(new Color(102, 205, 170));
		
		lbl_infoYI = new JLabel("");
		lbl_infoYI.setVisible(false);
		lbl_infoYI.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoYI.setBounds(346, 280, 128, 26);
		lbl_infoYI.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoYI.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_infoYI.setBackground(new Color(102, 205, 170));
		
		btnBack = new JButton("Back");
		btnBack.setBounds(270, 342, 154, 31);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStatus.dispose();
				StartMenu stMenu = new StartMenu();
				stMenu.getFrmUniversity().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		lbl_infoCar = new JLabel("");
		lbl_infoCar.setVisible(false);
		lbl_infoCar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoCar.setBounds(346, 139, 128, 26);
		lbl_infoCar.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoCar.setHorizontalTextPosition(SwingConstants.CENTER);
		frmStatus.getContentPane().setLayout(null);
		frmStatus.getContentPane().add(btnSubjets);
		frmStatus.getContentPane().add(btnCarrer);
		frmStatus.getContentPane().add(btnShowStatus);
		frmStatus.getContentPane().add(lbl_infoCar);
		frmStatus.getContentPane().add(lblCarrer);
		frmStatus.getContentPane().add(lblAvg);
		frmStatus.getContentPane().add(lbl_infoAvg);
		frmStatus.getContentPane().add(lbl_infoSI);
		frmStatus.getContentPane().add(lblSubjectsIn);
		frmStatus.getContentPane().add(lbl_infoYI);
		frmStatus.getContentPane().add(lblYearsIn);
		frmStatus.getContentPane().add(btnBack);
		
		lblLastname = new JLabel("Lastname");
		lblLastname.setVisible(false);
		lblLastname.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastname.setOpaque(true);
		lblLastname.setBackground(Color.ORANGE);
		lblLastname.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLastname.setFont(new Font("Consolas", Font.BOLD, 14));
		lblLastname.setBounds(211, 92, 128, 26);
		frmStatus.getContentPane().add(lblLastname);
		
		lblName = new JLabel("Name");
		lblName.setVisible(false);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setOpaque(true);
		lblName.setBackground(Color.ORANGE);
		lblName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName.setFont(new Font("Consolas", Font.BOLD, 14));
		lblName.setBounds(211, 45, 128, 26);
		frmStatus.getContentPane().add(lblName);
		
		lbl_infoLastName = new JLabel("");
		lbl_infoLastName.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_infoLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoLastName.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoLastName.setVisible(false);
		lbl_infoLastName.setBounds(346, 92, 128, 26);
		frmStatus.getContentPane().add(lbl_infoLastName);
		
		lbl_infoName = new JLabel("");
		lbl_infoName.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_infoName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoName.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoName.setVisible(false);
		lbl_infoName.setBounds(346, 45, 128, 26);
		frmStatus.getContentPane().add(lbl_infoName);
	}
	
	public JLabel getLbl_infoAvg() {
		return lbl_infoAvg;
	}

	public void setLbl_infoAvg(JLabel lbl_infoAvg) {
		this.lbl_infoAvg = lbl_infoAvg;
	}

	public JLabel getLbl_infoSI() {
		return lbl_infoSI;
	}

	public void setLbl_infoSI(JLabel lbl_infoSI) {
		this.lbl_infoSI = lbl_infoSI;
	}

	public JLabel getLbl_infoYI() {
		return lbl_infoYI;
	}

	public void setLbl_infoYI(JLabel lbl_infoYI) {
		this.lbl_infoYI = lbl_infoYI;
	}

	public JLabel getLbl_infoCar() {
		return lbl_infoCar;
	}

	public void setLbl_infoCar(JLabel lbl_infoCar) {
		this.lbl_infoCar = lbl_infoCar;
	}

	public JFrame getFrmStatus() {
		return frmStatus;
	}

	public void setFrmStatus(JFrame frmStatus) {
		this.frmStatus = frmStatus;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}

	protected void show() {
		if (btnShowStatus.getText().equals("Show Status")) {
			getInformation();
			btnShowStatus.setText("Hide Status");
			lblName.setVisible(true);
			lblLastname.setVisible(true);
			lblCarrer.setVisible(true);
			lblAvg.setVisible(true);
			lblSubjectsIn.setVisible(true);
			lblYearsIn.setVisible(true);
			lbl_infoName.setVisible(true);
			lbl_infoLastName.setVisible(true);
			lbl_infoCar.setVisible(true);
			lbl_infoAvg.setVisible(true);
			lbl_infoSI.setVisible(true);
			lbl_infoYI.setVisible(true);
		} else {
			btnShowStatus.setText("Show Status");
			lblName.setVisible(false);
			lblLastname.setVisible(false);
			lblCarrer.setVisible(false);
			lblAvg.setVisible(false);
			lblSubjectsIn.setVisible(false);
			lblYearsIn.setVisible(false);
			lbl_infoName.setVisible(false);
			lbl_infoLastName.setVisible(false);
			lbl_infoCar.setVisible(false);
			lbl_infoAvg.setVisible(false);
			lbl_infoSI.setVisible(false);
			lbl_infoYI.setVisible(false);
		}
	}

	protected void getInformation() {		
		Query query;
		
		try {
			//Se realiza una consulta por username para obtener los datos del usuario.
			Student stdLocal = HibernateConfig.getCurrentSession().get(Student.class, this.std.getUsername());
			
			//Se realiza una consulta para obtener las materias aprobadas hasta el momento.
			int subjectCounter = 0;
			float avg, total = 0;
			query = HibernateConfig.getCurrentSession().createQuery
					("FROM Enrollment e WHERE e.student.username = :Students_username AND e.status = :status");
			query.setParameter("Students_username", stdLocal.getUsername());
			query.setParameter("status", "APROBADA");
			stdLocal.setEnrollments(query.list());
			
			//Se calcula el total de materias aprobadas
			for (Enrollment enrollment : stdLocal.getEnrollments()) {
				subjectCounter++;
			}
			
			//Se calcula el promedio de las materias aprobadas
			for (Enrollment enrollment : stdLocal.getEnrollments()) {
				total += enrollment.getAverage();
			}
			avg = total/subjectCounter;
			
			//Se calcula el promedio de a�os completados hasta el momento.
			int yearCounter = subjectCounter / 8;
			
			//Se actualizan los datos obtenidos en las etiquetas
			lbl_infoName.setText(stdLocal.getName());
			lbl_infoLastName.setText(stdLocal.getLastName());
			lbl_infoCar.setText(String.valueOf(stdLocal.getCarrer().getName()));
			lbl_infoSI.setText(subjectCounter + "/44");
			lbl_infoYI.setText(yearCounter + "/6");
			lbl_infoAvg.setText(avg + "/10.0");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener los datos del estudiante");
		}
	}
	
}

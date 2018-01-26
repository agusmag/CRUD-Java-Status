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
import java.awt.Color;
import javax.swing.SwingConstants;

import org.hibernate.Session;

import hibernate.HibernateConfig;
import model.Student;

import java.awt.event.ActionListener;
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
	
	private String user;
	private String pass;
	
	private Session session;

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
		frmStatus.setBounds(100, 100, 816, 290);
		frmStatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStatus.setLocationRelativeTo(null);
		
		btnCarrer = new JButton("Carrer");
		btnCarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarrer.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		btnShowStatus = new JButton("Show Status");
		btnShowStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show();
				getInformation();
				
			}
		});
		btnShowStatus.setHorizontalTextPosition(SwingConstants.CENTER);
		btnShowStatus.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		btnSubjets = new JButton("Subjects");
		btnSubjets.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		lblCarrer = new JLabel("Carrer");
		lblCarrer.setOpaque(true);
		lblCarrer.setForeground(Color.BLACK);
		lblCarrer.setVisible(false);
		lblCarrer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCarrer.setFont(new Font("Consolas", Font.BOLD, 14));
		lblCarrer.setBackground(Color.ORANGE);
		
		lblAvg = new JLabel("Average");
		lblAvg.setOpaque(true);
		lblAvg.setVisible(false);
		lblAvg.setFont(new Font("Consolas", Font.BOLD, 14));
		lblAvg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvg.setBackground(Color.ORANGE);
		
		lblSubjectsIn = new JLabel("Subjects IN");
		lblSubjectsIn.setOpaque(true);
		lblSubjectsIn.setVisible(false);
		lblSubjectsIn.setFont(new Font("Consolas", Font.BOLD, 14));
		lblSubjectsIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjectsIn.setBackground(Color.ORANGE);
		
		lblYearsIn = new JLabel("Years IN");
		lblYearsIn.setOpaque(true);
		lblYearsIn.setVisible(false);
		lblYearsIn.setFont(new Font("Consolas", Font.BOLD, 14));
		lblYearsIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearsIn.setBackground(Color.ORANGE);
		
		lbl_infoAvg = new JLabel("");
		lbl_infoAvg.setVisible(false);
		lbl_infoAvg.setEnabled(false);
		lbl_infoAvg.setBackground(new Color(102, 205, 170));
		
		lbl_infoSI = new JLabel("");
		lbl_infoSI.setVisible(false);
		lbl_infoSI.setEnabled(false);
		lbl_infoSI.setBackground(new Color(102, 205, 170));
		
		lbl_infoYI = new JLabel("");
		lbl_infoYI.setVisible(false);
		lbl_infoYI.setEnabled(false);
		lbl_infoYI.setBackground(new Color(102, 205, 170));
		
		btnBack = new JButton("Back");
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
		GroupLayout groupLayout = new GroupLayout(frmStatus.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSubjets, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCarrer, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(btnShowStatus, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lbl_infoCar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCarrer, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAvg, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_infoAvg, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lbl_infoSI, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSubjectsIn, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_infoYI, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblYearsIn, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(21))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCarrer, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(btnSubjets, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnShowStatus, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblYearsIn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
									.addGap(33))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblSubjectsIn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblAvg, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCarrer, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_infoCar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lbl_infoSI, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
											.addComponent(lbl_infoAvg, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
											.addComponent(lbl_infoYI, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBack)))
					.addGap(35))
		);
		frmStatus.getContentPane().setLayout(groupLayout);
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

	protected void getInformation() {
		session = HibernateConfig.getCurrentSession();
		
		Student std = HibernateConfig.getCurrentSession().get(Student.class, user);
		
	}

	protected void show() {
		if (btnShowStatus.getText().equals("Show Status")) {
			btnShowStatus.setText("Hide Status");
			lblCarrer.setVisible(true);
			lblAvg.setVisible(true);
			lblSubjectsIn.setVisible(true);
			lblYearsIn.setVisible(true);
			lbl_infoCar.setVisible(true);
			lbl_infoAvg.setVisible(true);
			lbl_infoSI.setVisible(true);
			lbl_infoYI.setVisible(true);
		} else {
			btnShowStatus.setText("Show Status");
			lblCarrer.setVisible(false);
			lblAvg.setVisible(false);
			lblSubjectsIn.setVisible(false);
			lblYearsIn.setVisible(false);
			lbl_infoCar.setVisible(false);
			lbl_infoAvg.setVisible(false);
			lbl_infoSI.setVisible(false);
			lbl_infoYI.setVisible(false);
		}
	}

	public JFrame getFrmStatus() {
		return frmStatus;
	}

	public void setFrmStatus(JFrame frmStatus) {
		this.frmStatus = frmStatus;
	}
}

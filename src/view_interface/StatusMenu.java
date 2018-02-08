package view_interface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import org.hibernate.query.Query;
import hibernate.HibernateConfig;
import model.Enrollment;
import model.Student;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JSeparator;

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
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	private int xx;
	private int xy;
	private JLabel lblNewLabel_2;
	private JSeparator separator;
	private JSeparator separator_1;
	
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
		frmStatus.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				
				frmStatus.setLocation(x - xx, y - xy);
			}
		});
		frmStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		frmStatus.getContentPane().setBackground(new Color(0, 0, 0));
		frmStatus.setUndecorated(true);
		frmStatus.setBackground(Color.ORANGE);
		frmStatus.setTitle("Status");
		frmStatus.setBounds(100, 100, 550, 519);
		frmStatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStatus.setLocationRelativeTo(null);
		
		btnCarrer = new JButton("Carrer");
		btnCarrer.setFocusable(false);
		btnCarrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCarrer.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCarrer.setBackground(new Color(153, 153, 153));
			}
		});
		btnCarrer.setToolTipText("Despliega el menu de las carreras");
		btnCarrer.setBackground(new Color(153, 153, 153));
		btnCarrer.setBorderPainted(false);
		btnCarrer.setBounds(12, 80, 120, 100);
		btnCarrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarrerMenu carrerM = new CarrerMenu();
				carrerM.setStd(std);
				carrerM.getCarrerMenu().setVisible(true);
				frmStatus.dispose();
			}
		});
		btnCarrer.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		btnShowStatus = new JButton("Show");
		btnShowStatus.setFocusable(false);
		btnShowStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnShowStatus.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnShowStatus.setBackground(new Color(153, 153, 153));
			}
		});
		btnShowStatus.setToolTipText("Despliega el estado del Alumno");
		btnShowStatus.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnShowStatus.setIcon(new ImageIcon(StatusMenu.class.getResource("/background/if_User_Interface-39_2044249.png")));
		btnShowStatus.setBackground(new Color(153, 153, 153));
		btnShowStatus.setBorderPainted(false);
		btnShowStatus.setBounds(12, 333, 120, 165);
		btnShowStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				show();
			}
		});
		btnShowStatus.setHorizontalTextPosition(SwingConstants.CENTER);
		btnShowStatus.setFont(new Font("LLPixel", Font.PLAIN, 18));
		
		btnSubjets = new JButton("Subjects");
		btnSubjets.setFocusable(false);
		btnSubjets.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSubjets.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSubjets.setBackground(new Color(153, 153, 153));
			}
		});
		btnSubjets.setToolTipText("Abre el menu de materias");
		btnSubjets.setBackground(new Color(153, 153, 153));
		btnSubjets.setBorderPainted(false);
		btnSubjets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SubjectsMenu sbMenu = new SubjectsMenu();
				frmStatus.dispose();
				sbMenu.setStd(std);
				sbMenu.getFrmSubjets().setVisible(true);
			}
		});
		btnSubjets.setBounds(12, 180, 120, 100);
		btnSubjets.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		lblCarrer = new JLabel("Carrer");
		lblCarrer.setBounds(210, 198, 128, 26);
		lblCarrer.setOpaque(true);
		lblCarrer.setForeground(new Color(51, 204, 51));
		lblCarrer.setVisible(false);
		lblCarrer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarrer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCarrer.setFont(new Font("LLPixel", Font.BOLD, 20));
		lblCarrer.setBackground(new Color(0, 0, 0));
		
		lblAvg = new JLabel("Average");
		lblAvg.setForeground(new Color(51, 204, 51));
		lblAvg.setBounds(210, 259, 128, 26);
		lblAvg.setOpaque(true);
		lblAvg.setVisible(false);
		lblAvg.setFont(new Font("LLPixel", Font.BOLD, 20));
		lblAvg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvg.setBackground(new Color(0, 0, 0));
		
		lblSubjectsIn = new JLabel("Subjects IN");
		lblSubjectsIn.setForeground(new Color(51, 204, 51));
		lblSubjectsIn.setBounds(210, 320, 128, 26);
		lblSubjectsIn.setOpaque(true);
		lblSubjectsIn.setVisible(false);
		lblSubjectsIn.setFont(new Font("LLPixel", Font.BOLD, 20));
		lblSubjectsIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubjectsIn.setBackground(new Color(0, 0, 0));
		
		lblYearsIn = new JLabel("Years IN");
		lblYearsIn.setForeground(new Color(51, 204, 51));
		lblYearsIn.setBounds(210, 381, 128, 26);
		lblYearsIn.setOpaque(true);
		lblYearsIn.setVisible(false);
		lblYearsIn.setFont(new Font("LLPixel", Font.BOLD, 20));
		lblYearsIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblYearsIn.setBackground(new Color(0, 0, 0));
		
		lbl_infoAvg = new JLabel("");
		lbl_infoAvg.setForeground(new Color(255, 255, 255));
		lbl_infoAvg.setOpaque(true);
		lbl_infoAvg.setVisible(false);
		lbl_infoAvg.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoAvg.setBounds(380, 259, 128, 26);
		lbl_infoAvg.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoAvg.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_infoAvg.setBackground(new Color(51, 51, 51));
		
		lbl_infoSI = new JLabel("");
		lbl_infoSI.setForeground(new Color(255, 255, 255));
		lbl_infoSI.setOpaque(true);
		lbl_infoSI.setVisible(false);
		lbl_infoSI.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoSI.setBounds(380, 320, 128, 27);
		lbl_infoSI.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoSI.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_infoSI.setBackground(new Color(51, 51, 51));
		
		lbl_infoYI = new JLabel("");
		lbl_infoYI.setForeground(new Color(255, 255, 255));
		lbl_infoYI.setOpaque(true);
		lbl_infoYI.setVisible(false);
		lbl_infoYI.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoYI.setBounds(380, 381, 128, 26);
		lbl_infoYI.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoYI.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_infoYI.setBackground(new Color(51, 51, 51));
		
		btnBack = new JButton("");
		btnBack.setFocusable(false);
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
		btnBack.setIcon(new ImageIcon(StatusMenu.class.getResource("/background/if_User_Interface-09_2044237.png")));
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(153, 153, 153));
		btnBack.setBounds(357, 467, 154, 31);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStatus.dispose();
				StartMenu stMenu = new StartMenu();
				stMenu.getFrmUniversity().setVisible(true);
			}
		});
		btnBack.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		lbl_infoCar = new JLabel("");
		lbl_infoCar.setForeground(new Color(255, 255, 255));
		lbl_infoCar.setBackground(new Color(51, 51, 51));
		lbl_infoCar.setOpaque(true);
		lbl_infoCar.setVisible(false);
		lbl_infoCar.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoCar.setBounds(380, 198, 128, 26);
		lbl_infoCar.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoCar.setHorizontalTextPosition(SwingConstants.CENTER);
		frmStatus.getContentPane().setLayout(null);
		frmStatus.getContentPane().add(btnSubjets);
		frmStatus.getContentPane().add(btnCarrer);
		frmStatus.getContentPane().add(btnShowStatus);
		frmStatus.getContentPane().add(lbl_infoCar);
		frmStatus.getContentPane().add(lblCarrer);
		frmStatus.getContentPane().add(lblAvg);
		
		separator = new JSeparator();
		separator.setOpaque(true);
		separator.setBackground(new Color(51, 204, 51));
		separator.setForeground(new Color(51, 204, 51));
		separator.setBounds(144, 52, 4, 467);
		frmStatus.getContentPane().add(separator);
		frmStatus.getContentPane().add(lbl_infoAvg);
		frmStatus.getContentPane().add(lbl_infoSI);
		frmStatus.getContentPane().add(lblSubjectsIn);
		frmStatus.getContentPane().add(lbl_infoYI);
		frmStatus.getContentPane().add(lblYearsIn);
		frmStatus.getContentPane().add(btnBack);
		
		lblLastname = new JLabel("Lastname");
		lblLastname.setForeground(new Color(51, 204, 51));
		lblLastname.setVisible(false);
		lblLastname.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastname.setOpaque(true);
		lblLastname.setBackground(new Color(0, 0, 0));
		lblLastname.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLastname.setFont(new Font("LLPixel", Font.BOLD, 20));
		lblLastname.setBounds(210, 137, 128, 26);
		frmStatus.getContentPane().add(lblLastname);
		
		lblName = new JLabel("Name");
		lblName.setForeground(new Color(51, 204, 51));
		lblName.setVisible(false);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setOpaque(true);
		lblName.setBackground(new Color(0, 0, 0));
		lblName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName.setFont(new Font("LLPixel", Font.BOLD, 20));
		lblName.setBounds(210, 80, 128, 26);
		frmStatus.getContentPane().add(lblName);
		
		lbl_infoLastName = new JLabel("");
		lbl_infoLastName.setForeground(new Color(255, 255, 255));
		lbl_infoLastName.setBackground(new Color(51, 51, 51));
		lbl_infoLastName.setOpaque(true);
		lbl_infoLastName.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_infoLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoLastName.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoLastName.setVisible(false);
		lbl_infoLastName.setBounds(380, 137, 128, 26);
		frmStatus.getContentPane().add(lbl_infoLastName);
		
		lbl_infoName = new JLabel("");
		lbl_infoName.setForeground(new Color(255, 255, 255));
		lbl_infoName.setBackground(new Color(51, 51, 51));
		lbl_infoName.setOpaque(true);
		lbl_infoName.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_infoName.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_infoName.setFont(new Font("Consolas", Font.PLAIN, 14));
		lbl_infoName.setVisible(false);
		lbl_infoName.setBounds(380, 80, 128, 26);
		frmStatus.getContentPane().add(lbl_infoName);
		
		panel = new JPanel();
		panel.setBackground(new Color(51, 51, 51));
		panel.setBounds(0, 0, 605, 52);
		frmStatus.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
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
		lblNewLabel.setBackground(new Color(153, 153, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(StatusMenu.class.getResource("/background/if_User_Interface-02_2044283.png")));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(510, 13, 32, 32);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(102, 102, 102));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setBackground(new Color(153, 153, 153));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frmStatus.setState(Frame.ICONIFIED);
			}
		});
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(153, 153, 153));
		lblNewLabel_1.setIcon(new ImageIcon(StatusMenu.class.getResource("/background/if_window-minimize_1954552.png")));
		lblNewLabel_1.setBounds(462, 13, 32, 32);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setForeground(new Color(51, 204, 51));
		lblNewLabel_2.setFont(new Font("LLPixel", Font.BOLD, 29));
		lblNewLabel_2.setBounds(12, 13, 119, 32);
		panel.add(lblNewLabel_2);
		
		separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setBackground(new Color(51, 204, 51));
		separator_1.setBounds(0, 305, 146, 4);
		frmStatus.getContentPane().add(separator_1);
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
		if (btnShowStatus.getText().equals("Show")) {
			getInformation();
			btnShowStatus.setText("Hide");
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
			btnShowStatus.setText("Show");
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
			
			//Se calcula el promedio de años completados hasta el momento.
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

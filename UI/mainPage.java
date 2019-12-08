package UI;
/*
Author: Yansong Peng and Jain Nayan
Date: 11/17/2019
For: SER515, Professor Findler
*/
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Implementation.ImplementationService;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class mainPage extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passwordField;
	
	private final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	private String user = "root";
	private String password = "Kuan890618";
	private int level;
	private static mainPage frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try { 
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		    }
		catch (Exception e) {
		    e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new mainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean checkStudent(String username, String password1) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			ImplementationService imp = new ImplementationService(conn);
			Object [][]data = imp.getAllStudent();
			boolean result = false;
			for (int i = 0; i < data.length; i++) {
				if (data[i][1].equals(username) && data[i][2].equals(password1)) {
					result = true;
				}
			}
			return result;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean checkTeacher(String username, String password1) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			ImplementationService imp = new ImplementationService(conn);
			Object [][]data = imp.getAllTeacher();
			boolean result = false;
			for (int i = 0; i < data.length; i++) {
				if (data[i][1].equals(username) && data[i][2].equals(password1)) {
					result = true;
				}
			}
			return result;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	/**
	 * Create the frame.
	 */
	public mainPage() {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWelcomePleaseSelect = new JLabel("Welcome! Please Log in / Register");
		lblWelcomePleaseSelect.setBounds(145, 18, 1149, 58);
		lblWelcomePleaseSelect.setForeground(SystemColor.activeCaption);
		lblWelcomePleaseSelect.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomePleaseSelect.setFont(new Font("Palatino Linotype", Font.PLAIN, 30));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(145, 125, 126, 40);
		lblUsername.setForeground(SystemColor.activeCaption);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(145, 214, 126, 40);
		lblPassword.setForeground(SystemColor.activeCaption);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		usernameTF = new JTextField();
		usernameTF.setName("mainpage");
		usernameTF.setBounds(276, 122, 427, 46);
		usernameTF.setForeground(Color.WHITE);
		usernameTF.setBackground(Color.DARK_GRAY);
		usernameTF.setFont(new Font("Tahoma", Font.PLAIN, 26));
		usernameTF.setColumns(10);
		usernameTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(276, 214, 427, 48);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JLabel lblSelectRole = new JLabel("Select Role:");
		lblSelectRole.setBounds(856, 83, 220, 67);
		lblSelectRole.setForeground(SystemColor.activeCaption);
		lblSelectRole.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblSelectLevel = new JLabel("Select Level:");
		lblSelectLevel.setBounds(856, 245, 220, 67);
		lblSelectLevel.setEnabled(false);
		lblSelectLevel.setForeground(SystemColor.activeCaption);
		lblSelectLevel.setBackground(Color.DARK_GRAY);
		lblSelectLevel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JRadioButton rdbtnLow = new JRadioButton("Low");
		rdbtnLow.setBounds(917, 330, 147, 41);
		rdbtnLow.setEnabled(false);
		rdbtnLow.setForeground(SystemColor.activeCaption);
		rdbtnLow.setBackground(Color.DARK_GRAY);
		rdbtnLow.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JRadioButton rdbtnHigh = new JRadioButton("High");
		rdbtnHigh.setBounds(1210, 330, 106, 41);
		rdbtnHigh.setForeground(SystemColor.activeCaption);
		rdbtnHigh.setBackground(Color.DARK_GRAY);
		rdbtnHigh.setEnabled(false);
		rdbtnHigh.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBounds(917, 169, 119, 44);
		rdbtnStudent.setForeground(SystemColor.activeCaption);
		rdbtnStudent.setBackground(Color.DARK_GRAY);
		rdbtnStudent.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JRadioButton rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setBounds(1210, 169, 121, 44);
		rdbtnTeacher.setForeground(SystemColor.activeCaption);
		rdbtnTeacher.setBackground(Color.DARK_GRAY);
		rdbtnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		rdbtnStudent.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				if (rdbtnStudent.isSelected()) {
					lblSelectLevel.setEnabled(true);
					rdbtnLow.setEnabled(true);
					rdbtnHigh.setEnabled(true);
					rdbtnTeacher.setSelected(false);
				} 
		    }
		});
		
		rdbtnTeacher.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				if (rdbtnTeacher.isSelected()) {
					lblSelectLevel.setEnabled(false);
					rdbtnLow.setEnabled(false);
					rdbtnHigh.setEnabled(false);
					rdbtnStudent.setSelected(false);
				}
		    }
		});
		
		rdbtnLow.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				if (rdbtnLow.isSelected()) {
					rdbtnHigh.setSelected(false);
				}
		    }
		});
		
		rdbtnHigh.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				if (rdbtnHigh.isSelected()) {
					rdbtnLow.setSelected(false);
				}
		    }
		});
		
		JButton loginBtn = new JButton("LOG IN");
		loginBtn.setBounds(206, 318, 174, 50);
		loginBtn.setForeground(SystemColor.activeCaption);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password1 = new String(passwordField.getPassword());
				boolean stuCheck = checkStudent(usernameTF.getText(), password1);
				boolean teaCheck = checkTeacher(usernameTF.getText(), password1);

				try {
					if (rdbtnStudent.isSelected()) {
						
						if (rdbtnLow.isSelected()) {
							level = 0;
						} else if (rdbtnHigh.isSelected()) {
							level = 1;
						}
						if (stuCheck == true) {
							studentCalculate student = new studentCalculate(level);
							frame.dispose();
							student.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Fail to Login");
						}
					} else if (rdbtnTeacher.isSelected()) {
						if (teaCheck == true) {
							teacherInput teacher = new teacherInput();
							frame.dispose();
							teacher.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Fail to Login");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Error! Please select role");
					}
				} catch (Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "Fail to Login");
				}
			}
		});
		loginBtn.setFont(new Font("Calibri", Font.BOLD, 26));
		loginBtn.setBackground(Color.DARK_GRAY);
		loginBtn.setForeground(SystemColor.activeCaption);
		loginBtn.setOpaque(true);
		loginBtn.setBorderPainted(false);
		
		JButton registerBtn = new JButton("REGISTER");
		registerBtn.setBounds(539, 318, 174, 50);
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerPage register = new registerPage();
				register.setVisible(true);
			}
		});
		registerBtn.setFont(new Font("Calibri", Font.BOLD, 26));
		registerBtn.setBackground(Color.DARK_GRAY);
		registerBtn.setForeground(SystemColor.activeCaption);
		registerBtn.setOpaque(true);
		registerBtn.setBorderPainted(false);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(276, 169, 427, 10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(276, 269, 427, 10);
		contentPane.setLayout(null);
		contentPane.add(lblWelcomePleaseSelect);
		contentPane.add(lblUsername);
		contentPane.add(separator_1);
		contentPane.add(usernameTF);
		contentPane.add(lblPassword);
		contentPane.add(separator_2);
		contentPane.add(passwordField);
		contentPane.add(lblSelectRole);
		contentPane.add(lblSelectLevel);
		contentPane.add(rdbtnStudent);
		contentPane.add(loginBtn);
		contentPane.add(registerBtn);
		contentPane.add(rdbtnLow);
		contentPane.add(rdbtnTeacher);
		contentPane.add(rdbtnHigh);
	}
}

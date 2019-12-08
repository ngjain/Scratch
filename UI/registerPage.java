package UI;
/*
Author: Yansong Peng
Date: 11/13/2019
For: SER515, Professor Findler
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Implementation.ImplementationService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.Statement;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class registerPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	private final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	private String user = "root";
	private String password = "Kuan890618";
	
	public boolean checkStuUsername(String username) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			ImplementationService imp = new ImplementationService(conn);
			Object [][]data = imp.getAllStudent();
			boolean result = false;
			for (int i = 0; i < data.length; i++) {
				if (data[i][1].equals(username)) {
					result = true;
				}
			}
			return result;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	
	public boolean checkTeaUsername(String username) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			ImplementationService imp = new ImplementationService(conn);
			Object [][]data = imp.getAllTeacher();
			boolean result = false;
			for (int i = 0; i < data.length; i++) {
				if (data[i][1].equals(username)) {
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
	public registerPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 586);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRegisterPage = new JLabel("Register Page");
		lblRegisterPage.setBounds(17, 29, 628, 61);
		lblRegisterPage.setForeground(SystemColor.activeCaption);
		lblRegisterPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterPage.setFont(new Font("Palatino Linotype", Font.PLAIN, 30));
		
		JLabel label_1 = new JLabel("Username");
		label_1.setForeground(SystemColor.activeCaption);
		label_1.setBounds(17, 114, 126, 55);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		usernameTextField = new JTextField();
		usernameTextField.setBorder(null);
		usernameTextField.setForeground(Color.WHITE);
		usernameTextField.setBackground(Color.DARK_GRAY);
		usernameTextField.setBounds(271, 108, 364, 46);
		usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		usernameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setForeground(SystemColor.activeCaption);
		label_2.setBounds(17, 219, 126, 40);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBounds(267, 201, 368, 49);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(SystemColor.activeCaption);
		lblConfirmPassword.setBounds(17, 304, 219, 62);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(null);
		passwordField_1.setForeground(Color.WHITE);
		passwordField_1.setBackground(Color.DARK_GRAY);
		passwordField_1.setBounds(267, 293, 368, 49);
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setForeground(SystemColor.activeCaption);
		rdbtnStudent.setBackground(Color.DARK_GRAY);
		rdbtnStudent.setBounds(173, 392, 109, 37);
		rdbtnStudent.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JRadioButton rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setForeground(SystemColor.activeCaption);
		rdbtnTeacher.setBackground(Color.DARK_GRAY);
		rdbtnTeacher.setBounds(395, 392, 115, 37);
		rdbtnTeacher.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		rdbtnStudent.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				if (rdbtnStudent.isSelected()) {
					rdbtnTeacher.setSelected(false);
				} 
		    }
		});
		
		rdbtnTeacher.addActionListener(new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e)
		    {
				if (rdbtnTeacher.isSelected()) {
					rdbtnStudent.setSelected(false);
				}
		    }
		});
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.setForeground(SystemColor.activeCaption);
		btnRegister.setBorder(null);
		btnRegister.setBackground(Color.DARK_GRAY);
		btnRegister.setBounds(253, 466, 145, 55);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password1 = new String(passwordField.getPassword());
				String password_check = new String(passwordField_1.getPassword());
				
				try {
					if (password1.equals(password_check)) {
						boolean stuCheck = checkStuUsername(usernameTextField.getText());
						boolean teaCheck = checkTeaUsername(usernameTextField.getText());
						if (rdbtnStudent.isSelected()) {
							if (stuCheck == true) {
								JOptionPane.showMessageDialog(null, "Username Exists!");
							} else {
								Class.forName("com.mysql.jdbc.Driver");
								Connection conn = DriverManager.getConnection(url, user, password);
								String queryStu = "insert into student(username, password) values('" + usernameTextField.getText() + "', '" + password1 + "')";
								Statement statement = conn.createStatement();
								statement.executeUpdate(queryStu);
								JOptionPane.showMessageDialog(null, "Successful Registration");
								setVisible(false);
							}
						} else if (rdbtnTeacher.isSelected()) {
							if (teaCheck == true) {
								JOptionPane.showMessageDialog(null, "Username Exists!");
							} else {
								Class.forName("com.mysql.jdbc.Driver");
								Connection conn = DriverManager.getConnection(url, user, password);
								String queryTea = "insert into teacher(username, password) values('" + usernameTextField.getText() + "', '" + password1 + "')";
								Statement statement = conn.createStatement();
								statement.executeUpdate(queryTea);
								JOptionPane.showMessageDialog(null, "Successful Registration");
								setVisible(false);
							}
						}
						
						
					} else {
						JOptionPane.showMessageDialog(null, "Password Does Not Match!");
					}
				} catch (Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "Fail to register");
				}
				
			}
		});
		btnRegister.setFont(new Font("Calibri", Font.BOLD, 26));
		contentPane.setLayout(null);
		contentPane.add(lblRegisterPage);
		contentPane.add(label_1);
		contentPane.add(usernameTextField);
		contentPane.add(label_2);
		contentPane.add(passwordField);
		contentPane.add(lblConfirmPassword);
		contentPane.add(passwordField_1);
		contentPane.add(rdbtnStudent);
		contentPane.add(rdbtnTeacher);
		contentPane.add(btnRegister);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(265, 159, 381, 10);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(264, 252, 381, 10);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(264, 342, 381, 10);
		contentPane.add(separator_2);
	}

}

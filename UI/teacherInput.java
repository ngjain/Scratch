package UI;

/*
Author: Yansong Peng and Jain Nayan
Date: 11/15/2019
For: SER515, Professor Findler
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Implementation.ImplementationService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.nio.file.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JRadioButton;



@SuppressWarnings({ "unused", "serial" })
public class teacherInput extends JFrame {

	private JPanel contentPane;
	private final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	private String user = "root";
	private String password = "Kuan890618";
	private teacherInput ti;
	public int getTotalQA() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			ImplementationService imp = new ImplementationService(conn);
			return imp.getTotalNum();
		} catch (Exception ex) {
			System.out.println(ex);
			return 0;
		}
	}

	/**
	 * Create the frame.
	 */
	public teacherInput() {
		ti = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextArea answerText = new JTextArea();
		answerText.setText("AnswerText");
		answerText.setFont(new Font("Times New Roman", Font.PLAIN, 45));
		answerText.setTabSize(4);
		
		JTextArea questionText = new JTextArea();
		questionText.setFont(new Font("Times New Roman", Font.PLAIN, 45));
		questionText.setTabSize(4);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setFont(new Font("Rockwell", Font.PLAIN, 25));
		
		JRadioButton rdbtnLow = new JRadioButton("Low");
		rdbtnLow.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnLow.setBackground(Color.CYAN);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setFont(new Font("Rockwell", Font.PLAIN, 25));
		
		JRadioButton rdbtnHigh = new JRadioButton("High");
		rdbtnHigh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnHigh.setBackground(Color.CYAN);
		
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
		
		JButton btnBack = new JButton("Return");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPage main = new mainPage();
				ti.dispose();
				main.setVisible(true);
				setVisible(false);
			}
		});
			
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url, user, password);
					String level = "";
					if (rdbtnLow.isSelected()) {
						level = "0";
					} else if (rdbtnHigh.isSelected()) {
						level = "1";
					} else {
						JOptionPane.showMessageDialog(null, "Error! Please Select the grade level!");
					}
					String query = "insert into question(question, answer, grades) values('" + questionText.getText() + "', '" + answerText.getText() + "','" + level + "')";
					Statement statement = conn.createStatement();
					statement.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Successfully added the question");
				} catch(Exception ex) {
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "Failed to add the question");
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setFont(new Font("Rockwell", Font.PLAIN, 25));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblQuestion, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
							.addGap(1089)
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(122)
							.addComponent(rdbtnLow, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(77)
							.addComponent(rdbtnHigh, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addGap(716)
							.addComponent(btnSubmit, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(questionText, GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAnswer, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(1234))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(answerText, GroupLayout.DEFAULT_SIZE, 1348, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(lblQuestion, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
							.addGap(6)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(questionText, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAnswer, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(answerText, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addComponent(btnSubmit, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLevel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnLow, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnHigh, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
							.addGap(42))))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

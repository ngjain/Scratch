package UI;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Implementation.ImplementationService;

import java.awt.Font;
/***
 * 
 * @author hzhan193, MayankASU
 * date create - 11/14/2019
 * date modified - 11/19/2019
 */
public class DragAndDropPanel extends JPanel {
	public JTextArea text, result;
	private JPanel dragAndDrop;
	private JPanel resultPanel;
	private JPanel operation;
	private JButton btn1;
	private JButton btn2;
	private JButton dropArea;
	public int level;
	private final String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	private String user = "root";
	private String password = "Kuan890618";
	private studentCalculate stu;
	public String Id;
	public DragAndDropPanel obj_of_drag_drop;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1888406948735963582L;
	private JButton btnReturn;

	/**
	 * Create the panel.
	 */
	public DragAndDropPanel(int level, studentCalculate student) {
		this.level = level;
		stu = student;
		obj_of_drag_drop = this;
		init();
	}
	public void init() {
		this.setBackground(Color.cyan);
		
		/***
		 * add jpanel and jbutton to the drag and drop area 
		 */
		dragAndDrop = new JPanel();
		dragAndDrop.setBorder(BorderFactory.createTitledBorder("Drag & Drop Area"));
		dragAndDrop.setBackground(Color.cyan);
		
		dropArea = new JButton("Drop Off Area");
		dropArea.setBackground(Color.cyan);
		dropArea.setOpaque(true);
		dropArea.setBorderPainted(false);
		
		text = new JTextArea();
		text.setFont(new Font("Rockwell", Font.PLAIN, 26));
		text.setColumns(20);
		text.setRows(4);
		text.setBorder(BorderFactory.createTitledBorder(""));
		text.setBackground(Color.cyan);
		resultPanel = new JPanel();
		resultPanel.setBackground(Color.cyan);
	
		
		dragAndDrop.add(text);
		dragAndDrop.add(dropArea);
		dragAndDrop.setLayout(new GridLayout(1, 2));
		
		result = new JTextArea();
		result.setFont(new Font("Rockwell", Font.PLAIN, 26));
		result.setColumns(19);
		result.setRows(4);
		result.setBackground(Color.cyan);
		result.setEditable(false);
		result.setLineWrap(true);
		result.setWrapStyleWord(true);
		resultPanel.add(result);
		
		operation = new JPanel();
		btn1 = new JButton("CLEAR");
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btn1.setBackground(Color.cyan);
		btn1.setOpaque(true);
		btn1.setBorderPainted(false);
		
		btn2 = new JButton("SUBMIT");
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btn2.setBackground(Color.cyan);
		btn2.setOpaque(true);
		btn2.setBorderPainted(false);
		
		operation.add(btn1);
		operation.add(btn2);
		operation.setBackground(Color.cyan);
		operation.setLayout(new GridLayout(1, 2));
		
		this.add(dragAndDrop);
		this.add(resultPanel);
		this.add(operation);
		
		btnReturn = new JButton("RETURN");
		btnReturn.setBackground(Color.cyan);
		btnReturn.setOpaque(true);
		btnReturn.setBorderPainted(false);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPage main = new mainPage();
				main.setVisible(true);
				stu.dispose();
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		operation.add(btnReturn);
		this.setLayout(new GridLayout(3, 1));
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText(null);
				result.setText(null);
			}
		});
	
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Id == null)
					JOptionPane.showMessageDialog(null, "Select a question from list for which you want to check your answer!");
				else {
					DatabaseConn db = new DatabaseConn(url, user, password);
				Connection conn = db.getMySqlConnection();		
				if(conn == null) {
					JOptionPane.showMessageDialog(null, "database connection failed");
					return;
				}
				ImplementationService imp = new ImplementationService(conn);
				if(imp.checkAnswer(Id, result.getText(), obj_of_drag_drop)) {
					result.setText("You answer is correct!");
				}
				else {
					result.setText("Your answer is wrong! Try again!");
				}
			}
		}
		});
	}
	
	public void calculate(String eqn) {		
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    try {
			result.setText(engine.eval(eqn).toString());
		} catch (ScriptException e) {
			String error = "ERROR: " + "an operand is expected after the operator";
			result.setText(error);
			System.out.println(e.getColumnNumber());
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}
	}
}
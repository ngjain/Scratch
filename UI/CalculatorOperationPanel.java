package UI;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.TransferHandler;

import DragMouseAdapter.DragMouseAdapter;
import DragMouseAdapter.ValueExportTransferHandler;
import DragMouseAdapter.ValueImportTransferHandler;
import java.awt.Font;
import java.awt.SystemColor;

@SuppressWarnings("unused")
public class CalculatorOperationPanel extends JPanel {
	
	private JPanel groupOperandBtn;
	private JPanel groupOperationBtn;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnMulti;
	private JButton btnDivision;
	private int level;
	private DragAndDropPanel dragPanel;
	private static final long serialVersionUID = 1L;
	private JButton btnLeftPts;
	private JButton btnRightPts;

	/**
	 * Create the panel.
	 */
	public CalculatorOperationPanel(DragAndDropPanel dPanel, int level) {
		dragPanel = dPanel;
		this.level = level;
		init();
	}
	
	public void disabledButton(int level) {
		if(level == 0) {
			this.btnMulti.setVisible(false);
			this.btnDivision.setVisible(false);
			this.btnLeftPts.setVisible(false);
			this.btnRightPts.setVisible(false);
		}
	}
	public void init() {
		panelInit();
		btnInit();
		groupOperandBtn.setLayout(new GridLayout(4,3));
		groupOperandBtn.setBorder(BorderFactory.createTitledBorder("Operand"));
		groupOperandBtn.setBackground(Color.CYAN);
		
		groupOperationBtn.add(btnPlus);
		groupOperationBtn.add(btnMinus);
		groupOperationBtn.add(btnMulti);
		groupOperationBtn.add(btnDivision);
		groupOperationBtn.add(btnLeftPts);
		groupOperationBtn.add(btnRightPts);
		
		groupOperationBtn.setLayout(new GridLayout(3,2));
		groupOperationBtn.setBorder(BorderFactory.createTitledBorder("Operator"));
		groupOperationBtn.setBackground(Color.cyan);
		
		this.add(groupOperandBtn);
		this.add(groupOperationBtn);
		
		this.setLayout(new GridLayout(2,1));
	}
	private void panelInit() {
		groupOperandBtn = new JPanel();
		groupOperationBtn = new JPanel();
		//this.setBackground(new Color(255,255,204));
		this.setBackground(Color.cyan);
	}
	private void btnInit() {
		DragMouseAdapter listener = new DragMouseAdapter();
		for(int i = 0; i <= 9; i++) {
			JButton btnOperand = new JButton(Integer.toString(i));
			btnOperand.setBackground(Color.cyan);
			btnOperand.setOpaque(true);
			btnOperand.setBorderPainted(false);
			groupOperandBtn.add(btnOperand);
			btnOperand.setFont(new Font("Rockwell", Font.PLAIN, 28));
			btnOperand.setTransferHandler(new ValueExportTransferHandler(Integer.toString(i), dragPanel));
			btnOperand.addMouseMotionListener(listener);
		}
		btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Rockwell", Font.PLAIN, 32));
		btnPlus.setBackground(Color.cyan);
		btnPlus.setOpaque(true);
		btnPlus.setBorderPainted(false);
		btnPlus.setTransferHandler(new ValueExportTransferHandler("+", dragPanel));
		btnPlus.addMouseMotionListener(listener);
		
		
		btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Rockwell", Font.PLAIN, 32));
		btnMinus.setBackground(Color.cyan);
		btnMinus.setOpaque(true);
		btnMinus.setBorderPainted(false);
		btnMinus.setTransferHandler(new ValueExportTransferHandler("-", dragPanel));
		btnMinus.addMouseMotionListener(listener);
		
		btnMulti = new JButton("*");
		btnMulti.setFont(new Font("Rockwell", Font.PLAIN, 32));
		btnMulti.setBackground(Color.cyan);
		btnMulti.setOpaque(true);
		btnMulti.setBorderPainted(false);
		btnMulti.setTransferHandler(new ValueExportTransferHandler("*", dragPanel));
		btnMulti.addMouseMotionListener(listener);
		
		btnDivision = new JButton("/");
		btnDivision.setFont(new Font("Rockwell", Font.PLAIN, 32));
		btnDivision.setBackground(Color.cyan);
		btnDivision.setOpaque(true);
		btnDivision.setBorderPainted(false);
		btnDivision.setTransferHandler(new ValueExportTransferHandler("/", dragPanel));
		btnDivision.addMouseMotionListener(listener);
		
		btnLeftPts = new JButton("(");
		btnLeftPts.setFont(new Font("Rockwell", Font.PLAIN, 30));
		btnLeftPts.setBackground(Color.cyan);
		btnLeftPts.setOpaque(true);
		btnLeftPts.setBorderPainted(false);
		btnLeftPts.setTransferHandler(new ValueExportTransferHandler("(", dragPanel));
		btnLeftPts.addMouseMotionListener(listener);
		
		btnRightPts = new JButton(")");
		btnRightPts.setFont(new Font("Rockwell", Font.PLAIN, 30));
		btnRightPts.setBackground(Color.cyan);
		btnRightPts.setOpaque(true);
		btnRightPts.setBorderPainted(false);
		btnRightPts.setTransferHandler(new ValueExportTransferHandler(")", dragPanel));
		btnRightPts.addMouseMotionListener(listener);
		
		disabledButton(this.level);
	
	}

}

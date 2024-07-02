import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.PlainDocument;
public class View {

	private static final int UI_WIDTH = 500;
	private static final int UI_HEIGHT = 255;

	private JFrame frame;
	private Container contentPane;
	private JPanel[] panel;

	private JLabel msgLabel;
	private JLabel warningLabel;
	private JLabel yearLabel;
	private JLabel monthLabel;
	private JLabel dayLabel;
	private JLabel leapYearLabel;
	private JLabel isEndOfAMonthLabel;
	private JLabel leapYearResultLabel;
	private JLabel isEndOfAMonthResultLabel;

	private JTextField yearField;
	private JTextField monthField;
	private JTextField dayField;

	private JButton confirmButton;
	private JButton clearButton;

	public View() {
		this.setFrame();
		this.setContainer();
		this.setDateField();
		this.setResultField();
		this.setButton();
		this.setWarning();
	}

	// Set up the Frame layout
	private void setFrame() {
		frame = new JFrame("Lab 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(UI_WIDTH, UI_HEIGHT);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	// Set up the content pane layout
	private void setContainer() {
		panel = new JPanel[4];
		contentPane = frame.getContentPane();
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
			panel[i].setLayout(new BoxLayout(panel[i], BoxLayout.X_AXIS));
			panel[i].setBorder(new EmptyBorder(10, 10, 10, 10));
		}
		panel[3].setPreferredSize(new Dimension(UI_WIDTH, 35));
		contentPane.add(panel[0], BorderLayout.PAGE_START);
		contentPane.add(panel[1], BorderLayout.LINE_START);
		contentPane.add(panel[2], BorderLayout.LINE_END);
		contentPane.add(panel[3], BorderLayout.PAGE_END);
	}

	// Set up the Text Field layout
	private void setDateField() {
		// Date Label
		msgLabel = new JLabel("Please enter the date (yyyy-MM-dd): ");
		yearLabel = new JLabel("Year:");
		monthLabel = new JLabel("Month:");
		dayLabel = new JLabel("Day:");

		// Date field
		yearField = new JTextField(4);
		monthField = new JTextField(2);
		dayField = new JTextField(2);

		// Limit the input size
		yearField.setDocument(new PlainDocument());
		monthField.setDocument(new PlainDocument());
		dayField.setDocument(new PlainDocument());

		// Use Vertical Box to group the component
		Box box = Box.createVerticalBox();
		box.add(msgLabel);

		JPanel datePanel = new JPanel();
		datePanel.add(yearLabel);
		datePanel.add(yearField);
		datePanel.add(monthLabel);
		datePanel.add(monthField);
		datePanel.add(dayLabel);
		datePanel.add(dayField);
		box.add(datePanel);

		// Add the Vertical box into the panel
		panel[0].add(box);
	}

	// Set up result label layout
	private void setResultField() {

		// Result Label
		leapYearLabel = new JLabel("Is leap year : ");
		leapYearLabel.setForeground(Color.BLUE);
		isEndOfAMonthLabel = new JLabel("Is the end of a month : ");
		isEndOfAMonthLabel.setForeground(Color.BLUE);

		leapYearResultLabel = new JLabel();
		isEndOfAMonthResultLabel = new JLabel();

		// Use Group layout to group the component
		JPanel resultPanel = new JPanel();
		GroupLayout layout = new GroupLayout(resultPanel);
		resultPanel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		// Add component into group layout
		layout.setHorizontalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup()
								.addComponent(leapYearLabel)
								.addComponent(isEndOfAMonthLabel))
				.addGroup(
						layout.createParallelGroup()
								.addComponent(leapYearResultLabel)
								.addComponent(isEndOfAMonthResultLabel)));

		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGap(10)
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.BASELINE)
								.addComponent(leapYearLabel)
								.addComponent(leapYearResultLabel))
				.addGap(10)
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING)
								.addComponent(isEndOfAMonthLabel)
								.addComponent(isEndOfAMonthResultLabel))
				.addGap(10)
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING))
				.addGap(10)
				.addGroup(
						layout.createParallelGroup(
								GroupLayout.Alignment.LEADING)).addGap(10));

		// Add the Result Panel into the panel
		panel[1].add(resultPanel);
	}

	// Set up the Button layout
	private void setButton() {
		confirmButton = new JButton("Confirm");
		clearButton = new JButton("Clear");

		// Use GridLayout to group the component
		JPanel buttonPanel = new JPanel();
		GridLayout layout = new GridLayout(2, 1);
		buttonPanel.setLayout(layout);

		buttonPanel.add(confirmButton);
		buttonPanel.add(clearButton);

		// Add the Vertical box into the panel
		panel[2].add(buttonPanel);
	}

	// Set up the warning label layout
	private void setWarning() {
		warningLabel = new JLabel("*** Date incorrect, try again");
		warningLabel.setForeground(Color.RED);
		warningLabel.setVisible(false);

		// Add the Vertical box into the panel
		panel[3].add(warningLabel);
	}

	/*
	 * Button
	 */

	public JButton getConfirmButton() {
		return confirmButton;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	/*
	 * Input date text field
	 */

	public JTextField getYearField() {
		return yearField;
	}

	public JTextField getMonthField() {
		return monthField;
	}

	public JTextField getDayField() {
		return dayField;
	}

	/*
	 * Output Result Label
	 */

	public JLabel getLeapYearResultLabel() {
		return leapYearResultLabel;
	}

	public JLabel getIsEndOfAMonthResultLabel() {
		return isEndOfAMonthResultLabel;
	}

	/*
	 * Warning Message
	 */

	public JLabel getWarning() {
		return warningLabel;
	}

}

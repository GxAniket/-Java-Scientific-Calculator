import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends JFrame implements ActionListener {
	private JTextField textField;
	private double num1, num2, result;
	private char operator;

	// Constructor to design the GUI
	public ScientificCalculator() {
    	setTitle("Scientific Calculator");
    	setSize(400, 500);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLayout(new BorderLayout());

    	textField = new JTextField();
    	textField.setHorizontalAlignment(JTextField.RIGHT);
    	textField.setEditable(false);
    	add(textField, BorderLayout.NORTH);

    	JPanel panel = new JPanel();
    	panel.setLayout(new GridLayout(5, 4, 5, 5));

    	String[] buttons = {
        	"7", "8", "9", "/", "sin",
        	"4", "5", "6", "*", "cos",
        	"1", "2", "3", "-", "tan",
        	"0", ".", "=", "+", "√",
        	"C", "log", "exp", "pow"
    	};

    	for (String text : buttons) {
        	JButton button = new JButton(text);
        	button.addActionListener(this);
        	panel.add(button);
    	}

    	add(panel, BorderLayout.CENTER);
    	setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
    	String command = e.getActionCommand();

    	try {
        	switch (command) {
            	case "C" -> textField.setText("");
            	case "=" -> {
                	num2 = Double.parseDouble(textField.getText());
                	switch (operator) {
                    	case '+' -> result = num1 + num2;
                    	case '-' -> result = num1 - num2;
                    	case '*' -> result = num1 * num2;
                    	case '/' -> result = num1 / num2;
                	}
                	textField.setText(String.valueOf(result));
            	}
            	case "sin" -> textField.setText(String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(textField.getText())))));
            	case "cos" -> textField.setText(String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(textField.getText())))));
            	case "tan" -> textField.setText(String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(textField.getText())))));
            	case "√" -> textField.setText(String.valueOf(Math.sqrt(Double.parseDouble(textField.getText()))));
            	case "log" -> textField.setText(String.valueOf(Math.log10(Double.parseDouble(textField.getText()))));
            	case "exp" -> textField.setText(String.valueOf(Math.exp(Double.parseDouble(textField.getText()))));
            	case "pow" -> {
                	num1 = Double.parseDouble(textField.getText());
                	textField.setText("");
                	operator = '^';
            	}
            	default -> {
                	if ("+-*/".contains(command)) {
                    	num1 = Double.parseDouble(textField.getText());
                    	textField.setText("");
                    	operator = command.charAt(0);
                	} else {
                    	textField.setText(textField.getText() + command);
                	}
            	}
        	}
    	} catch (Exception ex) {
        	textField.setText("Error");
    	}
	}

	public static void main(String[] args) {
    	new ScientificCalculator();
	}
}

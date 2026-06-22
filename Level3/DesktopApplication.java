import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopApplication extends JFrame {
    private JTextField display;
    private String currentInput = "";
    private double firstOperand = 0;
    private String operator = "";

    public DesktopApplication() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(new ButtonListener());
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if ("0123456789".contains(cmd)) {
                currentInput += cmd;
                display.setText(currentInput);
            } else if ("+-*/".contains(cmd)) {
                firstOperand = Double.parseDouble(currentInput);
                operator = cmd;
                currentInput = "";
                display.setText(operator);
            } else if (cmd.equals("=")) {
                double secondOperand = Double.parseDouble(currentInput);
                double result = 0;
                switch (operator) {
                    case "+": result = firstOperand + secondOperand; break;
                    case "-": result = firstOperand - secondOperand; break;
                    case "*": result = firstOperand * secondOperand; break;
                    case "/": result = secondOperand != 0 ? firstOperand / secondOperand : 0; break;
                }
                currentInput = String.valueOf(result);
                display.setText(currentInput);
                operator = "";
            } else if (cmd.equals("C")) {
                currentInput = "";
                operator = "";
                display.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DesktopApplication::new);
    }
}

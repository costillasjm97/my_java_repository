import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LabActivity4EmpInfoSystemGUI extends JFrame {

    private JTextField firstNameField, lastNameField, ageField, hoursField, rateField;
    private JButton submitButton;
    private JTextArea resultArea;

    public LabActivity4EmpInfoSystemGUI() {
        setTitle("Laboratory Activity 4");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));

        inputPanel.add(new JLabel("First Name"));
        firstNameField = new JTextField();
        inputPanel.add(firstNameField);

        inputPanel.add(new JLabel("Last Name"));
        lastNameField = new JTextField();
        inputPanel.add(lastNameField);

        inputPanel.add(new JLabel("Age"));
        ageField = new JTextField();
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Hours Worked"));
        hoursField = new JTextField();
        inputPanel.add(hoursField);

        inputPanel.add(new JLabel("Hourly Rate"));
        rateField = new JTextField();
        inputPanel.add(rateField);

        submitButton = new JButton("Submit");
        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        inputPanel.add(submitButton);

        // Placeholder for spacing
        inputPanel.add(new JLabel());

        add(inputPanel, BorderLayout.NORTH);

        // Result Panel
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBorder(BorderFactory.createTitledBorder("Output:"));
        add(resultArea, BorderLayout.CENTER);


        // Action Listener
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateEmployeeInfo();
            }
        });
    }

    private void calculateEmployeeInfo() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String ageText = ageField.getText();
        String hoursText = hoursField.getText();
        String rateText = rateField.getText();

        // Error Handling
        if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || hoursText.isEmpty() || rateText.isEmpty()) {
            resultArea.setText("Error: All fields must be filled out.");
            return;
        }

        int age;
        double hours, rate;

        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException e) {
            resultArea.setText("Error: Age must be a valid integer.");
            return;
        }

        try {
            hours = Double.parseDouble(hoursText);
            rate = Double.parseDouble(rateText);
        } catch (NumberFormatException e) {
            resultArea.setText("Error: Hours worked and hourly rate must be valid numbers.");
            return;
        }

        String fullName = firstName + " " + lastName;
        double dailyWage = hours * rate;

        // Display Results
        resultArea.setText("Full Name: " + fullName +
                           "\nAge: " + age + " " + "years old" +
                           "\nDaily Salary: PHP" + " " + String.format("%.2f", dailyWage));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LabActivity4EmpInfoSystemGUI().setVisible(true);
        });
    }
}
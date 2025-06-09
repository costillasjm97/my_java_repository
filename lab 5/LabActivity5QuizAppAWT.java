import java.awt.*;
import java.awt.event.*;

public class LabActivity5QuizAppAWT extends Frame implements ActionListener {
    String[] questions = {
        "What is the capital of France?",
        "Which language is used for Android development?",
        "What is the result of 2 + 2 * 2?"
    };

    String[][] options = {
        {"Paris", "Rome", "Berlin", "Madrid"},
        {"Swift", "Java", "Python", "Kotlin"},
        {"6", "8", "4", "10"}
    };

    int[] correctAnswers = {0, 3, 1};
    int currentQuestion = 0;
    int score = 0;

    Label questionLabel;
    Label errorLabel;
    Button nextButton;
    CheckboxGroup optionsGroup;
    Checkbox[] optionButtons;

    public LabActivity5QuizAppAWT() {
        setTitle("Quiz App");
        setSize(500, 300);
        setLayout(new BorderLayout());

        // Top Panel (Question)
        Panel topPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        questionLabel = new Label();
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        topPanel.add(questionLabel);
        add(topPanel, BorderLayout.NORTH);

        // Center Panel (Options)
        Panel centerPanel = new Panel(new GridLayout(2, 2, 10, 10));
        optionsGroup = new CheckboxGroup();
        optionButtons = new Checkbox[4];
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new Checkbox("", optionsGroup, false);
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
            optionButtons[i].setForeground(Color.BLUE);
            centerPanel.add(optionButtons[i]);
        }
        add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel (Error message and Next button)
        Panel bottomPanel = new Panel(new BorderLayout());

        errorLabel = new Label(" ", Label.CENTER);
        errorLabel.setForeground(Color.BLACK);
        bottomPanel.add(errorLabel, BorderLayout.NORTH);

        nextButton = new Button("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 14));
        nextButton.addActionListener(this);
        bottomPanel.add(nextButton, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // Show first question
        displayQuestion();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    private void displayQuestion() {
        questionLabel.setText(questions[currentQuestion]);
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setLabel((char) ('A' + i) + ". " + options[currentQuestion][i]);
            optionButtons[i].setState(false);
        }

        errorLabel.setText(" "); // Clear previous error
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Checkbox selected = optionsGroup.getSelectedCheckbox();
        if (selected == null) {
            errorLabel.setText("Please select an answer.");
            return;
        }

        errorLabel.setText(" ");

        int selectedIndex = -1;
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i] == selected) {
                selectedIndex = i;
                break;
            }
        }

        if (selectedIndex == correctAnswers[currentQuestion]) {
            score++;
        }

        currentQuestion++;

        if (currentQuestion < questions.length) {
            displayQuestion();
        } else {
            questionLabel.setText("Quiz Completed! Your Score: " + score + " out of " + questions.length);
            for (Checkbox optionButton : optionButtons) {
                optionButton.setEnabled(false);
            }
            nextButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        new LabActivity5QuizAppAWT();
    }
}

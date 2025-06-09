import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class LabActivity6SwingToDoList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListViewer::new);
    }
}

class ToDoListViewer extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton addButton;
    private ToDoListForm formWindow;

    public ToDoListViewer() {
        setTitle("To-Do List Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel with "Add Task" button
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addButton = new JButton("Add Task");
        topPanel.add(addButton);
        add(topPanel, BorderLayout.NORTH);

        // Table setup
        tableModel = new DefaultTableModel(new Object[]{"Task Name", " Task Description", "Status"}, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        add(tableScrollPane, BorderLayout.CENTER);

        // Button event to show form
        addButton.addActionListener(e -> {
            if (formWindow == null || !formWindow.isDisplayable()) {
                formWindow = new ToDoListForm(this);
                formWindow.setVisible(true);
            } else {
                formWindow.toFront();
            }
        });

        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to add new row to table
    public void addTask(String name, String desc, String status) {
        tableModel.addRow(new Object[]{name, desc, status});
    }
}

class ToDoListForm extends JFrame {
    private JTextField taskNameField;
    private JTextArea taskDescArea;
    private JComboBox<String> statusDropdown;
    private JButton saveButton;

    public ToDoListForm(ToDoListViewer viewer) {
        setTitle("Add New Task");
        setSize(400, 300);
        setLocationRelativeTo(viewer);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Main panel for form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Task Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Task Name:"), gbc);
        taskNameField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(taskNameField, gbc);

        // Task Description
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Task Description:"), gbc);
        taskDescArea = new JTextArea(4, 20);
        JScrollPane descScroll = new JScrollPane(taskDescArea);
        gbc.gridx = 1;
        formPanel.add(descScroll, gbc);

        // Status Dropdown
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Status:"), gbc);
        String[] statuses = {"Not Started", "Ongoing", "Completed"};
        statusDropdown = new JComboBox<>(statuses);
        gbc.gridx = 1;
        formPanel.add(statusDropdown, gbc);

        add(formPanel, BorderLayout.CENTER);

        // Save button
        saveButton = new JButton("Save Task");
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(saveButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Event handling
        saveButton.addActionListener(e -> {
            String name = taskNameField.getText().trim();
            String desc = taskDescArea.getText().trim();
            String status = (String) statusDropdown.getSelectedItem();

            if (name.isEmpty() || status.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in Task Name and Status.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            viewer.addTask(name, desc, status);
            dispose();
        });
    }
}
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynamicTableExample extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public DynamicTableExample() {
        setTitle("Dynamic Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the table model with initial data
        String[] columnNames = {"Name", "Age", "Occupation"};
        Object[][] initialData = {
                {"ABC xyz", 25, "Engineer"},
                {"XYZ abc", 32, "Manager"}
        };
        model = new DefaultTableModel(initialData, columnNames);

        // Create the table with the model
        table = new JTable(model);

        // Create buttons for adding rows and columns
        JButton addRowButton = new JButton("Add Row");
        JButton addColumnButton = new JButton("Add Column");

        // Add action listeners to the buttons
        addRowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRow();
            }
        });

        addColumnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addColumn();
            }
        });

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addRowButton);
        buttonPanel.add(addColumnButton);

        // Add the table and button panel to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addRow() {
        // Create an array of empty objects with the same length as the columns
        Object[] rowData = new Object[model.getColumnCount()];
        model.addRow(rowData);
    }

    private void addColumn() {
        String columnName = JOptionPane.showInputDialog("Enter column name:");
        if (columnName != null && !columnName.isEmpty()) {
            model.addColumn(columnName);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DynamicTableExample example = new DynamicTableExample();
                example.pack();
                example.setVisible(true);
            }
        });
    }
}

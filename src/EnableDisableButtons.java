import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnableDisableButtons extends JFrame implements ActionListener {
    private JButton enableButton;
    private JButton disableButton;

    public EnableDisableButtons() {
        setTitle("Button Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the buttons
        enableButton = new JButton("Enable");
        disableButton = new JButton("Disable");

        // Set initial button states
        enableButton.setEnabled(false);
        disableButton.setEnabled(true);

        // Set button positions
        enableButton.setBounds(50, 50, 80, 30);
        disableButton.setBounds(150, 50, 80, 30);

        // Add action listeners to the buttons
        enableButton.addActionListener(this);
        disableButton.addActionListener(this);

        // Add buttons to the frame
        add(enableButton);
        add(disableButton);

        // Set layout to null for manual button positioning
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enableButton) {
            // Enable the disableButton and disable the enableButton
            disableButton.setEnabled(true);
            enableButton.setEnabled(false);
        } 
        else if (e.getSource() == disableButton) {
            // Enable the enableButton and disable the disableButton
            enableButton.setEnabled(true);
            disableButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	EnableDisableButtons example = new EnableDisableButtons();
            example.setVisible(true);
        });
    }
}

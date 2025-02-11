import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Admin_Login extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Admin_Login frame = new Admin_Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Admin_Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the window to full screen or maximized
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Get the screen size dynamically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        // Calculate central positioning
        int centralX = width / 2;
        int centralY = height / 2;

        // For USERNAME label
        JLabel lblNewLabel = new JLabel("USERNAME:");
        lblNewLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Decreased font size
        lblNewLabel.setBounds(centralX - 150, centralY - 100, 200, 25); // Centralized
        contentPane.add(lblNewLabel);

        // Username text field
        textField = new JTextField();
        textField.setFont(new Font("Serif", Font.PLAIN, 20)); // Normal text size
        textField.setBounds(centralX - 150, centralY - 60, 300, 40); // Increased width and height
        textField.setHorizontalAlignment(JTextField.CENTER); // Center align text
        contentPane.add(textField);

        // For PASSWORD label
        JLabel lblNewLabel_1 = new JLabel("PASSWORD:");
        lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 24)); // Decreased font size
        lblNewLabel_1.setBounds(centralX - 150, centralY + 10, 200, 25); // Centralized
        contentPane.add(lblNewLabel_1);

        // Password field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Serif", Font.PLAIN, 20)); // Normal text size
        passwordField.setBounds(centralX - 150, centralY + 50, 300, 40); // Increased width and height
        passwordField.setHorizontalAlignment(JTextField.CENTER); // Center align text
        contentPane.add(passwordField);

        // Correct username and password
        String correctUsername = "admin";
        String correctPassword = "password";

        // Login button
        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.setFont(new Font("Serif", Font.BOLD, 18)); // Changed to Serif
        btnNewButton.setBounds(centralX - 50, centralY + 180, 100, 35); // Moved button down
        btnNewButton.setBackground(new Color(255, 220, 220)); // Set background color
        btnNewButton.setForeground(new Color(138, 25, 25)); // Set text color
        btnNewButton.setBorderPainted(true);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setOpaque(true); // Make it opaque
        btnNewButton.addActionListener(e -> {
            String enteredUsername = textField.getText();
            String enteredPassword = new String(passwordField.getPassword()); // Retrieve password
            if (enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword)) {
                Admin obj = new Admin();
                obj.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "INCORRECT CREDENTIALS");
            }
        });
        contentPane.add(btnNewButton);

        // Load and scale the background image
        ImageIcon originalIcon = new ImageIcon("C:\\G\\APP project\\Pulse\\BloodBank\\img\\admin login.jpg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH); // Scaled the image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Background image label
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(scaledIcon);
        lblNewLabel_3.setBounds(0, 0, width, height); // Full screen size
        contentPane.add(lblNewLabel_3);

        // Ensure the background is behind other components
        contentPane.setComponentZOrder(lblNewLabel_3, contentPane.getComponentCount() - 1);

        // Adding BACK button
        JButton btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Serif", Font.BOLD, 16));
        btnBack.setBounds(width - 100, 10, 80, 30); // Top-right corner
        btnBack.setBackground(new Color(255, 220, 220)); // Background color
        btnBack.setForeground(new Color(138, 25, 25)); // Text color
        btnBack.setBorderPainted(true);
        btnBack.setFocusPainted(false);
        btnBack.setOpaque(true); // Make it opaque
        btnBack.addActionListener(e -> {
            // Hide the current Admin_Login frame
            setVisible(false);

            // Create an instance of Select.java and display it
            Select selectFrame = new Select(); // Assuming Select.java is another JFrame class
            selectFrame.setVisible(true); // Show the Select frame
        });
        contentPane.add(btnBack);
    }
}

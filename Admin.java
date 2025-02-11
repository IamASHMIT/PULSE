import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Admin extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Admin frame = new Admin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Admin() {
        // Set window to full screen or maximized
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get the screen size dynamically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        contentPane = new JPanel() {
            @Override
            public void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                
                // Load the image file
                String imagePath = "C:\\G\\APP project\\Pulse\\BloodBank\\img\\adminpage.jpg";  // Use double backslashes
                File imgFile = new File(imagePath);
                
                if (imgFile.exists()) {
                    ImageIcon originalIcon = new ImageIcon(imagePath);
                    Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    g.drawImage(scaledImage, 0, 0, this);
                } else {
                    System.out.println("Image file not found: " + imagePath);
                    // Optionally, set a fallback color
                    setBackground(new Color(235, 35, 70)); // Default color
                }
            }
        };
        
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // For WELCOME ADMIN label
        JLabel lblNewLabel = new JLabel("WELCOME ADMIN");
        lblNewLabel.setFont(new Font("Bradley Hand ITC", Font.BOLD | Font.ITALIC, 45));
        lblNewLabel.setBounds((int) (width * 0.35), (int) (height * 0.05), 500, 60);
        contentPane.add(lblNewLabel);

        // For TO VIEW RECORDS label
        JLabel lblNewLabel_1 = new JLabel("TO VIEW RECORDS:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_1.setBounds((int) (width * 0.05), (int) (height * 0.3), 150, 25);
        contentPane.add(lblNewLabel_1);

        // View Records button
        JButton btnNewButton = new JButton("VIEW RECORDS");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewRecords obj = new ViewRecords();
                obj.setVisible(true);
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton.setBounds((int) (width * 0.15), (int) (height * 0.3), 170, 30);
        contentPane.add(btnNewButton);

        // For TO VIEW USERS label
        JLabel lblNewLabel_2 = new JLabel("TO VIEW USERS:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblNewLabel_2.setBounds((int) (width * 0.05), (int) (height * 0.45), 150, 25);
        contentPane.add(lblNewLabel_2);

        // View Users button
        JButton btnNewButton_1 = new JButton("VIEW USERS");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Register_Table obj = new Register_Table();
                obj.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton_1.setBounds((int) (width * 0.15), (int) (height * 0.45), 170, 30);
        contentPane.add(btnNewButton_1);

        // Back button
        JButton btnNewButton_2 = new JButton("BACK");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Select obj = new Select();
                obj.setVisible(true);
                dispose();
            }
        });
        btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton_2.setBounds((int) (width * 0.02), (int) (height * 0.02), 100, 30);
        contentPane.add(btnNewButton_2);
    }
}

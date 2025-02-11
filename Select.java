import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Toolkit; // For screen size detection

// Custom button class with rounded corners
class RoundedButton extends JButton {
    private int borderRadius = 20; // Adjust for more or less curvature

    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false); // Disable the default button filling
        setFocusPainted(false); // Disable focus border
        setBorderPainted(false); // Disable the button's border
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(230, 80); // Set preferred size
    }
}

public class Select extends JFrame {
    public JPanel contentPane;

    public Select() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the window to full screen or maximized
        setExtendedState(JFrame.MAXIMIZED_BOTH); // This will maximize the window

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Get the screen size dynamically
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        // Load and scale the background image to fit the entire screen size
        ImageIcon originalIcon = new ImageIcon("C:\\G\\APP project\\Pulse\\BloodBank\\img\\desktopimage.jpg");
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH); // Scaled the image
        ImageIcon scaledIcon = new ImageIcon(scaledImage);


        // Background image label
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(scaledIcon);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel.setBounds(0, 0, width, height); // Set bounds to the full screen size
        contentPane.add(lblNewLabel);

        // For ADMIN button
        RoundedButton btnAdmin = new RoundedButton("ADMIN Login");
        btnAdmin.addActionListener(e -> {
            Admin_Login obj = new Admin_Login();
            obj.setVisible(true);
            dispose();
        });
        btnAdmin.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Increased font size to 24
        btnAdmin.setBackground(new Color(255, 220, 220)); // Background color FFDCDC
        btnAdmin.setForeground(new Color(138, 25, 25)); // Change text color to '8A1919'
        btnAdmin.setBounds(1650, 10, 200, 110); // Position for the ADMIN button
        contentPane.add(btnAdmin);

        // For DONOR button
        RoundedButton btnDonor = new RoundedButton("Donate Now");
        btnDonor.addActionListener(e -> {
            Donor obj = new Donor();
            obj.setVisible(true);
            dispose();
        });
        btnDonor.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set original font size
        btnDonor.setBackground(new Color(255, 220, 220)); // Background color FFDCDC
        btnDonor.setForeground(new Color(138, 25, 25)); // Change text color to '8A1919'
        btnDonor.setBounds(100, 700, 256, 80); // Button position and size
        contentPane.add(btnDonor);

        // For RECEIVER button
        RoundedButton btnReceiver = new RoundedButton("Get Blood");
        btnReceiver.addActionListener(e -> {
            Receiver obj = new Receiver();
            obj.setVisible(true);
            dispose();
        });
        btnReceiver.setFont(new Font("Times New Roman", Font.BOLD, 24)); // Set original font size
        btnReceiver.setBackground(new Color(255, 220, 220)); // Background color FFDCDC
        btnReceiver.setForeground(new Color(138, 25, 25)); // Change text color to '8A1919'
        btnReceiver.setBounds(400, 700, 256, 80); // Button position and size
        contentPane.add(btnReceiver);

        // Set layout and set the background label to be behind other components
        contentPane.setComponentZOrder(lblNewLabel, contentPane.getComponentCount() - 1);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Select frame = new Select();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

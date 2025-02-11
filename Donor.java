import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Donor extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Donor frame = new Donor();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Donor() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        // Load the background image
        ImageIcon backgroundIcon = new ImageIcon("C:\\G\\APP project\\Pulse\\BloodBank\\img\\donordetails.jpg");
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Adding labels and text fields with adjusted positions to move contents down
        JLabel lblNewLabel = new JLabel("DONOR_ID:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel.setForeground(Color.WHITE);  // Set text color to white
        lblNewLabel.setBounds((int) (width * 0.23) - 10, (int) (height * 0.3) + 10, 101, 14);  // Adjusted down
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds((int) (width * 0.33) - 10, (int) (height * 0.3) + 10, 167, 20);  // Adjusted down
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("NAME:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_1.setForeground(Color.WHITE);  // Set text color to white
        lblNewLabel_1.setBounds((int) (width * 0.23) - 10, (int) (height * 0.35) + 10, 60, 14);  // Adjusted down
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds((int) (width * 0.33) - 10, (int) (height * 0.35) + 10, 167, 20);  // Adjusted down
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("AGE:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_2.setForeground(Color.WHITE);  // Set text color to white
        lblNewLabel_2.setBounds((int) (width * 0.23) - 10, (int) (height * 0.4) + 10, 33, 14);  // Adjusted down
        contentPane.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds((int) (width * 0.33) - 10, (int) (height * 0.4) + 10, 167, 20);  // Adjusted down
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("SEX:");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_3.setForeground(Color.WHITE);  // Set text color to white
        lblNewLabel_3.setBounds((int) (width * 0.23) - 10, (int) (height * 0.45) + 10, 33, 14);  // Adjusted down
        contentPane.add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setBounds((int) (width * 0.33) - 10, (int) (height * 0.45) + 10, 168, 20);  // Adjusted down
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("REGISTER_DATE:");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_4.setForeground(Color.WHITE);  // Set text color to white
        lblNewLabel_4.setBounds((int) (width * 0.23) - 10, (int) (height * 0.5) + 10, 116, 14);  // Adjusted down
        contentPane.add(lblNewLabel_4);

        textField_4 = new JTextField();
        textField_4.setBounds((int) (width * 0.33) - 10, (int) (height * 0.5) + 10, 167, 20);  // Adjusted down
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("BLOOD_TYPE:");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5.setForeground(Color.WHITE);  // Set text color to white
        lblNewLabel_5.setBounds((int) (width * 0.23) - 10, (int) (height * 0.55) + 10, 101, 14);  // Adjusted down
        contentPane.add(lblNewLabel_5);

        textField_5 = new JTextField();
        textField_5.setBounds((int) (width * 0.33) - 10, (int) (height * 0.55) + 10, 167, 20);  // Adjusted down
        contentPane.add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("BLOOD QUANTITY:");
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_6.setForeground(Color.WHITE);  // Set text color to white
        lblNewLabel_6.setBounds((int) (width * 0.23) - 10, (int) (height * 0.6) + 10, 130, 14);  // Adjusted down
        contentPane.add(lblNewLabel_6);

        textField_6 = new JTextField();
        textField_6.setBounds((int) (width * 0.33) - 10, (int) (height * 0.6) + 10, 167, 20);  // Adjusted down
        contentPane.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("STATE:");
        lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_7.setForeground(Color.WHITE);  // Set text color to white
        lblNewLabel_7.setBounds((int) (width * 0.23) - 10, (int) (height * 0.65) + 10, 47, 14);  // Adjusted down
        contentPane.add(lblNewLabel_7);

        textField_7 = new JTextField();
        textField_7.setBounds((int) (width * 0.33) - 10, (int) (height * 0.65) + 10, 167, 20);  // Adjusted down
        contentPane.add(textField_7);
        textField_7.setColumns(10);

        JLabel lblNewLabel_9 = new JLabel("ADDRESS:");
        lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_9.setForeground(Color.WHITE);  // Set text color to white
        lblNewLabel_9.setBounds((int) (width * 0.23) - 10, (int) (height * 0.7) + 10, 60, 14);  // Adjusted down
        contentPane.add(lblNewLabel_9);

        textField_8 = new JTextField();
        textField_8.setBounds((int) (width * 0.33) - 10, (int) (height * 0.7) + 10, 167, 20);  // Adjusted down
        contentPane.add(textField_8);
        textField_8.setColumns(10);

        JLabel lblNewLabel_10 = new JLabel("CONTACT:");
        lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_10.setForeground(Color.WHITE);  // Set text color to white
        lblNewLabel_10.setBounds((int) (width * 0.23) - 10, (int) (height * 0.75) + 10, 73, 14);  // Adjusted down
        contentPane.add(lblNewLabel_10);

        textField_9 = new JTextField();
        textField_9.setBounds((int) (width * 0.33) - 10, (int) (height * 0.75) + 10, 167, 20);  // Adjusted down
        contentPane.add(textField_9);
        textField_9.setColumns(10);

        JButton btnNewButton = new JButton("REGISTER");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        // Adjust the x-coordinate to align it more to the left
        btnNewButton.setBounds((int) (width * 0.33) - 10, (int) (height * 0.8), 150, 30); // Adjusted to align with the text fields
        contentPane.add(btnNewButton);

        JButton btnBack = new JButton("BACK");
        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
        // Position the back button at the top right corner
        btnBack.setBounds(width - 100, 10, 80, 30); // Adjust x-coordinate to move it to the right
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hide current frame
                setVisible(false);
                
                // Create an instance of Select.java and display it
                Select selectFrame = new Select(); // Assuming Select.java is another JFrame class
                selectFrame.setVisible(true); // Show the Select frame
            }
        });
        contentPane.add(btnBack);
        
        
    }
}

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

    public JPanel contentPane;
    public JTextField txtEnterUsername;
    public JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Opens in full-screen mode
        setResizable(false);

        // Load the background image with proper path handling
        ImageIcon backgroundIcon = new ImageIcon("C:\\G\\APP project\\Pulse\\BloodBank\\img\\firstlogin.jpg");
        
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Get window dimensions
                int width = getWidth();
                int height = getHeight();

                // Scale the image proportionally
                Image scaledImage = backgroundIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                g.drawImage(scaledImage, 0, 0, width, height, this);
            }
        };

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("USERNAME:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(1200, 300, 200, 30); // Moved to right side
        contentPane.add(lblNewLabel_1);

        txtEnterUsername = new JTextField();
        txtEnterUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        txtEnterUsername.setBounds(1200, 330, 300, 40); // Positioned to the right and increased size
        contentPane.add(txtEnterUsername);
        txtEnterUsername.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("PASSWORD:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBounds(1200, 380, 200, 30); // Moved to right side
        contentPane.add(lblNewLabel_2);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBounds(1200, 410, 300, 40); // Positioned to the right and increased size
        contentPane.add(passwordField);

        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton.setBackground(new Color(255, 102, 102));  // Light red color
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(1200, 470, 120, 40); // Positioned to the right
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] input1 = passwordField.getPassword();
                String input2 = txtEnterUsername.getText();
                if (input1.length != 0 && input2.length() != 0) {
                    String query = "SELECT * from register WHERE username='" + txtEnterUsername.getText() + "' AND Password='" + passwordField.getText() + "'";
                    connectDB obj_connectDB = new connectDB();
                    Connection con = obj_connectDB.get_db();
                    java.sql.Statement st = null;
                    try {
                        st = con.createStatement();
                        ResultSet rs = st.executeQuery(query);
                        if (rs.next()) {
                            Select obj = new Select();
                            obj.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "You are not a registered user.");
                        }
                    } catch (Exception i) {
                        System.out.println(i);
                    }
                } else if (input1.length == 0 && input2.length() != 0) {
                    JOptionPane.showMessageDialog(null, "Enter Password");
                } else if (input1.length != 0 && input2.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Enter Username");
                } else {
                    JOptionPane.showMessageDialog(null, "Enter Credentials");
                }
            }
        });
        contentPane.add(btnNewButton);

        JButton btnRegister = new JButton("REGISTER");
        btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnRegister.setBackground(new Color(255, 102, 102));  // Light red color
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setBounds(1380, 470, 120, 40); // Positioned to the right
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                REGISTER obj = new REGISTER();
                obj.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnRegister);
    }
}

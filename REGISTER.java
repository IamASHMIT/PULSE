import java.awt.Component;
import java.sql.Connection;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.util.Arrays;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.Color;

public class REGISTER extends JFrame {

    private JPanel contentPane;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
    private JTextField textField_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    REGISTER frame = new REGISTER();
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
    public REGISTER() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get the screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int screenWidth = toolkit.getScreenSize().width;
        int screenHeight = toolkit.getScreenSize().height;

        // Set the frame size to match the screen resolution
        setBounds(0, 0, screenWidth, screenHeight);  // Set full screen
        contentPane = new JPanel() {
            // Override paintComponent to add the background image
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("C:\\G\\APP project\\Pulse\\BloodBank\\img\\Register.jpg");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this); // Scale image to fit the frame
            }
        };
        
        contentPane.setBackground(new Color(235, 35, 70));  // Optional, can be removed if image covers it fully
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("USERNAME:");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel.setBounds(287, 126, 101, 14);
        contentPane.add(lblNewLabel);

        JTextField textField = new JTextField();
        textField.setBounds(379, 124, 167, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("FULL NAME:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_1.setBounds(287, 153, 91, 14);
        contentPane.add(lblNewLabel_1);

        JTextField textField_1 = new JTextField();
        textField_1.setBounds(379, 151, 167, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("EMAIL:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_2.setBounds(309, 178, 50, 18);
        contentPane.add(lblNewLabel_2);

        JTextField textField_2 = new JTextField();
        textField_2.setBounds(379, 178, 167, 20);
        contentPane.add(textField_2);

        JLabel lblNewLabel_3 = new JLabel("SEX:");
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_3.setBounds(329, 205, 33, 14);
        contentPane.add(lblNewLabel_3);

        textField_3 = new JTextField();
        textField_3.setBounds(379, 203, 167, 20);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("DATE_OF_BIRTH:");
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_4.setBounds(248, 232, 130, 14);
        contentPane.add(lblNewLabel_4);

        JTextField textField_4 = new JTextField();
        textField_4.setBounds(379, 230, 167, 20);
        contentPane.add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("PASSWORD:");
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_5.setBounds(277, 263, 101, 14);
        contentPane.add(lblNewLabel_5);

        passwordField = new JPasswordField(10);
        passwordField.setBounds(379, 261, 167, 20);
        contentPane.add(passwordField);

        JLabel lblNewLabel_9 = new JLabel("CONFIRM PASSWORD:");
        lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_9.setBounds(206, 294, 157, 14);
        contentPane.add(lblNewLabel_9);

        passwordField_1 = new JPasswordField(10);
        passwordField_1.setBounds(379, 292, 167, 20);
        contentPane.add(passwordField_1);

        JLabel lblNewLabel_6 = new JLabel("PHONE_NO:");
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblNewLabel_6.setBounds(287, 325, 78, 14);
        contentPane.add(lblNewLabel_6);

        JTextField textField_6 = new JTextField();
        textField_6.setBounds(379, 323, 167, 20);
        contentPane.add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("REGISTER");
        lblNewLabel_8.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 23));
        lblNewLabel_8.setBounds(353, 34, 276, 38);
        contentPane.add(lblNewLabel_8);

        JButton btnNewButton = new JButton("REGISTER");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] input1 = passwordField.getPassword();
                char[] input2 = passwordField_1.getPassword();
                boolean match = Arrays.equals(input1, input2);
                if(textField_1.getText().length()!=0 && textField_2.getText().length()!=0 && textField_3.getText().length()!=0 && textField_4.getText().length()!=0
                        && passwordField.getText().length()!=0 && passwordField_1.getText().length()!=0 && textField_6.getText().length()!=0) {
                    if (match) {
                        Select obj = new Select();
                        obj.setVisible(true);
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Passwords do not match!");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "Enter all Credentials!!");
                }

                connectDB obj_connectDB = new connectDB();
                Connection con = obj_connectDB.get_db();
                java.sql.Statement st = null;
                String query = "INSERT INTO register values('" + textField.getText() + "','" + textField_1.getText() + "','" + textField_2.getText() + "','" + textField_3.getText() + "','" + textField_4.getText()
                        + "','" + passwordField.getText() + "'," + textField_6.getText() + ")";
                try {
                    st = con.createStatement();
                    System.out.println(st.executeQuery(query));
                } catch (Exception i) {
                    System.out.println(i);
                }
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton.setBounds(339, 382, 133, 23);
        contentPane.add(btnNewButton);
    }
}

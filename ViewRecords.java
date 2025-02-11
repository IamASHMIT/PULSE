import java.awt.EventQueue;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class ViewRecords extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewRecords frame = new ViewRecords();
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
    public ViewRecords() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Ensure it opens maximized
        
        // Set main panel with light red background and central alignment properties
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 204, 204)); // Light red background
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        String[] columns = {"Donor_ID", "Name", "Age", "Sex", "Register_Date",
                            "Blood_Type", "Blood_Quantity", "Phone_Number", "State", "City"};

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        connectDB obj_connectDB = new connectDB();
        Connection con = obj_connectDB.get_db();
        java.sql.Statement st = null;
        String query = "SELECT * FROM Donor";
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Object[] row = {rs.getString(1), rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getString(5), rs.getString(6),
                                rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)};
                tableModel.addRow(row);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JTable table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.BOLD, 14)); // Black and bold text
        table.setForeground(Color.BLACK);
        table.setRowHeight(25);
        table.setBackground(new Color(255, 230, 230)); // Slightly lighter red for the table rows
        table.setGridColor(Color.LIGHT_GRAY);

        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(255, 153, 153)); // Header color: deeper red
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Arial", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(table);

        // Get screen dimensions to centralize the table
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width - 100;
        int height = screenSize.height - 150;

        scrollPane.setBounds((screenSize.width - width) / 2, 80, width, height - 100); // Centralize the table
        contentPane.add(scrollPane);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 100, 30);
        btnBack.setBackground(new Color(255, 153, 153));
        btnBack.setForeground(Color.BLACK);
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin obj = new Admin();
                obj.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnBack);
    }
}

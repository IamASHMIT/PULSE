import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Receiver extends JFrame {
    private JTable table;
    private JTextField bloodGroupField, cityField;
    private JButton searchButton, backButton;

    public Receiver() {
        setTitle("Blood Donor Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize window on startup
        
        // Set background color for the content pane to cover the whole window
        getContentPane().setBackground(new Color(255, 204, 204)); // Light red background
        setLayout(null);

        // Labels and text fields for searching
        JLabel bloodGroupLabel = new JLabel("Blood Group:");
        bloodGroupLabel.setBounds(20, 20, 100, 30);
        bloodGroupLabel.setForeground(Color.BLACK);
        bloodGroupLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(bloodGroupLabel);

        bloodGroupField = new JTextField();
        bloodGroupField.setBounds(130, 20, 150, 30);
        add(bloodGroupField);

        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(300, 20, 50, 30);
        cityLabel.setForeground(Color.BLACK);
        cityLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(cityLabel);

        cityField = new JTextField();
        cityField.setBounds(350, 20, 150, 30);
        add(cityField);

        // Search button
        searchButton = new JButton("SEARCH");
        searchButton.setBounds(520, 20, 120, 30);
        searchButton.setBackground(new Color(255, 153, 153)); // Light red button color
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));
        add(searchButton);

        // Back button
        backButton = new JButton("BACK");
        backButton.setBounds(660, 20, 120, 30);
        backButton.setBackground(new Color(255, 153, 153));
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        add(backButton);

        // Table setup
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"Donor_ID", "Name", "Age", "Sex", "Register_Date", "Blood_Type", "Blood_Quantity", "State", "City"}
        ));
        table.setRowHeight(30);
        table.setFont(new Font("Arial", Font.BOLD, 14)); // Set font to bold and black
        table.setForeground(Color.BLACK);
        table.setBackground(new Color(255, 230, 230)); // Slightly lighter red for rows

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(new Color(255, 153, 153));
        header.setForeground(Color.BLACK);

        JScrollPane scrollPane = new JScrollPane(table);

        // Center the table within the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width - 100;
        int height = screenSize.height - 150;
        scrollPane.setBounds((screenSize.width - width) / 2, 70, width, height - 100);

        add(scrollPane);

        // Load data on start
        loadData();

        // Action listeners
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchDonors();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Select selectPage = new Select();
                selectPage.setVisible(true);
                dispose();
            }
        });

        setVisible(true);
    }

    private void loadData() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Testdb", "postgres", "@Mdtasfin786")) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Donor");

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing data

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("Donor_ID"),
                    rs.getString("Name"),
                    rs.getInt("Age"),
                    rs.getString("Sex"),
                    rs.getDate("Register_Date"),
                    rs.getString("Blood_Type"),
                    rs.getInt("Blood_Quantity"),
                    rs.getString("STATE"),
                    rs.getString("CITY")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchDonors() {
        String bloodGroup = bloodGroupField.getText().trim();
        String city = cityField.getText().trim();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Testdb", "postgres", "@Mdtasfin786")) {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM Donor WHERE Blood_Type LIKE '%" + bloodGroup + "%' AND CITY LIKE '%" + city + "%'";
            ResultSet rs = stmt.executeQuery(query);

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Clear existing data

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("Donor_ID"),
                    rs.getString("Name"),
                    rs.getInt("Age"),
                    rs.getString("Sex"),
                    rs.getDate("Register_Date"),
                    rs.getString("Blood_Type"),
                    rs.getInt("Blood_Quantity"),
                    rs.getString("STATE"),
                    rs.getString("CITY")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching donors: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Receiver();
    }
}

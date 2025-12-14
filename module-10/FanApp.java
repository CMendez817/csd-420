//Cameron Mendez
//12/14/2025
//Module-10


import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FanApp extends JFrame {

    // GUI components
    private JTextField txtID, txtFirstName, txtLastName, txtFavoriteTeam;
    private JButton btnDisplay, btnUpdate;

    public FanApp() {
        setTitle("Fan Database Application");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Labels
        JLabel lblID = new JLabel("ID:");
        JLabel lblFirstName = new JLabel("First Name:");
        JLabel lblLastName = new JLabel("Last Name:");
        JLabel lblFavoriteTeam = new JLabel("Favorite Team:");

        lblID.setBounds(20, 20, 100, 25);
        lblFirstName.setBounds(20, 50, 100, 25);
        lblLastName.setBounds(20, 80, 100, 25);
        lblFavoriteTeam.setBounds(20, 110, 100, 25);

        add(lblID);
        add(lblFirstName);
        add(lblLastName);
        add(lblFavoriteTeam);

        // Text Fields
        txtID = new JTextField();
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtFavoriteTeam = new JTextField();

        txtID.setBounds(130, 20, 200, 25);
        txtFirstName.setBounds(130, 50, 200, 25);
        txtLastName.setBounds(130, 80, 200, 25);
        txtFavoriteTeam.setBounds(130, 110, 200, 25);

        add(txtID);
        add(txtFirstName);
        add(txtLastName);
        add(txtFavoriteTeam);

        // Buttons
        btnDisplay = new JButton("Display");
        btnUpdate = new JButton("Update");

        btnDisplay.setBounds(50, 150, 100, 30);
        btnUpdate.setBounds(200, 150, 100, 30);

        add(btnDisplay);
        add(btnUpdate);

        // Button actions
        btnDisplay.addActionListener(e -> displayFan());
        btnUpdate.addActionListener(e -> updateFan());
    }

    private void displayFan() {
        int id;
        try {
            id = Integer.parseInt(txtID.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid ID.");
            return;
        }

        String query = "SELECT firstname, lastname, favoriteteam FROM fans WHERE ID = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                txtFirstName.setText(rs.getString("firstname"));
                txtLastName.setText(rs.getString("lastname"));
                txtFavoriteTeam.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "No fan found with ID " + id);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    private void updateFan() {
        int id;
        try {
            id = Integer.parseInt(txtID.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid ID.");
            return;
        }

        String query = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, txtFirstName.getText());
            stmt.setString(2, txtLastName.getText());
            stmt.setString(3, txtFavoriteTeam.getText());
            stmt.setInt(4, id);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Fan updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "No fan found with ID " + id);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FanApp().setVisible(true);
        });
    }
}

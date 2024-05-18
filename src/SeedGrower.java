import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SeedGrower extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public SeedGrower() {
        // Set up the frame
        setTitle("Multi-Page Form");
        getContentPane().setBackground(new Color(255,255,255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Initialize CardLayout and main panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create pages
        Page1 page1 = new Page1();
        Page2 page2 = new Page2(page1);

        mainPanel.add(page1, "Page 1");
        mainPanel.add(page2, "Page 2");

        // Add main panel to frame
        add(mainPanel);

        // Initialize database
//        initializeDatabase();

        // Set frame to full screen but with window decorations
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame
        setVisible(true);
    }

//    private void initializeDatabase() {
//        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:formdata.db");
//             Statement stmt = conn.createStatement()) {
//            String sql = "CREATE TABLE IF NOT EXISTS formdata (\n"
//                    + " id integer PRIMARY KEY AUTOINCREMENT,\n"
//                    + " page1_input text NOT NULL,\n"
//                    + " page2_input text NOT NULL\n"
//                    + ");";
//            stmt.execute(sql);
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(this, "Error initializing database: " + e.getMessage());
//        }
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SeedGrower::new);
    }
}


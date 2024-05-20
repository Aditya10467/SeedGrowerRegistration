import javax.swing.*;
import java.awt.*;

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

        // Set frame to full screen but with window decorations
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SeedGrower::new);
    }
}

import javax.swing.*;
import java.awt.*;

public class TitleBarPanel extends JPanel {
    private JLabel titleLabel;

    public TitleBarPanel(String title) {
        // Set background color
        setBackground(new Color(139, 69, 19));  // Brown color

        // Create and customize the title label
        titleLabel = new JLabel(title);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));  // Customize font and size
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text horizontally

        // Set layout manager to BorderLayout to center the label
        setLayout(new BorderLayout());

        // Add the title label to the panel and center it
        add(titleLabel, BorderLayout.CENTER);
    }

    // Method to update the title text
    public void setTitle(String title) {
        titleLabel.setText(title);
    }

    // Override getPreferredSize to ensure consistent size
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(super.getPreferredSize().width, 50); // Height 50, width adjusts to contents
    }
}

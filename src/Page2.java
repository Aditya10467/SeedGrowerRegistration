import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Page2 extends JPanel {
    private JTextField textField2;
    private TitleBarPanel titleBar;
    private Page1 page1;

    public Page2(Page1 page1) {
        this.page1 = page1;
        setLayout(null);

        // Create and add the custom title bar
        titleBar = new TitleBarPanel("Page 2 Title");
        titleBar.setBounds(0, 0, getWidth(), 50);
        add(titleBar);

        JLabel label = new JLabel("Page 2");
        label.setBounds(150, 60, 100, 30); // Adjusting position due to title bar
        add(label);

        textField2 = new JTextField();
        textField2.setBounds(150, 100, 200, 30); // Adjusting position due to title bar
        add(textField2);

        JButton previousButton = new JButton("Previous");
        previousButton.setBounds(50, 150, 100, 30); // Adjusting position due to title bar
        previousButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "Page 1");
        });
        add(previousButton);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(250, 150, 100, 30); // Adjusting position due to title bar
        add(saveButton);

        // Add a resize listener to adjust the title bar width
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                titleBar.setBounds(0, 0, getWidth(), 50);
            }
        });
    }


}

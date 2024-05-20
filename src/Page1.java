import javax.swing.*;
import java.awt.*;

public class Page1 extends JPanel {
    private JTextField nameField, pinField, emailField, mobileField, alternateMobileField;
    private JTextField fatherField;
    private JTextField houseField;
    private JComboBox<String> relationField, districtField, blockField, mouzaField, identificationField;
    private TitleBarPanel titleBar;

    public Page1() {
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        setBackground(new Color(255, 255, 255));

        // Create and add the custom title bar
        titleBar = new TitleBarPanel("Basic Profile of Seed Grower (Seed Grower)");
        add(titleBar);
        layout.putConstraint(SpringLayout.NORTH, titleBar, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleBar, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleBar, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, titleBar, 50, SpringLayout.NORTH, this);

        // Add more spacing between the title bar and the first row of components
        int verticalSpacing = 20; // Increase the vertical spacing to 20 pixels
        int leftMargin = 100; // Additional left margin to center the form

        // Name
        JLabel nameLabel = new JLabel("Name");
        add(nameLabel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, verticalSpacing, SpringLayout.SOUTH, titleBar);
        layout.putConstraint(SpringLayout.WEST, nameLabel, leftMargin, SpringLayout.WEST, this);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 30));
        add(nameField);
        layout.putConstraint(SpringLayout.NORTH, nameField, 5, SpringLayout.SOUTH, nameLabel);
        layout.putConstraint(SpringLayout.WEST, nameField, leftMargin, SpringLayout.WEST, this);

        // Father/Husband/Organisation
        JLabel fatherLabel = new JLabel("Father/Husband/Organisation");
        add(fatherLabel);
        layout.putConstraint(SpringLayout.NORTH, fatherLabel, 0, SpringLayout.NORTH, nameLabel);
        layout.putConstraint(SpringLayout.WEST, fatherLabel, 250 + leftMargin, SpringLayout.WEST, this);

        fatherField = new JTextField();
        fatherField.setPreferredSize(new Dimension(200, 30));
        add(fatherField);
        layout.putConstraint(SpringLayout.NORTH, fatherField, 5, SpringLayout.SOUTH, fatherLabel);
        layout.putConstraint(SpringLayout.WEST, fatherField, 250 + leftMargin, SpringLayout.WEST, this);

        // Relation
        JLabel relationLabel = new JLabel("Relation");
        add(relationLabel);
        layout.putConstraint(SpringLayout.NORTH, relationLabel, 0, SpringLayout.NORTH, nameLabel);
        layout.putConstraint(SpringLayout.WEST, relationLabel, 500 + leftMargin, SpringLayout.WEST, this);

        relationField = new JComboBox<>();
        relationField.setPreferredSize(new Dimension(200, 30));
        add(relationField);
        layout.putConstraint(SpringLayout.NORTH, relationField, 5, SpringLayout.SOUTH, relationLabel);
        layout.putConstraint(SpringLayout.WEST, relationField, 500 + leftMargin, SpringLayout.WEST, this);

        // House No/LandMark
        JLabel houseLabel = new JLabel("House No/LandMark");
        add(houseLabel);
        layout.putConstraint(SpringLayout.NORTH, houseLabel, 0, SpringLayout.NORTH, nameLabel);
        layout.putConstraint(SpringLayout.WEST, houseLabel, 750 + leftMargin, SpringLayout.WEST, this);

        houseField = new JTextField();
        houseField.setPreferredSize(new Dimension(200, 30));
        add(houseField);
        layout.putConstraint(SpringLayout.NORTH, houseField, 5, SpringLayout.SOUTH, houseLabel);
        layout.putConstraint(SpringLayout.WEST, houseField, 750 + leftMargin, SpringLayout.WEST, this);

        // District
        JLabel districtLabel = new JLabel("District");
        add(districtLabel);
        layout.putConstraint(SpringLayout.NORTH, districtLabel, 40, SpringLayout.SOUTH, nameField);
        layout.putConstraint(SpringLayout.WEST, districtLabel, leftMargin, SpringLayout.WEST, this);

        districtField = new JComboBox<>();
        districtField.setPreferredSize(new Dimension(200, 30));
        add(districtField);
        layout.putConstraint(SpringLayout.NORTH, districtField, 5, SpringLayout.SOUTH, districtLabel);
        layout.putConstraint(SpringLayout.WEST, districtField, leftMargin, SpringLayout.WEST, this);

        // Block
        JLabel blockLabel = new JLabel("Block");
        add(blockLabel);
        layout.putConstraint(SpringLayout.NORTH, blockLabel, 0, SpringLayout.NORTH, districtLabel);
        layout.putConstraint(SpringLayout.WEST, blockLabel, 250 + leftMargin, SpringLayout.WEST, this);

        blockField = new JComboBox<>();
        blockField.setPreferredSize(new Dimension(200, 30));
        add(blockField);
        layout.putConstraint(SpringLayout.NORTH, blockField, 5, SpringLayout.SOUTH, blockLabel);
        layout.putConstraint(SpringLayout.WEST, blockField, 250 + leftMargin, SpringLayout.WEST, this);

        // Mouza
        JLabel mouzaLabel = new JLabel("Mouza");
        add(mouzaLabel);
        layout.putConstraint(SpringLayout.NORTH, mouzaLabel, 0, SpringLayout.NORTH, districtLabel);
        layout.putConstraint(SpringLayout.WEST, mouzaLabel, 500 + leftMargin, SpringLayout.WEST, this);

        mouzaField = new JComboBox<>();
        mouzaField.setPreferredSize(new Dimension(200, 30));
        add(mouzaField);
        layout.putConstraint(SpringLayout.NORTH, mouzaField, 5, SpringLayout.SOUTH, mouzaLabel);
        layout.putConstraint(SpringLayout.WEST, mouzaField, 500 + leftMargin, SpringLayout.WEST, this);

        // Pin Code
        JLabel pinLabel = new JLabel("Pin Code (Optional)");
        add(pinLabel);
        layout.putConstraint(SpringLayout.NORTH, pinLabel, 40, SpringLayout.SOUTH, districtField);
        layout.putConstraint(SpringLayout.WEST, pinLabel, leftMargin, SpringLayout.WEST, this);

        pinField = new JTextField();
        pinField.setPreferredSize(new Dimension(450, 30));
        add(pinField);
        layout.putConstraint(SpringLayout.NORTH, pinField, 5, SpringLayout.SOUTH, pinLabel);
        layout.putConstraint(SpringLayout.WEST, pinField, leftMargin, SpringLayout.WEST, this);

        // Email
        JLabel emailLabel = new JLabel("Email Id (Optional)");
        add(emailLabel);
        layout.putConstraint(SpringLayout.NORTH, emailLabel, 0, SpringLayout.NORTH, pinLabel);
        layout.putConstraint(SpringLayout.WEST, emailLabel, 500 + leftMargin, SpringLayout.WEST, this);

        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(450, 30));
        add(emailField);
        layout.putConstraint(SpringLayout.NORTH, emailField, 5, SpringLayout.SOUTH, emailLabel);
        layout.putConstraint(SpringLayout.WEST, emailField, 500 + leftMargin, SpringLayout.WEST, this);

        // Mobile
        JLabel mobileLabel = new JLabel("Mobile No.");
        add(mobileLabel);
        layout.putConstraint(SpringLayout.NORTH, mobileLabel, 40, SpringLayout.SOUTH, pinField);
        layout.putConstraint(SpringLayout.WEST, mobileLabel, leftMargin, SpringLayout.WEST, this);

        mobileField = new JTextField();
        mobileField.setPreferredSize(new Dimension(450, 30));
        add(mobileField);
        layout.putConstraint(SpringLayout.NORTH, mobileField, 5, SpringLayout.SOUTH, mobileLabel);
        layout.putConstraint(SpringLayout.WEST, mobileField, leftMargin, SpringLayout.WEST, this);

        // Alternate Mobile
        JLabel alternateMobileLabel = new JLabel("Alternate Mobile No. (Optional)");
        add(alternateMobileLabel);
        layout.putConstraint(SpringLayout.NORTH, alternateMobileLabel, 0, SpringLayout.NORTH, mobileLabel);
        layout.putConstraint(SpringLayout.WEST, alternateMobileLabel, 500 + leftMargin, SpringLayout.WEST, this);

        alternateMobileField = new JTextField();
        alternateMobileField.setPreferredSize(new Dimension(450, 30));
        add(alternateMobileField);
        layout.putConstraint(SpringLayout.NORTH, alternateMobileField, 5, SpringLayout.SOUTH, alternateMobileLabel);
        layout.putConstraint(SpringLayout.WEST, alternateMobileField, 500 + leftMargin, SpringLayout.WEST, this);

        // Identification
        JLabel identificationLabel = new JLabel("Identification Type");
        add(identificationLabel);
        layout.putConstraint(SpringLayout.NORTH, identificationLabel, 40, SpringLayout.SOUTH, mobileField);
        layout.putConstraint(SpringLayout.WEST, identificationLabel, leftMargin, SpringLayout.WEST, this);

        identificationField = new JComboBox<>();
        identificationField.setPreferredSize(new Dimension(450, 30));
        add(identificationField);
        layout.putConstraint(SpringLayout.NORTH, identificationField, 5, SpringLayout.SOUTH, identificationLabel);
        layout.putConstraint(SpringLayout.WEST, identificationField, leftMargin, SpringLayout.WEST, this);

        // Next Button
        JButton nextButton = new JButton("Next");
        nextButton.setPreferredSize(new Dimension(100, 30));
        nextButton.setBackground(new Color(243, 142, 57));
        nextButton.setForeground(new Color(253, 253, 253));
        nextButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "Page 2");
        });
        add(nextButton);
        layout.putConstraint(SpringLayout.NORTH, nextButton, 20, SpringLayout.SOUTH, identificationField);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, nextButton, 0, SpringLayout.HORIZONTAL_CENTER, this);

        // Add a resize listener to adjust the title bar width
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                titleBar.setBounds(0, 0, getWidth(), 50);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw thicker orange border
        g.setColor(new Color(243, 142, 57)); // Orange color
        int thickness = 5; // Thickness of the border
        int width = getWidth();
        int height = getHeight();
        // Draw top border
        g.fillRect(0, 0, width, thickness);
        // Draw bottom border
        g.fillRect(0, height - thickness, width, thickness);
        // Draw left border
        g.fillRect(0, 0, thickness, height);
        // Draw right border
        g.fillRect(width - thickness, 0, thickness, height);
    }

    public String getTextField1Value() {
        return nameField.getText();
    }
}
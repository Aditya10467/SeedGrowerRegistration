import javax.swing.*;
import java.awt.*;

public class Page1 extends JPanel {
    private JTextField nameField,pinField,emailField,mobileField,alternateMobileField;
    private JTextField fatherField;
    private JTextField houseField;
    private JComboBox relationField,districtField,blockField,mouzaField,identificationField;
    private TitleBarPanel titleBar;

    public Page1() {
        setLayout(null);
        setBackground(new Color(255, 255, 255));

        // Create and add the custom title bar
        titleBar = new TitleBarPanel("Basic Profile of Seed Grower (Seed Grower)");
        titleBar.setBounds(0, 0, getWidth(), 50);
        add(titleBar);

        //Name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(150, 80, 100, 30); // Adjusting position due to title bar
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 110, 200, 30); // Adjusting position due to title bar
        add(nameField);

        //Father/Husband/Organisation
        JLabel fatherLabel = new JLabel("Father/Husband/Organisation");
        fatherLabel.setBounds(400, 80, 200, 30); // Adjusting position due to title bar
        add(fatherLabel);

        fatherField = new JTextField();
        fatherField.setBounds(400, 110, 200, 30); // Adjusting position due to title bar
        add(fatherField);

        //Relation
        JLabel relationLabel = new JLabel("Relation");
        relationLabel.setBounds(650, 80, 200, 30); // Adjusting position due to title bar
        add(relationLabel);

        relationField = new JComboBox<>();
        relationField.setBounds(650, 110, 200, 30);
        relationField.setBackground(new Color(255, 255, 255));// Adjusting position due to title bar
        add(relationField);

        //House No/LandMark
        JLabel houseLabel = new JLabel("House No/LandMark");
        houseLabel.setBounds(900, 80, 200, 30); // Adjusting position due to title bar
        add(houseLabel);

        houseField = new JTextField();
        houseField.setBounds(900, 110, 200, 30); // Adjusting position due to title bar
        add(houseField);


        //District
        JLabel districtLabel = new JLabel("District");
        districtLabel.setBounds(150, 170, 100, 30); // Adjusting position due to title bar
        add(districtLabel);

        districtField = new JComboBox<>();
        districtField.setBounds(150, 200, 200, 30);
        districtField.setBackground(new Color(255, 255, 255));// Adjusting position due to title bar
        add(districtField);

        //Block
        JLabel blockLabel = new JLabel("Block");
        blockLabel.setBounds(400, 170, 200, 30); // Adjusting position due to title bar
        add(blockLabel);

        blockField = new JComboBox<>();
        blockField.setBounds(400, 200, 200, 30);
        blockField.setBackground(new Color(255, 255, 255));// Adjusting position due to title bar
        add(blockField);

        //Mouza
        JLabel mouzaLabel = new JLabel("Mouza");
        mouzaLabel.setBounds(650, 170, 200, 30); // Adjusting position due to title bar
        add(mouzaLabel);

        mouzaField = new JComboBox<>();
        mouzaField.setBounds(650, 200, 200, 30);
        mouzaField.setBackground(new Color(255, 255, 255));// Adjusting position due to title bar
        add(mouzaField);

        //Pin Code
        JLabel pinLabel = new JLabel("Pin Code (Optional)");
        pinLabel.setBounds(150, 270, 200, 30); // Adjusting position due to title bar
        add(pinLabel);

        pinField = new JTextField();
        pinField.setBounds(150, 300, 450, 30); // Adjusting position due to title bar
        add(pinField);

        //Email
        JLabel emailLabel = new JLabel("Email Id (Optional)");
        emailLabel.setBounds(650, 270, 200, 30); // Adjusting position due to title bar
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(650, 300, 450, 30); // Adjusting position due to title bar
        add(emailField);


        //Mobile
        JLabel mobileLabel = new JLabel("Mobile No.");
        mobileLabel.setBounds(150, 370, 200, 30); // Adjusting position due to title bar
        add(mobileLabel);

        mobileField = new JTextField();
        mobileField.setBounds(150, 400, 450, 30); // Adjusting position due to title bar
        add(mobileField);

        //Alternate Mobile
        JLabel alternateMobileLabel = new JLabel("Alternate Mobile No. (Optional)");
        alternateMobileLabel.setBounds(650, 370, 200, 30); // Adjusting position due to title bar
        add(alternateMobileLabel);

        alternateMobileField = new JTextField();
        alternateMobileField.setBounds(650, 400, 450, 30); // Adjusting position due to title bar
        add(alternateMobileField);

        //Identification
        JLabel identificationLabel = new JLabel("Identification Type");
        identificationLabel.setBounds(150, 470, 200, 30); // Adjusting position due to title bar
        add(identificationLabel);

        identificationField = new JComboBox<>();
        identificationField.setBounds(150, 500, 450, 30);
        identificationField.setBackground(new Color(255, 255, 255));// Adjusting position due to title bar
        add(identificationField);




        JButton nextButton = new JButton("Next");
        nextButton.setBounds(600, 570, 100, 30);
        nextButton.setBackground(new Color(243, 142, 57));
        nextButton.setForeground(new Color(253, 253, 253));
        nextButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "Page 2");
        });
        add(nextButton);

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


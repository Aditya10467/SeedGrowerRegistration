import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Page1 extends JPanel {
    static JTextField nameField, pinField, emailField, mobileField, alternateMobileField;
    static JTextField fatherField;
    static JTextField houseField;
    static JComboBox<String> relationField, districtField, blockField, mouzaField, identificationField;
    private TitleBarPanel titleBar;

    public Page1() {
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        setBackground(new Color(250, 231, 209));

        // Create and add the custom title bar
        titleBar = new TitleBarPanel("Basic Profile of Seed Grower (Seed Grower)");
        add(titleBar);


        layout.putConstraint(SpringLayout.NORTH, titleBar, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleBar, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleBar, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, titleBar, 50, SpringLayout.NORTH, this);

        // Add more spacing between the title bar and the first row of components
        int verticalSpacing = 20; // Increase the vertical spacing to 20 pixels
        int leftMargin = 180; // Additional left margin to center the form

        LoadDetails l=new LoadDetails();
        l.connectToDatabase();

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
        relationField.addItem("Father");
        relationField.addItem("Husband");
        relationField.addItem("Organisation");
        relationField.setPreferredSize(new Dimension(200, 30));
        relationField.setBackground(new Color(255,255,255));
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
        districtField.setBackground(new Color(255,255,255));
        districtField.setPreferredSize(new Dimension(200, 30));
        l.populateDistrictField();
        districtField.setSelectedItem(null);
        add(districtField);
        layout.putConstraint(SpringLayout.NORTH, districtField, 5, SpringLayout.SOUTH, districtLabel);
        layout.putConstraint(SpringLayout.WEST, districtField, leftMargin, SpringLayout.WEST, this);

        districtField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDistrict=(String)districtField.getSelectedItem();
                if(selectedDistrict!=null){
                    l.populateBlockField(selectedDistrict);
                }
            }
        });

        // Block
        JLabel blockLabel = new JLabel("Block");
        add(blockLabel);
        layout.putConstraint(SpringLayout.NORTH, blockLabel, 0, SpringLayout.NORTH, districtLabel);
        layout.putConstraint(SpringLayout.WEST, blockLabel, 250 + leftMargin, SpringLayout.WEST, this);

        blockField = new JComboBox<>();
        blockField.setBackground(new Color(255,255,255));
        blockField.setPreferredSize(new Dimension(200, 30));
        blockField.setSelectedItem(null);
        add(blockField);
        layout.putConstraint(SpringLayout.NORTH, blockField, 5, SpringLayout.SOUTH, blockLabel);
        layout.putConstraint(SpringLayout.WEST, blockField, 250 + leftMargin, SpringLayout.WEST, this);

        blockField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedBlock=(String) blockField.getSelectedItem();
                    l.populateMouzaField(selectedBlock);

            }
        });

        // Mouza
        JLabel mouzaLabel = new JLabel("Mouza");
        add(mouzaLabel);
        layout.putConstraint(SpringLayout.NORTH, mouzaLabel, 0, SpringLayout.NORTH, districtLabel);
        layout.putConstraint(SpringLayout.WEST, mouzaLabel, 500 + leftMargin, SpringLayout.WEST, this);

        mouzaField = new JComboBox<>();
        mouzaField.setBackground(new Color(255,255,255));
        mouzaField.setPreferredSize(new Dimension(200, 30));
        mouzaField.setSelectedItem(null);
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
        identificationField.addItem("Aadhar Card");
        identificationField.addItem("PAN Card");
        identificationField.setBackground(new Color(255, 255, 255));
        identificationField.setPreferredSize(new Dimension(450, 30));
        identificationField.setSelectedItem(null);
        add(identificationField);
        layout.putConstraint(SpringLayout.NORTH, identificationField, 5, SpringLayout.SOUTH, identificationLabel);
        layout.putConstraint(SpringLayout.WEST, identificationField, leftMargin, SpringLayout.WEST, this);

        // Create the additional label, text field, and validation message label
        JLabel additionalInfoLabel = new JLabel();
        layout.putConstraint(SpringLayout.NORTH, additionalInfoLabel, 0, SpringLayout.NORTH, identificationLabel);
        layout.putConstraint(SpringLayout.WEST, additionalInfoLabel, 500 + leftMargin, SpringLayout.WEST, this);
        add(additionalInfoLabel);

        JTextField additionalInfoField = new JTextField();
        additionalInfoField.setPreferredSize(new Dimension(450, 30));
        layout.putConstraint(SpringLayout.NORTH, additionalInfoField, 5, SpringLayout.SOUTH, additionalInfoLabel);
        layout.putConstraint(SpringLayout.WEST, additionalInfoField, 500 + leftMargin, SpringLayout.WEST, this);
        add(additionalInfoField);

        JLabel validationMessageLabel = new JLabel();
        validationMessageLabel.setForeground(Color.RED);
        layout.putConstraint(SpringLayout.NORTH, validationMessageLabel, 5, SpringLayout.SOUTH, additionalInfoField);
        layout.putConstraint(SpringLayout.WEST, validationMessageLabel, 500+leftMargin, SpringLayout.WEST, this);
        add(validationMessageLabel);

        // Initially, hide the label, text field, and validation message label
        additionalInfoLabel.setVisible(false);
        additionalInfoField.setVisible(false);
        validationMessageLabel.setVisible(false);

        // Add ActionListener to the combo box
        identificationField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) identificationField.getSelectedItem();
                if ("Aadhar Card".equals(selectedItem) || "PAN Card".equals(selectedItem)) {
                    additionalInfoLabel.setText(selectedItem + " Number");
                    additionalInfoLabel.setVisible(true);
                    additionalInfoField.setVisible(true);
                    additionalInfoField.setText("");
                    validationMessageLabel.setVisible(false);

                    // Apply the document filter if Aadhar Card is selected
                    if ("Aadhar Card".equals(selectedItem)) {
                        ((AbstractDocument) additionalInfoField.getDocument()).setDocumentFilter(new AadharCardDocumentFilter());
                    } else {
                        ((AbstractDocument) additionalInfoField.getDocument()).setDocumentFilter(null);
                    }
                } else {
                    additionalInfoLabel.setVisible(false);
                    additionalInfoField.setVisible(false);
                    validationMessageLabel.setVisible(false);
                }
            }
        });

        // Add ActionListener to the additional text field for validation
        additionalInfoField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) identificationField.getSelectedItem();
                String input = additionalInfoField.getText();
                if ("PAN Card".equals(selectedItem)) {
                    String panRegex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
                    Pattern pattern = Pattern.compile(panRegex);
                    Matcher matcher = pattern.matcher(input);

                    if (matcher.matches()) {
                        validationMessageLabel.setText("Valid PAN Card Number");
                        validationMessageLabel.setForeground(Color.GREEN);
                    } else {
                        validationMessageLabel.setText("Invalid PAN Card Number");
                        validationMessageLabel.setForeground(Color.RED);
                    }
                    validationMessageLabel.setVisible(true);
                } else if ("Aadhar Card".equals(selectedItem)) {
                    String aadharRegex = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
                    Pattern pattern = Pattern.compile(aadharRegex);
                    Matcher matcher = pattern.matcher(input);

                    if (matcher.matches()) {
                        validationMessageLabel.setText("Valid Aadhar Card Number");
                        validationMessageLabel.setForeground(Color.GREEN);
                    } else {
                        validationMessageLabel.setText("Invalid Aadhar Card Number");
                        validationMessageLabel.setForeground(Color.RED);
                    }
                    validationMessageLabel.setVisible(true);
                } else {
                    validationMessageLabel.setVisible(false);
                }
            }
        });






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
        layout.putConstraint(SpringLayout.NORTH, nextButton, 40, SpringLayout.SOUTH, identificationField);
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
class AadharCardDocumentFilter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) return;
        replace(fb, offset, 0, string, attr);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) return;

        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.replace(offset, offset + length, text);

        String textWithSpaces = formatAadharNumber(sb.toString());
        fb.replace(0, fb.getDocument().getLength(), textWithSpaces, attrs);
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.delete(offset, offset + length);

        String textWithSpaces = formatAadharNumber(sb.toString());
        fb.replace(0, fb.getDocument().getLength(), textWithSpaces, null);
    }

    private String formatAadharNumber(String input) {
        input = input.replaceAll("\\s", ""); // Remove all existing spaces
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i > 0 && (i % 4 == 0) && i < 12) {
                sb.append(' ');
            }
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
}
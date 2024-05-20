import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class Page2 extends JPanel {
    private Page1 page1;

    public Page2(Page1 page1) {
        this.page1 = page1;
        SpringLayout layout = new SpringLayout();
        setLayout(layout);

        // Create and add the custom title bar
        TitleBarPanel titleBar = new TitleBarPanel("Crop Registration Details of the Seed Grower");
        add(titleBar);
        layout.putConstraint(SpringLayout.NORTH, titleBar, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleBar, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleBar, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, titleBar, 50, SpringLayout.NORTH, this);

        int verticalSpacing = 20; // Vertical spacing between components
        int horizontalSpacing = 30; // Horizontal spacing between components
        int topMargin = 60; // Top margin after title bar
        int leftMargin = 100; // Left margin to center the form

        // Row 1
        JLabel sourceOfSeedsLabel = new JLabel("Source Of Seeds:");
        add(sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.NORTH, sourceOfSeedsLabel, topMargin, SpringLayout.SOUTH, titleBar);
        layout.putConstraint(SpringLayout.WEST, sourceOfSeedsLabel, leftMargin, SpringLayout.WEST, this);

        JTextField sourceOfSeedsField = new JTextField(10);
        add(sourceOfSeedsField);
        layout.putConstraint(SpringLayout.NORTH, sourceOfSeedsField, 5, SpringLayout.SOUTH, sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.WEST, sourceOfSeedsField, leftMargin, SpringLayout.WEST, this);

        JLabel roUnitOfficeLabel = new JLabel("RO / Unit Office:");
        add(roUnitOfficeLabel);
        layout.putConstraint(SpringLayout.NORTH, roUnitOfficeLabel, 0, SpringLayout.NORTH, sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.WEST, roUnitOfficeLabel, 250 + leftMargin, SpringLayout.WEST, this);

        JComboBox<String> roUnitOfficeComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        add(roUnitOfficeComboBox);
        layout.putConstraint(SpringLayout.NORTH, roUnitOfficeComboBox, 5, SpringLayout.SOUTH, roUnitOfficeLabel);
        layout.putConstraint(SpringLayout.WEST, roUnitOfficeComboBox, 250 + leftMargin, SpringLayout.WEST, this);

        JLabel monthOfSowingLabel = new JLabel("Month of Sowing:");
        add(monthOfSowingLabel);
        layout.putConstraint(SpringLayout.NORTH, monthOfSowingLabel, 0, SpringLayout.NORTH, sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.WEST, monthOfSowingLabel, 500 + leftMargin, SpringLayout.WEST, this);

        JComboBox<String> monthOfSowingComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        add(monthOfSowingComboBox);
        layout.putConstraint(SpringLayout.NORTH, monthOfSowingComboBox, 5, SpringLayout.SOUTH, monthOfSowingLabel);
        layout.putConstraint(SpringLayout.WEST, monthOfSowingComboBox, 500 + leftMargin, SpringLayout.WEST, this);

        JLabel weekOfSowingLabel = new JLabel("Week of Sowing:");
        add(weekOfSowingLabel);
        layout.putConstraint(SpringLayout.NORTH, weekOfSowingLabel, 0, SpringLayout.NORTH, sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.WEST, weekOfSowingLabel, 750 + leftMargin, SpringLayout.WEST, this);

        JComboBox<String> weekOfSowingComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        add(weekOfSowingComboBox);
        layout.putConstraint(SpringLayout.NORTH, weekOfSowingComboBox, 5, SpringLayout.SOUTH, weekOfSowingLabel);
        layout.putConstraint(SpringLayout.WEST, weekOfSowingComboBox, 750 + leftMargin, SpringLayout.WEST, this);

        // Row 2
        JLabel cropLabel = new JLabel("Crop:");
        add(cropLabel);
        layout.putConstraint(SpringLayout.NORTH, cropLabel, verticalSpacing, SpringLayout.SOUTH, sourceOfSeedsField);
        layout.putConstraint(SpringLayout.WEST, cropLabel, leftMargin, SpringLayout.WEST, this);

        JComboBox<String> cropComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        add(cropComboBox);
        layout.putConstraint(SpringLayout.NORTH, cropComboBox, 5, SpringLayout.SOUTH, cropLabel);
        layout.putConstraint(SpringLayout.WEST, cropComboBox, leftMargin, SpringLayout.WEST, this);

        JLabel varietyLabel = new JLabel("Variety:");
        add(varietyLabel);
        layout.putConstraint(SpringLayout.NORTH, varietyLabel, 0, SpringLayout.NORTH, cropLabel);
        layout.putConstraint(SpringLayout.WEST, varietyLabel, 250 + leftMargin, SpringLayout.WEST, this);

        JComboBox<String> varietyComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        add(varietyComboBox);
        layout.putConstraint(SpringLayout.NORTH, varietyComboBox, 5, SpringLayout.SOUTH, varietyLabel);
        layout.putConstraint(SpringLayout.WEST, varietyComboBox, 250 + leftMargin, SpringLayout.WEST, this);

        JLabel sourceClassLabel = new JLabel("Source Class:");
        add(sourceClassLabel);
        layout.putConstraint(SpringLayout.NORTH, sourceClassLabel, 0, SpringLayout.NORTH, cropLabel);
        layout.putConstraint(SpringLayout.WEST, sourceClassLabel, 500 + leftMargin, SpringLayout.WEST, this);

        JComboBox<String> sourceClassComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        add(sourceClassComboBox);
        layout.putConstraint(SpringLayout.NORTH, sourceClassComboBox, 5, SpringLayout.SOUTH, sourceClassLabel);
        layout.putConstraint(SpringLayout.WEST, sourceClassComboBox, 500 + leftMargin, SpringLayout.WEST, this);

        JLabel classToBeProducedLabel = new JLabel("Class to be produced:");
        add(classToBeProducedLabel);
        layout.putConstraint(SpringLayout.NORTH, classToBeProducedLabel, 0, SpringLayout.NORTH, cropLabel);
        layout.putConstraint(SpringLayout.WEST, classToBeProducedLabel, 750 + leftMargin, SpringLayout.WEST, this);

        JComboBox<String> classToBeProducedComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        add(classToBeProducedComboBox);
        layout.putConstraint(SpringLayout.NORTH, classToBeProducedComboBox, 5, SpringLayout.SOUTH, classToBeProducedLabel);
        layout.putConstraint(SpringLayout.WEST, classToBeProducedComboBox, 750 + leftMargin, SpringLayout.WEST, this);

        // Row 3
        JLabel plotNoLabel = new JLabel("Plot No:");
        add(plotNoLabel);
        layout.putConstraint(SpringLayout.NORTH, plotNoLabel, verticalSpacing, SpringLayout.SOUTH, cropComboBox);
        layout.putConstraint(SpringLayout.WEST, plotNoLabel, leftMargin, SpringLayout.WEST, this);

        JTextField plotNoField = new JTextField(10);
        add(plotNoField);
        layout.putConstraint(SpringLayout.NORTH, plotNoField, 5, SpringLayout.SOUTH, plotNoLabel);
        layout.putConstraint(SpringLayout.WEST, plotNoField, leftMargin, SpringLayout.WEST, this);

        JLabel districtLabel = new JLabel("District:");
        add(districtLabel);
        layout.putConstraint(SpringLayout.NORTH, districtLabel, 0, SpringLayout.NORTH, plotNoLabel);
        layout.putConstraint(SpringLayout.WEST, districtLabel, 250 + leftMargin, SpringLayout.WEST, this);

        JComboBox<String> districtComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        add(districtComboBox);
        layout.putConstraint(SpringLayout.NORTH, districtComboBox, 5, SpringLayout.SOUTH, districtLabel);
        layout.putConstraint(SpringLayout.WEST, districtComboBox, 250 + leftMargin, SpringLayout.WEST, this);

        JLabel blockLabel = new JLabel("Block:");
        add(blockLabel);
        layout.putConstraint(SpringLayout.NORTH, blockLabel, 0, SpringLayout.NORTH, plotNoLabel);
        layout.putConstraint(SpringLayout.WEST, blockLabel, 500 + leftMargin, SpringLayout.WEST, this);

        JComboBox<String> blockComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        add(blockComboBox);
        layout.putConstraint(SpringLayout.NORTH, blockComboBox, 5, SpringLayout.SOUTH, blockLabel);
        layout.putConstraint(SpringLayout.WEST, blockComboBox, 500 + leftMargin, SpringLayout.WEST, this);

        JLabel mouzaLabel = new JLabel("Mouza:");
        add(mouzaLabel);
        layout.putConstraint(SpringLayout.NORTH, mouzaLabel, 0, SpringLayout.NORTH, plotNoLabel);
        layout.putConstraint(SpringLayout.WEST, mouzaLabel, 750 + leftMargin, SpringLayout.WEST, this);

        JComboBox<String> mouzaComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        add(mouzaComboBox);
        layout.putConstraint(SpringLayout.NORTH, mouzaComboBox, 5, SpringLayout.SOUTH, mouzaLabel);
        layout.putConstraint(SpringLayout.WEST, mouzaComboBox, 750 + leftMargin, SpringLayout.WEST, this);

        // Row 4
        JLabel areaLabel = new JLabel("Area (in ha):");
        add(areaLabel);
        layout.putConstraint(SpringLayout.NORTH, areaLabel, verticalSpacing, SpringLayout.SOUTH, plotNoField);
        layout.putConstraint(SpringLayout.WEST, areaLabel, leftMargin, SpringLayout.WEST, this);

        JTextField areaField = new JTextField(10);
        add(areaField);
        layout.putConstraint(SpringLayout.NORTH, areaField, 5, SpringLayout.SOUTH, areaLabel);
        layout.putConstraint(SpringLayout.WEST, areaField, leftMargin, SpringLayout.WEST, this);

        // Row 5
        JLabel lotNumberLabel = new JLabel("Lot Number:");
        add(lotNumberLabel);
        layout.putConstraint(SpringLayout.NORTH, lotNumberLabel, verticalSpacing, SpringLayout.SOUTH, areaField);
        layout.putConstraint(SpringLayout.WEST, lotNumberLabel, leftMargin, SpringLayout.WEST, this);

        JTextField lotNumberField = new JTextField(10);
        add(lotNumberField);
        layout.putConstraint(SpringLayout.NORTH, lotNumberField, 5, SpringLayout.SOUTH, lotNumberLabel);
        layout.putConstraint(SpringLayout.WEST, lotNumberField, leftMargin, SpringLayout.WEST, this);

        JLabel tagNumberLabel = new JLabel("Tag Number:");
        add(tagNumberLabel);
        layout.putConstraint(SpringLayout.NORTH, tagNumberLabel, 0, SpringLayout.NORTH, lotNumberLabel);
        layout.putConstraint(SpringLayout.WEST, tagNumberLabel, 250 + leftMargin, SpringLayout.WEST, this);

        JTextField tagNumberField = new JTextField(10);
        add(tagNumberField);
        layout.putConstraint(SpringLayout.NORTH, tagNumberField, 5, SpringLayout.SOUTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, tagNumberField, 250 + leftMargin, SpringLayout.WEST, this);

        JButton addTagButton = new JButton("+");
        add(addTagButton);
        layout.putConstraint(SpringLayout.NORTH, addTagButton, 5, SpringLayout.SOUTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, addTagButton, 420 + leftMargin, SpringLayout.WEST, this);

        JLabel tagNumberAreaLabel = new JLabel("Added Tag Number:");
        add(tagNumberAreaLabel);
        layout.putConstraint(SpringLayout.NORTH, tagNumberAreaLabel, 0, SpringLayout.NORTH, lotNumberLabel);
        layout.putConstraint(SpringLayout.WEST, tagNumberAreaLabel, 500 + leftMargin, SpringLayout.WEST, this);

        JTextArea addedTagNumbersArea = new JTextArea();
        addedTagNumbersArea.setRows(3);
        addedTagNumbersArea.setColumns(20);
        addedTagNumbersArea.setLineWrap(true);
        addedTagNumbersArea.setWrapStyleWord(true);
        add(addedTagNumbersArea);
        layout.putConstraint(SpringLayout.NORTH, addedTagNumbersArea, 20, SpringLayout.NORTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, addedTagNumbersArea, 500 + leftMargin, SpringLayout.WEST, this);

// Row 6

        // Row 6
        JLabel weightPerBagLabel = new JLabel("Weight per bag in Kg:");
        add(weightPerBagLabel);
        layout.putConstraint(SpringLayout.NORTH, weightPerBagLabel, verticalSpacing, SpringLayout.SOUTH, lotNumberField);
        layout.putConstraint(SpringLayout.WEST, weightPerBagLabel, leftMargin, SpringLayout.WEST, this);

        JTextField weightPerBagField = new JTextField(10);
        add(weightPerBagField);
        layout.putConstraint(SpringLayout.NORTH, weightPerBagField, 5, SpringLayout.SOUTH, weightPerBagLabel);
        layout.putConstraint(SpringLayout.WEST, weightPerBagField, leftMargin, SpringLayout.WEST, this);

        JLabel numberOfBagsLabel = new JLabel("Number Of Bags:");
        add(numberOfBagsLabel);
        layout.putConstraint(SpringLayout.NORTH, numberOfBagsLabel, 0, SpringLayout.NORTH, weightPerBagLabel);
        layout.putConstraint(SpringLayout.WEST, numberOfBagsLabel, 250 + leftMargin, SpringLayout.WEST, this);

        JTextField numberOfBagsField = new JTextField(10);
        add(numberOfBagsField);
        layout.putConstraint(SpringLayout.NORTH, numberOfBagsField, 5, SpringLayout.SOUTH, numberOfBagsLabel);
        layout.putConstraint(SpringLayout.WEST, numberOfBagsField, 250 + leftMargin, SpringLayout.WEST, this);

        JButton addBagButton = new JButton("+");
        add(addBagButton);
        layout.putConstraint(SpringLayout.NORTH, addBagButton, 5, SpringLayout.SOUTH, numberOfBagsLabel);
        layout.putConstraint(SpringLayout.WEST, addBagButton, 420 + leftMargin, SpringLayout.WEST, this);



        // Row 7

        JLabel billReceiptLabel = new JLabel("Bill/ Receipt / Challan:");
        add(billReceiptLabel);
        layout.putConstraint(SpringLayout.NORTH, billReceiptLabel, verticalSpacing, SpringLayout.SOUTH, weightPerBagField);
        layout.putConstraint(SpringLayout.WEST, billReceiptLabel, leftMargin, SpringLayout.WEST, this);


        JTextField billReceiptField = new JTextField(15);
        add(billReceiptField);
        layout.putConstraint(SpringLayout.NORTH, billReceiptField, 5, SpringLayout.SOUTH, billReceiptLabel);
        layout.putConstraint(SpringLayout.WEST, billReceiptField, leftMargin, SpringLayout.WEST, this);

        JLabel dateLabel = new JLabel("Date:");
        add(dateLabel);
        layout.putConstraint(SpringLayout.NORTH, dateLabel, 0, SpringLayout.NORTH, billReceiptLabel);
        layout.putConstraint(SpringLayout.WEST, dateLabel, 250 + leftMargin, SpringLayout.WEST, this);

        JFormattedTextField dateField = new JFormattedTextField(new SimpleDateFormat("dd-MM-yyyy"));
        dateField.setColumns(10);
        add(dateField);
        layout.putConstraint(SpringLayout.NORTH, dateField, 5, SpringLayout.SOUTH, dateLabel);
        layout.putConstraint(SpringLayout.WEST, dateField, 250 + leftMargin, SpringLayout.WEST, this);

        JButton addDateButton = new JButton("+");
        add(addDateButton);
        layout.putConstraint(SpringLayout.NORTH, addDateButton, 5, SpringLayout.SOUTH, dateLabel);
        layout.putConstraint(SpringLayout.WEST, addDateButton, 420 + leftMargin, SpringLayout.WEST, this);



        // Bottom Buttons
        JButton backButton = new JButton("< BACK");
        add(backButton);
        layout.putConstraint(SpringLayout.NORTH, backButton, verticalSpacing, SpringLayout.SOUTH, billReceiptField);
        layout.putConstraint(SpringLayout.WEST, backButton, 500 + leftMargin, SpringLayout.WEST, this);

        JButton saveButton = new JButton("SAVE");
        add(saveButton);
        layout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, backButton);
        layout.putConstraint(SpringLayout.WEST, saveButton, horizontalSpacing, SpringLayout.EAST, backButton);

        // Add visibility constraints for the buttons
        backButton.setVisible(true);
        saveButton.setVisible(true);

        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "Page 1");
        });

        saveButton.addActionListener(e -> {
            String textField1Value = page1.getTextField1Value();
            JOptionPane.showMessageDialog(Page2.this, "Data to save:\nField 1: " + textField1Value);
        });



        // Add a resize listener to adjust the title bar width
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                titleBar.setBounds(0, 0, getWidth(), 50);
            }
        });
    }
}
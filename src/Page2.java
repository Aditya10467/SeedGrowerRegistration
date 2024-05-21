import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;


public class Page2 extends JPanel {
    private Page1 page1;
    private DefaultTableModel tableModel;

    JLabel sourceOfSeedsLabel,roUnitOfficeLabel;

    public Page2(Page1 page1) {
        this.page1 = page1;
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        setBackground(new Color(250, 231, 209));

        // Create and add the custom title bar
        TitleBarPanel titleBar = new TitleBarPanel("Crop Registration Details of the Seed Grower");
        add(titleBar);
        layout.putConstraint(SpringLayout.NORTH, titleBar, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, titleBar, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, titleBar, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.SOUTH, titleBar, 50, SpringLayout.NORTH, this);

        int verticalSpacing = 15; // Vertical spacing between components
        int horizontalSpacing = 30; // Horizontal spacing between components
        int topMargin = 40; // Top margin after title bar
        int leftMargin = 100; // Left margin to center the form

        // Row 1
        sourceOfSeedsLabel = new JLabel("Source Of Seeds:");
        add(sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.NORTH, sourceOfSeedsLabel, topMargin, SpringLayout.SOUTH, titleBar);
        layout.putConstraint(SpringLayout.WEST, sourceOfSeedsLabel, leftMargin, SpringLayout.WEST, this);

        JTextField sourceOfSeedsField = new JTextField(10);
        add(sourceOfSeedsField);
        layout.putConstraint(SpringLayout.NORTH, sourceOfSeedsField, 5, SpringLayout.SOUTH, sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.WEST, sourceOfSeedsField, leftMargin, SpringLayout.WEST, this);

        roUnitOfficeLabel = new JLabel("RO / Unit Office:");
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
        addTagButton.setForeground(new Color(255,255,255));
        addTagButton.setBackground(new Color(243, 142, 57));
        add(addTagButton);
        layout.putConstraint(SpringLayout.NORTH, addTagButton, 5, SpringLayout.SOUTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, addTagButton, 420 + leftMargin, SpringLayout.WEST, this);

        JLabel tagNumberAreaLabel = new JLabel("Added Tag Number:");
        add(tagNumberAreaLabel);
        layout.putConstraint(SpringLayout.NORTH, tagNumberAreaLabel, 0, SpringLayout.NORTH, lotNumberLabel);
        layout.putConstraint(SpringLayout.WEST, tagNumberAreaLabel, 40, SpringLayout.EAST, addTagButton);

        JTextArea addedTagNumbersArea = new JTextArea();
        addedTagNumbersArea.setRows(3);
        addedTagNumbersArea.setColumns(20);
        addedTagNumbersArea.setLineWrap(true);
        addedTagNumbersArea.setWrapStyleWord(true);
        add(addedTagNumbersArea);
        layout.putConstraint(SpringLayout.NORTH, addedTagNumbersArea, 20, SpringLayout.NORTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, addedTagNumbersArea, 40, SpringLayout.EAST, addTagButton);

        JLabel packagingAreaLabel = new JLabel("Packaging details");
        add(packagingAreaLabel);
        layout.putConstraint(SpringLayout.NORTH, packagingAreaLabel, 0, SpringLayout.NORTH, lotNumberLabel);
        layout.putConstraint(SpringLayout.WEST, packagingAreaLabel, 20, SpringLayout.EAST, addedTagNumbersArea);

        JTextArea packagingArea = new JTextArea();
        packagingArea.setRows(3);
        packagingArea.setColumns(20);
        packagingArea.setLineWrap(true);
        packagingArea.setWrapStyleWord(true);
        add(packagingArea);
        layout.putConstraint(SpringLayout.NORTH, packagingArea, 20, SpringLayout.NORTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, packagingArea, 20, SpringLayout.EAST, addedTagNumbersArea);

        JLabel challanDetailsLabel = new JLabel("Challan Details");
        add(challanDetailsLabel);
        layout.putConstraint(SpringLayout.NORTH, challanDetailsLabel, 0, SpringLayout.NORTH, lotNumberLabel);
        layout.putConstraint(SpringLayout.WEST, challanDetailsLabel, 20, SpringLayout.EAST, packagingArea);

        JTextArea challanDetailsArea = new JTextArea();
        challanDetailsArea.setRows(3);
        challanDetailsArea.setColumns(20);
        challanDetailsArea.setLineWrap(true);
        challanDetailsArea.setWrapStyleWord(true);
        add(challanDetailsArea);
        layout.putConstraint(SpringLayout.NORTH, challanDetailsArea, 20, SpringLayout.NORTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, challanDetailsArea, 20, SpringLayout.EAST, packagingArea);



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
        addBagButton.setForeground(new Color(255,255,255));
        addBagButton.setBackground(new Color(243, 142, 57));
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


        JDateChooser dateField=new JDateChooser();
        add(dateField);
        layout.putConstraint(SpringLayout.NORTH, dateField, 5, SpringLayout.SOUTH, dateLabel);
        layout.putConstraint(SpringLayout.WEST, dateField, 250 + leftMargin, SpringLayout.WEST, this);

        JButton addDateButton = new JButton("+");
        addDateButton.setForeground(new Color(255,255,255));
        addDateButton.setBackground(new Color(243, 142, 57));
        add(addDateButton);
        layout.putConstraint(SpringLayout.NORTH, addDateButton, 5, SpringLayout.SOUTH, dateLabel);
        layout.putConstraint(SpringLayout.WEST, addDateButton, 420 + leftMargin, SpringLayout.WEST, this);



        // Add Crop Button

        JButton addCropButton = new JButton("ADD CROP");
        addCropButton.setForeground(new Color(255,255,255));
        addCropButton.setBackground(new Color(243, 142, 57));
        add(addCropButton);
        layout.putConstraint(SpringLayout.NORTH, addCropButton, verticalSpacing+5, SpringLayout.NORTH, billReceiptField);
        layout.putConstraint(SpringLayout.WEST, addCropButton, 500+leftMargin, SpringLayout.WEST, this);

        // Add visibility constraints for the buttons



        addCropButton.addActionListener(e -> {
            String textField1Value = page1.getTextField1Value();
            JOptionPane.showMessageDialog(Page2.this, "Data to save:\nField 1: " + textField1Value);
        });

        String[] columnNames = {"Source of Seeds", "RO / Unit Office", "Month of Sowing", "Week of Sowing", "Crop", "Variety", "Source Class", "Class to be produced", "Plot No", "District", "Block", "Mouza", "CDF", "Area (hectare)", "Expected Date of Harvest", "Edit", "Remove"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 15 || column == 16; // Allow editing only for "Edit" and "Remove" columns
            }
        };
        JTable table = new JTable(tableModel);
        table.getColumnModel().getColumn(15).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(15).setCellEditor(new ButtonEditor(new JCheckBox()));
        table.getColumnModel().getColumn(16).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(16).setCellEditor(new ButtonEditor(new JCheckBox()));
        JScrollPane scrollPane = new JScrollPane(table); // Wrap the table in a scroll pane
        scrollPane.setPreferredSize(new Dimension(800, 75)); // Adjust the height as needed
        add(scrollPane);
        layout.putConstraint(SpringLayout.NORTH, scrollPane, verticalSpacing, SpringLayout.SOUTH, addCropButton);
        layout.putConstraint(SpringLayout.WEST, scrollPane, leftMargin, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, scrollPane, -leftMargin, SpringLayout.EAST, this);

        JButton backButton = new JButton("BACK");
        backButton.setBackground(new Color(243, 142, 57));
        backButton.setForeground(new Color(255,255,255));
        add(backButton);
        layout.putConstraint(SpringLayout.NORTH, backButton, verticalSpacing, SpringLayout.SOUTH, scrollPane);
        layout.putConstraint(SpringLayout.WEST, backButton, 450 + leftMargin, SpringLayout.WEST, this);

        JButton saveButton = new JButton("SAVE");
        saveButton.setBackground(new Color(243, 142, 57));
        saveButton.setForeground(new Color(255,255,255));
        add(saveButton);
        layout.putConstraint(SpringLayout.NORTH, saveButton, verticalSpacing, SpringLayout.SOUTH, scrollPane);
        layout.putConstraint(SpringLayout.WEST, saveButton, horizontalSpacing, SpringLayout.EAST, backButton);

        backButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "Page 1");
        });






        // Add a resize listener to adjust the title bar width
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                titleBar.setBounds(0, 0, getWidth(), 50);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                // Reposition components based on the new size
                revalidate();
                repaint();
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
        // Draw left border
        g.fillRect(0, 0, thickness, height);
        // Draw right border
        g.fillRect(width - thickness, 0, thickness, height);
        //Draw bottom border
        g.fillRect(0, height - thickness, width, thickness);
    }

    // Custom cell renderer for rendering buttons
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // Custom cell editor for editing buttons
    class ButtonEditor extends DefaultCellEditor {
        protected JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                // Perform edit or remove action based on column
                if (label.equals("Edit")) {
                    // Perform edit action
                    // You can implement the edit action here
                } else if (label.equals("Remove")) {
                    // Perform remove action
                    // You can implement the remove action here
                }
            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}

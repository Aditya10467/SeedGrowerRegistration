import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Page2 extends JPanel implements ActionListener  {
    private Page1 page1;
    private DefaultTableModel tableModel;

    JTextArea packagingArea,addedTagNumbersArea, challanDetailsArea;

    JDateChooser dateField;
    JTable table;
    ArrayList<Data> dataList = new ArrayList<>();


    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");


    JLabel sourceOfSeedsLabel,roUnitOfficeLabel;
    JButton addCropButton;

    JTextField sourceOfSeedsField,plotNoField,areaField,lotNumberField,tagNumberField,weightPerBagField,numberOfBagsField,billReceiptField;
    static JComboBox roUnitOfficeComboBox,monthOfSowingComboBox,weekOfSowingComboBox,varietyComboBox,sourceClassComboBox,classToBeProducedComboBox,districtComboBox,blockComboBox,mouzaComboBox,cropComboBox;

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

        LoadDetails l=new LoadDetails();
        l.connectToDatabase();

        // Row 1
        sourceOfSeedsLabel = new JLabel("Source Of Seeds:");
        add(sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.NORTH, sourceOfSeedsLabel, topMargin, SpringLayout.SOUTH, titleBar);
        layout.putConstraint(SpringLayout.WEST, sourceOfSeedsLabel, leftMargin, SpringLayout.WEST, this);

        sourceOfSeedsField = new JTextField(15);
        add(sourceOfSeedsField);
        layout.putConstraint(SpringLayout.NORTH, sourceOfSeedsField, 5, SpringLayout.SOUTH, sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.WEST, sourceOfSeedsField, leftMargin, SpringLayout.WEST, this);

        roUnitOfficeLabel = new JLabel("RO / Unit Office:");
        add(roUnitOfficeLabel);
        layout.putConstraint(SpringLayout.NORTH, roUnitOfficeLabel, 0, SpringLayout.NORTH, sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.WEST, roUnitOfficeLabel, 250 + leftMargin, SpringLayout.WEST, this);

        roUnitOfficeComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        roUnitOfficeComboBox.setBackground(new Color(255,255,255));
        roUnitOfficeComboBox.setPreferredSize(new Dimension(150,20));
        add(roUnitOfficeComboBox);
        layout.putConstraint(SpringLayout.NORTH, roUnitOfficeComboBox, 5, SpringLayout.SOUTH, roUnitOfficeLabel);
        layout.putConstraint(SpringLayout.WEST, roUnitOfficeComboBox, 250 + leftMargin, SpringLayout.WEST, this);

        JLabel monthOfSowingLabel = new JLabel("Month of Sowing:");
        add(monthOfSowingLabel);
        layout.putConstraint(SpringLayout.NORTH, monthOfSowingLabel, 0, SpringLayout.NORTH, sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.WEST, monthOfSowingLabel, 500 + leftMargin, SpringLayout.WEST, this);

        monthOfSowingComboBox = new JComboBox<>(new String[]{"--SELECT--","January","February","March","April","May","June","July","August","September","October","November","December"});
        monthOfSowingComboBox.setBackground(new Color(255,255,255));
        monthOfSowingComboBox.setPreferredSize(new Dimension(150,20));
        add(monthOfSowingComboBox);
        layout.putConstraint(SpringLayout.NORTH, monthOfSowingComboBox, 5, SpringLayout.SOUTH, monthOfSowingLabel);
        layout.putConstraint(SpringLayout.WEST, monthOfSowingComboBox, 500 + leftMargin, SpringLayout.WEST, this);

        JLabel weekOfSowingLabel = new JLabel("Week of Sowing:");
        add(weekOfSowingLabel);
        layout.putConstraint(SpringLayout.NORTH, weekOfSowingLabel, 0, SpringLayout.NORTH, sourceOfSeedsLabel);
        layout.putConstraint(SpringLayout.WEST, weekOfSowingLabel, 750 + leftMargin, SpringLayout.WEST, this);

        weekOfSowingComboBox = new JComboBox<>(new String[]{"--SELECT--","1","2","3","4","5"});
        weekOfSowingComboBox.setBackground(new Color(255,255,255));
        weekOfSowingComboBox.setPreferredSize(new Dimension(150,20));
        add(weekOfSowingComboBox);
        layout.putConstraint(SpringLayout.NORTH, weekOfSowingComboBox, 5, SpringLayout.SOUTH, weekOfSowingLabel);
        layout.putConstraint(SpringLayout.WEST, weekOfSowingComboBox, 750 + leftMargin, SpringLayout.WEST, this);

        // Row 2
        JLabel cropLabel = new JLabel("Crop:");
        add(cropLabel);
        layout.putConstraint(SpringLayout.NORTH, cropLabel, verticalSpacing, SpringLayout.SOUTH, sourceOfSeedsField);
        layout.putConstraint(SpringLayout.WEST, cropLabel, leftMargin, SpringLayout.WEST, this);

        cropComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        cropComboBox.setBackground(new Color(255,255,255));
        cropComboBox.setPreferredSize(new Dimension(150,20));
        l.populateCropBox();
        cropComboBox.setSelectedItem(null);
        add(cropComboBox);
        layout.putConstraint(SpringLayout.NORTH, cropComboBox, 5, SpringLayout.SOUTH, cropLabel);
        layout.putConstraint(SpringLayout.WEST, cropComboBox, leftMargin, SpringLayout.WEST, this);

        cropComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCrop=(String) cropComboBox.getSelectedItem();
                if(selectedCrop!="--SELECT--"){
                    l.populateVarietyBox(selectedCrop);
                }
            }
        });

        JLabel varietyLabel = new JLabel("Variety:");
        add(varietyLabel);
        layout.putConstraint(SpringLayout.NORTH, varietyLabel, 0, SpringLayout.NORTH, cropLabel);
        layout.putConstraint(SpringLayout.WEST, varietyLabel, 250 + leftMargin, SpringLayout.WEST, this);

        varietyComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        varietyComboBox.setBackground(new Color(255,255,255));
        varietyComboBox.setPreferredSize(new Dimension(150,20));
        add(varietyComboBox);
        layout.putConstraint(SpringLayout.NORTH, varietyComboBox, 5, SpringLayout.SOUTH, varietyLabel);
        layout.putConstraint(SpringLayout.WEST, varietyComboBox, 250 + leftMargin, SpringLayout.WEST, this);

        JLabel sourceClassLabel = new JLabel("Source Class:");
        add(sourceClassLabel);
        layout.putConstraint(SpringLayout.NORTH, sourceClassLabel, 0, SpringLayout.NORTH, cropLabel);
        layout.putConstraint(SpringLayout.WEST, sourceClassLabel, 500 + leftMargin, SpringLayout.WEST, this);

        sourceClassComboBox = new JComboBox<>(new String[]{"--SELECT--","Fundamental","Breeder"});
        sourceClassComboBox.setBackground(new Color(255,255,255));
        sourceClassComboBox.setPreferredSize(new Dimension(150,20));
        add(sourceClassComboBox);
        layout.putConstraint(SpringLayout.NORTH, sourceClassComboBox, 5, SpringLayout.SOUTH, sourceClassLabel);
        layout.putConstraint(SpringLayout.WEST, sourceClassComboBox, 500 + leftMargin, SpringLayout.WEST, this);

        JLabel classToBeProducedLabel = new JLabel("Class to be produced:");
        add(classToBeProducedLabel);
        layout.putConstraint(SpringLayout.NORTH, classToBeProducedLabel, 0, SpringLayout.NORTH, cropLabel);
        layout.putConstraint(SpringLayout.WEST, classToBeProducedLabel, 750 + leftMargin, SpringLayout.WEST, this);

        classToBeProducedComboBox = new JComboBox<>(new String[]{"--SELECT--","Fundamental","Breeder"});
        classToBeProducedComboBox.setBackground(new Color(255,255,255));
        classToBeProducedComboBox.setPreferredSize(new Dimension(150,20));
        add(classToBeProducedComboBox);
        layout.putConstraint(SpringLayout.NORTH, classToBeProducedComboBox, 5, SpringLayout.SOUTH, classToBeProducedLabel);
        layout.putConstraint(SpringLayout.WEST, classToBeProducedComboBox, 750 + leftMargin, SpringLayout.WEST, this);

        // Row 3
        JLabel plotNoLabel = new JLabel("Plot No:");
        add(plotNoLabel);
        layout.putConstraint(SpringLayout.NORTH, plotNoLabel, verticalSpacing, SpringLayout.SOUTH, cropComboBox);
        layout.putConstraint(SpringLayout.WEST, plotNoLabel, leftMargin, SpringLayout.WEST, this);

        plotNoField = new JTextField(15);
        add(plotNoField);
        layout.putConstraint(SpringLayout.NORTH, plotNoField, 5, SpringLayout.SOUTH, plotNoLabel);
        layout.putConstraint(SpringLayout.WEST, plotNoField, leftMargin, SpringLayout.WEST, this);

        JLabel districtLabel = new JLabel("District:");
        add(districtLabel);
        layout.putConstraint(SpringLayout.NORTH, districtLabel, 0, SpringLayout.NORTH, plotNoLabel);
        layout.putConstraint(SpringLayout.WEST, districtLabel, 250 + leftMargin, SpringLayout.WEST, this);

        districtComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        districtComboBox.setBackground(new Color(255,255,255));
        districtComboBox.setPreferredSize(new Dimension(150,20));
        l.populateDistrictBox();
        districtComboBox.setSelectedItem(null);
        add(districtComboBox);
        layout.putConstraint(SpringLayout.NORTH, districtComboBox, 5, SpringLayout.SOUTH, districtLabel);
        layout.putConstraint(SpringLayout.WEST, districtComboBox, 250 + leftMargin, SpringLayout.WEST, this);

        districtComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDistrict = (String) districtComboBox.getSelectedItem();
                if(selectedDistrict!=null){
                    l.populateBlockBox(selectedDistrict);
                }
            }
        });

        JLabel blockLabel = new JLabel("Block:");
        add(blockLabel);
        layout.putConstraint(SpringLayout.NORTH, blockLabel, 0, SpringLayout.NORTH, plotNoLabel);
        layout.putConstraint(SpringLayout.WEST, blockLabel, 500 + leftMargin, SpringLayout.WEST, this);

        blockComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        blockComboBox.setBackground(new Color(255,255,255));
        blockComboBox.setPreferredSize(new Dimension(150,20));
        add(blockComboBox);
        layout.putConstraint(SpringLayout.NORTH, blockComboBox, 5, SpringLayout.SOUTH, blockLabel);
        layout.putConstraint(SpringLayout.WEST, blockComboBox, 500 + leftMargin, SpringLayout.WEST, this);

//        blockComboBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String selectedBlock = (String) blockComboBox.getSelectedItem();
//                if(selectedBlock!=null){
//                    l.populateMouzaBox(selectedBlock);
//                    mouzaComboBox.setSelectedItem(null);
////
//                }
//            }
//        });

        JLabel mouzaLabel = new JLabel("Mouza:");
        add(mouzaLabel);
        layout.putConstraint(SpringLayout.NORTH, mouzaLabel, 0, SpringLayout.NORTH, plotNoLabel);
        layout.putConstraint(SpringLayout.WEST, mouzaLabel, 750 + leftMargin, SpringLayout.WEST, this);

        mouzaComboBox = new JComboBox<>(new String[]{"--SELECT--"});
        mouzaComboBox.setBackground(new Color(255,255,255));
        mouzaComboBox.setPreferredSize(new Dimension(150,20));
        mouzaComboBox.setSelectedItem(null);
        add(mouzaComboBox);
        layout.putConstraint(SpringLayout.NORTH, mouzaComboBox, 5, SpringLayout.SOUTH, mouzaLabel);
        layout.putConstraint(SpringLayout.WEST, mouzaComboBox, 750 + leftMargin, SpringLayout.WEST, this);

        // Row 4
        JLabel areaLabel = new JLabel("Area (in ha):");
        add(areaLabel);
        layout.putConstraint(SpringLayout.NORTH, areaLabel, verticalSpacing, SpringLayout.SOUTH, plotNoField);
        layout.putConstraint(SpringLayout.WEST, areaLabel, leftMargin, SpringLayout.WEST, this);

        areaField = new JTextField(15);
        add(areaField);
        layout.putConstraint(SpringLayout.NORTH, areaField, 5, SpringLayout.SOUTH, areaLabel);
        layout.putConstraint(SpringLayout.WEST, areaField, leftMargin, SpringLayout.WEST, this);

        // Row 5
        JLabel lotNumberLabel = new JLabel("Lot Number:");
        add(lotNumberLabel);
        layout.putConstraint(SpringLayout.NORTH, lotNumberLabel, verticalSpacing, SpringLayout.SOUTH, areaField);
        layout.putConstraint(SpringLayout.WEST, lotNumberLabel, leftMargin, SpringLayout.WEST, this);

        lotNumberField = new JTextField(15);
        add(lotNumberField);
        layout.putConstraint(SpringLayout.NORTH, lotNumberField, 5, SpringLayout.SOUTH, lotNumberLabel);
        layout.putConstraint(SpringLayout.WEST, lotNumberField, leftMargin, SpringLayout.WEST, this);

        JLabel tagNumberLabel = new JLabel("Tag Number:");
        add(tagNumberLabel);
        layout.putConstraint(SpringLayout.NORTH, tagNumberLabel, 0, SpringLayout.NORTH, lotNumberLabel);
        layout.putConstraint(SpringLayout.WEST, tagNumberLabel, 250 + leftMargin, SpringLayout.WEST, this);

        tagNumberField = new JTextField(15);
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

        addedTagNumbersArea = new JTextArea();
        addedTagNumbersArea.setRows(3);
        addedTagNumbersArea.setColumns(20);
        addedTagNumbersArea.setLineWrap(true);
        addedTagNumbersArea.setWrapStyleWord(true);
        layout.putConstraint(SpringLayout.NORTH, addedTagNumbersArea, 20, SpringLayout.NORTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, addedTagNumbersArea, 40, SpringLayout.EAST, addTagButton);

        JScrollPane tagareascrollPane = new JScrollPane(addedTagNumbersArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(tagareascrollPane);
        layout.putConstraint(SpringLayout.NORTH, tagareascrollPane, 20, SpringLayout.NORTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, tagareascrollPane, 40, SpringLayout.EAST, addTagButton);


        addTagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lotNumberField.getText().isEmpty() || tagNumberField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter all required fields", "Waring", JOptionPane.WARNING_MESSAGE);
                }else{
                    String lotNumber=lotNumberField.getText();
                    String tagNumber=tagNumberField.getText();
                    String addedTagNumber="{"+lotNumber+","+tagNumber+"}";
                    if (addedTagNumbersArea.getText().isEmpty()) {
                        addedTagNumbersArea.append("LotNumber :"+lotNumber+"\n");
                        addedTagNumbersArea.append("Tag Number(s):"+"\n"+tagNumber);
                    } else {
                        addedTagNumbersArea.append(","+"\n");
                        addedTagNumbersArea.append(tagNumber);
                    }
                }



            }
        });

        JLabel packagingAreaLabel = new JLabel("Packaging details");
        add(packagingAreaLabel);
        layout.putConstraint(SpringLayout.NORTH, packagingAreaLabel, 0, SpringLayout.NORTH, lotNumberLabel);
        layout.putConstraint(SpringLayout.WEST, packagingAreaLabel, 20, SpringLayout.EAST, addedTagNumbersArea);

        packagingArea = new JTextArea();
        packagingArea.setRows(3);
        packagingArea.setColumns(20);
        packagingArea.setLineWrap(true);
        packagingArea.setWrapStyleWord(true);
        add(packagingArea);
        layout.putConstraint(SpringLayout.NORTH, packagingArea, 20, SpringLayout.NORTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, packagingArea, 20, SpringLayout.EAST, addedTagNumbersArea);

//        JScrollPane pkgareascrollPane = new JScrollPane(packagingArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        add(pkgareascrollPane);
//        layout.putConstraint(SpringLayout.NORTH, pkgareascrollPane, 20, SpringLayout.NORTH, tagNumberLabel);
//        layout.putConstraint(SpringLayout.WEST, pkgareascrollPane, 20, SpringLayout.EAST, addedTagNumbersArea);

        JLabel challanDetailsLabel = new JLabel("Challan Details");
        add(challanDetailsLabel);
        layout.putConstraint(SpringLayout.NORTH, challanDetailsLabel, 0, SpringLayout.NORTH, lotNumberLabel);
        layout.putConstraint(SpringLayout.WEST, challanDetailsLabel, 20, SpringLayout.EAST, packagingArea);

        challanDetailsArea = new JTextArea();
        challanDetailsArea.setRows(3);
        challanDetailsArea.setColumns(20);
        challanDetailsArea.setLineWrap(true);
        challanDetailsArea.setWrapStyleWord(true);
        add(challanDetailsArea);
        layout.putConstraint(SpringLayout.NORTH, challanDetailsArea, 20, SpringLayout.NORTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, challanDetailsArea, 20, SpringLayout.EAST, packagingArea);

        JScrollPane challanareascrollPane = new JScrollPane(challanDetailsArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(challanareascrollPane);
        layout.putConstraint(SpringLayout.NORTH, challanareascrollPane, 20, SpringLayout.NORTH, tagNumberLabel);
        layout.putConstraint(SpringLayout.WEST, challanareascrollPane, 20, SpringLayout.EAST, packagingArea);



        // Row 6
        JLabel weightPerBagLabel = new JLabel("Weight per bag in Kg:");
        add(weightPerBagLabel);
        layout.putConstraint(SpringLayout.NORTH, weightPerBagLabel, verticalSpacing, SpringLayout.SOUTH, lotNumberField);
        layout.putConstraint(SpringLayout.WEST, weightPerBagLabel, leftMargin, SpringLayout.WEST, this);

        weightPerBagField = new JTextField(15);
        add(weightPerBagField);
        layout.putConstraint(SpringLayout.NORTH, weightPerBagField, 5, SpringLayout.SOUTH, weightPerBagLabel);
        layout.putConstraint(SpringLayout.WEST, weightPerBagField, leftMargin, SpringLayout.WEST, this);

        JLabel numberOfBagsLabel = new JLabel("Number Of Bags:");
        add(numberOfBagsLabel);
        layout.putConstraint(SpringLayout.NORTH, numberOfBagsLabel, 0, SpringLayout.NORTH, weightPerBagLabel);
        layout.putConstraint(SpringLayout.WEST, numberOfBagsLabel, 250 + leftMargin, SpringLayout.WEST, this);

        numberOfBagsField = new JTextField(15);
        add(numberOfBagsField);
        layout.putConstraint(SpringLayout.NORTH, numberOfBagsField, 5, SpringLayout.SOUTH, numberOfBagsLabel);
        layout.putConstraint(SpringLayout.WEST, numberOfBagsField, 250 + leftMargin, SpringLayout.WEST, this);

        JButton addBagButton = new JButton("+");
        addBagButton.setForeground(new Color(255,255,255));
        addBagButton.setBackground(new Color(243, 142, 57));
        add(addBagButton);
        layout.putConstraint(SpringLayout.NORTH, addBagButton, 5, SpringLayout.SOUTH, numberOfBagsLabel);
        layout.putConstraint(SpringLayout.WEST, addBagButton, 420 + leftMargin, SpringLayout.WEST, this);

        addBagButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(weightPerBagField.getText().isEmpty() || numberOfBagsField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter all required fields", "Waring", JOptionPane.WARNING_MESSAGE);
                }else{
                    int bagWeight=Integer.parseInt(weightPerBagField.getText());
                    int noOfBags=Integer.parseInt(numberOfBagsField.getText());
                    String packagingDetails="{"+bagWeight+","+noOfBags+"}";

                    if (packagingArea.getText().isEmpty()) {
                        packagingArea.append(packagingDetails);
                    } else {
                        packagingArea.append(",");
                        packagingArea.append(packagingDetails);
                    }
                }

            }
        });


        // Row 7

        JLabel billReceiptLabel = new JLabel("Bill/ Receipt / Challan:");
        add(billReceiptLabel);
        layout.putConstraint(SpringLayout.NORTH, billReceiptLabel, verticalSpacing, SpringLayout.SOUTH, weightPerBagField);
        layout.putConstraint(SpringLayout.WEST, billReceiptLabel, leftMargin, SpringLayout.WEST, this);


        billReceiptField = new JTextField(15);
        add(billReceiptField);
        layout.putConstraint(SpringLayout.NORTH, billReceiptField, 5, SpringLayout.SOUTH, billReceiptLabel);
        layout.putConstraint(SpringLayout.WEST, billReceiptField, leftMargin, SpringLayout.WEST, this);

        JLabel dateLabel = new JLabel("Date:");
        add(dateLabel);
        layout.putConstraint(SpringLayout.NORTH, dateLabel, 0, SpringLayout.NORTH, billReceiptLabel);
        layout.putConstraint(SpringLayout.WEST, dateLabel, 250 + leftMargin, SpringLayout.WEST, this);


        dateField=new JDateChooser();
        dateField.setPreferredSize(new Dimension(150,20));
        add(dateField);
        layout.putConstraint(SpringLayout.NORTH, dateField, 5, SpringLayout.SOUTH, dateLabel);
        layout.putConstraint(SpringLayout.WEST, dateField, 250 + leftMargin, SpringLayout.WEST, this);

        JButton addDateButton = new JButton("+");
        addDateButton.setForeground(new Color(255,255,255));
        addDateButton.setBackground(new Color(243, 142, 57));
        add(addDateButton);
        layout.putConstraint(SpringLayout.NORTH, addDateButton, 5, SpringLayout.SOUTH, dateLabel);
        layout.putConstraint(SpringLayout.WEST, addDateButton, 420 + leftMargin, SpringLayout.WEST, this);

        addDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(billReceiptField.getText().isEmpty() || dateField.getDate()==null) {
                    JOptionPane.showMessageDialog(null, "Enter all required fields", "Waring", JOptionPane.WARNING_MESSAGE);
                }else{
                    String challanNo=billReceiptField.getText();
                    String date=dateFormat.format(dateField.getDate());

                    String addedTagNumber="{"+challanNo+","+date+"}";
                    if (challanDetailsArea.getText().isEmpty()) {
                        challanDetailsArea.append(addedTagNumber);
                    } else {
                        challanDetailsArea.append(",");
                        challanDetailsArea.append(addedTagNumber);
                    }
                }


            }
        });



        // Add Crop Button

        addCropButton = new JButton("ADD CROP");
        addCropButton.setForeground(new Color(255,255,255));
        addCropButton.setBackground(new Color(243, 142, 57));
        addCropButton.addActionListener(this);
        add(addCropButton);
        layout.putConstraint(SpringLayout.NORTH, addCropButton, verticalSpacing+5, SpringLayout.NORTH, billReceiptField);
        layout.putConstraint(SpringLayout.WEST, addCropButton, 500+leftMargin, SpringLayout.WEST, this);

        // Add visibility constraints for the buttons



//        addCropButton.addActionListener(e -> {
//            String textField1Value = page1.getTextField1Value();
//            JOptionPane.showMessageDialog(Page2.this, "Data to save:\nField 1: " + textField1Value);
//        });

        String[] columnNames = {"Sl No", "RO Name", "Crop", "Variety", "Source Class", "Class to be produced", "Plot No", "District", "Block", "Mouza","Area (hectare)", "Edit", "Remove"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 11 || column == 12; // Allow editing only for "Edit" and "Remove" columns
            }
        };
        JTable table = new JTable(tableModel);
        table.getColumnModel().getColumn(11).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(11).setCellEditor(new ButtonEditor(new JCheckBox(), true, table));
        table.getColumnModel().getColumn(12).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(12).setCellEditor(new ButtonEditor(new JCheckBox(), false, table));
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
        //saveButton.addActionListener(this);
        layout.putConstraint(SpringLayout.NORTH, saveButton, verticalSpacing, SpringLayout.SOUTH, scrollPane);
        layout.putConstraint(SpringLayout.WEST, saveButton, horizontalSpacing, SpringLayout.EAST, backButton);

        backButton.addActionListener(e -> {
//            CardLayout cl = (CardLayout) getParent().getLayout();
//            cl.show(getParent(), "Page 1");
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
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addCropButton){
            String sourceOfSeeds = sourceOfSeedsField.getText();
            String roUnitOffice = (String) roUnitOfficeComboBox.getSelectedItem();
            String crop = (String) cropComboBox.getSelectedItem();
            String variety = (String) varietyComboBox.getSelectedItem();
            String sourceClass = (String) sourceClassComboBox.getSelectedItem();
            String classToBeProduced = (String) classToBeProducedComboBox.getSelectedItem();
            String plotNo = plotNoField.getText();
            String district = (String) districtComboBox.getSelectedItem();
            String block = (String) blockComboBox.getSelectedItem();
            String mouza = (String) mouzaComboBox.getSelectedItem();
            String area = areaField.getText();
//            String lotNumber = lotNumberField.getText();
//            String tagNumber = tagNumberField.getText();
//            String weightPerBag = weightPerBagField.getText();
//            String numberOfBags = numberOfBagsField.getText();
//            String billReceipt = billReceiptField.getText();

            Data newData = new Data(sourceOfSeeds, roUnitOffice, crop, variety, sourceClass, classToBeProduced, plotNo, district, block, mouza, area);
            dataList.add(newData);

            // Update the table model with the new data
            tableModel.addRow(new Object[]{sourceOfSeeds, roUnitOffice, crop, variety, sourceClass, classToBeProduced, plotNo, district, block, mouza, area,"Edit","Remove"});
        }


        sourceOfSeedsField.setText("");
        roUnitOfficeComboBox.setSelectedItem(null);
        monthOfSowingComboBox.setSelectedItem(null);
        weekOfSowingComboBox.setSelectedItem(null);
        cropComboBox.setSelectedItem(null);
        varietyComboBox.setSelectedItem(null);
        sourceClassComboBox.setSelectedItem(null);
        classToBeProducedComboBox.setSelectedItem(null);
        plotNoField.setText("");
        districtComboBox.setSelectedItem(null);
        blockComboBox.setSelectedItem(null);
        mouzaComboBox.setSelectedItem(null);
        areaField.setText("");
        lotNumberField.setText("");
        tagNumberField.setText("");
        weightPerBagField.setText("");
        numberOfBagsField.setText("");
        billReceiptField.setText("");
        addedTagNumbersArea.setText(null);
        packagingArea.setText(null);
        challanDetailsArea.setText(null);
        dateField.setDate(null);

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
    private class ButtonEditor extends DefaultCellEditor {
        private final JButton button;
        private boolean isEditButton; // To track whether the button is for edit or remove
        private JTable table;

        public ButtonEditor(JCheckBox checkBox, boolean isEditButton, JTable table) {
            super(checkBox);
            this.isEditButton = isEditButton;
            this.table = table; // Initialize the table instance
            if (isEditButton) {
                button = new JButton("Edit");
            } else {
                button = new JButton("Remove");
            }
            button.setOpaque(true);
            button.setFocusable(true); // Make the button focusable
            button.addActionListener(e -> {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    if (isEditButton) {
                        // Implement your edit logic here
                    } else {
                        // Remove the selected row from the table
                        removeRow(table, tableModel, selectedRow);

                    }
                }
            });

        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return button;
        }
    }
    private void shiftRows(DefaultTableModel model, int index) {
        for (int i = index + 1; i < model.getRowCount(); i++) {
            model.setValueAt(model.getValueAt(i, 0), i - 1, 0);
        }
        model.removeRow(model.getRowCount() - 1);
    }
    private void removeRow(JTable table, DefaultTableModel model, int selectedRow) {
        if (selectedRow != -1 && !table.isEditing()) {
            if (selectedRow < model.getRowCount() - 1) {
                shiftRows(model, selectedRow);
            } else {
                model.removeRow(selectedRow);
            }
        } else if (selectedRow != -1 && table.isEditing()) {
            TableCellEditor editor = table.getCellEditor(table.getEditingRow(), table.getEditingColumn());
            if (editor != null) {
                editor.stopCellEditing();
            }
            model.removeRow(selectedRow);
        }
    }
}
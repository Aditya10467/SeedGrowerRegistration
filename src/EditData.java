import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EditData {


    void editData(int rowIndex) {
        // Remove existing action listeners to avoid multiple triggers
        for (ActionListener al : Page2.addCropButton.getActionListeners()) {
            Page2.addCropButton.removeActionListener(al);
        }

        CropData cropData = Page2.cropDataList.get(rowIndex);

        String source = cropData.getSourceOfSeeds();
        String roname = cropData.getRoName();
        String crop = cropData.getCrop();
        String variety = cropData.getVariety();
        String sourceclass = cropData.getSourceClass();
        String classTobeProduced = cropData.getClassToBeProduced();
        String plotNo = cropData.getPlotNo();
        String district = cropData.getDistrict();
        String block = cropData.getBlock();
        String mouza = cropData.getMouza();
        String area = cropData.getArea();
        String week = cropData.getWeekofSowing();
        String month = cropData.getMonthOfSowing();

        String tagnumbers = cropData.getTagNumbers();
        String challanDetails = cropData.getChallanDetails();
        String packagingDetails = cropData.getPackagingDetails();

        // Set the form fields with the selected crop data
        Page2.sourceOfSeedsField.setText(source);
        Page2.roUnitOfficeComboBox.setSelectedItem(roname);
        Page2.cropComboBox.setSelectedItem(crop);
        Page2.varietyComboBox.setSelectedItem(variety);
        Page2.sourceClassComboBox.setSelectedItem(sourceclass);
        Page2.classToBeProducedComboBox.setSelectedItem(classTobeProduced);
        Page2.plotNoField.setText(plotNo);
        Page2.districtComboBox.setSelectedItem(district);
        Page2.blockComboBox.setSelectedItem(block);
        Page2.mouzaComboBox.setSelectedItem(mouza);
        Page2.areaField.setText(area);
        Page2.weekOfSowingComboBox.setSelectedItem(week);
        Page2.monthOfSowingComboBox.setSelectedItem(month);
        Page2.addedTagNumbersArea.setText(tagnumbers);
        Page2.packagingArea.setText(packagingDetails);
        Page2.challanDetailsArea.setText(challanDetails);

        // Add action listener to the save button to save edited data
        Page2.addCropButton.addActionListener(e -> {
            saveEditedData(rowIndex);
            resetAddCropButtonListener();
        });
    }

    private void saveEditedData(int rowIndex) {
        // Retrieve the edited data from the form fields
        String sourceOfSeeds = Page2.sourceOfSeedsField.getText();
        String roUnitOffice = (String) Page2.roUnitOfficeComboBox.getSelectedItem();
        String crop = (String) Page2.cropComboBox.getSelectedItem();
        String variety = (String) Page2.varietyComboBox.getSelectedItem();
        String sourceClass = (String) Page2.sourceClassComboBox.getSelectedItem();
        String classToBeProduced = (String) Page2.classToBeProducedComboBox.getSelectedItem();
        String plotNo = Page2.plotNoField.getText();
        String district = (String) Page2.districtComboBox.getSelectedItem();
        String block = (String) Page2.blockComboBox.getSelectedItem();
        String mouza = (String) Page2.mouzaComboBox.getSelectedItem();
        String area = Page2.areaField.getText();
        String weekOfSowing = (String) Page2.weekOfSowingComboBox.getSelectedItem();
        String monthOfSowing = (String) Page2.monthOfSowingComboBox.getSelectedItem();
        String tagNumbers = Page2.addedTagNumbersArea.getText();
        String packagingDetails = Page2.packagingArea.getText();
        String challanDetails = Page2.challanDetailsArea.getText();

        // Update the CropData object in cropDataList
        CropData editedCropData = Page2.cropDataList.get(rowIndex);
        editedCropData.setSourceOfSeeds(sourceOfSeeds);
        editedCropData.setRoName(roUnitOffice);
        editedCropData.setCrop(crop);
        editedCropData.setVariety(variety);
        editedCropData.setSourceClass(sourceClass);
        editedCropData.setClassToBeProduced(classToBeProduced);
        editedCropData.setPlotNo(plotNo);
        editedCropData.setDistrict(district);
        editedCropData.setBlock(block);
        editedCropData.setMouza(mouza);
        editedCropData.setArea(area);
        editedCropData.setWeekOfSowing(weekOfSowing);
        editedCropData.setMonthOfSowing(monthOfSowing);
        editedCropData.setTagNumbers(tagNumbers);
        editedCropData.setPackagingDetails(packagingDetails);
        editedCropData.setChallanDetails(challanDetails);

        // Update the table model with the new data
        Page2.tableModel.setValueAt(sourceOfSeeds, rowIndex, 0);
        Page2.tableModel.setValueAt(roUnitOffice, rowIndex, 1);
        Page2.tableModel.setValueAt(crop, rowIndex, 2);
        Page2.tableModel.setValueAt(variety, rowIndex, 3);
        Page2.tableModel.setValueAt(sourceClass, rowIndex, 4);
        Page2.tableModel.setValueAt(classToBeProduced, rowIndex, 5);
        Page2.tableModel.setValueAt(plotNo, rowIndex, 6);
        Page2.tableModel.setValueAt(district, rowIndex, 7);
        Page2.tableModel.setValueAt(block, rowIndex, 8);
        Page2.tableModel.setValueAt(mouza, rowIndex, 9);
        Page2.tableModel.setValueAt(area, rowIndex, 10);

        clearAllFields();
    }

    private void resetAddCropButtonListener() {
        // Remove existing action listeners to avoid multiple triggers
        for (ActionListener al : Page2.addCropButton.getActionListeners()) {
            Page2.addCropButton.removeActionListener(al);
        }

        // Add a new action listener to handle adding a new crop
        Page2.addCropButton.addActionListener(e -> addData());
    }

    void addData() {
        String sourceOfSeeds = Page2.sourceOfSeedsField.getText();
        String roUnitOffice = (String) Page2.roUnitOfficeComboBox.getSelectedItem();
        String crop = (String) Page2.cropComboBox.getSelectedItem();
        String variety = (String) Page2.varietyComboBox.getSelectedItem();
        String sourceClass = (String) Page2.sourceClassComboBox.getSelectedItem();
        String classToBeProduced = (String) Page2.classToBeProducedComboBox.getSelectedItem();
        String plotNo = Page2.plotNoField.getText();
        String district = (String) Page2.districtComboBox.getSelectedItem();
        String block = (String) Page2.blockComboBox.getSelectedItem();
        String mouza = (String) Page2.mouzaComboBox.getSelectedItem();
        String area = Page2.areaField.getText();
        String tagNumbers = Page2.addedTagNumbersArea.getText();
        String packagingDetails = Page2.packagingArea.getText();
        String challanDetails = Page2.challanDetailsArea.getText();
        String weekOfSowing = (String) Page2.weekOfSowingComboBox.getSelectedItem();
        String monthOfSowing = (String) Page2.monthOfSowingComboBox.getSelectedItem();
        //ArrayList packagingList=Page2.packagingList;



        CropData newCropData = new CropData(sourceOfSeeds, roUnitOffice, crop, variety, sourceClass, classToBeProduced, plotNo, district, block, mouza, area, tagNumbers, packagingDetails, challanDetails, weekOfSowing, monthOfSowing);
        Page2.cropDataList.add(newCropData);

        // Update the table model with the new data
        Page2.tableModel.addRow(new Object[]{sourceOfSeeds, roUnitOffice, crop, variety, sourceClass, classToBeProduced, plotNo, district, block, mouza, area, "Edit", "Remove"});

        clearAllFields();
    }

    void shiftRows(DefaultTableModel model, int index) {
        for (int i = index + 1; i < model.getRowCount(); i++) {
            model.setValueAt(model.getValueAt(i, 0), i - 1, 0);
            // Update the cropDataList as well
            Page2.cropDataList.set(i - 1, Page2.cropDataList.get(i));
        }
        // Remove the last element in the cropDataList
        Page2.cropDataList.remove(model.getRowCount() - 1);
        model.removeRow(model.getRowCount() - 1);
    }


    void removeRow(JTable table, DefaultTableModel model, int selectedRow) {
        if (selectedRow != -1 && !table.isEditing()) {
            // Remove the data from the cropDataList
            Page2.cropDataList.remove(selectedRow);

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

            // Remove the data from the cropDataList
            Page2.cropDataList.remove(selectedRow);

            model.removeRow(selectedRow);
        }
    }

    void clearAllFields() {
        Page2.sourceOfSeedsField.setText("");
        Page2.roUnitOfficeComboBox.setSelectedItem(null);
        Page2.monthOfSowingComboBox.setSelectedItem(null);
        Page2.weekOfSowingComboBox.setSelectedItem(null);
        Page2.cropComboBox.setSelectedItem(null);
        Page2.varietyComboBox.setSelectedItem(null);
        Page2.sourceClassComboBox.setSelectedItem(null);
        Page2.classToBeProducedComboBox.setSelectedItem(null);
        Page2.plotNoField.setText("");
        Page2.districtComboBox.setSelectedItem(null);
        Page2.blockComboBox.setSelectedItem(null);
        Page2.mouzaComboBox.setSelectedItem(null);
        Page2.areaField.setText("");
        Page2.lotNumberField.setText("");
        Page2.tagNumberField.setText("");
        Page2.weightPerBagField.setText("");
        Page2.numberOfBagsField.setText("");
        Page2.billReceiptField.setText("");
        Page2.addedTagNumbersArea.setText(null);
        Page2.packagingArea.setText(null);
        Page2.challanDetailsArea.setText(null);
        Page2.dateField.setDate(null);
    }

    void addPackaging(int weight,int noOfBags){
        PackagingDetails p=new PackagingDetails(weight,noOfBags);
        Page2.packagingList.add(p);
    }


}

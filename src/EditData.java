import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

public class EditData {
    void editData(int rowIndex){
        String source = (String) Page2.table.getValueAt(rowIndex, 0);
        String roname = (String) Page2.table.getValueAt(rowIndex, 1);
        String crop = (String) Page2.table.getValueAt(rowIndex, 2);
        String variety = (String) Page2.table.getValueAt(rowIndex, 3);
        String sourceclass = (String) Page2.table.getValueAt(rowIndex, 4);
        String classTobeProduced = (String) Page2.table.getValueAt(rowIndex, 5);
        String plotNo = (String) Page2.table.getValueAt(rowIndex, 6);
        String district = (String) Page2.table.getValueAt(rowIndex, 7);
        String block = (String) Page2.table.getValueAt(rowIndex, 8);
        String mouza = (String) Page2.table.getValueAt(rowIndex, 9);
        String area = (String) Page2.table.getValueAt(rowIndex, 10);

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
    }

    void addData(){
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
//            String lotNumber = lotNumberField.getText();
//            String tagNumber = tagNumberField.getText();
//            String weightPerBag = weightPerBagField.getText();
//            String numberOfBags = numberOfBagsField.getText();
//            String billReceipt = billReceiptField.getText();

        Data newData = new Data(sourceOfSeeds, roUnitOffice, crop, variety, sourceClass, classToBeProduced, plotNo, district, block, mouza, area);
        Page2.dataList.add(newData);

        // Update the table model with the new data
        Page2.tableModel.addRow(new Object[]{sourceOfSeeds, roUnitOffice, crop, variety, sourceClass, classToBeProduced, plotNo, district, block, mouza, area,"Edit","Remove"});

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

    void shiftRows(DefaultTableModel model, int index) {
        for (int i = index + 1; i < model.getRowCount(); i++) {
            model.setValueAt(model.getValueAt(i, 0), i - 1, 0);
        }
        model.removeRow(model.getRowCount() - 1);
    }
    void removeRow(JTable table, DefaultTableModel model, int selectedRow) {
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

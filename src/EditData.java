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
}

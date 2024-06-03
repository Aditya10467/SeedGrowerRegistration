import java.util.ArrayList;

public class SaveData {
    void saveData(){
            String name=Page1.nameField.getText();
            String fatherOrHusband=Page1.fatherField.getText();
            String relation=(String) Page1.relationField.getSelectedItem();
            String houseNo=Page1.houseField.getText();
            String district=(String) Page1.districtField.getSelectedItem();
            String block=(String) Page1.blockField.getSelectedItem();
            String mouza=(String) Page1.mouzaField.getSelectedItem();
            String pin=Page1.pinField.getText();
            String email=Page1.emailField.getText();
            String mobile=Page1.mobileField.getText();
            String alternateMobile=Page1.alternateMobileField.getText();
            String identification=(String)Page1.identificationField.getSelectedItem();
            ArrayList cropDataList= Page2.cropDataList;

            Data newData=new Data(name,fatherOrHusband,relation,houseNo,district,block,mouza,pin,email,mobile,alternateMobile,identification,cropDataList);
            Page2.dataList.add(newData);

    }

}

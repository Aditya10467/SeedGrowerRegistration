import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable {

    // Scalar properties from Page1 ;
    private String name;
    private String pinCode;
    private String email;
    private String mobile;
    private String alternateMobile;
    private String fatherOrHusbandOrOrganisation;
    private String houseNoOrLandMark;
    private String relation;
    private String district;
    private String block;
    private String mouza;
    private String identificationType;

    private String identificationNumber;

    // Navigational property referring to CropData
    @SerializedName("cropList")
    private ArrayList<CropData> cropDataList;

    // Constructor
    public Data(String name,String fatherOrHusbandOrOrganisation,String relation, String houseNoOrLandMark, String district, String block, String mouza,String pinCode, String email, String mobile, String alternateMobile, String identificationType,String identificationNumber, ArrayList<CropData> cropDataList) {
        this.name = name;
        this.pinCode = pinCode;
        this.email = email;
        this.mobile = mobile;
        this.alternateMobile = alternateMobile;
        this.fatherOrHusbandOrOrganisation = fatherOrHusbandOrOrganisation;
        this.houseNoOrLandMark = houseNoOrLandMark;
        this.relation = relation;
        this.district = district;
        this.block = block;
        this.mouza = mouza;
        this.identificationType = identificationType;
        this.identificationNumber=identificationNumber;
        this.cropDataList = cropDataList;
    }

    // Getters and setters for scalar properties
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAlternateMobile() {
        return alternateMobile;
    }

    public void setAlternateMobile(String alternateMobile) {
        this.alternateMobile = alternateMobile;
    }

    public String getFatherOrHusbandOrOrganisation() {
        return fatherOrHusbandOrOrganisation;
    }

    public void setFatherOrHusbandOrOrganisation(String fatherOrHusbandOrOrganisation) {
        this.fatherOrHusbandOrOrganisation = fatherOrHusbandOrOrganisation;
    }

    public String getHouseNoOrLandMark() {
        return houseNoOrLandMark;
    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", fatherOrHusbandOrOrganisation='" + fatherOrHusbandOrOrganisation + '\'' +
                ", relation='" + relation + '\'' +
                ", houseNoOrLandMark='" + houseNoOrLandMark + '\'' +
                ", district='" + district + '\'' +
                ", block='" + block + '\'' +
                ", mouza='" + mouza + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", alternateMobile='" + alternateMobile + '\'' +
                ", identificationType='" + identificationType + '\'' +
                ", identification='" + identificationNumber + '\'' +
                ", cropList= '" + cropDataList +
                '}';
    }

    public void setHouseNoOrLandMark(String houseNoOrLandMark) {
        this.houseNoOrLandMark = houseNoOrLandMark;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getMouza() {
        return mouza;
    }

    public void setMouza(String mouza) {
        this.mouza = mouza;
    }

    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    // Getters and setters for navigational properties
    public ArrayList<CropData> getCropDataList() {
        return cropDataList;
    }

    public void setCropDataList(ArrayList<CropData> cropDataList) {
        this.cropDataList = cropDataList;
    }
}

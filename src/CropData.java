import java.util.ArrayList;

public class CropData {
    String sourceOfSeeds;
    String roName;
    String crop;
    String variety;
    String sourceClass;
    String classToBeProduced;
    String plotNo;
    String district;
    String block;
    String mouza;
    String area;
    String tagNumbers;
    String packagingDetails;
    String challanDetails;
    String weekofSowing;
    String monthOfSowing;

    ArrayList<PackagingDetails> packagingList;



    public CropData(String sourceOfSeeds, String roName, String crop, String variety, String sourceClass, String classToBeProduced, String plotNo, String district, String block, String mouza, String area, String tagNumbers, String packagingDetails, String challanDetails, String weekofSowing, String monthOfSowing) {
        this.sourceOfSeeds = sourceOfSeeds;
        this.roName = roName;
        this.crop = crop;
        this.variety = variety;
        this.sourceClass = sourceClass;
        this.classToBeProduced = classToBeProduced;
        this.plotNo = plotNo;
        this.district = district;
        this.block = block;
        this.mouza = mouza;
        this.area = area;
        this.tagNumbers = tagNumbers;
        this.packagingDetails = packagingDetails;
        this.challanDetails = challanDetails;
        this.weekofSowing = weekofSowing;
        this.monthOfSowing = monthOfSowing;
        this.packagingList=packagingList;

    }

    public String getWeekofSowing() {
        return weekofSowing;
    }

    public void setWeekOfSowing(String weekofSowing) {
        this.weekofSowing = weekofSowing;
    }

    public String getMonthOfSowing() {
        return monthOfSowing;
    }

    public void setMonthOfSowing(String monthOfSowing) {
        this.monthOfSowing = monthOfSowing;
    }

    @Override
    public  String toString() {
        return "CropData{" +
                "sourceOfSeeds='" + sourceOfSeeds + '\'' +
                ", roName='" + roName + '\'' +
                ", crop='" + crop + '\'' +
                ", variety='" + variety + '\'' +
                ", sourceClass='" + sourceClass + '\'' +
                ", classToBeProduced='" + classToBeProduced + '\'' +
                ", plotNo='" + plotNo + '\'' +
                ", district='" + district + '\'' +
                ", block='" + block + '\'' +
                ", mouza='" + mouza + '\'' +
                ", area='" + area + '\'' +
                ", tagNumbers='" + tagNumbers + '\'' +
                ", packagingDetails='" + packagingDetails + '\'' +
                ", challanDetails='" + challanDetails + '\'' +
                ", monthOfSowing='" + monthOfSowing + '\'' +
                ", weekOfSowing='" + weekofSowing + '\'' +
                ", packagings='" + packagingList + '\'' +
                '}';
    }

    public String getSourceOfSeeds() {
        return sourceOfSeeds;
    }

    public void setSourceOfSeeds(String sourceOfSeeds) {
        this.sourceOfSeeds = sourceOfSeeds;
    }

    public String getRoName() {
        return roName;
    }

    public void setRoName(String roName) {
        this.roName = roName;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getSourceClass() {
        return sourceClass;
    }

    public void setSourceClass(String sourceClass) {
        this.sourceClass = sourceClass;
    }

    public String getClassToBeProduced() {
        return classToBeProduced;
    }

    public void setClassToBeProduced(String classToBeProduced) {
        this.classToBeProduced = classToBeProduced;
    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTagNumbers() {
        return tagNumbers;
    }

    public void setTagNumbers(String tagNumbers) {
        this.tagNumbers = tagNumbers;
    }

    public String getPackagingDetails() {
        return packagingDetails;
    }

    public void setPackagingDetails(String packagingDetails) {
        this.packagingDetails = packagingDetails;
    }

    public String getChallanDetails() {
        return challanDetails;
    }

    public void setChallanDetails(String challanDetails) {
        this.challanDetails = challanDetails;
    }




}

class Data {
    String sourceOfSeeds, roName, crop, variety,sourceClass,classToBeProduced,plotNo,district,block,mouza,area;

    @Override
    public String toString() {
        return "Data{" +
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
                '}';
    }

    public String getSourceOfSeeds() {
        return sourceOfSeeds;
    }

    public String getRoName() {
        return roName;
    }

    public String getCrop() {
        return crop;
    }

    public String getVariety() {
        return variety;
    }

    public String getSourceClass() {
        return sourceClass;
    }

    public String getClassToBeProduced() {
        return classToBeProduced;
    }

    public String getPlotNo() {
        return plotNo;
    }

    public String getMouza() {
        return mouza;
    }

    public String getArea() {
        return area;
    }


    public Data(String sourceOfSeeds, String roName, String crop, String variety, String sourceClass, String classToBeProduced, String plotNo, String district, String block, String mouza, String area) {
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
    }

}


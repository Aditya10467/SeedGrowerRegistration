public class PackagingDetails {
    int weight,noOfUnits;
    public PackagingDetails(int weight,int noOfUnits){
        this.weight=weight;
        this.noOfUnits=noOfUnits;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNoOfUnits() {
        return noOfUnits;
    }

    public void setNoOfUnits(int noOfUnits) {
        this.noOfUnits = noOfUnits;
    }

    @Override
    public String toString() {
        return "{" +
                "kg='" + weight + '\'' +
                ", noOfUnits='" + noOfUnits + '\'' +
                '}';
    }
}

public class PackagingDetails {
    private int weight;
    private int noOfUnits;


    public PackagingDetails(int weight, int noOfUnits) {
        this.weight = weight;
        this.noOfUnits = noOfUnits;
    }

    // Getters and Setters
    public int getWeight() { return weight; }
    public void setWeight(int kg) { this.weight = weight; }

    public int getNoOfUnits() { return noOfUnits; }
    public void setNoOfUnits(int noOfUnits) { this.noOfUnits = noOfUnits; }

    @Override
    public String toString() {
        return "PackagingDetails{" +
                "kg=" + weight +
                ", noOfUnits=" + noOfUnits +
                '}';
    }
}

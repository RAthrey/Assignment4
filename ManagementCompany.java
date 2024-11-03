public class ManagementCompany extends Object {
    static final int MAX_PROPERTY = 5;
    static final int MGMT_WIDTH = 10;
    static final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmFee;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFee = 0.0;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(x, y, width, depth);
        this.numberOfProperties = 0;
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this.name = otherCompany.name;
        this.taxID = otherCompany.taxID;
        this.mgmFee = otherCompany.mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        for (int i = 0; i < otherCompany.numberOfProperties; i++) {
            this.properties[i] = new Property(otherCompany.properties[i]);
        }
        this.numberOfProperties = otherCompany.numberOfProperties;
        this.plot = new Plot(otherCompany.plot);
    }

    public int addProperty(String name, String city, double rent, String owner) {
        if (isPropertiesFull()) {
            return -1;
        }
        Property newProperty = new Property(name, city, rent, owner);
        return addProperty(newProperty);
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        if (isPropertiesFull()) {
            return -1;
        }
        Property newProperty = new Property(name, city, rent, owner, x, y, width, depth);
        return addProperty(newProperty);
    }

    public int addProperty(Property property) {
    	if (isPropertiesFull()) {
            return -1;
        }
        if (property == null) {
            return -2;
        }
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }
        properties[numberOfProperties] = new Property(property);
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties == 0) {
            return null;
        }
        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    public double getMgmFeePer() {
        return mgmFee;
    }

    public String getName() {
        return name;
    }

    public Plot getPlot() {
        return plot;
    }

    public Property[] getProperties() {
        return properties;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    public boolean isMangementFeeValid() {
        return mgmFee >= 0 && mgmFee <= 100;
    }

    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    @Override
    public String toString() {
        String result = "List of the properties for " + name + ", taxID: " + taxID + "\n";
        result += "______________________________________________________\n";   
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                result += properties[i].toString() + "\n";
            }
        }
        result += "______________________________________________________\n\n";
        result += " total management Fee: " + String.format("%.2f", (mgmFee / 100) * getTotalRent()); 
        return result;
    }
}

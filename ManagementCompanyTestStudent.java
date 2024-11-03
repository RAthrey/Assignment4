import static org.junit.Assert.*;
import org.junit.Test;

public class ManagementCompanyTestStudent {

    @Test
    public void testDefaultConstructor() {
        ManagementCompany company = new ManagementCompany();
        assertEquals("", company.getName());
        assertEquals("", company.getTaxID());
        assertEquals(0, company.getPropertiesCount());
    }

    @Test
    public void testParameterizedConstructor() {
        ManagementCompany company = new ManagementCompany("Railey", "555555555", 10.0);
        assertEquals("Railey", company.getName());
        assertEquals("555555555", company.getTaxID());
        assertEquals(10.0, company.getMgmFeePer(), 0.01);
    }
    @Test
    public void testCopyConstructor() {
        ManagementCompany original = new ManagementCompany("OriginalCo", "123456789", 10.0, 0, 0, 10, 10);
        ManagementCompany copy = new ManagementCompany(original);
        assertEquals("OriginalCo", copy.getName());
        assertEquals("123456789", copy.getTaxID());
        assertEquals(10.0, copy.getMgmFeePer(), 0.01);
        assertEquals(original.getPlot().getX(), copy.getPlot().getX());
        assertEquals(original.getPlot().getY(), copy.getPlot().getY());
        assertEquals(original.getPlot().getWidth(), copy.getPlot().getWidth());
        assertEquals(original.getPlot().getDepth(), copy.getPlot().getDepth());
    }
    @Test
    public void testAddProperty() {
        ManagementCompany company = new ManagementCompany("Railey", "555555555", 10.0);
        int index = company.addProperty("Seaside Cottage", "Malibu", 3000.0, "Alice Brown");
        assertEquals(0, index);
        assertEquals(1, company.getPropertiesCount());
    }

    @Test
    public void testGetHighestRentProperty() {
        ManagementCompany company = new ManagementCompany("Railey", "555555555", 10.0);
        company.addProperty("Beach House", "San Diego", 5000.0, "Chris Pine");
        company.addProperty("City Loft", "Los Angeles", 4000.0, "Alex Moore");
        Property highestRentProperty = company.getHighestRentProperty();
        assertEquals("Beach House", highestRentProperty.getPropertyName());
    }

    @Test
    public void testGetTotalRent() {
        ManagementCompany company = new ManagementCompany("Railey", "555555555", 10.0);
        company.addProperty("Lakefront", "Lake Tahoe", 2000.0, "Nina West");
        company.addProperty("Penthouse", "New York", 8000.0, "James Earl");
        assertEquals(2000.0, company.getTotalRent(), 0.01);
    }
    @Test
    public void testGetPropertiesCount() {
        ManagementCompany company = new ManagementCompany("Realty Group", "987654321", 8.5);
        assertEquals(0, company.getPropertiesCount()); 
        company.addProperty("Property1", "City1", 1500, "Owner1", 0, 0, 2, 2);
        assertEquals(1, company.getPropertiesCount()); 
        company.addProperty("Property2", "City2", 2500, "Owner2", 3, 3, 2, 2);
        assertEquals(2, company.getPropertiesCount()); 
        company.addProperty("Property3", "City3", 3500, "Owner3", 6, 6, 2, 2);
        assertEquals(3, company.getPropertiesCount()); 
    }
    @Test
    public void testRemoveLastProperty() {
        ManagementCompany company = new ManagementCompany("Railey", "555555555", 10.0);
        company.addProperty("Country House", "Nashville", 1500.0, "Eliza Kings");
        assertEquals(1, company.getPropertiesCount());
        company.removeLastProperty();
        assertEquals(0, company.getPropertiesCount());
    }

    @Test
    public void testIsPropertiesFull() {
        ManagementCompany company = new ManagementCompany("Railey", "555555555", 10.0);
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            company.addProperty("Property " + i, "City " + i, 1000 + i * 100, "Owner " + i);
        }
        assertTrue(!company.isPropertiesFull());
    }

    @Test
    public void testIsManagementFeeValid() {
        ManagementCompany company = new ManagementCompany("Railey", "555555555", 10.0);
        assertTrue(company.isMangementFeeValid());
    }

    @Test
    public void testToString() {
        ManagementCompany company = new ManagementCompany("Railey", "555555555", 10.0);
        company.addProperty("Mountain Cabin", "Aspen", 2200.0, "Tom Hardy");
        String output = company.toString();
        assertTrue(output.contains("Mountain Cabin,Aspen,Tom Hardy,2200.0"));
    }
}

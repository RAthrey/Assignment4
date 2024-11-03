import static org.junit.Assert.*;
import org.junit.Test;

public class PropertyTestStudent {

    @Test
    public void testDefaultConstructor() {
        Property property = new Property();
        assertEquals("", property.getPropertyName());
        assertEquals("", property.getCity());
        assertEquals(0.0, property.getRentAmount(), 0.01);
        assertEquals("", property.getOwner());
        assertNotNull(property.getPlot());
    }

    @Test
    public void testParameterizedConstructor() {
        Property property = new Property("Ocean View", "Miami", 2500.0, "John Doe");
        assertEquals("Ocean View", property.getPropertyName());
        assertEquals("Miami", property.getCity());
        assertEquals(2500.0, property.getRentAmount(), 0.01);
        assertEquals("John Doe", property.getOwner());
        assertNotNull(property.getPlot());
    }

    @Test
    public void testParameterizedConstructorWithPlot() {
        Property property = new Property("Sunset Villa", "Los Angeles", 3000.0, "Jane Smith", 1, 2, 3, 4);
        assertEquals("Sunset Villa", property.getPropertyName());
        assertEquals("Los Angeles", property.getCity());
        assertEquals(3000.0, property.getRentAmount(), 0.01);
        assertEquals("Jane Smith", property.getOwner());
        assertEquals(1, property.getPlot().getX());
        assertEquals(2, property.getPlot().getY());
        assertEquals(3, property.getPlot().getWidth());
        assertEquals(4, property.getPlot().getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Property original = new Property("Green Acres", "Austin", 1800.0, "Anna Bell", 5, 5, 10, 15);
        Property copy = new Property(original);
        assertEquals(original.getPropertyName(), copy.getPropertyName());
        assertEquals(original.getCity(), copy.getCity());
        assertEquals(original.getRentAmount(), copy.getRentAmount(), 0.01);
        assertEquals(original.getOwner(), copy.getOwner());
        assertEquals(original.getPlot().getX(), copy.getPlot().getX());
        assertEquals(original.getPlot().getY(), copy.getPlot().getY());
        assertEquals(original.getPlot().getWidth(), copy.getPlot().getWidth());
        assertEquals(original.getPlot().getDepth(), copy.getPlot().getDepth());
    }

    @Test
    public void testGetPropertyName() {
        Property property = new Property("Cozy Cottage", "Seattle", 1200.0, "Tim Horton");
        assertEquals("Cozy Cottage", property.getPropertyName());
    }

    @Test
    public void testSetPropertyName() {
        Property property = new Property();
        property.setPropertyName("Lakeside Retreat");
        assertEquals("Lakeside Retreat", property.getPropertyName());
    }

    @Test
    public void testGetCity() {
        Property property = new Property("Luxury Condo", "San Francisco", 3500.0, "Elon Musk");
        assertEquals("San Francisco", property.getCity());
    }

    @Test
    public void testSetCity() {
        Property property = new Property();
        property.setCity("Chicago");
        assertEquals("Chicago", property.getCity());
    }

    @Test
    public void testGetRentAmount() {
        Property property = new Property("Downtown Flat", "New York", 4000.0, "Mary Lee");
        assertEquals(4000.0, property.getRentAmount(), 0.01);
    }

    @Test
    public void testSetRentAmount() {
        Property property = new Property();
        property.setRentalAmount(1500.0);
        assertEquals(1500.0, property.getRentAmount(), 0.01);
    }

    @Test
    public void testGetOwner() {
        Property property = new Property("Sunny Villa", "Miami", 2800.0, "Tom Cruise");
        assertEquals("Tom Cruise", property.getOwner());
    }

    @Test
    public void testSetOwner() {
        Property property = new Property();
        property.setOwner("Robert Downey Jr.");
        assertEquals("Robert Downey Jr.", property.getOwner());
    }

    @Test
    public void testGetPlot() {
        Property property = new Property("Forest Cabin", "Denver", 1000.0, "Sam Smith", 3, 4, 5, 6);
        assertEquals(3, property.getPlot().getX());
        assertEquals(4, property.getPlot().getY());
        assertEquals(5, property.getPlot().getWidth());
        assertEquals(6, property.getPlot().getDepth());
    }

    @Test
    public void testSetPlot() {
        Property property = new Property();
        Plot newPlot = new Plot(2, 3, 4, 5);
        property.setPlot(newPlot);
        assertEquals(newPlot, property.getPlot());
    }

    @Test
    public void testToString() {
        Property property = new Property("Blue Lagoon", "Hawaii", 5000.0, "Chris Hemsworth");
        assertEquals("Blue Lagoon,Hawaii,Chris Hemsworth,5000.0", property.toString());
    }
}

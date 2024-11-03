import static org.junit.Assert.*;
import org.junit.Test;

public class PlotTestStudent {

    @Test
    public void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        Plot plot = new Plot(2, 3, 5, 6);
        assertEquals(2, plot.getX());
        assertEquals(3, plot.getY());
        assertEquals(5, plot.getWidth());
        assertEquals(6, plot.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Plot original = new Plot(1, 1, 4, 5);
        Plot copy = new Plot(original);
        assertEquals(original.getX(), copy.getX());
        assertEquals(original.getY(), copy.getY());
        assertEquals(original.getWidth(), copy.getWidth());
        assertEquals(original.getDepth(), copy.getDepth());
    }

    @Test
    public void testGetX() {
        Plot plot = new Plot(4, 2, 3, 3);
        assertEquals(4, plot.getX());
    }

    @Test
    public void testGetY() {
        Plot plot = new Plot(4, 2, 3, 3);
        assertEquals(2, plot.getY());
    }

    @Test
    public void testGetWidth() {
        Plot plot = new Plot(4, 2, 3, 3);
        assertEquals(3, plot.getWidth());
    }

    @Test
    public void testGetDepth() {
        Plot plot = new Plot(4, 2, 3, 3);
        assertEquals(3, plot.getDepth());
    }

    @Test
    public void testSetX() {
        Plot plot = new Plot();
        plot.setX(10);
        assertEquals(10, plot.getX());
    }

    @Test
    public void testSetY() {
        Plot plot = new Plot();
        plot.setY(12);
        assertEquals(12, plot.getY());
    }

    @Test
    public void testSetWidth() {
        Plot plot = new Plot();
        plot.setWidth(15);
        assertEquals(15, plot.getWidth());
    }

    @Test
    public void testSetDepth() {
        Plot plot = new Plot();
        plot.setDepth(20);
        assertEquals(20, plot.getDepth());
    }

    @Test
    public void testOverlaps() {
        Plot plot1 = new Plot(0, 0, 5, 5);
        Plot plot2 = new Plot(3, 3, 4, 4);
        assertTrue(plot1.overlaps(plot2));
    }

    @Test
    public void testEncompasses() {
        Plot plot1 = new Plot(0, 0, 10, 10);
        Plot plot2 = new Plot(2, 2, 3, 3);
        assertTrue(plot1.encompasses(plot2));
    }

    @Test
    public void testToString() {
        Plot plot = new Plot(1, 1, 4, 5);
        assertEquals("1,1,4,5", plot.toString());
    }
}

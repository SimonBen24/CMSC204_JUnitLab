import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTrackerTest {

    private ProductSalesTracker tracker1;
    private ProductSalesTracker tracker2;

    @BeforeEach
    public void setUp() {
        tracker1 = new ProductSalesTracker(5);
        tracker2 = new ProductSalesTracker(3);
        tracker1.addSale(100.0);
        tracker1.addSale(200.0);
        tracker1.addSale(50.0);
        tracker2.addSale(300.0);
        tracker2.addSale(150.0);
    }

    @AfterEach
    public void tearDown() {
        tracker1 = null;
        tracker2 = null;
    }

    @Test
    public void testAddSale() {
        assertTrue(tracker1.addSale(75.0)); // Within capacity
        assertTrue(tracker1.addSale(120.0)); // Now full
    }


    @Test
    public void testTotalSales() {
        assertEquals(350.0, tracker1.totalSales(), 0.001);
        assertEquals(450.0, tracker2.totalSales(), 0.001);
    }

    @Test
    public void testLowestSale() {
        assertEquals(50.0, tracker1.lowestSale(), 0.001);
        assertEquals(150.0, tracker2.lowestSale(), 0.001);
    }

    @Test
    public void testFinalSalesTotal() {
        assertEquals(300.0, tracker1.finalSalesTotal(), 0.001);
        assertEquals(300.0, tracker2.finalSalesTotal(), 0.001);
    }

    @Test
    public void testToString() {
        assertEquals("100.0 200.0 50.0", tracker1.toString());
        assertEquals("300.0 150.0", tracker2.toString());
    }
}

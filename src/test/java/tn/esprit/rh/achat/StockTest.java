import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import tn.esprit.rh.achat.entities.Stock;

public class StockTest {

    private Stock stock;

    @Before
    public void setUp() {
        stock = new Stock("Test Stock", 100, 10);
    }

    @Test
    public void testIdStock() {
        stock.setIdStock(1L);
        assertEquals(1L, stock.getIdStock().longValue());
    }

    @Test
    public void testLibelleStock() {
        stock.setLibelleStock("Updated Stock");
        assertEquals("Updated Stock", stock.getLibelleStock());
    }

    @Test
    public void testQte() {
        stock.setQte(50);
        assertEquals(50, stock.getQte().intValue());
    }

    @Test
    public void testQteMin() {
        stock.setQteMin(5);
        assertEquals(5, stock.getQteMin().intValue());
    }

    @Test
    public void testStockConstructor() {
        assertNotNull(stock);
    }
}

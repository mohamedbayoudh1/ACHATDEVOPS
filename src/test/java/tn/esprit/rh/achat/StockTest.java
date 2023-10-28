package tn.esprit.rh.achat;
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

    @Test
    public void testDefaultValues() {
        Stock defaultStock = new Stock();
        assertNotNull(defaultStock);
        assertEquals(0L, defaultStock.getIdStock().longValue());
        assertEquals(null, defaultStock.getLibelleStock());
        assertEquals(0, defaultStock.getQte().intValue());
        assertEquals(0, defaultStock.getQteMin().intValue());
    }

    @Test
    public void testEquality() {
        Stock stock1 = new Stock("Test Stock", 100, 10);
        Stock stock2 = new Stock("Test Stock", 100, 10);
        assertEquals(stock1, stock2);
    }

    @Test
    public void testInequality() {
        Stock stock1 = new Stock("Stock 1", 100, 10);
        Stock stock2 = new Stock("Stock 2", 100, 10);
        assertEquals(false, stock1.equals(stock2));
    }
}
package tn.esprit.rh.achat;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {StockServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class StockTest {
    @MockBean
    private StockRepository stockRepository;
    @Autowired
    private StockServiceImpl stockService;
    @Test
    void testRetrieveAllStocks(){
        ArrayList<Stock> stockArrayList = new ArrayList<>();
        when(stockRepository.findAll()).thenReturn(stockArrayList);
        List<Stock> actualRetrieveAllStocksResult = stockService.retrieveAllStocks();
        assertSame(stockArrayList, actualRetrieveAllStocksResult);
        assertTrue(actualRetrieveAllStocksResult.isEmpty());
        verify(stockRepository).findAll();
    }
    @Test
    void testDeleteStock(){
        doNothing().when(stockRepository).deleteById((Long) any());
        stockService.deleteStock(2L);
        verify(stockRepository).deleteById((Long) any());
    }
    @Test
    void testAddStock(){
        Stock stock =new Stock();
        when(stockRepository.save(any(Stock.class))).thenReturn(stock);

        Stock actualAddStocksResult = stockService.addStock(stock);

        assertEquals(stock, actualAddStocksResult);

    }
    @Test
    void testRetrieveStock(){
        Stock stock =new Stock();


        Long id = 500L;
        when(stockRepository.findById(id)).thenReturn(Optional.of(stock));

        Stock actualRetrieveStocksResult = stockService.retrieveStock(id);

        assertEquals(stock, actualRetrieveStocksResult);

    }
    @Test
    public void testUpdateStock() {
        Stock stock = new Stock();


        when(stockRepository.save(any(Stock.class))).thenReturn(stock);

        Stock actualUpdateStocksResult = stockService.updateStock(stock);

        assertEquals(stock, actualUpdateStocksResult);
    }
}
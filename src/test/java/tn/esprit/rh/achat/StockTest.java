package tn.esprit.rh.achat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.rh.achat.controllers.StockRestController;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import java.util.UUID;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class StockTest {

    @InjectMocks
    private StockRestController stockController;

    @Mock
    private IStockService stockService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStock() throws Exception {
        // Mock the service method
        Stock stock = new Stock();
        Mockito.when(stockService.retrieveStock(1L)).thenReturn(stock);

        // Perform the GET request to /stock/retrieve-stock/{stock-id}
        mockMvc.perform(get("/stock/retrieve-stock/{stock-id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddStock() throws Exception {
        Stock stock = new Stock();
        // Mock the service method
        when(stockService.addStock(stock)).thenReturn(stock);

        // Perform the POST request to /stock/add-stock
        mockMvc.perform(post("/stock/add-stock")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"someKey\":\"someValue\"}"))  // Replace with your JSON content
                .andExpect(status().isOk());
    }

    @Test
    public void testRemoveStock() throws Exception {
        // Mock the service method
        Long stockId = 27L;
        // Use Mockito's doNothing() when dealing with void methods
        doNothing().when(stockService).deleteStock(stockId);

        // Perform the DELETE request to /stock/remove-stock/{stock-id}
        mockMvc.perform(delete("/stock/remove-stock/{stock-id}", stockId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }



    @Test
    public void testModifyStock() throws Exception {
        Stock stock = new Stock();
        // Mock the service method
        when(stockService.updateStock(stock)).thenReturn(stock);

        // Perform the PUT request to /stock/modify-stock
        mockMvc.perform(put("/stock/modify-stock")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"someKey\":\"someValue\"}"))  // Replace with your JSON content
                .andExpect(status().isOk());
    }
}

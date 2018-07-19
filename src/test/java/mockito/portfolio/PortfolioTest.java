package mockito.portfolio;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PortfolioTest {
    Portfolio portfolio;
    StockService stockService;

    @BeforeClass
    void setUp() {
        portfolio = new Portfolio();

        stockService = mock(StockService.class);
        portfolio.setStockService(stockService);

        List<Stock> stocks = new ArrayList<Stock>();
        Stock googleStock = new Stock("1","Google", 10);
        Stock microsoftStock = new Stock("2","Microsoft",100);

        stocks.add(googleStock);
        stocks.add(microsoftStock);

        //add stocks to the portfolio
        portfolio.setStocks(stocks);

        //mock the behavior of stock service to return the value of various stocks
        when(stockService.getStockPrice(googleStock)).thenReturn(50.00);
        when(stockService.getStockPrice(microsoftStock)).thenReturn(1000.00);

    }

   public void testMarketValue(){
        PortfolioTest tester = new PortfolioTest();
        double marketValue = portfolio.getMarketValue();
       Assert.assertEquals(100500.0, marketValue);
    }
}
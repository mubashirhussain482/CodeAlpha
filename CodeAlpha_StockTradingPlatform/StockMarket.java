package stocktradingplatform;
import java.util.Random;
import java.util.ArrayList;
public class StockMarket {
    private ArrayList<Stock> stocks;
    public StockMarket() {
        stocks = new ArrayList<>();
        loadStocks();
    }
    private void loadStocks() {
        stocks.add(new Stock("AAPL", "Apple Inc.", 20000));
        stocks.add(new Stock("MSFT", "Microsoft Corp.", 40000));
        stocks.add(new Stock("GOOGL", "Alphabet Inc.", 35000));
        stocks.add(new Stock("AMZN", "Amazon.com Inc.", 30000));
        stocks.add(new Stock("TSLA", "Tesla Inc.", 25000));
        stocks.add(new Stock("META", "Meta Platforms Inc.", 28000));
    }
    public ArrayList<Stock> getStocks() {
        return stocks;
    }
    public Stock findStock(String symbol) {
        for (Stock stock : stocks) {
            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }
        return null;
    }
    public void displayMarketData() {
        System.out.println();
        System.out.println("==============================================================");
        System.out.println("                    MARKET DATA");
        System.out.println("==============================================================");
        System.out.printf("%-10s %-25s %-15s %-15s%n", "Symbol", "Company", "Price", "Change");
        System.out.println("--------------------------------------------------------------");
        for (Stock stock : stocks) {
            double change = stock.getPriceChange();
            double percentage = stock.getPercentageChange();
            System.out.printf("%-10s %-25s Rs. %-10.2f %+.2f%%%n",
                    stock.getSymbol(),
                    stock.getCompanyName(),
                    stock.getCurrentPrice(),
                    percentage);
        }
        System.out.println("==============================================================");
    }
    public void updateMarketPrices() {
        Random random = new Random();
        for (Stock stock : stocks) {
            double currentPrice = stock.getCurrentPrice();
            // Random change between -5% and +5%
            double percentageChange = (random.nextDouble() * 10) - 5;
            double newPrice = currentPrice + (currentPrice * percentageChange / 100);
            // Prevent the price from becoming zero or negative
            if (newPrice < 1) {
            newPrice = 1;
            }
            stock.setCurrentPrice(newPrice);
        }
    }
}

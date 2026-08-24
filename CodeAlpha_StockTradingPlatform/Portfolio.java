package stocktradingplatform;
import java.util.ArrayList;
public class Portfolio {
    private ArrayList<Holding> holdings;
    
    public Portfolio() {
        holdings = new ArrayList<>();
    }
    public ArrayList<Holding> getHoldings() {
        return holdings;
    }
    public Holding findHolding(String symbol) {
        for (Holding holding : holdings) {
            if (holding.getStock().getSymbol().equalsIgnoreCase(symbol)) {
                return holding;
            }
        }
        return null;
    }
    public void addStock(Stock stock, int quantity, double buyPrice) {
        Holding existingHolding = findHolding(stock.getSymbol());
        if (existingHolding != null) {
            existingHolding.addShares(quantity, buyPrice);
        } else {
            Holding newHolding = new Holding(stock, quantity, buyPrice);
            holdings.add(newHolding);
        }
    }
    public boolean removeStock(String symbol, int quantity) {
        Holding holding = findHolding(symbol);
        if (holding == null) {
            return false;
        }
        if (quantity > holding.getQuantity()) {
            return false;
        }
        holding.removeShares(quantity);
        if (holding.getQuantity() == 0) {
            holdings.remove(holding);
        }
        return true;
    }
    public double getTotalValue() {
        double totalValue = 0;
        for (Holding holding : holdings) {
            totalValue += holding.getCurrentValue();
        }
        return totalValue;
    }
    public double getTotalProfitLoss() {
        double totalProfitLoss = 0;
        for (Holding holding : holdings) {
            totalProfitLoss += holding.getProfitLoss();
        }
        return totalProfitLoss;
    }
    public boolean isEmpty() {
        return holdings.isEmpty();
    }
}

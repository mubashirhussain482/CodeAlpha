package stocktradingplatform;
public class Stock {
    private String symbol;
    private String companyName;
    private double currentPrice;
    private double previousPrice;

    public Stock(String symbol, String companyName, double currentPrice) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.currentPrice = currentPrice;
        this.previousPrice = currentPrice;
    }
    public String getSymbol() {
        return symbol;
    }
    public String getCompanyName() {
        return companyName;
    }
    public double getCurrentPrice() {
        return currentPrice;
    }
    public double getPreviousPrice() {
        return previousPrice;
    }
    public void setCurrentPrice(double currentPrice) {
        this.previousPrice = this.currentPrice;
        this.currentPrice = currentPrice;
    }
    public double getPriceChange() {
        return currentPrice - previousPrice;
    }
    public double getPercentageChange() {

        if (previousPrice == 0) {
            return 0;
        }
        return ((currentPrice - previousPrice) / previousPrice) * 100;
    }
}

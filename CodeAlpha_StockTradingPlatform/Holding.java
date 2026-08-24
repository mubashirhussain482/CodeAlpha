package stocktradingplatform;
public class User {
    private int userId;
    private String username;
    private String password;
    private double cashBalance;
    private double initialBalance;
    private Portfolio portfolio;

    public User(int userId, String username, String password, double cashBalance) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.cashBalance = cashBalance;
        this.initialBalance = cashBalance;
        this.portfolio = new Portfolio();
    }
    public int getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public double getCashBalance() {
        return cashBalance;
    }
    public double getInitialBalance() {
        return initialBalance;
    }
    public Portfolio getPortfolio() {
        return portfolio;
    }
    public void addCash(double amount) {
        cashBalance += amount;
    }
    public boolean deductCash(double amount) {
        if (amount <= cashBalance) {
            cashBalance -= amount;
            return true;
        }
        return false;
    }
}

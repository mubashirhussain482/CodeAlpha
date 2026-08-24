package stocktradingplatform;
import java.util.ArrayList;
import java.util.Scanner;
public class StockTradingPlatform {
    private static Scanner scanner = new Scanner(System.in);
    private static StockMarket stockMarket;
    private static User user;
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static int transactionIdCounter = 1;
    
    private static void buyStock() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("             BUY STOCK");
        System.out.println("========================================");
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.nextLine().trim().toUpperCase();
        Stock stock = stockMarket.findStock(symbol);
        if (stock == null) {
            System.out.println("Stock not found.");
            return;
        }
        System.out.println("Company: " + stock.getCompanyName());
        System.out.printf("Current Price: Rs. %.2f%n", stock.getCurrentPrice());
        int quantity;
        double totalCost;
        while (true) {
            System.out.print("Enter quantity: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
                continue;
            }
            quantity = scanner.nextInt();
            scanner.nextLine();
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero. Please try again.");
                continue;
            }
            totalCost = stock.getCurrentPrice() * quantity;
            if (totalCost > user.getCashBalance()) {
                System.out.printf("Insufficient funds. Your balance is Rs. %.2f.%n",user.getCashBalance());
                System.out.println("Please enter a smaller quantity.");
                continue;
            }
            break;
        }
        System.out.printf("Total Cost: Rs. %.2f%n", totalCost);
        user.deductCash(totalCost);
        user.getPortfolio().addStock(stock, quantity, stock.getCurrentPrice());
        Transaction transaction=new Transaction(transactionIdCounter++,"BUY",
                stock,quantity,stock.getCurrentPrice());
        transactions.add(transaction);
        System.out.println();
        System.out.println("Stock purchased successfully!");
        System.out.println("Stock: " + stock.getSymbol());
        System.out.println("Quantity: " + quantity);
        System.out.printf("Amount Paid: Rs. %.2f%n", totalCost);
        System.out.printf("Remaining Balance: Rs. %.2f%n", user.getCashBalance());
    }
    
    private static void sellStock() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("             SELL STOCK");
        System.out.println("========================================");
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.nextLine().trim().toUpperCase();
        Stock stock = stockMarket.findStock(symbol);
        if (stock == null) {
            System.out.println("Stock not found.");
            return;
        }
        Holding holding = user.getPortfolio().findHolding(symbol);
        if (holding == null) {
            System.out.println("You do not own this stock.");
            return;
        }
        System.out.println("Company: " + stock.getCompanyName());
        System.out.printf("Current Price: Rs. %.2f%n", stock.getCurrentPrice());
        System.out.println("Owned Quantity: " + holding.getQuantity());
        int quantity;
        while (true) {
            System.out.print("Enter quantity: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.nextLine();
                continue;
            }
            quantity = scanner.nextInt();
            scanner.nextLine();
            if (quantity <= 0) {
                System.out.println("Quantity must be greater than zero. Please try again.");
                continue;
            }
            if (quantity > holding.getQuantity()) {
                System.out.println("You do not own enough shares. Please try again.");
                continue;
            }
            break;
        }
        double totalAmount = stock.getCurrentPrice() * quantity;
        boolean removed = user.getPortfolio().removeStock(symbol, quantity);
        if (!removed) {
            System.out.println("Unable to complete the sale.");
            return;
        }
        user.addCash(totalAmount);
        Transaction transaction = new Transaction(transactionIdCounter++,"SELL",
                stock,quantity,stock.getCurrentPrice());
        transactions.add(transaction);
        System.out.println();
        System.out.println("Stock sold successfully!");
        System.out.println("Stock: " + stock.getSymbol());
        System.out.println("Quantity: " + quantity);
        System.out.printf("Amount Received: Rs. %.2f%n",totalAmount);
        System.out.printf("Current Balance: Rs. %.2f%n",user.getCashBalance());
    }
    
    private static void viewPortfolio() {
        System.out.println();
        System.out.println("==========================================================================");
        System.out.println("                         MY PORTFOLIO");
        System.out.println("==========================================================================");
        Portfolio portfolio = user.getPortfolio();
        if (portfolio.isEmpty()) {
            System.out.println("Your portfolio is currently empty.");
            System.out.println("Buy some stocks to build your portfolio.");
            System.out.println("==========================================================================");
            return;
        }
        System.out.printf("%-8s %-22s %-10s %-15s %-15s %-15s %-15s%n",
                "Symbol",
                "Company",
                "Quantity",
                "Avg Buy Price",
                "Current Price",
                "Current Value",
                "Profit/Loss");
        System.out.println("--------------------------------------------------------------------------");
        for (Holding holding : portfolio.getHoldings()) {
            Stock stock = holding.getStock();
            System.out.printf("%-8s %-22s %-10d Rs. %-11.2f Rs. %-11.2f Rs. %-11.2f Rs. %-11.2f%n",
                    stock.getSymbol(),
                    stock.getCompanyName(),
                    holding.getQuantity(),
                    holding.getAverageBuyPrice(),
                    stock.getCurrentPrice(),
                    holding.getCurrentValue(),
                    holding.getProfitLoss());
        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("Total Portfolio Value: Rs. %.2f%n",portfolio.getTotalValue());
        System.out.printf("Total Profit/Loss: Rs. %.2f%n",portfolio.getTotalProfitLoss());
        System.out.println("==========================================================================");
    }
    
    private static void showPortfolioPerformance() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("        PORTFOLIO PERFORMANCE");
        System.out.println("========================================");
        double initialBalance = user.getInitialBalance();
        double currentCash = user.getCashBalance();
        double stockValue = user.getPortfolio().getTotalValue();
        double totalPortfolioValue = currentCash + stockValue;
        double profitLoss = totalPortfolioValue - initialBalance;
        double returnPercentage = (profitLoss / initialBalance) * 100;
        System.out.printf("Initial Balance:       Rs. %.2f%n", initialBalance);
        System.out.printf("Current Cash:          Rs. %.2f%n", currentCash);
        System.out.printf("Stock Value:           Rs. %.2f%n", stockValue);
        System.out.printf("Total Portfolio Value: Rs. %.2f%n", totalPortfolioValue);
        System.out.printf("Total Profit/Loss:     Rs. %.2f%n", profitLoss);
        System.out.printf("Return:                %.2f%%%n", returnPercentage);
        System.out.println("========================================");
    }
    
    private static void viewTransactionHistory() {
        System.out.println();
        System.out.println("==========================================================================");
        System.out.println("                       TRANSACTION HISTORY");
        System.out.println("==========================================================================");
        if (transactions.isEmpty()) {
            System.out.println("No transactions have been made yet.");
            System.out.println("==========================================================================");
            return;
        }
        System.out.printf("%-5s %-8s %-8s %-10s %-15s %-15s %-20s%n",
            "ID",
            "Type",
            "Stock",
            "Quantity",
            "Price",
            "Total",
            "Date & Time");
        System.out.println("--------------------------------------------------------------------------");
        for (Transaction transaction : transactions) {
            System.out.printf(
                "%-5d %-8s %-8s %-10d Rs. %-10.2f Rs. %-10.2f %-20s%n",
                transaction.getTransactionId(),
                transaction.getType(),
                transaction.getStock().getSymbol(),
                transaction.getQuantity(),
                transaction.getPrice(),
                transaction.getTotalAmount(),
                transaction.getFormattedDateTime()
            );
        }
        System.out.println("==========================================================================");
    }
    
    public static void main(String[] args) {
        stockMarket = new StockMarket();
        user = new User( 1, "Mubashir", "1234", 100000);
        System.out.println("========================================");
        System.out.println("       STOCK TRADING PLATFORM");
        System.out.println("========================================");
        System.out.println();
        System.out.println("Welcome, " + user.getUsername() + "!");
        System.out.printf("Starting Balance: Rs. %.2f%n", user.getCashBalance());
        System.out.println();
        showMenu();
    }
    private static void showMenu() {
        int choice=0;
        do {
            System.out.println();
            System.out.println("========================================");
            System.out.println("              MAIN MENU");
            System.out.println("========================================");
            System.out.println("1. View Market Data");
            System.out.println("2. Refresh Market Prices");
            System.out.println("3. Buy Stock");
            System.out.println("4. Sell Stock");
            System.out.println("5. View Portfolio");
            System.out.println("6. Portfolio Performance");
            System.out.println("7. Transaction History");
            System.out.println("8. Account Balance");
            System.out.println("9. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number from 1 to 9.");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    stockMarket.displayMarketData();
                    break;
                case 2:
                    stockMarket.updateMarketPrices();
                    System.out.println();
                    System.out.println("Market prices updated successfully!");
                    break;
                case 3:
                    buyStock();
                    break;
                case 4:
                    sellStock();
                    break;
                case 5:
                    viewPortfolio();
                    break;
                case 6:
                    showPortfolioPerformance();
                    break;
                case 7:
                    viewTransactionHistory();
                    break;
                case 8:
                    System.out.printf( "Current Balance: Rs. %.2f%n", user.getCashBalance() );
                    break;
                case 9:
                    System.out.println();
                    System.out.println("Thank you for using Stock Trading Platform.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }
}

package Deque.StockLedger;

public class Main {
    public static void main(String[] args) {

        StockLedgerInterface stockLedger = new Stockledger();


        //Buy 20 shares of AAPL at $45.
        stockLedger.buy("AAPL", 20, 45.0);

        //Buy 20 shares of AAPL at $75.
        stockLedger.buy("AAPL", 20, 75.0);

        //Buy 20 shares of MSFT at $95
        stockLedger.buy("MSFT", 20, 95.0);

        //Display
        stockLedger.displayLedger();

        //Sell 30 shares of AAPL at $65
        stockLedger.sell("AAPL", 30, 65.0);

        //Display the ledger
        stockLedger.displayLedger();

        //Sell 10 shares of AAPL at $65
        stockLedger.sell("AAPL", 10, 65.0);

        //Display the ledger
        stockLedger.displayLedger();

        //Buy 100 shares of AAPL at $20
        stockLedger.buy("AAPL", 100, 20.0);

        //Buy 20 shares of AAPL at $24
        stockLedger.buy("AAPL", 20, 24.0);

        //Buy 200 shares of TSLA at $36
        stockLedger.buy("TSLA", 200, 36.0);

        //Display the ledger
        stockLedger.displayLedger();

        //Sell 10 shares of AAPL at $65
        stockLedger.sell("AAPL", 10, 65.0);

        //Display the ledger
        stockLedger.displayLedger();

        //Sell 150 shares of TSLA at $30
        stockLedger.sell("TSLA", 150, 30.0);

        //Display the ledger
        stockLedger.displayLedger();

        //Buy 5 shares of MSFT at $60
        stockLedger.buy("MSFT", 5, 60.0);

        //Buy 5 shares of MSFT at $70
        stockLedger.buy("MSFT", 5, 70.0);

        //Display the ledger
        stockLedger.displayLedger();

        //Sell 4 shares of MSFT at $30
        stockLedger.sell("MSFT", 4, 30.0);

        //Display the ledger
        stockLedger.displayLedger();
        //Sell 2 shares of MSFT at $30
        stockLedger.sell("MSFT", 2, 30.0);

        //Display the ledger
        stockLedger.displayLedger();
    }
}

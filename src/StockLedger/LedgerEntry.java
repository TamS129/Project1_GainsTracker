package Deque.StockLedger;

import Deque.Deque.LinkedDeque;

public class LedgerEntry<T> extends LinkedDeque<T> {

    LinkedDeque<StockPurchase> deque = new LinkedDeque<>();

    private String stockSymbol;
    private LinkedDeque<StockPurchase> purchases;
    private int sharesBought;
    private double pricePerShare;


    /**
     * Constructor to be used for our Ledger Entries. It also holds our Deque of purchases.
     * @param stockSymbol
     *
     */
    public LedgerEntry(String stockSymbol){

    this.stockSymbol = stockSymbol;
    this.sharesBought = sharesBought;
    this.pricePerShare = pricePerShare;
    purchases = (LinkedDeque<StockPurchase>) new LinkedDeque<T>();

    }

    /**
     * Getter methods for all of our parameters.
     * @return stockSymbol, sharesBought, StockPurchases deque, and getPricePerShare;
     */
    public String getStockSymbol() {

        return this.stockSymbol;

    }

    public LinkedDeque<StockPurchase> getCosts(){
        return purchases;
    }
    public int getSharesBought(){

        return this.sharesBought;

    }

    public double getPricePerShare(){

        return this.pricePerShare;

    }


}

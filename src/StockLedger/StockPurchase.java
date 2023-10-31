package Deque.StockLedger;

public class StockPurchase extends Stockledger {
    private int sharesBought;
    private double pricePerShare;

    /**
        Constructor for our StockPurchases
        @param pricePerShare
        @param sharesBought
     */

    public StockPurchase(double pricePerShare, int sharesBought){
        this.sharesBought = sharesBought;
        this.pricePerShare = pricePerShare;

    }

    /**
     * Getter Methods of our parameters
     * @return sharesBought
     * @return getPricePerShare
     */

    public int getSharesBought(){

        return this.sharesBought;

    }

    public double getPricePerShare(){

        return this.pricePerShare;

    }
}

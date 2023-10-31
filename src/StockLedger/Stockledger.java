package Deque.StockLedger;


import java.util.ArrayList;
import java.util.Iterator;

public class Stockledger implements StockLedgerInterface{

    private ArrayList<LedgerEntry> ledger = new ArrayList<>();

    @Override
    /** Records a stock purchase in this ledger.
     @param stockSymbol    The stock's symbol.
     @param sharesBought   The number of shares purchased.
     @param pricePerShare  The price per share. */
    public void buy(String stockSymbol, int sharesBought, double pricePerShare) {
            //Checks to see if there is a stockSymbol in the ledger already.
            // We're going to use getEntry(stockSymbol) to check and see if we already have the stock symbol in there.
            //If we have an entry then we are going to use StockPurchase to purchase the stock.
            LedgerEntry current = getEntry(stockSymbol);

            if(current != null){
                // newPurchase will store the new Purchased Stock values
                StockPurchase newPurchase = new StockPurchase(pricePerShare, sharesBought);
                //.getCosts() will recieved the purchase values pricePerShare and sharesBought
                //.addToFront() will add it to our deque
                current.getCosts().addToFront(newPurchase);
            }
            //If we do not have a ledger within the Arraylist we add a new LedgerEntry and use StockPurchase
            else{
                //First we need to add a LedgerEntry for our StockSymbol
                LedgerEntry newEntry = new LedgerEntry(stockSymbol);
                //Same as above adding the purchases to the newEntry.
                StockPurchase newPurchase = new StockPurchase(pricePerShare, sharesBought);
                newEntry.getCosts().addToFront(newPurchase);

           }
            //testing:
        System.out.println();

    }

    @Override
    /** Removes from this ledger any shares of a particular stock
     that were sold and computes the capital gain or loss.
     @param stockSymbol    The stock's symbol.
     @param sharesSold     The number of shares sold.
     @param pricePerShare  The price per share.
     @return  The capital gain (loss). */
    public double sell(String stockSymbol, int sharesSold, double pricePerShare){
        //First we need to find the stockSymbol in our Ledger (Using our getEntry)
        LedgerEntry entry = getEntry(stockSymbol);

        //If the entry doesn't show up during the getEntry() grab it returns as null meaning there is no entry.
        if(entry == null){

            return 0.0 ;
        }
            //We get the current Availble shares through getSharesBought()
            // We take the total shares by subtracting the shares we have available with the sharesSold
            int availableSharesBought = entry.getSharesBought();
            int totalShares = availableSharesBought - sharesSold;

            //If the totalShares are less than 0 then there are not enough shares to sell, so it returns 0.0.
            if(totalShares < 0){
                return 0.0;
            }

            //OrginalPrice takes the price from the orginal deque and times it by how many shares we have.
            //thisPrice takes the price of our current pricePerShare
            double originalPrice = totalShares * entry.getPricePerShare();
            double thisPrice = totalShares * pricePerShare;

            //Finally our capital takes our orginal sell price and our current sell price and minuses it to get our gain/loss.
            double capital = originalPrice - thisPrice;

            //Removes the Entry from the ledger with purchases.
            entry.getCosts().removeBack();
        System.out.println(capital);

        //Returns the captial gain/loss.
        return capital;
    }

    @Override
    /** Returns a boolean on whether the passed in stock symbol is contained in the ledger.
     @param stockSymbol    The stock's symbol.
     @return  Boolean of if the stock exists in the ledger. */

    public boolean contains(String stockSymbol){
        //Using a for loop to search through the ledger.
        for(LedgerEntry search: ledger ){

            //Use string value and getStockSymbol() to see each of the stockSymbols in the loop
            String symbol = search.getStockSymbol();
            // if the symbol and stockSymbol match then return true. If not return false.
            if(symbol.equals(stockSymbol)){

                return true;
            }

        }
        return false;
    }

    @Override
    /**
     * Returns a LedgerEntry object based on stock symbol.
     *
     * @param stockSymbol The stock's symbol.
     * @return LedgerEntry object of stock symbol.
     */
    public LedgerEntry getEntry(String stockSymbol){

        //For loop to search the Arraylist for all the stockSymbols.
        for(LedgerEntry search: ledger){

            //Variable added to get the stockSymbol from the ledger.
            String symbol = search.getStockSymbol();

            //If the current search entry is the same as our stockSymbol we're looking for we return the entry name.
            if(symbol.equals(stockSymbol)){

                return search;
            }
        }
        //If we don't have an entry then it returns null.
        return null;
    }

    @Override
    /**
     * Displays our ArrayList Ledger to Main.
     * No parameters
     */
    public void displayLedger(){
        //A for loop to sift through the arraylist Ledger and get each entries.
        for(LedgerEntry seperateEntrys: ledger){

            //Selects the entries from the ledger and grabs the StockSymbol
            String entry = seperateEntrys.getStockSymbol();
            //Prints out the Stock Symbols
            System.out.print(entry + ": ");

            //Now we need to get the purchases deque and the iterator.
            Iterator<StockPurchase> seperateType = seperateEntrys.getCosts().iterator();

            //Traverses through the iterator until the Deque is empty.
            while(seperateType.hasNext()){

                //Goes through each of the entries in the Deque purchases (.next) and gathers the PriceperShare and sharesBought.
                StockPurchase purchases = seperateType.next();
                double pricePerShare = purchases.getPricePerShare();
                int sharesBought = purchases.getSharesBought();

                //Prints out the info in the deque:
                System.out.print( pricePerShare + "( " + sharesBought + " ), " );
            }
        }


    }


}

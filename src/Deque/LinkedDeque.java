package Deque.Deque;

import Deque.StockLedger.StockPurchase;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedDeque<T> implements DequeInterface<T> {
    private DLNode firstNode;
    private DLNode lastNode;
     T newEntry;
    /**
     * Constructor for our LinkedDeque
     * @param DLNode firstNode and lastNode
     */
    public LinkedDeque(){
        this.firstNode = null;
        this.lastNode = null;
    }

    @Override
    /** Adds a new entry to the front of this deque.
     * @param newEntry An object to be added.
     */
    public void addToFront(T newEntry) {
        DLNode newNode = new DLNode(newEntry);

        //First we need to check if the deque is empty. If it is empty then we add the newNode as the front and last Nodes.
        if(isEmpty()){
            firstNode = newNode;
            lastNode = newNode;
        }
        //If the deque is not empty we set the firstNode -> next node in deque. Then set the node before firstNode -> newNode.
        //The newNode now takes the frontNode in the deque.
        else{
            firstNode.setNextNode(firstNode);
            firstNode.setPreviousNode(newNode);
            firstNode = newNode;
        }


    }

    /** Adds a new entry to the back of this deque.
     * @param newEntry An object to be added.
     */

    @Override
    public void addToBack(T newEntry) {
        DLNode newNode = new DLNode(newEntry);
        //First we need to check if the deque isEmpty(). If it is we set both FirstNode and lastNode to newNode.
        if(isEmpty()){

            firstNode = newNode;
            lastNode = newNode;
        }
        // Sets lastNode -> previousNode. Then replace the nextNode after lastNode -> newNode. LastNode now equals newNode.
        else{

            lastNode.setPreviousNode(lastNode);
            lastNode.setNextNode(newNode);
            lastNode = newNode;

        }

    }

    @Override
    /**
     * Removes and returns the front entry of the deque.
     * @return The object at the front of the deque
     * @throws EmptyQueueException if the deque is empty.
     */

    public T removeFront() throws EmptyQueueException {
        //First we need to check if the deque is empty. And if it's empty we have to throw EmptyQueueException.
        if(isEmpty()){

            throw new EmptyQueueException();
        }
        //If the deque is not empty then we procede to remove the first node.
        else{
            //Gather the data of the firstNode to return later.
            T entry = (T) firstNode.getData();

            //Set the first node to the next Node.
            firstNode = firstNode.getNextNode();
            //Once the firstNode is set to the NextNode, we make the previous Node null to pop the old FirstNode.
            firstNode.setPreviousNode(null);

            return entry;

        }
    }

    @Override
    /**
     * Removes and returns the back entry of the deque.
     * @return The object at the back of the deque
     */
    public T removeBack() {
        //First we need to check if the deque is empty.
        if(isEmpty()){
            return null;
        }
        //If the Deque is not empty we proceed to remove the lastNode within the deque.
        else{
            //We use an object data type to find the data of the lastNode set.
            T backEntry = (T) lastNode.getData();

            //We set the last node to be the previous node and set the "next" lastNode to be popped from the deque.
           lastNode = lastNode.getPreviousNode();
           lastNode.setNextNode(null);

           //returns the lastNode.
           return backEntry;
        }
    }

    @Override
    /** Returns the front entry's data.
     * @return Entry data for front of back node.
     */
    public T getFront(){
        //First we need to check if the front of the deque is empty. If so return null.
        if(isEmpty()){
            return null;
        }
        //If the deque entry is not empty we'll set the firstNode as dataentry and return the entry.
        else{
            T entry = (T) firstNode.getData();
            return entry;
        }
    }

    @Override
    /** Returns the back entry's data.
     * @return Entry data for front of back node.
     */
    public T getBack(){
        //First we have to check if the deque is empty. If it is we return null.
        if(isEmpty()){
            return null;
        }
        //If it's not empty we grab the lastNode within the deque and return the object as a dataEntry.
        else{
            T entry = (T) lastNode.getData();
            return entry;
        }
    }

    /* Removes all entries from this deque. */
    public void clear() {
        //While the deque is not empty we'll remove each front Node.
       while(!isEmpty()){
           // Gather the first node.
           firstNode = firstNode.getNextNode();

           //If the first node is not null go to next node ->
           if(firstNode != null){

               //Set the firstNode to previous node which is null.
               firstNode.setPreviousNode(null);

           } //If the firstNode is null. We'll set the lastNode to Null
           else{
               lastNode = null;
           }
       }
    }

    @Override
    /** Detects whether this deque is empty.
     * @return True if deque is empty, or false otherwise.
     */
    public boolean isEmpty(){
        //If the firstNode of the deque is null then the deque is empty, so it returns true;
        if(firstNode == null){
            return true;
        }//If the firstNode is not null it is not empty so the code returns false.
        else{
            return false;
        }
    }


    @Override
    /** Creates iterators to iterate through deque.
     * @return Returns an iterator for use.
     */
    public Iterator<T> iterator() {
        //Pulls in the iterator class to be used and returns it
        IteratorForLinkedList<StockPurchase> irterable = new IteratorForLinkedList<>();
        return (Iterator<T>) irterable;

    }

    public Iterator<T> getIterator() {
        //Calls for iterator.
        return iterator();
    }






    /* Private Class for Iterator that will iterate through the deque into the ArrayList.
     */

    private class IteratorForLinkedList<T> {
        private DLNode temp = firstNode;

        /*
           Checks through the deque to make sure the next node is not null.
         */
        public T next(){
            //If the next Node is null it throws a noSuchElementException
            if(!hasNext()){

                throw new NoSuchElementException();
            }
            //If there is a next node we place the data of the deque into our temp node and return the dataEntry.
            T dataEntry = (T) temp.data;
            temp = temp.next;
            return dataEntry;
        }

        //Checks to see if we have another Node within the deque.
        public boolean hasNext(){

            return temp != null;

        }


    }


    /*
        Class for our DLNode contains our Nodes to traverse through the Deque
     */

    private class DLNode<T> {

        private T data;
        private DLNode next;
        private DLNode prev;

        /*
          Constructor for the DLNode
         */
        public DLNode(T data, DLNode next, DLNode prev){
            this.data = data;
            this.next = next;
            this.prev = prev;

        }
        public DLNode(T data){
            this.data = data;
            this.next = null;

        }

        /*
            Getter method for Data.
         */
        public T getData() {
            return data;
        }

        /*
            Sets new data.
         */
        public void setData(T newData){
            data = newData;

        }

        /*
            Gets the next Node in the deque.
         */
        public DLNode getNextNode(){
            return next;
        }

        /*
            Setter for next node.
         */
        public void setNextNode(DLNode nextNode){
            next = nextNode;
        }

        /*
            Getter method for the previous Node
         */
        public DLNode getPreviousNode(){
            return prev;
        }

        /*
            Setter method for the previous Node
         */
        public void setPreviousNode(DLNode prevNode){
            prev = prevNode;
        }
    }

}

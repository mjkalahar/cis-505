/* 
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package BowlingShopApp;

import java.util.LinkedList;

/*
 * Represents a generic queue data structure 
 */
public class GenericQueue<E> {
    //Linked list to hold the queue
    private LinkedList<E> list = new LinkedList<E>();

    /*
     * Adds an item to the queue
     * @param item The item to add to the queue
     */
    public void enqueue(E item) {
        list.addFirst(item);
    }

    /*
     * Removes an item from the queue
     * @return E The item removed from the queue
     */
    public E dequeue() {
        return list.removeFirst();
    }

    /*
     * Returns the size of the queue
     * @return int The size of the queue
     */
    public int size() {
        return list.size();
    }
}
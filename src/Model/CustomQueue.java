/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author binay
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * A custom queue implementation using an ArrayList
 * @param <ObjType>
 */

public class CustomQueue<ObjType> implements Iterable<ObjType> {

    private ArrayList<ObjType> data;
    private int front;
    private int rear;
    private final int maxSize; 

    /**
    * Constructs a fixed-size queue with the specified maximum size
    *
    * @param maxSize the maximum number of elements allowed in the queue
    */

    public CustomQueue(int maxSize) {
        this.data = new ArrayList<>();
        this.front = 0;
        this.rear = -1;
        this.maxSize = maxSize;
    }

    /**
    * Inserts an element at the queue from rear
    *
    * @param element the element to be added to the queue
    * @throws IllegalStateException if the queue is full
    */
    public void add(ObjType element) {
        if (size() == maxSize) {
            throw new IllegalStateException("Queue is full");
        }
        rear++;
        if (rear < data.size()) {
            data.set(rear, element);
        } else {
            data.add(element);
        }
    }

    /**
    * Removes and returns the element at the front of the queue
    *
    * @return the element at the front or null if the queue is empty
    */
    public ObjType poll() {
        if (front > rear) {
            return null;
        }
        ObjType element = data.get(front);
        front++;
        return element;
    }

    /**
    * Returns the current number of elements in the queue
    *
    * @return the size of the queue
    */
    public int size() {
        return rear - front + 1;
    }

    /**
    * Checks whether the queue is empty
    *
    * @return true if the queue is empty or false if not empty
    */
    public boolean isEmpty() {
        return front > rear;
    }

    /**
    * Adds multiple elements to the queue
    *
    * @param items the collection of elements to add
    * @throws IllegalStateException if the queue becomes full
    */
    public void addAll(Collection<ObjType> items) {
        for (ObjType item : items) {
            add(item);
        }
    }

    /**
    * Returns an iterator to traverse the elements of the queue from front to rear
    *
    * @return an iterator of the queue elements
    */
    @Override
    public Iterator<ObjType> iterator() {
        return data.subList(front, rear + 1).iterator();
    }
}

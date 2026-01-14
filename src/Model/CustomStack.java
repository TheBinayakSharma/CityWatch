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
 * A custom stack implementation using an ArrayList
 *
 * @param <ObjType> the type of elements stored in the stack
 */
public class CustomStack<ObjType> implements Iterable<ObjType> {

    private ArrayList<ObjType> data;
    private int top;
    private final int maxSize;

    /**
     * Constructs a stack with a fixed maximum size.
     *
     * @param maxSize the maximum number of elements allowed in the stack
     */
    public CustomStack(int maxSize) {
        this.data = new ArrayList<>();
        this.top = -1;
        this.maxSize = maxSize;
    }

    /**
     * Pushes an element to the top of the stack
     *
     * @param element the element to be pushed
     * @throws IllegalStateException if the stack is full
     */
    public void push(ObjType element) {
        if (top + 1 == maxSize) {
            throw new IllegalStateException("Stack overflow");
        }
        top++;
        if (top < data.size()) {
            data.set(top, element);
        } else {
            data.add(element);
        }
    }

    /**
     * Removes and returns the top element from the stack
     *
     * @return the top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public ObjType pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack underflow");
        }
        ObjType element = data.get(top);
        top--;
        return element;
    }

    /**
     * Adds all elements from the given collection in the stack
     *
     * @param items the collection of elements to add
     * @throws IllegalStateException if adding items exceeds max size
     */
    public void addAll(Collection<ObjType> items) {
        for (ObjType item : items) {
            push(item);
        }
    }

    /**
     * Returns an iterator over the elements in the stack from bottom to top
     *
     * @return an iterator for the stack elements
     */
    @Override
    public Iterator<ObjType> iterator() {
        return data.subList(0, top + 1).iterator();
    }
}

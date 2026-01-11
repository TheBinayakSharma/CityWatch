/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author binay
 */

/**
 * DataStore for the system with different data structures
 */
public class StructuralStorage {

    public static CustomStack<Civilian> civilianStack = new CustomStack<>(20);
    public static CustomStack<Organization> organizationStack = new CustomStack<>(20);
    public static CustomQueue<Task> taskQueue = new CustomQueue<>(20);
    public static LinkedList<Notice> noticeLinkedList = new LinkedList<>();
    public static ArrayList<Civilian> civilianArrayList = new ArrayList<>();
    public static ArrayList<Organization> organizationArrayList = new ArrayList<>();
    public static ArrayList<Task> tasksArrayList = new ArrayList<>();
    public static ArrayList<Task> tasksInProgressArrayList = new ArrayList<>();
    public static ArrayList<Task> tasksCompletedArrayList = new ArrayList<>();
    public static ArrayList<Notice> noticesArrayList = new ArrayList<>();
    public static CustomQueue<Notice> recentNoticesQueue = new CustomQueue<>(5);

    /**
     * Updates the civilianArrayList to reflect the current elements in the
     * civilianStack.
     */
    public static void updateCivilianArrayList() {
        civilianArrayList = new ArrayList<>();
        for (Civilian c : civilianStack) {
            civilianArrayList.add(c);
        }
    }

    /**
     * Updates the civilianArrayList to reflect the current elements in the
     * civilianStack.
     */
    public static void updateOrganizationArrayList() {
        organizationArrayList = new ArrayList<>();
        for (Organization o : organizationStack) {
            organizationArrayList.add(o);
        }
    }

    /**
     * Updates the noticesArrayList to reflect the current elements in the
     * noticeLinkedList.
     */
    public static void updateNoticesArrayList() {
        noticesArrayList = new ArrayList<>(noticeLinkedList);
    }

    /**
     * Updates the tasksArrayList to reflect the current elements in the
     * taskQueue.
     */
    public static void updateTaskArrayList() {
        tasksArrayList = new ArrayList<>();
        for (Task t : taskQueue) {
            tasksArrayList.add(t);
        }
    }

    /**
     * Adds a new notice to the recentNoticesQueue. If the queue is full (size
     * 5), removes the oldest notice first
     *
     * @param n the Notice to add to the recent queue
     */
    public static void addRecentNotice(Notice n) {
        if (recentNoticesQueue.size() == 5) {
            recentNoticesQueue.poll();
        }
        recentNoticesQueue.add(n);
    }

}

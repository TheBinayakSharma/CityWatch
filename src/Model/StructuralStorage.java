/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 *
 * @author binay
 */
public class StructuralStorage {

    public static Stack<Civilian> civilianStack = new Stack<>();
    public static Stack<Organization> organizationStack = new Stack<>();
    public static Queue<Task> taskQueue = new LinkedList<>();
    public static LinkedList<Notice> noticeLinkedList = new LinkedList<>();
    public static ArrayList<Civilian> civilianArrayList = new ArrayList<>();
    public static ArrayList<Organization> organizationArrayList = new ArrayList<>();
    public static ArrayList<Task> tasksArrayList = new ArrayList<>();
    public static ArrayList<Task> tasksInProgressArrayList = new ArrayList<>();
    public static ArrayList<Task> tasksCompletedArrayList = new ArrayList<>();
    public static ArrayList<Notice> noticesArrayList = new ArrayList<>();
    public static Queue<Notice> recentNoticesQueue = new LinkedList<>();
    
    public static void updateCivilianArrayList() {
        civilianArrayList = new ArrayList<>(civilianStack);
    }

    public static void updateOrganizationArrayList() {
        organizationArrayList = new ArrayList<>(organizationStack);
    }

    public static void updateNoticesArrayList() {
        noticesArrayList = new ArrayList<>(noticeLinkedList);
    }
    
    public static void updateTaskArrayList(){
        tasksArrayList = new ArrayList<>(taskQueue);
    }
    
    public static void addRecentNotice(Notice n) {
        if (recentNoticesQueue.size() == 5) {
            recentNoticesQueue.poll(); // remove the oldest notice
        }
            recentNoticesQueue.add(n); // add the new notice
    }

    
    
}

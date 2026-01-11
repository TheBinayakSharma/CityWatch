/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Notice;
import Model.StructuralStorage;
import static Model.StructuralStorage.recentNoticesQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
* Controller class responsible for managing notices in the system
*/
public class NoticeController {
    
    /**
* Creates a new notice 
* Adds the notice to the storage and updates the recent notices queue
*
* @param title the notice title
* @param desc the notice description
* @throws Exception if a notice with the same title and description already exists
*/

    public static void createNotice(String title, String desc) throws Exception{
        for(Notice n: getNoticeLinkedList()){
            if (n.getTitle().equalsIgnoreCase(title) && n.getDescription().equalsIgnoreCase(desc)){
                throw new Exception("Notice Already Exists");
            }
        }
        Notice not = new Notice(title, desc);
        StructuralStorage.noticeLinkedList.add(not);
        StructuralStorage.updateNoticesArrayList();
        StructuralStorage.addRecentNotice(not);
    }
    
    /**
* Retrieves the linked list of all notices in the system
*
* @return the linked list of notices
*/
    public static LinkedList<Notice> getNoticeLinkedList(){
        return StructuralStorage.noticeLinkedList;
    }
    
    /**
* Updates the title and description of an existing notice based on its ID
*
* @param noticeId the ID of the notice to update
* @param title the new title
* @param desc the new description
*/
    public static void updateNoticeLinkedList(String noticeId, String title, String desc){
        for(Notice not: StructuralStorage.noticeLinkedList){
            if(not.getNoticeId().equalsIgnoreCase(noticeId)){
                not.setTitle(title);
                not.setDescription(desc);
                break;
            }
        }
        StructuralStorage.updateTaskArrayList();
    }
    
    /**
* Removes a notice from the system based on its ID
*
* @param id the ID of the notice to remove
* @throws Exception if the notice ID is invalid
*/
    public static void removeNotice(String id) throws Exception{
        Iterator<Notice> iter = StructuralStorage.noticeLinkedList.iterator();
        while(iter.hasNext()) {
            Notice not = iter.next();
            if(not.getNoticeId().equalsIgnoreCase(id)) {
                iter.remove(); // safe removal
                StructuralStorage.updateNoticesArrayList();
                return;
            }
        }
       
       throw new Exception("Invalid Notice ID");
    }
    
    /**
* Retrieves all notices as an ArrayList
*
* @return an ArrayList containing all notices
*/
    public static ArrayList<Notice> getNoticeAL(){
        return new ArrayList<>(StructuralStorage.noticeLinkedList);
    }
    
    /**
* Retrieves the most recent notices as an ArrayList
*
* @return an ArrayList containing the recent notices
*/
    public static ArrayList<Notice> getRecentNoticesAl() {
    ArrayList<Notice> list = new ArrayList<>();
    for (Notice n : recentNoticesQueue) {
        list.add(n);
    }
    return list;
}
}

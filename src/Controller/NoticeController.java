/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Notice;
import Model.StructuralStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author binay
 */
public class NoticeController {
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
    
    public static LinkedList<Notice> getNoticeLinkedList(){
        return StructuralStorage.noticeLinkedList;
    }
    
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
    
    public static ArrayList<Notice> getNoticeAL(){
        return new ArrayList<>(StructuralStorage.noticeLinkedList);
    }
    
    public static ArrayList<Notice> getRecentNoticesAl(){
        return new ArrayList<>(StructuralStorage.recentNoticesQueue);
    }
}

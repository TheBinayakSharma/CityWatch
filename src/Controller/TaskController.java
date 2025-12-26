/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Organization;
import Model.StructuralStorage;
import Model.Task;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author binay
 */
public class TaskController {
    
    public static void createTask(String title, String desc) throws Exception{
        for(Task t: getTaskQueue()){
            if(t.getTitle().equalsIgnoreCase(title) && t.getDescription().equalsIgnoreCase(desc)){
                throw new Exception("Task Already Exists");
            }
        }
        Task tsk = new Task(title, desc);
        StructuralStorage.taskQueue.add(tsk);
        StructuralStorage.updateTaskArrayList();
    }
    
    public static Queue<Task> getTaskQueue(){
        return StructuralStorage.taskQueue;
    }
    
    public static void updateTaskQueue(String taskId, String title, String desc){
        for(Task tsk: StructuralStorage.taskQueue){
            if(tsk.getTaskId().equalsIgnoreCase(taskId)){
                tsk.setTitle(title);
                tsk.setDescription(desc);
                break;
            }
        }
        StructuralStorage.updateTaskArrayList();
    }
    
    public static void removeTask(String id) throws Exception{
        Iterator<Task> iter = StructuralStorage.taskQueue.iterator();
        while(iter.hasNext()) {
            Task t = iter.next();
            if(t.getTaskId().equalsIgnoreCase(id)) {
                iter.remove();
                StructuralStorage.updateTaskArrayList();
                return;
            }
        }
       
       throw new Exception("Invalid task ID");
    }
    
    public static ArrayList<Task> getTaskAL(){
        return new ArrayList(StructuralStorage.taskQueue);
    }
    
    public static ArrayList<Model.Task> getComTaskAL(){
        return StructuralStorage.tasksCompletedArrayList;
    }
    
    public static ArrayList<Task> getTaskIPAL(){
        return  StructuralStorage.tasksInProgressArrayList;
    }
    
    public static void takeTask(){
        Organization org = null;
        for(Organization o: StructuralStorage.organizationArrayList){
            if(o.getOrgId().equalsIgnoreCase(LoginAndRegistrationController.sessionUser)){
                org = o;
                break;
            }
        }
        
        Task taskTaken = StructuralStorage.taskQueue.poll();
        StructuralStorage.updateTaskArrayList();
        taskTaken.setAssignedTo(LoginAndRegistrationController.sessionUser);
        org.getTaskAssigned().add(taskTaken);
        StructuralStorage.tasksInProgressArrayList.add(taskTaken);
    }
}

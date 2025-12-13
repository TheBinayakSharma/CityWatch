/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.StructuralStorage;
import Model.Task;
import java.util.Iterator;
import java.util.Queue;

/**
 *
 * @author binay
 */
public class TaskController {
    
    public static void createTask(String title, String desc){
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
                iter.remove(); // safe removal
                StructuralStorage.updateTaskArrayList();
                return;
            }
        }
       
       throw new Exception("Invalid task ID");
    }
}

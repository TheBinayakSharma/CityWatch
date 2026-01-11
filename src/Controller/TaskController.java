/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CustomQueue;
import Model.Organization;
import Model.StructuralStorage;
import Model.Task;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Controller class responsible for managing tasks in the system
 */
public class TaskController {

    /**
     * Creates a new task with the specified title and description and adds it
     * to the task queue
     *
     * @param title the title of the task
     * @param desc the description of the task
     * @throws Exception if a task with the same title and description already
     * exists
     */
    public static void createTask(String title, String desc) throws Exception {
        for (Task t : getTaskQueue()) {
            if (t.getTitle().equalsIgnoreCase(title) && t.getDescription().equalsIgnoreCase(desc)) {
                throw new Exception("Task Already Exists");
            }
        }
        Task tsk = new Task(title, desc);
        StructuralStorage.taskQueue.add(tsk);
        StructuralStorage.updateTaskArrayList();
    }

    /**
     * Returns the task queue containing all unassigned tasks
     *
     * @return the CustomQueue of Task objects
     */
    public static CustomQueue<Task> getTaskQueue() {
        return StructuralStorage.taskQueue;
    }

    /**
     * Updates an existing task's title and description in the task queue
     *
     * @param taskId the ID of the task to update
     * @param title the new title
     * @param desc the new description
     */
    public static void updateTaskQueue(String taskId, String title, String desc) {
        for (Task tsk : StructuralStorage.taskQueue) {
            if (tsk.getTaskId().equalsIgnoreCase(taskId)) {
                tsk.setTitle(title);
                tsk.setDescription(desc);
                break;
            }
        }
        StructuralStorage.updateTaskArrayList();
    }

    /**
     * Removes a task from the task queue based on its ID
     *
     * @param id the ID of the task to remove
     * @throws Exception if the task ID does not exist
     */
    public static void removeTask(String id) throws Exception {
        Iterator<Task> iter = StructuralStorage.taskQueue.iterator();
        while (iter.hasNext()) {
            Task t = iter.next();
            if (t.getTaskId().equalsIgnoreCase(id)) {
                iter.remove();
                StructuralStorage.updateTaskArrayList();
                return;
            }
        }

        throw new Exception("Invalid task ID");
    }

    /**
     * Returns an ArrayList of all tasks currently in the task queue
     *
     * @return ArrayList of Task objects
     */
    public static ArrayList<Task> getTaskAL() {
        ArrayList<Task> list = new ArrayList<>();
        for (Task t : StructuralStorage.taskQueue) {
            list.add(t);
        }
        return list;
    }

    /**
     * Returns an ArrayList of all completed tasks in the system
     *
     * @return ArrayList of Task objects that are completed
     */
    public static ArrayList<Model.Task> getComTaskAL() {
        return StructuralStorage.tasksCompletedArrayList;
    }

    /**
     * Returns an ArrayList of all tasks currently in progress
     *
     * @return ArrayList of Task objects that are in progress
     */
    public static ArrayList<Task> getTaskIPAL() {
        return StructuralStorage.tasksInProgressArrayList;
    }

    /**
     * Assigns the next available task from the queue to the currently logged-in
     * organization The task is removed from the queue, added to the
     * organization's assigned task list, and tracked in the in-progress list
     */
    public static void takeTask() {
        Organization org = null;
        for (Organization o : StructuralStorage.organizationArrayList) {
            if (o.getOrgId().equalsIgnoreCase(LoginAndRegistrationController.sessionUser)) {
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

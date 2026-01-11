/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author binay
 */
/**
 * Class for task in the system
 */
public class Task {

    private final String taskId;
    private String title;
    private String assignedTo;
    private String completedBy;
    private String description;
    private final LocalDate issueDate;

    /**
     * Constructs a new Task with the specified title and description. The task
     * is assigned a unique ID and the issue date is set to the current date.
     * The assignedTo and completedBy fields are initialized as null.
     *
     * @param title the title of the task
     * @param description the description of the task
     */
    public Task(String title, String description) {
        this.taskId = "T" + UUID.randomUUID().toString().substring(0, 4);
        this.title = title;
        this.description = description;
        this.assignedTo = null;
        this.completedBy = null;
        this.issueDate = LocalDate.now();
    }

    /**
     * Returns the unique identifier of the task.
     *
     * @return the taskId as a String
     */
    public String getTaskId() {
        return this.taskId;
    }

    /**
     * Returns the title of the task.
     *
     * @return the task title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the task.
     *
     * @param title the new title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the ID of the organization or user the task is assigned to.
     *
     * @return assignedTo as a String
     */
    public String getAssignedTo() {
        return assignedTo;
    }

    /**
     * Sets the ID of the organization or user the task is assigned to.
     *
     * @param assignedTo the ID of the assignee
     */
    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    /**
     * Returns the ID of the organization or user who completed the task.
     *
     * @return completedBy as a String
     */
    public String getCompletedBy() {
        return this.completedBy;
    }

    /**
     * Sets the ID of the organization or user who completed the task.
     *
     * @param completedBy the ID of the completer
     */
    public void setCompletedBy(String completedBy) {
        this.completedBy = completedBy;
    }

    /**
     * Returns the description of the task.
     *
     * @return task description as a String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the task.
     *
     * @param description the new description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the issue date of the task.
     *
     * @return the issueDate as a LocalDate
     */
    public LocalDate getIssueDate() {
        return this.issueDate;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.UUID;
/**
 *
 * @author binay
 */
public class Task {
    private final String taskId;
    private String title;
    private String assignedTo;    
    private String completedBy;   
    private String description;
    private final Date issueDate;

    // Constructor
    public Task(String title, String description) {
        this.taskId = "T" + UUID.randomUUID().toString(); 
        this.title = title;
        this.description = description;
        this.assignedTo = null;
        this.completedBy = null;
        this.issueDate = new Date(); 
    }

    public String getTaskId() {
        return taskId;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(String completedBy) {
        this.completedBy = completedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getIssueDate() {
        return issueDate;
    }


}

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
public class Notice {
    private final String noticeId;
    private String title;
    private String description;
    private final LocalDate issueDate;
    
    // Constructor
    public Notice(String title, String description) {
        this.noticeId = "N" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        this.title = title;
        this.description = description;
        this.issueDate = LocalDate.now(); 
    }

    // Getters
    public String getNoticeId() {
        return noticeId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    

    public LocalDate getIssueDate() {
        return issueDate;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author binay
 */
public class Notice {
    private final String noticeId;
    private String title;
    private String content;
    private final String issuedBy;
    private final LocalDateTime issueDate;
    
    // Constructor
    public Notice(String title, String content, String issuedBy) {
        this.noticeId = "N" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        this.title = title;
        this.content = content;
        this.issueDate = LocalDateTime.now(); 
        this.issuedBy = issuedBy;
    }

    // Getters
    public String getNoticeId() {
        return noticeId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    
    public String getissuedBy(){
        return this.issuedBy;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}

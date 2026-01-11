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
 * Object for notice issued in the system
 */

public class Notice {
    private final String noticeId;
    private String title;
    private String description;
    private final LocalDate issueDate;
    
    /**
    * Creates a new notice with a title and description
    * Generates a unique noticeId and sets the issue date to current date
    * @param title The title of the notice.
    * @param description The description of the notice.
    */
    public Notice(String title, String description) {
        this.noticeId = "N" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
        this.title = title;
        this.description = description;
        this.issueDate = LocalDate.now(); 
    }

    /**
    * Returns the unique notice ID
    *
    * @return the noticeId
    */
    public String getNoticeId() {
        return noticeId;
    }

    /**
    * Returns the title of the notice
    *
    * @return the title
    */
    public String getTitle() {
        return title;
    }

    /**
    * Returns the description of the notice
    *
    * @return the description
    */
    public String getDescription() {
        return description;
    }
    
    /**
    * Returns the issue date of the notice
    *
    * @return the issueDate
    */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
    * Sets the title of the notice
    *
    * @param title The new title to set
    */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
    * Sets the description of the notice
    *
    * @param description The new description to set
    */

    public void setDescription(String description) {
        this.description = description;
    }
    
}

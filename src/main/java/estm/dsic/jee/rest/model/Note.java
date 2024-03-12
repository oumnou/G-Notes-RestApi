package estm.dsic.jee.rest.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "notes")
public class Note implements Serializable{
    
    @Id

    private int id;

    @ManyToOne
    @JoinColumn(name="user_is")
    private User user;
    

    
    private String dateTime;
    private String title;
    private String body;
    private String user_email;
    



    public Note() {
    }

  
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
        
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getUser_email() {
        return user_email;
    }
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    public void setId(int id) {
        this.id = id;
    }


    

}

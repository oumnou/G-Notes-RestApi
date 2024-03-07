package estm.dsic.jee.rest.model;

import java.sql.Date;


public class Note {
    
    private int id ;
    private String dateTime;
    private String title;
    private String body;
    private String user_email;
    
    public Note() {
    }



    public Note(int id ,String dateTime, String title, String body, String user_email) {
        
        this.id = id;
        this.dateTime = dateTime;
        this.title = title;
        this.body = body;
        this.user_email = user_email;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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



    @Override
    public String toString() {
        return "Note [id=" + id + ", dateTime=" + dateTime + ", title=" + title + ", body=" + body + ", user_email="
                + user_email + "]";
    }
    

}

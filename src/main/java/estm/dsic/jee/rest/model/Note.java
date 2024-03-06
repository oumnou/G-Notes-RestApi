package estm.dsic.jee.rest.model;

import java.sql.Date;


public class Note {
    
    private int id ;
    private Date dateTime;
    private String subject;
    private String body;
    private String user_email;
    
    public Note(int id ,Date dateTime, String subject, String body, String user_email) {
        
        this.id = id;
        this.dateTime = dateTime;
        this.subject = subject;
        this.body = body;
        this.user_email = user_email;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Date getDateTime() {
        return dateTime;
    }
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
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
    

}

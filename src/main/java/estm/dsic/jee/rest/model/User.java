package estm.dsic.jee.rest.model;

public class User  {
    
    public User() {
    }
    private String email;
    private String password;
    private Boolean isAdmin;
    private Boolean isValid;
    
    
    public User(String email, String password, Boolean isAdmin, Boolean isValid) {
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isValid = isValid;
    }
 
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getIsAdmin() {
        return isAdmin;
    }
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
 

}

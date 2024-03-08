package estm.dsic.jee.rest.model;

public class User  {
    
    private String username;
    private String email;
    private String password;
    private Boolean isAdmin;
    private Boolean isValid;

    public User() {
    }
    
    public User(String username,String email, String password, Boolean isAdmin, Boolean isValid) {
        this.username = username;
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
  public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

package estm.dsic.jee.rest.business.interfaces;
import estm.dsic.jee.rest.model.User;

import java.util.ArrayList;


public interface IAdmin {
    
    void validate(User user);
    void delete(User user);
    ArrayList<User> getAllUsers();
  
}

package estm.dsic.jee.rest.business.interfaces;

import estm.dsic.jee.rest.model.User;

public interface IAdmin {
    
    void validate(User user);
    void delete(User user);
  
}

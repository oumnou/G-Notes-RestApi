package estm.dsic.jee.rest.business.interfaces;

import estm.dsic.jee.rest.model.User;

public interface IUser {

    User authentification(User user);
    void signup(User user);
    
}

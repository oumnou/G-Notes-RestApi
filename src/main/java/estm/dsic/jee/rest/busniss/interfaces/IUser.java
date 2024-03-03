package estm.dsic.jee.rest.busniss.interfaces;

import estm.dsic.jee.rest.model.User;

public interface IUser {

    User authentification(User user);
    //Boolean subscription(User user);
    boolean validate(User user);
    
}

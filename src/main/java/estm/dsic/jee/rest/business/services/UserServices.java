package estm.dsic.jee.rest.business.services;

import estm.dsic.jee.rest.business.interfaces.IUser;
import estm.dsic.jee.rest.dao.UserDAO;
import estm.dsic.jee.rest.model.User;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;


/**
 * UserServices
 */

@Named
@SessionScoped
public class UserServices implements IUser, Serializable{
    
    @Inject UserDAO userDAO;


    @Override
    public User authentification(User user) {
        User userDB = userDAO.auth(user);

        if(userDB == null) {

        } else if (userDB.getIsAdmin()) {
                       
                        
        }
        return userDB;
                    
    }
          

    @Override
    public void signup(User user) {
        userDAO.create(user) ;
    }
    
}

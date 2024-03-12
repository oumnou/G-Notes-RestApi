package estm.dsic.jee.rest.business.services;

import estm.dsic.jee.rest.business.interfaces.IUser;
import estm.dsic.jee.rest.dao.UserDAOP;
import estm.dsic.jee.rest.model.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;


/**
 * UserServices
 */
@Named
@RequestScoped
public class UserServices implements IUser, Serializable{
    
     @Inject 
     UserDAOP userDAO = new UserDAOP();


    @Override
    public User authentification(User user) {
        return userDAO.searchUser(user);
        
                    
    }
          

    @Override
    public void signup(User user) {
        userDAO.insertUser(user) ;
    }
    
}

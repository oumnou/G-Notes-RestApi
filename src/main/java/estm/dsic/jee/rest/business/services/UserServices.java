package estm.dsic.jee.rest.business.services;

import estm.dsic.jee.rest.business.interfaces.IUser;
import estm.dsic.jee.rest.dao.UserDAO;
import estm.dsic.jee.rest.model.User;
import jakarta.inject.Inject;

public class UserServices implements IUser{
    
    @Inject UserDAO userDAO;


    @Override
    public User authentification(User user) {
        userDAO = new UserDAO();
        User user2 = userDAO.auth(user);

        if(user2 == null) {

        } else if (user2.getIsAdmin()) {
                       
                        
        }
        return user2;
                    
    }
          

    @Override
    public void signup(User user) {
        userDAO = new UserDAO();
        userDAO.create(user) ;
    }
    
}

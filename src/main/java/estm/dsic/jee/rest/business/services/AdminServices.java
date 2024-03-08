package estm.dsic.jee.rest.business.services;

import java.util.List;
import java.io.Serializable;

import estm.dsic.jee.rest.business.interfaces.IAdmin;
import estm.dsic.jee.rest.dao.UserDAO;
import estm.dsic.jee.rest.model.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * AdminServices
 */

@Named
@SessionScoped
public class AdminServices implements IAdmin, Serializable{
    @Inject UserDAO userDAO = new UserDAO();

    @Override
    public void validate(User user) {
        userDAO.update(user);
    }


    
    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }



    @Override
    public List<User> getAllUsers() {
       return userDAO.getAll();
    }

    public List<User> getUsers(User user) {
       return userDAO.find(user);
    }



  

}
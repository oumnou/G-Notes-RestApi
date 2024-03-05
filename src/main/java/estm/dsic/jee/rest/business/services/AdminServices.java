package estm.dsic.jee.rest.business.services;

import estm.dsic.jee.rest.business.interfaces.IAdmin;
import estm.dsic.jee.rest.dao.UserDAO;
import estm.dsic.jee.rest.model.User;
import jakarta.inject.Inject;

/**
 * AdminServices
 */
public class AdminServices implements IAdmin {
    @Inject UserDAO userDAO;




    @Override
    public void validate(User user) {
        userDAO = new UserDAO();
        userDAO.update(user);
    }


    
    @Override
    public void delete(User user) {
        userDAO = new UserDAO();
        userDAO.delete(user);
    }

}
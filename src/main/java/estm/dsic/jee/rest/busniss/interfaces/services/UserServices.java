package estm.dsic.jee.rest.busniss.interfaces.services;

import estm.dsic.jee.rest.busniss.interfaces.IUser;
import estm.dsic.jee.rest.model.User;

public class UserServices implements IUser{

    
    @Override
    public User authentification(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
        // return userDao.getUser(user);
    }

    @Override
    public Boolean subscription(User user) {
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
        // return userDao.getUserByEmail(user);
    }

    @Override
    public boolean validate(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validate'");
    }
    
}
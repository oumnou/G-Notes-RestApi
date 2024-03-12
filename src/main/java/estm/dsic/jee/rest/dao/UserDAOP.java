package estm.dsic.jee.rest.dao;

import java.util.List;


import estm.dsic.jee.rest.model.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Named
@RequestScoped
@Transactional
public class UserDAOP {

    @PersistenceContext(name="g-notes")
    private EntityManager em;

    // Insert
    public void insertUser(User user) {
        em.persist(user);
    }

    //Search Update
    public User searchUser(User user) {
        User u = em.find(User.class, 1);
        return u;
        // u.setUsername("Oumaima");    
        // em.merge(user);
    }

    public void removeUser(User user) {
            em.remove(user);
        
    }

    // Select all users
    public List<User> getAllUsers() {
        Query query = em.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }
}

package estm.dsic.jee.rest.dao;

import java.util.List;

import estm.dsic.jee.rest.model.Note;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Named
@RequestScoped
@Transactional
public class NoteDAOP {
    

    @PersistenceContext(name = "g-notes")
    
    private EntityManager em;

    // Insert
    public void insertNote(Note note) {
        System.out.println(em);
        em.persist(note);
    }

    //Search
    public void searchNote(Note note) {
        Note u = em.find(Note.class, 1);
        u.setTitle("Oumaima");

    }

    // Search and update
    public void updateNote(Note note) {
        em.merge(note);
    }

    public void removeNote(Note note) {
            em.remove(note);
        
    }

    // Select all users
    @SuppressWarnings("unchecked")
    public List<Note> getAllNotes() {
        Query query = em.createQuery("SELECT n FROM Note n");
        return query.getResultList();
    }
}
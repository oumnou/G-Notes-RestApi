package estm.dsic.jee.rest.business.services;

import java.io.Serializable;
import java.util.List;

import estm.dsic.jee.rest.business.interfaces.INote;
import estm.dsic.jee.rest.dao.NoteDAO;
import estm.dsic.jee.rest.model.Note;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * NoteServices
 */

@Named
@SessionScoped
public class NoteServices implements INote, Serializable{

    @Inject NoteDAO noteDAO ;

    @Override
    public Note addNote(Note note) {
       return noteDAO.create(note) ;
        
    }

    @Override
    public void deleteNote(Note note) {
        noteDAO.delete(note) ;
    }

    @Override
    public void updateNote(Note note) {
       noteDAO.update(note) ;
    }

    @Override
    public List<Note> getNotes(String email) {
        return noteDAO.getAll(email);
    }


    
}

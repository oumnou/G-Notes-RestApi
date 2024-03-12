package estm.dsic.jee.rest.business.services;

import java.io.Serializable;
import java.util.List;

import estm.dsic.jee.rest.business.interfaces.INote;
import estm.dsic.jee.rest.dao.NoteDAOP;
import estm.dsic.jee.rest.model.Note;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


/**
 * NoteServices
 */

@Named
@RequestScoped
public class NoteServices implements INote, Serializable{

    @Inject
     NoteDAOP noteDAO = new NoteDAOP();

    @Override
    public void addNote(Note note) {
        noteDAO.insertNote(note) ;
        
    }

    @Override
    public void deleteNote(Note note) {
        noteDAO.removeNote(note) ;
    }

    @Override
    public void updateNote(Note note) {
       noteDAO.updateNote(note) ;
    }

    @Override
    public List<Note> getNotes(String email) {
        return noteDAO.getAllNotes();
    }


    
}

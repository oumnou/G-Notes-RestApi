package estm.dsic.jee.rest.business.services;

import java.util.ArrayList;

import estm.dsic.jee.rest.business.interfaces.INote;
import estm.dsic.jee.rest.dao.NoteDAO;
import estm.dsic.jee.rest.model.Note;
import jakarta.inject.Inject;

/**
 * NoteServices
 */


public class NoteServices implements INote{

    @Inject NoteDAO noteDAO ;

    @Override
    public void addNote(Note note) {
        noteDAO.create(note) ;

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
    public ArrayList<Note> getNotes(String email) {
        return noteDAO.getNotes(email);
    }


    
}

package estm.dsic.jee.rest.business.interfaces;

import estm.dsic.jee.rest.model.Note;
import java.util.ArrayList;

public interface INote {
    
    void addNote(Note note);
    void deleteNote(Note note);
    void updateNote(Note note);
    ArrayList<Note> getNotes(String email);
}

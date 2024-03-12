package estm.dsic.jee.rest.business.interfaces;

import estm.dsic.jee.rest.model.Note;
import java.util.List;

public interface INote {
    
    void addNote(Note note);
    void deleteNote(Note note);
    void updateNote(Note note);
    List<Note> getNotes(String email);
}

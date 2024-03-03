package estm.dsic.jee.rest.busniss.interfaces;

import estm.dsic.jee.rest.model.Note;

public interface INote {
    
    Note addNote(Note note);
    Note deleteNote(Note note);
    Note updateNote(Note note);
}

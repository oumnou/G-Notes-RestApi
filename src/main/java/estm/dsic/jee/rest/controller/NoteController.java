package estm.dsic.jee.rest.controller;

import estm.dsic.jee.rest.business.services.NoteServices;
import estm.dsic.jee.rest.model.Note;

import java.util.ArrayList;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/notes")
public class NoteController {


    NoteServices noteServices;

    @POST
    @Path("/addNotes")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addNote(Note note) {
       
        noteServices.addNote(note);

    }


    @GET
    @Path("/getNotes")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Note> getNotes(String email) {

        return noteServices.getNotes(email);
        
    }



    @POST
    @Path("/updateNote")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateNote(Note note) {
        
        noteServices.updateNote(note);
           
    }
}


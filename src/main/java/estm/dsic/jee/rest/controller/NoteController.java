package estm.dsic.jee.rest.controller;

import estm.dsic.jee.rest.business.services.NoteServices;
import estm.dsic.jee.rest.model.Note;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/notes")
public class NoteController { 
    
    @Inject NoteServices noteServices;

    @POST
    @Path("/addNote")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Note addNote(Note note) {
        System.out.println(note);
       
        return noteServices.addNote(note);


    }


@GET
@Path("/getNotes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public List<Note> getNotes(@QueryParam("user_email") String email) {

    return noteServices.getNotes(email);
}


    @POST
    @Path("/updateNote")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateNote(Note note) {

        noteServices.updateNote(note);
           
    }

    // http://localhost:9040/

    @POST
    @Path("/deleteNote")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteNote(Note note) {

        noteServices.deleteNote(note);
           
    }
}


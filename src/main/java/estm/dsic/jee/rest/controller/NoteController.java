package estm.dsic.jee.rest.controller;

import estm.dsic.jee.rest.dao.NoteDAO.NoteDAO;
import estm.dsic.jee.rest.model.Note;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.util.ArrayList;

import jakarta.annotation.Resource;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/notes")

public class NoteController {
    @Resource(lookup = "jdbc/myDB")
    private DataSource dataSource;

    NoteDAO noteDAO;

    @POST
    @Path("/addNotes")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNote(Note note) {
        
            try (Connection connection = dataSource.getConnection()) {
                
                if (dataSource != null) {
                    noteDAO = new NoteDAO(connection);
                    noteDAO.create(note) ;
                } 
            
            } catch (SQLException e) {
                e.printStackTrace();

                // Handle database errors
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Database error").build();
            }
         
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Added succ").build();

}


    @GET
    @Path("/getNotes")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Note> getNotes(String email) {
        
            try (Connection connection = dataSource.getConnection()) {
                if (dataSource != null) {
                    noteDAO = new NoteDAO(connection);
                    
                    return noteDAO.getNotes(email);
                                            
                } else {
                
                
            }

                
            } catch (SQLException e) {
                e.printStackTrace();

            }
            return null;
 
        
        }



    @POST
    @Path("/updateNote")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateNote(Note note) {
        
            try (Connection connection = dataSource.getConnection()) {
                
                if (dataSource != null) {
                    noteDAO = new NoteDAO(connection);
                    noteDAO.update(note);
                } 
            
            } catch (SQLException e) {
                e.printStackTrace();

                // Handle database errors
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Database error").build();
            }
         
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("updated succ").build();

}
}


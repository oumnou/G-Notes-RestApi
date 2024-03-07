package estm.dsic.jee.rest.dao;

import java.util.List;
import java.util.ArrayList;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import estm.dsic.jee.rest.model.Note;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class NoteDAO implements Reposistory<Note,String> {
   
   @Resource(lookup="jdbc/myDB")
    private DataSource dataSource;

    public NoteDAO(){
        super();
    }

    public List<Note> getNotes(String user_email)  {
             
        String query = "SELECT * FROM note where user_email = ?";
        try(Connection connection = dataSource.getConnection();) {
            
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, user_email);
                ResultSet resultSet = statement.executeQuery() ;

                List<Note> notes = new ArrayList<>();
                
                if (resultSet.next()) {
                    
                   notes.add(
                    new Note(
                    resultSet.getInt("id"),             
                    resultSet.getString("date"),
                    resultSet.getString("title"),
                    resultSet.getString("body"),
                    resultSet.getString("user_email")
                    ));
                }

                return notes;
            
               
        } catch (Exception e) {
           
          e.printStackTrace();
            return null;
        }
    }
    
   
    
    @Override
    public Note create(Note note) {
        String query = "INSERT INTO note (body, title, user_email, date) VALUES (?, ?, ?, ?)";
        return executeQueryAndGetNote(query, note.getBody(), note.getTitle(), note.getUser_email(), note.getDateTime());
    }
    
    @Override
    public void delete(Note note) {
        String query = "DELETE FROM note WHERE user_email = ? AND id = ?";
        executeQueryAndGetNote(query, note.getUser_email(), note.getId());
    }
    
    @Override
    public void update(Note note) {
        String query = "UPDATE note SET body = ?, title = ?, date = ? WHERE user_email = ? AND id = ?";
        executeQueryAndGetNote(query, note.getBody(), note.getTitle(), note.getDateTime(), note.getUser_email(), note.getId());
    }
    
    
      
    @Override
    public Note auth(Note entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'auth'");
    }

    @Override
    public Note find(Note entity, String index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }
     
    private Note executeQueryAndGetNote(String query, Object... params) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            
            // Set parameters
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
    
            // Execute query
            int affectedRows = statement.executeUpdate();
    
            if (affectedRows == 0) {
                throw new SQLException("Operation failed, no rows affected.");
            }
    
            // Retrieve generated keys if any
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    Note note = new Note();
                    note.setId(id);
                    return note; // Return the Note object with the inserted id
                } else {
                    throw new SQLException("Operation failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if operation fails
    }
 }

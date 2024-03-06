package estm.dsic.jee.rest.dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import estm.dsic.jee.rest.model.Note;


public class NoteDAO implements Reposistory<Note,String> {
   
    Connection connection ;

    public NoteDAO(Connection connection){
        this.connection = connection;
    }

    public ArrayList<Note> getNotes(String user_email )  {
             
        String query = "SELECT * FROM note where user_email = ?";
        try {
            
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, user_email);
                ResultSet resultSet = statement.executeQuery() ;

                ArrayList<Note> notes = new ArrayList<>();
                
                if (resultSet.next()) {
                    
                   notes.add(
                    new Note(
                    resultSet.getInt(0),             
                    resultSet.getDate("date"),
                    resultSet.getString("subject"),
                    resultSet.getString("body"),
                    resultSet.getString("user_email")
                    ));
                }

                return notes;
            
               
        } catch (Exception e) {
           
          return null;

        }
    }
   
   
    @Override
    public void create(Note note) {
        String query = "INSERT INTO note(id, date, subject, body, user_email ) VALUES (?,?,?,?,?)";
            
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setInt(1, 0);
            statement.setDate(2, note.getDateTime());
            statement.setString(4, note.getBody());
            statement.setString(3, note.getSubject());
            statement.setString(5, note.getUser_email());

            statement.executeUpdate();
        } catch (Exception e) {
            
        }
    
    }
  

    @Override
    public void delete(Note note) {
        String query = "Delete * FROM note where email = ? and id = ?";
            

        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, note.getUser_email());
            statement.setInt(1, note.getId());
            
            statement.executeQuery();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
      
    }

    @Override
    public void update(Note entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
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
     

 }

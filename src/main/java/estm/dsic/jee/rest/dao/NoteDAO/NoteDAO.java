package estm.dsic.jee.rest.dao.NoteDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import estm.dsic.jee.rest.model.Note;

public class NoteDAO {
    
   
    Connection connection ;

    public NoteDAO(Connection connection){
        this.connection = connection;
    }

    public Note getNote(String id ,String id_user )  {
     
        String query = "SELECT * FROM notes where id = ? AND id_user = ?";
        try {
            
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, id);
                statement.setString(2, id_user);
                ResultSet resultSet = statement.executeQuery() ;

                if (resultSet.next()) {
                   return new Note(
                
                    resultSet.getInt("id"),
                    resultSet.getDate("date"),
                    resultSet.getString("subject"),
                    resultSet.getString("body"),
                    resultSet.getInt("idUser")
                    );
                }
            
               
        } catch (Exception e) {
           
          return null;

        }
        return null;
    }
   
    public Note addNote(Note note) {   
        String query = "INSERT INTO note(id, date, subject, body, user_id ) VALUES (?,?,?,?,?)";
        
       return null;

        
    }
      
     

 }

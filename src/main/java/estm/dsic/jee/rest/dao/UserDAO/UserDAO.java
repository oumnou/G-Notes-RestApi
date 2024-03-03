package estm.dsic.jee.rest.dao.UserDAO;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import estm.dsic.jee.rest.model.User;


public class UserDAO {
    
    
    Connection connection ;

    public UserDAO(Connection connection){
        this.connection = connection;
    }


    public User getUser(String email , String password)  {
     
        String query = "SELECT * FROM user where email = ? AND password = ?";

      
        try {
            

                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, email);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery() ;

                if (resultSet.next()) {
                   return new User(
                
                    resultSet.getInt("id"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getBoolean("isAdmin"));
                }
            
               
        } catch (Exception e) {
           
          return null;

        }
        return null;
    }
   


    public  User addUser(User user) throws SQLException {   
        String query = "INSERT INTO user(id,email, password, isAdmin ) VALUES (?,?,?,?)";
        
    


            String password = user.getPassword();
            String email = user.getEmail();
            int id = user.getId();
            Boolean isAdmin = user.getIsAdmin();
            
            PreparedStatement statement = connection.prepareStatement(query);
                
                statement.setInt(1, id);
                statement.setString(2, email);
                statement.setString(3, password);
                statement.setBoolean(4, isAdmin);

                statement.executeUpdate();
                return new User(
                    id,
                    email,
                    password,
                    isAdmin);

   }

      
   
     boolean emailExists(String email) throws SQLException {
        String query = "SELECT * FROM user_accounts WHERE email = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery() ;

        if (resultSet.next()) {
            return true;
        }

        return false;
    }

    public User getUserByEmail( String email)  {
     
        String query = "SELECT * FROM user where email = ? ";

      
        try {
            

                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery() ;

                if (resultSet.next()) {
                   return new User(
                    resultSet.getInt("id"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getBoolean("isAsmin"));
                }
            
               
        } catch (Exception e) {
           
          return null;

        }
        return null;
    }




}
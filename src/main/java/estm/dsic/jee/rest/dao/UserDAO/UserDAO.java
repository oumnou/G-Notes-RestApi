package estm.dsic.jee.rest.dao.UserDAO;

import estm.dsic.jee.rest.dao.Reposistory;
import estm.dsic.jee.rest.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserDAO implements Reposistory<User,String>{
    
    
    Connection connection ;

    public UserDAO(Connection connection){
        this.connection = connection;
    }
             
    @Override
    public void create(User user) {   
        String query = "INSERT INTO user(id,user_email, password, isAdmin ) VALUES (?,?,?,?)";
    
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, 0);
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());
                statement.setBoolean(4, false);

                statement.executeUpdate();

                // return new User(
                //     id,
                //     email,
                //     password,
                //     isAdmin);
            } catch (SQLException e) {
                e.printStackTrace();
            }

   }


    @Override
    public User auth(User entity) {
       return find(entity, null);
    }


    @Override
    public User find(User user, String index) {
      
        String query = "SELECT * FROM user where user_email = ? AND password = ?";

      
        try {
            

                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getPassword());
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


    @Override
    public void delete(User user) {
        String query = "DELETE FROM user WHERE user_email = ?";
            
            PreparedStatement statement;
            try {
                statement = connection.prepareStatement(query);
                statement.setString(1, user.getEmail());
                statement.execute();
            
            } catch (SQLException e) {
                e.printStackTrace();
            }
          

        
    
}

    @Override
    public void update(User user) {
       
        String query = "UPDATE user SET isAdmin = 1 WHERE user_email = ?";
        
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
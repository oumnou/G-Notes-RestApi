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
        String query = "INSERT INTO user(id,email, password, isAdmin ) VALUES (?,?,?,?)";
    
            String password = user.getPassword();
            String email = user.getEmail();
            int id = user.getId();
            Boolean isAdmin = user.getIsAdmin();
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.setString(2, email);
                statement.setString(3, password);
                statement.setBoolean(4, isAdmin);

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
      
        String query = "SELECT * FROM user where email = ? AND password = ?";

      
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
        String query = "Delete * FROM user where email = ?";
            

            PreparedStatement statement;
            try {
                statement = connection.prepareStatement(query);
                statement.setString(1, user.getEmail());
                ResultSet resultSet = statement.executeQuery();
            
            } catch (SQLException e) {
                e.printStackTrace();
            }
          

        
    
}






    @Override
    public void update(User entity, String index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }





}
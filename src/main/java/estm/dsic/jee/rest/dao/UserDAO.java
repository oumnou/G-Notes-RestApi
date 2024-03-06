package estm.dsic.jee.rest.dao;

import estm.dsic.jee.rest.model.User;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

import java.sql.ResultSet;


@ApplicationScoped
public class UserDAO implements Reposistory<User,String>{
    
    @Resource(lookup="jdbc/myDB")
     private DataSource dataSource;

     private  Connection connection;
      public UserDAO(){
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      }

    @Override
    public void create(User user) {   
        String query = "INSERT INTO user(user_email, password, isAdmin, isValid) VALUES (?,?,?,?)";         
        try (Connection connectiont = dataSource.getConnection();) {
            
            
            PreparedStatement statement = connectiont.prepareStatement(query);
            
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setBoolean(3, false);
            statement.setBoolean(4, false);

            statement.executeUpdate();

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

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            ResultSet resultSet = statement.executeQuery() ;

            if (resultSet.next()) {

                return new User(

                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getBoolean("isAdmin"),
                    resultSet.getBoolean("isValid"));
                
                }
            
               
        }catch (Exception e) {
           
          return null;

        }

        return null;
    }


    @Override
    public void delete(User user) {
        String query = "DELETE FROM user WHERE user_email = ?";

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);

            
            statement.setString(1, user.getEmail());
            statement.execute();
            
            }catch (SQLException e) {
                e.printStackTrace();
            }
          
}

    @Override
    public void update(User user) {
       
       
        String query = "UPDATE user SET isAdmin = 1 WHERE user_email = ?";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<User> getAllUsers() {

        String query = "SELECT * FROM user"; 
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery() ;
             ArrayList<User> users = new ArrayList<>();
                    
                    if (resultSet.next()) {
                        
                       users.add(
                        new User(
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("isAdmin"),
                        resultSet.getBoolean("isValid")

                        ));
                    }

                    return users;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;


            


}
}
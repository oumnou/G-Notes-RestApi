package estm.dsic.jee.rest.dao;

import estm.dsic.jee.rest.model.User;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;
import java.sql.ResultSet;


@Named
@RequestScoped
public class UserDAO implements Reposistory<User,String>{
    
    @Resource(lookup="jdbc/myDB")
    private DataSource dataSource;
    private Connection connection;

    @Override
    public void create(User user) {   
        

        try {

            if (connection == null) {
                connection = dataSource.getConnection();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO user(user_email, password, isAdmin ) VALUES (?,?,?)";
    
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getPassword());
                statement.setBoolean(3, false);

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
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      
        String query = "SELECT * FROM user where user_email = ? AND password = ?";

      
        try {
            

                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, user.getEmail());
                statement.setString(2, user.getPassword());
                ResultSet resultSet = statement.executeQuery() ;

                if (resultSet.next()) {

                   return new User(
                
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
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        try {
          
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
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
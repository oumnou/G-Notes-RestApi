package estm.dsic.jee.rest.dao;

import estm.dsic.jee.rest.model.User;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

import java.sql.ResultSet;

@Named
@ApplicationScoped
public class UserDAO implements Reposistory<User,String>{
    
    @Resource(lookup="jdbc/myDB")
     private DataSource dataSource;

      public UserDAO(){
        super();
      }

    @Override
    public User create(User user) {   
        String query = "INSERT INTO user(username,user_email, password, isAdmin, isValid) VALUES (?,?,?,?,?)";         
        try (Connection connectiont = dataSource.getConnection();) {
            
            
            PreparedStatement statement = connectiont.prepareStatement(query);
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setBoolean(4, false);
            statement.setBoolean(5, false);
            statement.setString(1, user.getUsername());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
                
        return null;
    } 
   


    public User auth(User user) {
        String query = "SELECT * FROM user where user_email = ? And password = ? ";

        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            ResultSet resultSet = statement.executeQuery() ;

 
            if (resultSet.next()) {

                return new User(

                    resultSet.getString("username"),
                    resultSet.getString("user_email"),
                    "",
                    resultSet.getBoolean("isAdmin"),
                    resultSet.getBoolean("isValid"))
                    ;
                
                }
               
        }catch (Exception e) {
           
          e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<User> find(User user) {
        if (user.getUsername() == "") {
            return getAll();
            
        }
        String query = "SELECT * FROM user WHERE username LIKE ?";

        try {

            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getUsername());
            ResultSet resultSet = statement.executeQuery() ;

            List<User> users = new ArrayList<>();
 
            if (resultSet.next()) {

                User userD = new User(

                    resultSet.getString("username"),
                    resultSet.getString("user_email"),
                    "",
                    false,
                    true
                    );

                    users.add(userD);
                
                }
            return users;
               
        }catch (Exception e) {
           
          e.printStackTrace();

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
       
       
        String query = "UPDATE user SET isValid = ? WHERE user_email = ?";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(2, user.getUsername());
            statement.setBoolean(1, !user.getIsValid());
            statement.executeUpdate();
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAll() {

        String query = "SELECT * FROM user"; 
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery() ;
             List<User> users = new ArrayList<>();
                    
                    while (resultSet.next()) {
                        
                        User userD = new User(                      
                            
                        resultSet.getString("username"),
                        resultSet.getString("user_email"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("isAdmin"),
                        resultSet.getBoolean("isValid")

                        );
                        users.add(userD);
                    }

                    return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


            


}

   
}

/**
    JAS : For security
    DAO ABSTRACT
    ResultSet Meta data
    Default in interface : to remove the redundant in the methods implemented
    Factory
 */



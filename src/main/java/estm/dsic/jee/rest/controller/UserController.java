package estm.dsic.jee.rest.controller;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import estm.dsic.jee.rest.dao.UserDAO.UserDAO;
import estm.dsic.jee.rest.model.User;

import jakarta.annotation.Resource;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")

public class UserController {
    @Resource(lookup = "jdbc/myDB")
    private DataSource dataSource;

    UserDAO userDAO;

    @POST
    @Path("/signup")

    @Consumes(MediaType.APPLICATION_JSON)
    public Response signup(String userjson) {
        
        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
    
            // Parse JSON string to JsonNode
            JsonNode jsonNode = objectMapper.readTree(userjson);
    
            // Extract user information from JSON
            String email = jsonNode.get("email").asText();
            String password = jsonNode.get("password").asText();
            
    
    
            // Create a User object
            User user = new User(0,email, password,false);
    
            // Add the user to the database
            try (Connection connection = dataSource.getConnection()) {
                if (dataSource != null) {
                    userDAO = new UserDAO(connection);
                    if(userDAO.addUser(user) == null) {
                        System.out.println();
                    }
                }
               else{
                    System.out.println("Couldn't connect to database");
               }
    
                
            } catch (SQLException e) {
                e.printStackTrace();

                // Handle database errors
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Database error").build();
            }
    
            // Return a success response
            return Response.status(Response.Status.OK).entity("User added successfully").build();
        
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // Handle JSON parsing errors
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid JSON data").build();
        }
  
}
}
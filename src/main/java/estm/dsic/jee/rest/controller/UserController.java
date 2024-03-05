package estm.dsic.jee.rest.controller;

import estm.dsic.jee.rest.dao.UserDAO.UserDAO;
import estm.dsic.jee.rest.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
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
    public Response signup(User user) {
        
            try (Connection connection = dataSource.getConnection()) {
                
                if (dataSource != null) {
                    userDAO = new UserDAO(connection);
                    userDAO.create(user) ;
                } 
            
            } catch (SQLException e) {
                e.printStackTrace();

                // Handle database errors
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Database error").build();
            }
         
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Added succ").build();

}


    @GET
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        
            try (Connection connection = dataSource.getConnection()) {
                if (dataSource != null) {
                    userDAO = new UserDAO(connection);
                    User user2 = userDAO.auth(user);

                    if(user2 == null) {
                        return Response.status(Response.Status.OK).entity("User is null").build();

                    } else if (user2.getIsAdmin()) {
                        return Response.status(Response.Status.OK).entity("Admin").build();
                       
                        
                    }else {
                        return Response.status(Response.Status.OK).entity("No").build();

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
            return Response.status(Response.Status.OK).entity("User is here").build();
        
        }


        
  
}

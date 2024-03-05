package estm.dsic.jee.rest.controller;

import estm.dsic.jee.rest.dao.UserDAO.UserDAO;
import estm.dsic.jee.rest.model.User;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/admins")

public class AdminController {
    @Resource(lookup = "jdbc/myDB")
    private DataSource dataSource;

    UserDAO userDAO;
    
    
    @POST
    @Path("/validateUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validateUser(User user) {
        
            try (Connection connection = dataSource.getConnection()) {
                
                if (dataSource != null) {
                    userDAO = new UserDAO(connection);
                    userDAO.update(user);
                    
                } 
            
            } catch (SQLException e) {
                e.printStackTrace();

                // Handle database errors
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Database error").build();
            }
         
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Updated succ").build();

}



@POST
    @Path("/deleteUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(User user) {
        
            try (Connection connection = dataSource.getConnection()) {
                
                if (dataSource != null) {
                    userDAO = new UserDAO(connection);
                    userDAO.delete(user);
                    
                } 
            
            } catch (SQLException e) {
                e.printStackTrace();

                // Handle database errors
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Database error").build();
            }
         
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Updated succ").build();

}


}

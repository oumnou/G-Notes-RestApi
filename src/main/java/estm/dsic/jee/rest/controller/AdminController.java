package estm.dsic.jee.rest.controller;

import estm.dsic.jee.rest.business.services.AdminServices;
import estm.dsic.jee.rest.dao.UserDAO;
import estm.dsic.jee.rest.model.User;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/admins")

public class AdminController {

    UserDAO userDAO;
    
    
    @POST
    @Path("/validateUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void validateUser(User user) {
        AdminServices adminServices = new AdminServices();

        adminServices.validate(user);
           
    }



    @POST
    @Path("/deleteUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(User user) {
        AdminServices adminServices = new AdminServices();

        adminServices.delete(user);

    }

}
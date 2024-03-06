package estm.dsic.jee.rest.controller;

import estm.dsic.jee.rest.business.services.AdminServices;
import estm.dsic.jee.rest.model.User;

import java.util.ArrayList;


import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/admins")

public class AdminController {
    @Inject AdminServices adminServices;
   
    
    @POST
    @Path("/validateUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void validateUser(User user) {

        adminServices.validate(user);
           
    }



    @POST
    @Path("/deleteUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(User user) {

        adminServices.delete(user);

    }


    @Path("/allUsers")
    @GET
    public ArrayList<User> getAllUsers(){

        return adminServices.getAllUsers();
    }
}
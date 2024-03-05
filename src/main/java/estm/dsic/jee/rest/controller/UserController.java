package estm.dsic.jee.rest.controller;

import estm.dsic.jee.rest.business.services.UserServices;
import estm.dsic.jee.rest.dao.UserDAO;
import estm.dsic.jee.rest.model.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;


@Path("/users")

public class UserController {

    @Inject UserDAO userDao;

    UserServices userServices = new UserServices();

    @POST
    @Path("/signup")
    @Consumes(MediaType.APPLICATION_JSON)
    public void signup(User user) {
      UserServices userServices = new UserServices();

      userServices.signup(user);

}


    @GET
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public User login(User user) {
        return userServices.authentification(user);
          
    }



}

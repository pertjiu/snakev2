package nl.hu.bep.setup.servlet;

import nl.hu.bep.setup.domein.AuthResponse;
import nl.hu.bep.setup.domein.LoginRequest;
import nl.hu.bep.setup.domein.UserDetails;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/auth")
public class AuthController {
    // Hardcoded user credentials (for demonstration purposes)
    private static final String hardcodedUsername = "admin";
    private static final String hardcodedPassword = "admin";
    private static final String hardcodedRole = "admin";

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest loginRequest) {
        // Simulate authentication against hardcoded credentials
        if (loginRequest.getUsername().equals(hardcodedUsername) && loginRequest.getPassword().equals(hardcodedPassword)) {
            // Generate a dummy token (for simplicity)
            String token = "dummy_token_for_hardcoded_user";
            return Response.ok(new AuthResponse(token)).build();
        } else {
            // Return unauthorized response
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@Context HttpServletRequest request) {
        // Return hardcoded user details based on the dummy token
        String token = request.getHeader("Authorization").substring(7);
        if (token.equals("dummy_token_for_hardcoded_user")) {
            UserDetails userDetails = new UserDetails(hardcodedUsername, hardcodedRole);
            return Response.ok(userDetails).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Path("/logout")
    public Response logout(@Context HttpServletRequest request) {
        // Invalidate the token (for simplicity, no actual token invalidation logic for now)
        return Response.ok().build();
    }
}

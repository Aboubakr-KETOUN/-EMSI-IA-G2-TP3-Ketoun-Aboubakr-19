package ma.emsi.ketoun.tp3.tp3_ketoun_aboubakr_19;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/hello/personnes")
public class HelloResource {

    @GET
    @Produces("text/plain")
    @Path("/{nom}")
    public String hello(@PathParam("nom") String nom) {
        return "Hello, " + nom;
    }
}

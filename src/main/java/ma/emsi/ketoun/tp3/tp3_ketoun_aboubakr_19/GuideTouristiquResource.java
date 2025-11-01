package ma.emsi.ketoun.tp3.tp3_ketoun_aboubakr_19;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/guide")
public class GuideTouristiquResource {

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("application/json")
    public String [] guide(@PathParam("ville_ou_pays")String ville_ou_pays) {
        switch (ville_ou_pays.toLowerCase()) {
            case "paris":
                return new String[]{"a", "b"};
            case "casa":
                return new String[]{"c", "d"};
            default:
                return new String[]{"rien" + ville_ou_pays};
        }    }
}

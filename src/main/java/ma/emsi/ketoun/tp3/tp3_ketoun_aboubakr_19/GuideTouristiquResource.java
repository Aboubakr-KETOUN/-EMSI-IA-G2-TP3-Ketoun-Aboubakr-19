package ma.emsi.ketoun.tp3.tp3_ketoun_aboubakr_19;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/guide")
public class GuideTouristiquResource {

    @Inject
    private LLM llm;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("application/json")
    public String guide(@PathParam("ville_ou_pays")String ville_ou_pays) {
        return llm.PoserQuestion(ville_ou_pays);
    }
}

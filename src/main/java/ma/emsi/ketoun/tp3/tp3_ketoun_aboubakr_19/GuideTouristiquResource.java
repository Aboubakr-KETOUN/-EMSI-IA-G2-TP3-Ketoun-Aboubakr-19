package ma.emsi.ketoun.tp3.tp3_ketoun_aboubakr_19;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;

@Path("/guide")
public class GuideTouristiquResource {

    @Inject
    private LLM llm;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces("application/json")
    public String guide(@PathParam("ville_ou_pays")String ville_ou_pays,
                        @QueryParam("nb") Integer nbEndroits
    ) {
        if (nbEndroits == null || nbEndroits <= 0) {
            nbEndroits = 2;
        }

        String question_a_jour = String.format(
                "le pays ou ville est :" + ville_ou_pays +
                "le nombre d'endroit souhaite est : " + nbEndroits
        );
        return llm.PoserQuestion(question_a_jour);
    }
}

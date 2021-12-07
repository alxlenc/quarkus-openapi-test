package org.musicchart.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Path("/ranking")
public class RankingResource {

    private static Map<Integer, List<Song>> SONGS_BY_YEAR = Map.of(
            1985, List.of(
                    new Song(1,"Take on Me","a-ha"),
                    new Song(2, "Shout", "Tears for Fears"),
                    new Song(3, "Born in the U.S.A", "Bruce Springsteen")),
            1995, List.of(
                    new Song(1,"Boombastic","Shaggy"),
                    new Song(2, "December", "Collective Soul"),
                    new Song(3, "Carnival", "Natalie Merchant")),
           2005, List.of(
                    new Song(1,"Feel Good Inc.","Gorillaz"),
                    new Song(2, "Photograph", "Nickelback"),
                    new Song(3, "Speed of Sound", "Coldplay"))
    );

    @Operation(summary = "Return top songs by year",
            description = "Given a year it returns the top 5 songs")
    @GET
    @Path("/songs/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> topSongs(
            @Parameter(
                    description = "Input year to provide songs",
                    required = true, example = "1995",
                    schema = @Schema(type = SchemaType.STRING)
            )
            @PathParam("year") Integer year) {
        return SONGS_BY_YEAR.get(year);
    }


}

record Song(int position, String title, String artist) {}
